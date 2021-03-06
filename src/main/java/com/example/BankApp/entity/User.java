package com.example.BankApp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long accountID = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

	@NotBlank(message="Please enter your name")
	private String firstName;

	@NotEmpty(message = "Please enter a last name")
	private String lastName;
	
	@NotEmpty(message = "Please enter a last name")
	private int age;
	
	@NotEmpty(message = "Please enter a pan")
	private String pan;
	
	@NotEmpty(message = "Please enter a mobile number for banking purpose and otps")
	private String phone;
	
	@NotEmpty(message = "Please enter a email for paperless account statments")
	private String email;
	
	@NotEmpty(message = "Gender parameter is missing")
	private String gender;
	
	private int initialAmt = 10000;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getInitialAmt() {
		return initialAmt;
	}

	public void setInitialAmt(int initialAmt) {
		this.initialAmt = initialAmt;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	
	
}
	
