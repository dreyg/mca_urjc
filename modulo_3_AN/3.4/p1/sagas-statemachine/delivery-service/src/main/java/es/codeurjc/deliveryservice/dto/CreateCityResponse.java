package es.codeurjc.deliveryservice.dto;

import java.util.UUID;

public class CreateCityResponse {

	private UUID inventoryId;


	public CreateCityResponse() {
	}

	public CreateCityResponse(UUID inventoryId) {
		this.inventoryId = inventoryId;
	}

	public UUID getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(UUID inventoryId) {
		this.inventoryId = inventoryId;
	}

}
