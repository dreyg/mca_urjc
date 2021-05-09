package es.codeurjc.deliveryservice.stream.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import es.codeurjc.deliveryservice.model.events.AllocateResult;

@Service
public class DeliveryStreamService {
	
	private Logger log = LoggerFactory.getLogger(DeliveryStreamService.class);
	
	private final DeliveryStream deliveryStream;
	
	@Autowired
	public DeliveryStreamService(DeliveryStream deliveryStream) {
		this.deliveryStream = deliveryStream;
	}
	
	public void sendAllocateResult(final AllocateResult allocateResult) {
		log.info("Sending allocateResult {}", allocateResult);
		MessageChannel messageChannel = deliveryStream.outboundAllocateOrder();
        messageChannel.send(MessageBuilder
                .withPayload(allocateResult)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
	}
}
