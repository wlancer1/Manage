package com.appcrews.javaee.maicai.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appcrews.javaee.maicai.dal.Userimpl;
import com.appcrews.javaee.maicai.model.BuyerInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"/applicationContext.xml");
	Userimpl u = (Userimpl) context.getBean("useraction");
	List<BuyerInfo> info;
	List<SaleInfo> info1;
	ArrayList<UserInfo> info3;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String query() {
		info = u.getlistb();
		info1 = u.getlists();
		info3=new ArrayList<>();
		for (int i = 0; i < info1.size(); i++) {
			UserInfo u1=new UserInfo();
			u1.setEmail(info1.get(i).getEmail());
			u1.setId(info1.get(i).getUserid());
			u1.setName(info1.get(i).getUsername());
			u1.setPower(info1.get(i).getPower());
			info3.add(u1);
		}
		for (int i = 0; i < info.size(); i++) {
			UserInfo u1=new UserInfo();
			u1.setEmail(info.get(i).getBemail());
			u1.setId(info.get(i).getId());
			u1.setName(info.get(i).getBname());
			u1.setPower(info.get(i).getPower());
			info3.add(u1);
		}
	
		request.setAttribute("userinfo", info3);
		return "success";
	}
	public int size(){
		return u.size();
		
	}
}
