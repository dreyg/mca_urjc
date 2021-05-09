package es.codeurjc.deliveryservice.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import es.codeurjc.deliveryservice.stream.kafka.InventoryStream;

@EnableBinding(InventoryStream.class)
public class StreamsConfig {

}
