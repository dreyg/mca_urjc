package es.codeurjc.deliveryservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.deliveryservice.domain.Inventory;
import es.codeurjc.deliveryservice.dto.CreateInventoryRequest;
import es.codeurjc.deliveryservice.dto.CreateInventoryResponse;
import es.codeurjc.deliveryservice.dto.InventoryResponse;
import es.codeurjc.deliveryservice.dto.UpdateInventoryRequest;
import es.codeurjc.deliveryservice.dto.UpdateInventoryResponse;
import es.codeurjc.deliveryservice.exception.EntityNotFoundException;
import es.codeurjc.deliveryservice.repository.InventoryRepository;

@Service
@Transactional
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	@Autowired
	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	public CreateInventoryResponse createInventory(CreateInventoryRequest createCustomerRequest) {
		final Inventory inventory = new Inventory.Builder()
				                                 .withName(createCustomerRequest.getName())
				                                 .withReference(createCustomerRequest.getReference())
				                                 .withStockQuantity(createCustomerRequest.getStockQuantity())
				                                 .build();
		final Inventory inventorySaved = inventoryRepository.save(inventory);
		return new CreateInventoryResponse(inventorySaved.getId());
	}

	public UpdateInventoryResponse updateInventory(UpdateInventoryRequest updateInventoryRequest) {
		final Inventory inventory = inventoryRepository.findById(updateInventoryRequest.getId()).orElseThrow(() ->new EntityNotFoundException());
		inventory.setStockQuantity(inventory.getStockQuantity() + updateInventoryRequest.getStockQuantity());
		inventoryRepository.save(inventory);
		return new UpdateInventoryResponse(updateInventoryRequest.getId());
	}

	public InventoryResponse getInventory(UUID inventoryId) {
		final Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(() ->new EntityNotFoundException());
		return toInventoryResponse(inventory);
	}

	public List<InventoryResponse> getInventories() {
		final List<Inventory> inventories = inventoryRepository.findAll();
		return inventories.stream().map(i -> toInventoryResponse(i)).collect(Collectors.toList());
	}
	
	private InventoryResponse toInventoryResponse(final Inventory inventory) {
		return new InventoryResponse.Builder()
        .withId(inventory.getId())
        .withName(inventory.getName())
        .withReference(inventory.getReference())
        .withStockQuantity(inventory.getStockQuantity())
        .build();
	}
}
