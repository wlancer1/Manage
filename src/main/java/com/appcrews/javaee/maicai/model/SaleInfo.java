package com.appcrews.javaee.maicai.model;

public class SaleInfo {
	private int userid;
	private String username;
	private String email;
	private int power;
	private  int status;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTele() {
		return tele;
	}

	public void setTele(int tele) {
		this.tele = tele;
	}

	int tele;
	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	String saddress;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
