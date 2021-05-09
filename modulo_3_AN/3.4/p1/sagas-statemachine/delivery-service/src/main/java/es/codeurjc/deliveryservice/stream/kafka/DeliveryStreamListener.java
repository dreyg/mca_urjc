package es.codeurjc.deliveryservice.stream.kafka;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import es.codeurjc.deliveryservice.model.events.AllocateRequest;
import es.codeurjc.deliveryservice.model.events.AllocateResult;
import es.codeurjc.deliveryservice.model.events.DeallocateRequest;
import es.codeurjc.deliveryservice.model.events.dto.OrderDto;
import es.codeurjc.deliveryservice.service.AllocationService;


@Component
@Transactional
public class DeliveryStreamListener {
	
	private Logger log = LoggerFactory.getLogger(DeliveryStreamListener.class);
	private final AllocationService allocationService;
	private final DeliveryStreamService deliveryStreamService;
	
	@Autowired
	public DeliveryStreamListener(AllocationService allocationService, DeliveryStreamService deliveryStreamService) {
		this.allocationService = allocationService;
		this.deliveryStreamService = deliveryStreamService;
	}
	
	@StreamListener(DeliveryStream.INPUT_ALLOCATE_DELIVERY_ORDER)
	public void handleAllocateRequest(@Payload AllocateRequest allocateRequest) {
		// TODO cambiar logica
		final OrderDto orderDto =  allocateRequest.getOrder();
		final Boolean result = allocationService.allocateOrder(orderDto);
		final AllocateResult allocateResult = new AllocateResult.Builder().withIsValid(result).withOrderId(orderDto.getId()).withReason(Boolean.FALSE.equals(result) ? "SOLD_OUT":null).build();
		deliveryStreamService.sendAllocateResult(allocateResult);
	}
	
	/*@StreamListener(DeliveryStream.INPUT_DEALLOCATE_ORDER)
    public void handleDeallocateRequest(@Payload DeallocateRequest deallocateRequest) {
		// TODO cambiar logica
		final OrderDto orderDto =  deallocateRequest.getOrder();
		allocationService.deallocateOrder(orderDto);
	}*/
}
