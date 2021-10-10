package es.codeurjc.externalConsumer.services.impl;

import es.codeurjc.externalConsumer.dtos.responses.OrderResponseDto;
import es.codeurjc.externalConsumer.services.QueryOrderService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class QueryOrderServiceImpl implements QueryOrderService {

    private Mapper mapper;
    private String ordersServiceUrl;
    private RestTemplate restTemplate;

    public QueryOrderServiceImpl(Mapper mapper, @Value("${orders.service.url}") String ordersServiceUrl, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.ordersServiceUrl = ordersServiceUrl + "/api/v1/orders/";
        this.restTemplate = restTemplate;
    }

    public Collection<OrderResponseDto> findAll() {
        ResponseEntity<Collection<OrderResponseDto>> responseEntity = restTemplate.exchange(
                ordersServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }


    public OrderResponseDto findById(long orderId) {
        ResponseEntity<OrderResponseDto> responseEntity = restTemplate.exchange(
                ordersServiceUrl + "/" + orderId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        return responseEntity.getBody();
    }
}
