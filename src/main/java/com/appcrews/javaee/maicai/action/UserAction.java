package com.appcrews.javaee.maicai.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appcrews.javaee.maicai.model.base.PageInfo;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.userService;
import com.appcrews.javaee.maicai.tool.Util;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.appcrews.javaee.maicai.model.base.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller
public class UserAction extends	BaseAction implements ModelDriven<UserInfo> {//繼承model驱动注入参数
//@Autowired
//private userService userService;

	private List<UserInfo> userInfoList;
 	private  UserInfo userInfo=new UserInfo();
	private Map map;
	private static final Logger log = LogManager.getLogger();
	@Autowired
	public void setService(userService service) {

		this.service = service;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

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


	


	@Override
	public UserInfo getModel() {
		return userInfo;
	}

	public String query() {
		return "success";
	}
	public void queryWay() {
		map=new HashMap();
		userInfoList= ((userService)service).getQueryForPage(pageInfo.getPageNo(),pageInfo.getPageSize());
		pageInfo.setAllpage(service.getcountTotalPage(pageInfo.getPageSize()));
		map.put("datalist", userInfoList);
		map.put("allpage",pageInfo.getAllpage());
		Json json = new Json();
		json.setObj(map);
		json.setMsg("查询成功！");
		writeJson(json);

	}
	public String queryedit() {
		userInfo = (UserInfo) service.getById(getId());
		log.info(userInfo+"======"+getId());
		 getRequest().setAttribute("uid", getId());
		 getRequest().setAttribute("userinfo", userInfo);
		return "edit";

	}


	public void update(){
		userInfo.setUid(getId());
		Json json = new Json();
		try{
			service.update(userInfo);
			json.setSuccess(true);
			json.setMsg("更新成功！");
		}catch(HibernateException e){
			json.setMsg("更新失败！");
		}
		writeJson(json);
	}
	public String querydetail() {

		return "detail";
	}
	public void delete(){


	}


}
