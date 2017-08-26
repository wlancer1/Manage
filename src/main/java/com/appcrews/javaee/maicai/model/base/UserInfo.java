package com.appcrews.javaee.maicai.model.base;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class UserInfo implements Serializable {
	private int uid;
	private String name;
	private String email;
	private int power;
	private int phone;
	private int sid;
	private int status;
	private String password;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(updatable = false)
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUid() {
		return uid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}


	public int getSid() {
		return sid;
	}
@Column(name = "username")
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
@Column(updatable = false)
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

