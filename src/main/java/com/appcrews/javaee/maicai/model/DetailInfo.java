package com.appcrews.javaee.maicai.model;

public class DetailInfo {
	private int onum, SCid, SCnum;
	int ID;
	String name;
	private float price;
	private float sum;
	private String img = "";

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getOnum() {
		return onum;
	}

	public void setOnum(int ounm) {
		this.onum=ounm;
	}

	public int getSCid() {
		return SCid;
	}

	public void setSCid(int sCid) {
		SCid = sCid;
	}

	public int getSCnum() {
		return SCnum;
	}

	public void setSCnum(int sCnum) {
		SCnum = sCnum;
	}

}
