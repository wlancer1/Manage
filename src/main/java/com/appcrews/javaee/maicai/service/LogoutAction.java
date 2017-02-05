package com.appcrews.javaee.maicai.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {
	public Cookie[] cookies;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public String logout() {
		request = ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
		cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("loginInfo")){
				Cookie delCookie = new Cookie("loginInfo", null);
				delCookie.setMaxAge(0);
				delCookie.setPath("/");
				this.response.addCookie(delCookie);
				break;
			}
		}
		request.getSession().removeAttribute("myname");
		request.getSession().removeAttribute("power");
		return "false";

	}
}
