package es.codeurjc.deliveryservice.stream.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DeliveryStream {

	public String INPUT_ALLOCATE_DELIVERY_ORDER = "allocate-delivery-order-request";
    public String OUTPUT_ALLOCATE_DELIVERY_ORDER = "allocate-delivery-order-response";
    //public String INPUT_DEALLOCATE_ORDER = "deallocate-order-request";
    
    @Input(INPUT_ALLOCATE_DELIVERY_ORDER)
    SubscribableChannel inboundAllocateOrder();

    @Output(OUTPUT_ALLOCATE_DELIVERY_ORDER)
    MessageChannel outboundAllocateOrder();
    
    /*@Output(INPUT_DEALLOCATE_ORDER)
    SubscribableChannel inboundDeallocateOrder();*/
}
