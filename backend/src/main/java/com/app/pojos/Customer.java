package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "customer")
@JsonInclude(value = Include.NON_DEFAULT)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int id;

	@Column(length = 45)
	@JsonProperty("name")
	private String name;

	@Column(length = 200)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@JsonProperty("birth_date")
	private LocalDate birthDate;

	@Column(length = 20)
	@JsonProperty("contact")
	private String contact;

	@Column(length = 200)
	@JsonProperty("address")
	private String address;

	@Column(length = 200)
	@JsonProperty("exact_Address")
	private String exact_Address;

	@Column(length = 45, unique = true)
	@JsonProperty("email")
	@NotBlank
	@Email
	private String email;

	@Column(length = 1000)
	@NotBlank
	@JsonProperty("password")
	private String password;

	@Column(length = 50)
	@JsonProperty("employee_id")
	private int employeeId;

	@Column(length = 50)
	@JsonProperty("answer")
	private String answer;

	@OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER)
	private List<ServiceRequest> request_list = new ArrayList<>();

	/* ============================== Constructor ============================== */

	public Customer() {
		super();
	}

	public Customer(int id, String name, @Past LocalDate birthDate, String contact, String address,
			String exact_Address, @NotBlank @Email String email, @NotBlank String password, int employeeId,
			String answer, List<ServiceRequest> request_list) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.contact = contact;
		this.address = address;
		this.exact_Address = exact_Address;
		this.email = email;
		this.password = password;
		this.employeeId = employeeId;
		this.answer = answer;
		this.request_list = request_list;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public List<ServiceRequest> getRequest_list() {
		return request_list;
	}

	public void setRequest_list(List<ServiceRequest> request_list) {
		this.request_list = request_list;
	}

	public String getExact_Address() {
		return exact_Address;
	}

	public void setExact_Address(String exact_Address) {
		this.exact_Address = exact_Address;
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
				"Customer [id=%s, name=%s, birthDate=%s, contact=%s, address=%s, exact_Address=%s, email=%s, password=%s, employeeId=%s, answer=%s, request_list=%s]",
				id, name, birthDate, contact, address, exact_Address, email, password, employeeId, answer,
				request_list);
	}

	/* ================================ toString =============================== */

}
