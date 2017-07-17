package com.appcrews.javaee.maicai.model;

public class SaleInfo {
	int userid;
	String username;
	String email;
	int power;
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
}
