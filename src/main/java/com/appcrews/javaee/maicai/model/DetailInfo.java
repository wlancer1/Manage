package com.appcrews.javaee.maicai.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detailorder")
public class DetailInfo implements Serializable {
	private int onum, wareid, warenum;
	int ID;
	String name;
	private float price;
	private float sum;
	private String img = "";
	public  DetailInfo(){

	}
	public DetailInfo (int ounm,int wareid,int warenum){
			this.onum=ounm;
			this.wareid=wareid;
			this.warenum=warenum;
	}
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getWareid() {
		return wareid;
	}

	public void setWareid(int wareid) {
		this.wareid = wareid;
	}

	public int getWarenum() {
		return warenum;
	}

	public void setWarenum(int warenum) {
		this.warenum = warenum;
	}
}
