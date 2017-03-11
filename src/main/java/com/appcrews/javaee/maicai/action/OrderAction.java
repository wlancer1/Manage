package com.appcrews.javaee.maicai.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.appcrews.javaee.maicai.service.orderService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appcrews.javaee.maicai.dal.Orderimpl;
import com.appcrews.javaee.maicai.dal.Dataimpl;
import com.appcrews.javaee.maicai.dal.Userimpl;
import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.ShucaiInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class OrderAction extends ActionSupport {
	HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	private orderService orderService;
	int allpage, index = 0;
	List<OrderInfo> info1;
	List<DetailInfo> info2;
	List<ShucaiInfo> info3;
	List<String> namelist;



	List<String> SCnumlist;

	public String query() {
		int pagenow = 0;
		if (request.getParameter("pagenow") != null) {
			pagenow = Integer.parseInt(request.getParameter("pagenow"));
		} else {
			pagenow = 1;
		}
		allpage = ((orderService.getListorder().size() / 5) + 1);
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
		request.setAttribute("page", allpage);// 总页数
		request.setAttribute("pagenow", pagenow);
		index = (pagenow - 1) * 5;
		// 现在要查询的
		info1 = orderService.getList(index);
		request.setAttribute("orderinfo", info1);
		return "success";

	}

	public int size() {
		int size = orderService.getListorder().size();
		return size;
	}

//	public String save() {
//		int onum = Integer.parseInt(request.getParameter("onum"));
//		for (int i = 0; i < SCnumlist.size(); i++) {
//			int number = Integer.parseInt(SCnumlist.get(i));
//			String name = namelist.get(i);
//			int SCid = 0;
//			SCid = s.getSCid(name);
//			orderService.update(number, SCid, onum, i);
//		}
//		return edit1("" + onum);
//
//	}

	public String edit() {
		float sum = 0;
		int onum = Integer.parseInt(request.getParameter("ts"));// 得到订单号
		info2 = orderService.getListdetailorder(onum);// 向defaultinfo中输入蔬菜数量和蔬菜id
		request.setAttribute("nameinfo", info3);
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		request.setAttribute("sum", sum);
		return "edit";

	}

	public String delet() {
		String onum = request.getParameter("de");
		int id = Integer.parseInt(request.getParameter("scid"));
		orderService.delete(id, onum);
		edit1(onum);
		return "edit";

	}

	public String deletorder() {
		String onum = request.getParameter("de");
		orderService.deleteorder(onum);
		return query();

	}


	public String print() {
		float sum = 0;
		int onum = Integer.parseInt(request.getParameter("ts"));
		info2 = orderService.getListdetailorder(onum);
		OrderInfo order = orderService.getOrderInfo(onum);
		SaleInfo sale = orderService.getsaleinfo(order.getUserID());
		String name=sale.getSaddress();
		request.setAttribute("tele", sale.getTele());
		request.setAttribute("name", name);
		request.setAttribute("time", order.getOtime());
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		request.setAttribute("sum", sum);
		return "print";
	}

	public String edit1(String num) {
		float sum=0;
		int onum = Integer.parseInt(num);// 得到订单号
		info2 = orderService.getListdetailorder(onum);// 向defaultinfo中输入蔬菜数量和蔬菜id
		request.setAttribute("nameinfo", info3);
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		request.setAttribute("sum", sum);
		return "edit";

	}

	public String detailquery() {
		float sum = 0;
		int onum = Integer.parseInt(request.getParameter("ts"));
		info2 = orderService.getListdetailorder(onum);
		System.out.println(info2);
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		return "detail";

	}

	public List<String> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<String> namelist) {
		this.namelist = namelist;
	}

	public List<String> getSCnumlist() {
		return SCnumlist;
	}

	public void setSCnumlist(List<String> sCnumlist) {
		SCnumlist = sCnumlist;
	}
}
