package es.codeurjc.deliveryservice.dto;

import java.util.UUID;

public class CreateDeliveryResponse {

	private UUID inventoryId;

	
	public CreateDeliveryResponse() {
	}

	public CreateDeliveryResponse(UUID inventoryId) {
		this.inventoryId = inventoryId;
	}

	public UUID getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(UUID inventoryId) {
		this.inventoryId = inventoryId;
	}

}
