package com.example.demo.service;

import com.example.demo.grpc.GetWeatherRequest;
import com.example.demo.grpc.ResponseWeather;
import com.example.demo.grpc.WeatherServiceGrpc;
import com.example.demo.models.Topo;
import com.example.demo.models.Weather;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	private RestTemplate restTemplate;

	public Consumer(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@RabbitListener(queues = "eoloplantCreationProgressNotifications", ackMode = "AUTO")
	public void received(String city) throws InterruptedException {
		logger.info("city: " + city);
		// TODO devolver llamada para que actualice al 25% -- AMQP

		// llamada a WeatherService y a TopoService
		CompletableFuture<Topo> infoTopoCity = findTopoService(city);
		CompletableFuture<Weather> infoWeatherCity = findWeatherService(city);
		CompletableFuture<Void> allFutures = CompletableFuture.allOf(infoTopoCity,infoWeatherCity);

	}

	@Async
	public CompletableFuture<Topo> findTopoService(String city) throws InterruptedException {
		logger.info("Looking up " + city);
		String url = String.format("https://localhost:8080/api/topographicdetails/", city);
		Topo results = restTemplate.getForObject(url, Topo.class);
		// Artificial delay of 1s for demonstration purposes
		Thread.sleep(3000L);
		return CompletableFuture.completedFuture(results);
	}

	@Async
	public CompletableFuture<Weather> findWeatherService(String city) {
		// codigo para comunicarse con gRPC
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
				.usePlaintext()
				.build();

		WeatherServiceGrpc.WeatherServiceBlockingStub client =
			WeatherServiceGrpc.newBlockingStub(channel);

		GetWeatherRequest request = GetWeatherRequest.newBuilder()
				.setCity(city)
				.build();

		ResponseWeather response = client.getWeather(request);

		Weather res = new Weather(response.getCity(), response.getWeather());

		return res;
	}



}
