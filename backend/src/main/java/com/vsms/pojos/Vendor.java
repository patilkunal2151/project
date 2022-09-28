package com.vsms.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Vendor")
@JsonInclude(value = Include.NON_DEFAULT)
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("VendorId")
	@Column(name = "VendorId")
	private int vid;

	@Column(length = 50, name = "Name")
	@JsonProperty("Name")
	private String name;

	@Column(length = 50, name = "Email")
	@JsonProperty("Email")
	@Email
	@NotBlank
	private String email;

	@Column(length = 1000, name = "Password")
	@JsonProperty("Password")
	@NotBlank
	private String pass;

	@Column(length = 10, name = "contact")
	@JsonProperty("Contact")
	private String contact;

	@Column(length = 100, name = "Address")
	@JsonProperty("Address")
	private String address;

	@Column(length = 50, name = "State")
	@JsonProperty("State")
	private String state;

	@Column(length = 50, name = "City")
	@JsonProperty("City")
	private String city;

	@JsonProperty("Gid")
	@Column(name = "Gid")
	private int gid;

	@JsonProperty("GName")
	@Column(length = 50, name = "GName")
	private String gname;

	@JsonProperty("Capacity")
	@Column(name = "Capacity")
	private int capacity;

	@JsonProperty("Status")
	@Column(name = "Status")
	private boolean stat;

	public Vendor() {
		super();
	}

	public Vendor(int vid, String name, @Email String email, @NotNull String pass, String contact, String address,
			String state, String city, int gid, String gname, int capacity, boolean stat) {
		super();
		this.vid = vid;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.contact = contact;
		this.address = address;
		this.state = state;
		this.city = city;
		this.gid = gid;
		this.gname = gname;
		this.capacity = capacity;
		this.stat = stat;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isStat() {
		return stat;
	}

	public void setStat(boolean stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return String.format(
				"Vendor [vid=%s, name=%s, email=%s, pass=%s, contact=%s, address=%s, state=%s, city=%s, gid=%s, gname=%s, capacity=%s, stat=%s]",
				vid, name, email, pass, contact, address, state, city, gid, gname, capacity, stat);
	}

}
