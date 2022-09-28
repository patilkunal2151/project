package com.vsms.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Service")
@JsonInclude(value = Include.NON_DEFAULT)
public class Service {
	/* svc_id        int        
 svc_name      varchar(20)
 VendorId     int        
 ServicePrice double*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("svc_id")
	@Column(name = "svc_id")
	private int Id;
	
	@Column(length = 50, name = "svc_name")
	@JsonProperty("FirstName")
	private String SName;
	
	@Column(name = "ServicePrice")
	@JsonProperty("ServicePrice")
	private double ServPrice;
	
	
	@ManyToOne
	@JoinColumn(name="VendorId")
	private Vendor vend;
	
	
	
	

}
