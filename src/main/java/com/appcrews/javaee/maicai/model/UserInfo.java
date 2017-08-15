package com.appcrews.javaee.maicai.model;

public class UserInfo {
	private int id;
private String name;
	private String email;
	private int power;
	private int phone;
	private int status;

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

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
public int  getPower() {
	return power;
}
public void setPower(int power) {
	this.power = power;
}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getPhone() {
		return phone;
	}
}

