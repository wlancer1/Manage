package com.appcrews.javaee.maicai.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appcrews.javaee.maicai.dal.Admin;
import com.appcrews.javaee.maicai.model.AdminInfo;
import com.appcrews.javaee.maicai.tool.MD5;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class DLAction extends ActionSupport implements ModelDriven<AdminInfo> {
	List<AdminInfo> info;
	public Cookie[] cookies ;
HttpServletResponse response;
	HttpServletRequest request = ServletActionContext.getRequest();
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"/applicationContext.xml");
	private String account, password;

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
        response=ServletActionContext.getResponse();
		cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("loginInfo")){
				String loginInfo = cookie.getValue();
				this.account= loginInfo.split("%2C")[0];
				this.password = loginInfo.split("%2C")[1];

			}
		}

		String ma=MD5.Encrypt(account,account.length());
		String mp=MD5.Encrypt(password, password.length());
		power = a.panduan(ma,mp);
		if (power == -1) {
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("loginInfo")){
                    Cookie delCookie = new Cookie("loginInfo", null);
                    delCookie.setMaxAge(0);
                    delCookie.setPath("/");
                    response.addCookie(delCookie);
                    break;
				}
			}
			return "false";
		} else {
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
            request.getSession().setAttribute("myname", this.account);
			return "success";
		}

	}
}
