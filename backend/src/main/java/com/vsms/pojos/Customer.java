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
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Customer")
@JsonInclude(value = Include.NON_DEFAULT)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("cu_id")
	@Column(name = "cu_id")
	private int id;

	@Column(length = 50, name = "FirstName")
	@JsonProperty("FirstName")
	private String fname;

	@Column(length = 50, name = "LastName")
	@JsonProperty("LastName")
	private String lname;

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

	@JsonProperty("VehicleId")
	@Column(name = "VehicleId")
	private int vid;

	@Column(length = 20, name = "Answer")
	@JsonProperty("Answer")
	private String answer;

// ==============================================================================================================

	public Customer() {
		super();
	}

	public Customer(int id, String fname, String lname, String email, String pass, String contact, String address,
			String state, String city, int vid, String answer) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.contact = contact;
		this.address = address;
		this.state = state;
		this.city = city;
		this.vid = vid;
		this.answer = answer;
	}

	public Customer(@Email @NotNull String email, @NotNull String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer [id=%s, fname=%s, lname=%s, email=%s, pass=%s, contact=%s, address=%s, state=%s, city=%s, vid=%s, answer=%s]",
				id, fname, lname, email, pass, contact, address, state, city, vid, answer);
	}

}
