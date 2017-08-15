package com.appcrews.javaee.maicai.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "saler")
public class SaleInfo implements Serializable {
	private int userid;
	private String username;
	private String email;
	private int power;
	private  int status;
	private String password;
	private String saddress;
	private int tele;
	public SaleInfo(){
	}
	public SaleInfo(int id, String name,
			 String email, int power, int phone, int status){
		this.userid=id;
		this.username=name;
		this.email=email;
		this.power=power;
		this.tele=phone;
		this.status=status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

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


	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}



	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
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
