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
@Table(name = "feedback")
@JsonInclude(value = Include.NON_DEFAULT)
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int id;

	@JsonProperty("customer_id")
	private int customer_id;

	@Column(length = 100)
	@JsonProperty("feedback_message")
	private String feedback_message;

	@Column(length = 50)
	@JsonProperty("title")
	private String title;

	@Column(length = 50)
	@JsonProperty("vendor")
	private String vendor;

	/* ============================== Constructor ============================== */
	public Feedback() {
		super();
	}

	public Feedback(int id, int customer_id, String feedback_message, String title, String vendor) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.feedback_message = feedback_message;
		this.title = title;
		this.vendor = vendor;
	}

	/* =========================== Getters & Setters =========================== */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFeedback_message() {
		return feedback_message;
	}

	public void setFeedback_message(String feedback_message) {
		this.feedback_message = feedback_message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/* ================================ toString =============================== */

	@Override
	public String toString() {
		return String.format("Feedback [id=%s, customer_id=%s, feedback_message=%s, title=%s, vendor=%s]", id,
				customer_id, feedback_message, title, vendor);
	}
}
