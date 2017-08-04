package com.appcrews.javaee.maicai.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appcrews.javaee.maicai.service.orderService;
import com.appcrews.javaee.maicai.service.userService;
import com.appcrews.javaee.maicai.tool.Util;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.appcrews.javaee.maicai.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller
public class UserAction extends ActionSupport implements ModelDriven<UserInfo> {//繼承model驱动注入参数
@Autowired
private userService userService;

	private int  uid;
	private List<UserInfo> userInfoList;
 	private  UserInfo userInfo=new UserInfo();
	private HttpServletRequest request ;
	private HttpServletResponse response;
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public UserInfo getModel() {
		return userInfo;
	}

	public String query() {
	userInfoList=userService.query();
		return "success";
	}
	public String queryedit() {
		request=ServletActionContext.getRequest();
		uid = Integer.parseInt(request.getParameter(
				"uid"));
		userInfo = userService.query(uid);
		request.setAttribute("uid", uid);
		request.setAttribute("userinfo", userInfo);
		return "edit";

	}
	public void update(){
		request=ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
		uid=Integer.parseInt(request.getParameter("uid"));
		userInfo.setId(uid);
		if (userService.update(userInfo)==1){
			Util.renderData(this.response,"success");
		}else if (userService.update(userInfo)==-1){
			Util.renderData(this.response,"error1");
		}else {
			Util.renderData(this.response,"error2");
		}


	}
	public String querydetail() {

		return "detail";
	}
	public void delete(){
		response=ServletActionContext.getResponse();
		uid = Integer.parseInt(request.getParameter(
				"uid"));


	}


}
