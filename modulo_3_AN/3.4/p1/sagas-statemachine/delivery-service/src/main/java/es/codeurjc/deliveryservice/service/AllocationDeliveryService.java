package es.codeurjc.deliveryservice.service;

import javax.transaction.Transactional;

import es.codeurjc.deliveryservice.domain.City;
import es.codeurjc.deliveryservice.domain.Delivery;
import es.codeurjc.deliveryservice.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.deliveryservice.model.events.dto.OrderDto;
import es.codeurjc.deliveryservice.repository.DeliveryRepository;

import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class AllocationDeliveryService {

	private Logger log = LoggerFactory.getLogger(AllocationDeliveryService.class);

	private final DeliveryRepository deliveryRepository;

	private final CityRepository cityRepository;

	@Autowired
	public AllocationDeliveryService(DeliveryRepository deliveryRepository, CityRepository cityRepository) {
		this.deliveryRepository = deliveryRepository;
		this.cityRepository = cityRepository;
	}

	public Boolean allocateDeliveryOrder(OrderDto orderDto) {
		log.debug("Allocating OrderId: " + orderDto.getId());
	    Optional<City> optCity = cityRepository.findByCodCity(orderDto.getCodCity());
	    if (optCity.isPresent()) {
	    	City city = optCity.get();
	    	if (city.getDeliveryQuantity() > orderDto.getQuantity() ) {
	    		city.setDeliveryQuantity(city.getDeliveryQuantity() - 1);
	    		City savedCity = cityRepository.save(city);
				log.debug("Saved City city id: " + savedCity.getId());
				UUID pathRandom = UUID.randomUUID();
				final Delivery delivery = new Delivery.Builder()
						.withOrderId(orderDto.getId())
						.withPath(String.valueOf(pathRandom))
						.build();

				Delivery saveDelivery = deliveryRepository.save(delivery);
	    		log.debug("Saved Delivery delivery id: " + saveDelivery.getId());
	    		return Boolean.TRUE;
	    	}
	    }
	    return Boolean.FALSE;
	}

	public void deallocateDeliveryOrder(OrderDto orderDto) {
		    
		Optional<City> optCity = cityRepository.findByCodCity(orderDto.getCodCity());
		if (optCity.isPresent()) {
			City city = optCity.get();
			city.setDeliveryQuantity(city.getDeliveryQuantity() + 1);
			City savedCity = cityRepository.save(city);
			log.debug("Saved City city id: " + savedCity.getId());

			Optional<Delivery> optDelivery = deliveryRepository.findByOrderId(orderDto.getId());

			if (optDelivery.isPresent()) {
				Delivery delivery = optDelivery.get();
				deliveryRepository.delete(delivery);
				log.debug("Saved Delivery delivery id: " + delivery.getId());
			}
		}
	}
}
