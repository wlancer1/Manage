package com.appcrews.javaee.maicai.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appcrews.javaee.maicai.service.userService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appcrews.javaee.maicai.dal.Userimpl;
import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
@Autowired
private userService userService;
	private List<UserInfo> userInfoList;

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public String query() {
	userInfoList=userService.query();
		return "success";
	}
	public int size(){
		return 1;
		
	}
}
