package com.appcrews.javaee.maicai.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {
	private HttpServletRequest request;
	public String logout() {
		request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("myname");
		request.getSession().removeAttribute("power");
		return "false";

	}
}
