package com.appcrews.javaee.maicai.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appcrews.javaee.maicai.service.dataService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appcrews.javaee.maicai.dal.Dataimpl;
import com.appcrews.javaee.maicai.model.ShucaiInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller
public class ManagerAction extends ActionSupport implements ModelDriven<ShucaiInfo> {
	@Autowired
	private dataService dataService; 
	private ShucaiInfo info = new ShucaiInfo();
	int de, ts;
	int index, allpage;
	List<ShucaiInfo> info1;
	List<TypeInfo> info2;
    HttpServletResponse response;
	HttpServletRequest request = ServletActionContext.getRequest();

	public List<ShucaiInfo> getInfo1() {
		return info1;
	}

	public void setInfo1(List<ShucaiInfo> info1) {
		this.info1 = info1;
	}

	

	public ShucaiInfo getModel() {
		// TODO Auto-generated method stub
		return info;
	}

	public int fenye() {
		int pagenow = 0;
		if (request.getParameter("pagenow") != null) {
			pagenow = Integer.parseInt(request.getParameter("pagenow"));
		} else {
			pagenow = 1;
		}

		allpage = ((dataService.getListshucai().size() / 5) + 1);
		if (request.getParameter("flag") != null) {
			if (request.getParameter("flag").equals("0")) {
				if (pagenow != 1) {
					pagenow--;
				}
			} else if (request.getParameter("flag").equals("1")) {
				if (pagenow != allpage) {
					pagenow++;
				}
			}
		}
		return pagenow;
	}

	public String search() {
		int pagenow = fenye();
		request.setAttribute("page", allpage);// 总页数
		request.setAttribute("pagenow", pagenow);
		index = (pagenow - 1) * 5;
		String key = request.getParameter("key");
		request.setAttribute("moren", key);
		info1 = dataService.getListsearch(key);
		request.setAttribute("shucaiinfo", info1);
		return "success";

	}

	public String sort() {
		int pagenow = fenye();
		request.setAttribute("page", allpage);// 总页数
		request.setAttribute("pagenow", pagenow);
		index = (pagenow - 1) * 5;
		String target = request.getParameter("target");
		if (target.equals("up")) {
			info1 = dataService.getListshucaisort(pagenow, 1);
		} else {
			info1 = dataService.getListshucaisort(pagenow, 0);
		}
		request.setAttribute("shucaiinfo", info1);
		return "success";

	}

	public String query() {
		int pagenow = fenye();
		request.setAttribute("page", allpage);// 总页数
		request.setAttribute("pagenow", pagenow);
		index = (pagenow - 1) * 5;
		// 现在要查询的
		info1 = dataService.getList(index);
		request.setAttribute("shucaiinfo", info1);
		return "success";

	}

	public String queryedit() {
		ts = Integer.parseInt(ServletActionContext.getRequest().getParameter(
				"ts"));
		info = dataService.getShucaiInfo(ts);
		String type = info.getType();
		info2 = dataService.getType(type);
		request.setAttribute("ts", ts);
		request.setAttribute("typeinfo", info2);
		request.setAttribute("shucaiinfo", info);
		return "edit";

	}
public String querytype(){
	info2 = dataService.gettype();
	request.setAttribute("typeinfo", info2);
	return "type";
	
}
public String inserttype(){
	String type=request.getParameter("type");
	dataService.inserttype(type);
	request.setAttribute("flag", 1);
	return "type1";
}//插入类型
	public String save() {

		ServletContext sc = ServletActionContext.getServletContext();

		String path = sc.getRealPath("/fileupload");
		String Name = info.getUploadImageFileName();
		File file = new File(path, Name);
		File uploadimage = info.getUploadImage();
		try {
			FileUtils.copyFile(uploadimage, file);
			uploadimage.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		info.setImg(Name);
		dataService.insert(info);
		query();
		return "success";

	}

	public String delet() throws SQLException {
		de = Integer.parseInt(ServletActionContext.getRequest().getParameter(
				"de"));
        System.out.println(de);
        response=ServletActionContext.getResponse();
		if ((dataService.delete(de)).equals("success")) {
            dataService.delete(de);
			renderData(response,"success");
			return "success";
		} else {
            renderData(response,"error");
			return "input1";
		}
	}

	public int size() {
		int size = dataService.getListshucai().size();
		return size;
	}

	public String insert() {
		info2 = dataService.gettype();
		request.setAttribute("typeinfo", info2);
		return "insert";

	}

	public String edit() {
		try {
			ts = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("ts"));
			String Name = info.getUploadImageFileName();
			if (Name != null) {
				ServletContext sc = ServletActionContext.getServletContext();
				String path = sc.getRealPath("/fileupload");
				File file = new File(path, Name);
				File uploadimage = info.getUploadImage();
				try {
					FileUtils.copyFile(uploadimage, file);
					uploadimage.delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
				info.setImg(Name);
				dataService.update(ts, info);
			} else {
				dataService.update(ts, info);
				query();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
		query();
		return "success";
	}
    private void renderData(HttpServletResponse response, String data) {
        PrintWriter printWriter = null;
        response.setContentType("text/html;charset=utf-8");
        try {
            printWriter = response.getWriter();
            printWriter.print(data);
        } catch (IOException ex) {
            Logger.getLogger("ajax").log(Level.SEVERE, null, ex);
        } finally {
            if (null != printWriter) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }

}