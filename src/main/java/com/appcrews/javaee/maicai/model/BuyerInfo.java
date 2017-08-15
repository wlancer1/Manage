package com.appcrews.javaee.maicai.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "buyer")
public class BuyerInfo implements Serializable {
 private int id;
	private String bname;

	private String baddress;
	private String bremark;
	private String bemail;
	private int btele;
	private int power;
	private  int status;
	private  String password;
public BuyerInfo(){

}
	public BuyerInfo(int id, String name,
					String email, int power, int phone, int status){
		this.id=id;
		this.bname=name;
		this.bemail=email;
		this.power=power;
		this.btele=phone;
		this.status=status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "bpassword")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBemail() {
	return bemail;
}
public void setBemail(String bemail) {
	this.bemail = bemail;
}

 public int getPower() {
	return power;
}
public void setPower(int power) {
	this.power = power;
}

public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBaddress() {
	return baddress;
}
public void setBaddress(String baddress) {
	this.baddress = baddress;
}
public String getBremark() {
	return bremark;
}
public void setBremark(String bremark) {
	this.bremark = bremark;
}

	public void setBtele(int btele) {
		this.btele = btele;
	}

	public int getBtele() {
		return btele;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
