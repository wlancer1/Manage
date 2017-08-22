package com.appcrews.javaee.maicai.action;



import javax.servlet.http.HttpServletRequest;

import com.appcrews.javaee.maicai.validation.BaseValidator;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.appcrews.javaee.maicai.model.AdminInfo;
import com.appcrews.javaee.maicai.tool.MD5;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.appcrews.javaee.maicai.service.adminService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<AdminInfo> {
	private List<Integer> size;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private AdminInfo adminInfo=new AdminInfo();
	@Autowired
	private adminService adminService;
	@Autowired
	private BaseValidator baseValidator;
	private Map Result;


	public void setSize(List<Integer> size) {
		this.size = size;
	}

	public List<Integer> getSize() {
		return size;
	}


	@Override
	public AdminInfo getModel() {
		// TODO Auto-generated method stub
		return adminInfo;
	}

	public Map getResult() {
		return Result;
	}

	public void setResult(Map result) {
		Result = result;
	}

	public String login() throws UnsupportedEncodingException {
		int power;
		String quanxian = null;
		if(request.getSession().getAttribute("myname")!=null){
			return "success";
		}
		Result= baseValidator.validateModel(adminInfo);
		if(Result.size()!=0)
				return "false";

		String mp=MD5.Encrypt(this.adminInfo.getPassword(), this.adminInfo.getPassword().length());
		power = this.adminService.validate(this.adminInfo.getAccount(),mp);
		if (power == -1) {
			Result.put("fail","账号或者密码错误，请重新输入！");
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
			request.getSession().setAttribute("sizelist",this.adminService.sizeList());
			request.getSession().setAttribute("power", quanxian);
            request.getSession().setAttribute("myname", this.adminInfo.getAccount());
			return "success";
		}

	}

}
