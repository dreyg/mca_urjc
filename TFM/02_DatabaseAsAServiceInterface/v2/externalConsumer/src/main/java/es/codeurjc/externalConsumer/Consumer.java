package es.codeurjc.mastercloudapps.amqp;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@KafkaListener(topics = "dbserver1.order.t_order")

	public void received(ConsumerRecord<?, ?> message) {

		System.out.println("Message: "+message.value());
	}
}
