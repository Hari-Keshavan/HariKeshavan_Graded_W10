package com.question2;

public class Employee {

	private int id;
	private String name;
	private String email;
	private String mobileNo;
	
	public Employee(int id, String name, String email, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNum(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}