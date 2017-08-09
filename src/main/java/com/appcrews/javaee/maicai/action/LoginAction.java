package com.appcrews.javaee.maicai.action;



import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
import java.util.Set;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<AdminInfo> {
	private List<Integer> size;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private AdminInfo adminInfo=new AdminInfo();
	@Autowired
	private adminService adminService;


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


	public String login() throws UnsupportedEncodingException {
		int power;
		String quanxian = null;

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<AdminInfo>> constraintViolations= validator.validate(adminInfo);

		if(constraintViolations.size()!=0)
				return "false";
		if(request.getSession().getAttribute("myname")!=null){
			return "success";
		}
		String ma=MD5.Encrypt(this.adminInfo.getAccount(),this.adminInfo.getAccount().length());
		String mp=MD5.Encrypt(this.adminInfo.getPassword(), this.adminInfo.getPassword().length());
		power = this.adminService.panduan(ma,mp);
		if (power == -1) {
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
			request.getSession().setAttribute("sizelist",size());
			request.getSession().setAttribute("power", quanxian);
            request.getSession().setAttribute("myname", this.adminInfo.getAccount());
			return "success";
		}

	}

	public List size(){
		size=this.adminService.sizeList();
		return size;
	}
}
