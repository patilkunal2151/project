package com.vsms.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Employee")
@JsonInclude(value = Include.NON_DEFAULT)
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("EmpId")
	@Column(name = "EmpId")
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

	@JsonProperty("Role")
	@Column(name = "Role")
	private String role;

	@Column(name = "Salary")
	@JsonProperty("Salary")
	private double salary;

	public Employee() {
		super();
	}

	public Employee(int id, String fname, String lname, @Email @NotBlank String email, @NotBlank String pass,
			String contact, String address, String state, String city, String role, double salary) {
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
		this.role = role;
		this.salary = salary;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format(
				"Employee [id=%s, fname=%s, lname=%s, email=%s, pass=%s, contact=%s, address=%s, state=%s, city=%s, role=%s, salary=%s]",
				id, fname, lname, email, pass, contact, address, state, city, role, salary);
	}

}
