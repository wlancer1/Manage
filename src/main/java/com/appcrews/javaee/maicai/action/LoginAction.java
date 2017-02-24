package com.appcrews.javaee.maicai.action;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<AdminInfo> {
	private List<AdminInfo> info;
	private List<Integer> size;
	private Cookie[] cookies ;
	private HttpServletResponse response;
	private HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	private adminService adminService;

//	public void setAdminService(adminService adminService) {
//		this.adminService = adminService;
//	}
//
//	public adminService getAdminService() {
//		return adminService;
//	}

	//	ApplicationContext context = new ClassPathXmlApplicationContext(
//			"/applicationContext.xml");
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

	public void setSize(List<Integer> size) {
		this.size = size;
	}

	public List<Integer> getSize() {
		return size;
	}

//	Adminimpl a = (Adminimpl) context.getBean("adminaction");

	@Override
	public AdminInfo getModel() {
		// TODO Auto-generated method stub
		return (AdminInfo) info;
	}

	public String login() throws UnsupportedEncodingException {
		int power;
		String quanxian = null;
        response=ServletActionContext.getResponse();
		if(request.getSession().getAttribute("myname")!=null){
			return "success";
		}
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
		power = this.adminService.panduan(ma,mp);
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
			request.getSession().setAttribute("sizelist",size());
			request.getSession().setAttribute("power", quanxian);
            request.getSession().setAttribute("myname", this.account);
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("loginInfo")){
					Cookie delCookie = new Cookie("loginInfo", "***");
					delCookie.setPath("/");
					response.addCookie(delCookie);
					break;
				}
			}
			return "success";
		}

	}
	public List size(){
		size=new ArrayList<Integer>();
		size=this.adminService.sizeList();
		return size;
	}
}
