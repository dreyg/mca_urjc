package es.codeurjc.deliveryservice.service;

import java.util.Optional;

import javax.transaction.Transactional;

import es.codeurjc.deliveryservice.domain.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.deliveryservice.model.events.dto.OrderDto;
import es.codeurjc.deliveryservice.repository.DeliveryRepository;


@Service
@Transactional
public class AllocationService {

	private Logger log = LoggerFactory.getLogger(AllocationService.class);

	private final DeliveryRepository deliveryRepository;

	@Autowired
	public AllocationService(DeliveryRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}

	public Boolean allocateOrder(OrderDto orderDto) {
		log.debug("Allocating OrderId: " + orderDto.getId());
	    /*Optional<City> optInventory = deliveryRepository.findByReference(orderDto.getReference());
	    if (optInventory.isPresent()) {
	    	City city = optInventory.get();
	    	if (city.getStockQuantity() > orderDto.getQuantity() ) {
	    		city.setStockQuantity(city.getStockQuantity() - orderDto.getQuantity());
	    		City savedCity = deliveryRepository.save(city);
	    		log.debug("Saved Inventory inventory id: " + savedCity.getId());
	    		return Boolean.TRUE;
	    	}
	    }*/
	    return Boolean.FALSE;
	}


	public void deallocateOrder(OrderDto orderDto) {
		    
		   /* Optional<City> optInventory = deliveryRepository.findByReference(orderDto.getReference());
		    if (optInventory.isPresent()) {
		    	City city = optInventory.get();
		    	city.setStockQuantity(city.getStockQuantity() + orderDto.getQuantity());
				City savedCity = deliveryRepository.save(city);
				log.debug("Saved Inventory inventory id: " + savedCity.getId());
		    }*/
	}
}
