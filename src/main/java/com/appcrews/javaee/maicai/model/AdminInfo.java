package com.appcrews.javaee.maicai.model;


import com.appcrews.javaee.maicai.validation.NotBlank;

import javax.validation.constraints.NotNull;

public class AdminInfo {
	@NotBlank(message = "账号不能为空！")
	String account;
	@NotBlank(message = "密码不能为空！")
	String password;
	int power;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
