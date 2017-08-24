package com.appcrews.javaee.maicai.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appcrews.javaee.maicai.model.PageInfo;
import com.appcrews.javaee.maicai.service.orderService;
import com.appcrews.javaee.maicai.service.userService;
import com.appcrews.javaee.maicai.tool.Util;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private int uuid;
	private List<UserInfo> userInfoList;
 	private  UserInfo userInfo=new UserInfo();
	private HttpServletRequest request ;
	private HttpServletResponse response;
	private Map map;
    private PageInfo pageInfo=PageInfo.getPageInfo();
	private static final Logger log = LogManager.getLogger();

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

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	


	@Override
	public UserInfo getModel() {
		return userInfo;
	}

	public String query() {
		return "success";
	}
	public void queryWay() {
		response=ServletActionContext.getResponse();
		map=new HashMap();
		userInfoList=userService.getQueryForPage(pageInfo.getPageNo(),pageInfo.getPageSize());
		pageInfo.setAllpage(userService.getcountTotalPage(pageInfo.getPageSize()));
		map.put("datalist", userInfoList);
		map.put("allpage",pageInfo.getAllpage());
		JSONObject jsonObject = JSONObject.fromObject(map);
		Util.renderData(response, jsonObject);
	}
	public String queryedit() {
		request=ServletActionContext.getRequest();
		userInfo = userService.getUserInfo(uuid);
		log.info(userInfo+"======"+uuid);
		request.setAttribute("uid", uuid);
		request.setAttribute("userinfo", userInfo);
		return "edit";

	}


	public void update(){
		response=ServletActionContext.getResponse();
		userInfo.setUid(uuid);
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


	}


}
