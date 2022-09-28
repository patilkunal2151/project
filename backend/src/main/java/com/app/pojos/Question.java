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
@Table(name = "question")
@JsonInclude(value = Include.NON_DEFAULT)
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("question_id")
	private int question_id;

	@Column(length = 100)
	@JsonProperty("question")
	private String question_message;

	@Column(length = 1000)
	@JsonProperty("questionanswer")
	private String question_answer;

	/* ============================== Constructor ============================== */
	public Question() {
		super();
	}

	public Question(int question_id, String question_message, String question_answer) {
		super();
		this.question_id = question_id;
		this.question_message = question_message;
		this.question_answer = question_answer;
	}

	/* =========================== Getters & Setters =========================== */
	
	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_message() {
		return question_message;
	}

	public void setQuestion_message(String question_message) {
		this.question_message = question_message;
	}

	public String getQuestion_answer() {
		return question_answer;
	}

	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}
	
	/* ================================ toString =============================== */

	
	@Override
	public String toString() {
		return String.format("Question [question_id=%s, question_message=%s, question_answer=%s]", question_id,
				question_message, question_answer);
	}

	
}
