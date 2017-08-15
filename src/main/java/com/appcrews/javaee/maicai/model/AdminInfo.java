package com.appcrews.javaee.maicai.model;


import com.appcrews.javaee.maicai.validation.NotBlank;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "admin")
public class AdminInfo implements Serializable {

	private int id;
	@NotBlank(message = "账号不能为空！")
	private String account;
	@NotBlank(message = "密码不能为空！")
	private String password;
	private int power;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Basic
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	@Basic
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Basic
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
