package com.example.bank.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 27, 2023, 08:38 PM
 */

@Entity
@Table(name = "notice_details")
@Getter
@Setter
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "notice_id")
	private int noticeId;

	@Column(name = "notice_summary")
	private String noticeSummary;

	@Column(name = "notice_details")
	private String noticeDetails;

	@Column(name = "notic_beg_dt")
	private Date noticBegDt;
	
	@Column(name = "notic_end_dt")
	private Date noticEndDt;
	
	@Column(name = "create_dt")
	private Date createDt;
	
	@Column(name = "update_dt")
	private Date updateDt;

}
