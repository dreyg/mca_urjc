package es.codeurjc.loyalty.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "T_LOYALTY_CARD_NUMBER_VIEW")
@Data
public class LoyaltyView {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "LOYALTY_CARD_NUMBER")
	private String loyaltyCardNumber;

}
