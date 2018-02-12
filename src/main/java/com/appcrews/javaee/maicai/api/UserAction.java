package com.appcrews.javaee.maicai.api;

import com.appcrews.javaee.maicai.action.BaseAction;
import com.appcrews.javaee.maicai.model.base.UserInfo;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.userService;
import com.appcrews.javaee.maicai.tool.BaseConfig;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("apiUser")
public class UserAction extends BaseAction implements ModelDriven<UserInfo> {//繼承model驱动注入参数


 	private UserInfo userInfo=new UserInfo();
	@Autowired
	public void setService(userService service) {

		this.service = service;
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

//	public void resgiter(){
//		if (userInfo.getName()!=null&&userInfo.getPassword()!=null)
//			service.save(userInfo);
//
//	}
	public void login()  {
        int uid=((userService)service).validate(userInfo.getName(),userInfo.getPassword());
        Json json = new Json();
        if(uid !=-1){
            userInfo=((userService) service).getById(uid);
            json.setSuccess(true);
            json.setMsg("登陆成功！");
        }else{
            json.setMsg("登陆失败！账号或者密码错误。");
        }
        BaseConfig.setHeader(getResponse());//解决跨域问题
		json.setObj(userInfo);
		writeJson(json);

	}
	public  void queryUser(){
		Json json = new Json();
		userInfo=((userService) service).getById(userInfo.getUid());
		json.setSuccess(true);
		BaseConfig.setHeader(getResponse());
		json.setObj(userInfo);
		writeJson(json);
	}



}
