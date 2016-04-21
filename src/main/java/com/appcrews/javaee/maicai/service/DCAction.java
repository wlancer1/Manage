package com.appcrews.javaee.maicai.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DCAction extends ActionSupport {
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("myname");
		request.getSession().removeAttribute("power");
		return "false";

	}
}
