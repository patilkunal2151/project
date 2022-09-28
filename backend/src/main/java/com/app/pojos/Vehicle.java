package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Vehicle")
@JsonInclude(value = Include.NON_DEFAULT)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("VehicleId")
	private int VehicleId;

	@Column(length = 45)
	@JsonProperty("vehicle_type")
	private String vehicleType;

	@Column(length = 45)
	@JsonProperty("vehicle_model")
	private String vehicleModel;

	@Column(length = 45)
	@JsonProperty("vehicle_brand")
	private String vehicleBrand;

	@Column(length = 45, unique = true)
	@JsonProperty("vehicle_reg_no")
	private String vehicleRegNo;

	@JsonProperty("CustomerId")
	private int CustomerId;

	public Vehicle(int vehicleId, String vehicleType, String vehicleModel, String vehicleBrand, String vehicleRegNo,
			int customerId) {
		super();
		VehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.vehicleBrand = vehicleBrand;
		this.vehicleRegNo = vehicleRegNo;
		CustomerId = customerId;
	}

	public Vehicle() {
		super();
	}

	public int getVehicleId() {
		return VehicleId;
	}

	public void setVehicleId(int vehicleId) {
		VehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	@Override
	public String toString() {
		return String.format(
				"Vehicle [VehicleId=%s, vehicleType=%s, vehicleModel=%s, vehicleBrand=%s, vehicleRegNo=%s, CustomerId=%s]",
				VehicleId, vehicleType, vehicleModel, vehicleBrand, vehicleRegNo, CustomerId);
	}

}
