package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "admin")
@JsonInclude(value = Include.NON_DEFAULT)
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int id;

	@Column(length = 45)
	@JsonProperty("name")
	private String name;

	@Column(length = 70, unique = true)
	@JsonProperty("email")
	@NotBlank
	private String email;

	@Column(length = 1000)
	@NotBlank
	@JsonProperty("password")
	private String password;

	@Column(length = 50)
	@JsonProperty("answer")
	private String answer;

	/*
	 * ============================================
	 * Constructor============================================
	 */
	public Admin() {
		super();
	}

	public Admin(@NotBlank String email, @NotBlank String password, String answer) {
		super();
		this.email = email;
		this.password = password;
		this.answer = answer;
	}
	
	public Admin(int id, String name, @NotBlank String email, @NotBlank String password, String answer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.answer = answer;
	}

	

	

	/*
	 * ============================================ Getters & Setters
	 * ============================================
	 */

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/*
	 * ============================================toString=========================
	 * ===================
	 */

	@Override
	public String toString() {
		return String.format("Admin [id=%s, name=%s, email=%s, password=%s, answer=%s]", id, name, email, password,
				answer);
	}

}
