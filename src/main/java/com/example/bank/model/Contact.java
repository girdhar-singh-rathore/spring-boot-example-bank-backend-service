package com.example.bank.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 27, 2023, 08:19 PM
 */

@Entity
@Table(name = "contact_messages")
@Getter
@Setter
public class Contact {

	@Id
	@Column(name = "contact_id")
	private String contactId;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_email")
	private String contactEmail;
	
	private String subject;

	private String message;

	@Column(name = "create_dt")
	private Date createDt;

}
