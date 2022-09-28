package com.vsms.dtos;

public class Credentials {
	
	private String email;
	
	private String pass;

	public Credentials() {
		super();
	}

	public Credentials(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
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

	@Override
	public String toString() {
		return String.format("Credentials [email=%s, pass=%s]", email, pass);
	}

	
}
