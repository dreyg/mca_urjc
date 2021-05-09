package es.codeurjc.orderservice.sm.actions;

import es.codeurjc.orderservice.service.OrderManager;
import es.codeurjc.orderservice.types.OrderEventEnum;
import es.codeurjc.orderservice.types.OrderStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

@Component
public class AllocationDeliveryFailureAction implements Action<OrderStatusEnum, OrderEventEnum>{

	private Logger log = LoggerFactory.getLogger(AllocationDeliveryFailureAction.class);
	

	@Override
	public void execute(StateContext<OrderStatusEnum, OrderEventEnum> context) {
		String orderId = (String) context.getMessage().getHeaders().get(OrderManager.ORDER_ID_HEADER);

		log.info("Compensating Transaction.... Allocation Delivery Failed: " + orderId);
	}

}
