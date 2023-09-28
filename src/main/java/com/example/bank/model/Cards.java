package com.example.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 27, 2023, 08:16 PM
 */

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Cards {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "card_id")
	private int cardId;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "total_limit")
	private int totalLimit;

	@Column(name = "amount_used")
	private int amountUsed;

	@Column(name = "available_amount")
	private int availableAmount;

	@Column(name = "create_dt")
	private Date createDt;

	
}
