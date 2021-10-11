package es.codeurjc.externalConsumer.component;

import es.codeurjc.externalConsumer.models.event.Event;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Component
public class EventListener {

	private final IntegrationService integrationService;

	public EventListener (IntegrationService integrationService){
		this.integrationService = integrationService;
	}

	@KafkaListener(topics = "dbserver1.order.t_order")

	public void listenEvents(Event event){

		if (Objects.nonNull(event.getPayload().getSource())){
			log.info("New event consumed successfully");
			integrationService.processKafkaEvent(event);
		}else{
			log.error("The event has been discarded for not having the expected information");
		}
	}

}
