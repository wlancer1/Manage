package com.appcrews.javaee.maicai.model;

import java.sql.Timestamp;

public class OrderInfo {
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}




	public int getOnum() {
		return onum;
	}

	public void setOnum(int onum) {
		this.onum = onum;
	}

	public String getOremark() {
		return oremark;
	}

	public void setOremark(String oremark) {
		this.oremark = oremark;
	}

	public Timestamp getOtime() {
		return otime;
	}

	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}

	public Timestamp getStime() {
		return Stime;
	}

	public void setStime(Timestamp stime) {
		Stime = stime;
	}

	private  int userID, buyerID,onum;
	private String oremark;
	private Timestamp otime, Stime;
}
