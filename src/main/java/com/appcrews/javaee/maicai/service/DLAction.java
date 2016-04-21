package com.appcrews.javaee.maicai.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appcrews.javaee.maicai.dal.Admin;
import com.appcrews.javaee.maicai.model.AdminInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class DLAction extends ActionSupport implements ModelDriven<AdminInfo> {
	List<AdminInfo> info;
	HttpServletRequest request = ServletActionContext.getRequest();
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"/applicationContext.xml");
	String account, password;

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

	Admin a = (Admin) context.getBean("adminaction");

	@Override
	public AdminInfo getModel() {
		// TODO Auto-generated method stub
		return (AdminInfo) info;
	}

	public String login() throws UnsupportedEncodingException {
		int power;
		String quanxian = null;
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		power = a.panduan(account, password);
		if (power == -1) {
			return "false";
		} else {
			request.getSession().setAttribute("myname", account);
			switch (power) {
			case 0:
				quanxian = "管理员";
				break;
			case 1:
				quanxian = "超级管理员";
				break;
			default:
				break;
			}
			request.getSession().setAttribute("power", quanxian);
			return "success";
		}

	}
}
