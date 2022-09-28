package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "vendor")
@JsonInclude(value = Include.NON_DEFAULT)
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int id;

	@Column(length = 45)
	@JsonProperty("name")
	private String name;

	@Column(length = 200)
	@JsonProperty("address")
	private String address;

	@Column(length = 200)
	@JsonProperty("exact_address")
	private String exact_address;

	@Column(length = 30)
	@JsonProperty("contact")
	private String contact;

	@Column(length = 45)
	@JsonProperty("email")
	@NotBlank
	private String email;

	@Column(length = 1000)
	@JsonProperty("password")
	@NotBlank
	private String password;

	@Column(length = 200)
	@JsonProperty("garage")
	private String garage;

	@Column(length = 50)
	@JsonProperty("answer")
	private String answer;

	@OneToMany(mappedBy = "vendorId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees = new ArrayList<>();

	/* ============================== Constructor ============================== */
	public Vendor() {
		super();
		System.out.println("in vendor constructor");
	}

	public Vendor(int id, String name, String address, String exact_address, String contact, @NotBlank String email,
			@NotBlank String password, String garage, String answer, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.exact_address = exact_address;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.garage = garage;
		this.answer = answer;
		this.employees = employees;
	}

	public Vendor(String address) {
		super();
		this.address = address;
	}
	
	/* =========================== Getters & Setters =========================== */

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getExact_address() {
		return exact_address;
	}

	public void setExact_address(String exact_address) {
		this.exact_address = exact_address;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/* ================================ toString ================================ */

	@Override
	public String toString() {
		return String.format(
				"Vendor [id=%s, name=%s, address=%s, exact_address=%s, contact=%s, email=%s, password=%s, garage=%s, answer=%s, employees=%s]",
				id, name, address, exact_address, contact, email, password, garage, answer, employees);
	}

}
