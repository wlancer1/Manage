package com.appcrews.javaee.maicai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.appcrews.javaee.maicai.dal.Orderimpl;
import com.appcrews.javaee.maicai.dal.Dataimpl;
import com.appcrews.javaee.maicai.dal.Userimpl;
import com.appcrews.javaee.maicai.model.DetailInfo;
import com.appcrews.javaee.maicai.model.OrderInfo;
import com.appcrews.javaee.maicai.model.SaleInfo;
import com.appcrews.javaee.maicai.model.ShucaiInfo;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderAction extends ActionSupport {
	HttpServletRequest request = ServletActionContext.getRequest();
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"/applicationContext.xml");
	Orderimpl o = (Orderimpl) context.getBean("dingdanaction");
	Dataimpl s = (Dataimpl) context.getBean("shucaiaction");
	Userimpl u = (Userimpl) context.getBean("useraction");
	int allpage, index = 0;
	List<OrderInfo> info1;
	List<DetailInfo> info2;
	List<ShucaiInfo> info3;
	List<String> namelist;

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

	List<String> SCnumlist;

	public String query() {
		int pagenow = 0;
		if (request.getParameter("pagenow") != null) {
			pagenow = Integer.parseInt(request.getParameter("pagenow"));
		} else {
			pagenow = 1;
		}
		allpage = ((o.getListorder().size() / 5) + 1);
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
		info1 = o.getList(index);
		request.setAttribute("orderinfo", info1);
		return "success";

	}

	public int size() {
		int size = o.getListorder().size();
		return size;
	}

	public String save() {
		int onum = Integer.parseInt(request.getParameter("onum"));
		for (int i = 0; i < SCnumlist.size(); i++) {
			int number = Integer.parseInt(SCnumlist.get(i));
			String name = namelist.get(i);
			int SCid = 0;
			SCid = s.getSCid(name);
			o.update(number, SCid, onum, i);
		}
		return edit1("" + onum);

	}

	public String edit() {
		float sum = 0;
		int onum = Integer.parseInt(request.getParameter("ts"));// 得到订单号
		info2 = o.getListdetailorder(onum);// 向defaultinfo中输入蔬菜数量和蔬菜id
		sum = set();
		request.setAttribute("nameinfo", info3);
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		request.setAttribute("sum", sum);
		return "edit";

	}

	public String delet() {
		String onum = request.getParameter("de");
		int id = Integer.parseInt(request.getParameter("scid"));
		o.delete(id, onum);
		edit1(onum);
		return "edit";

	}

	public String deletorder() {
		String onum = request.getParameter("de");
		o.deleteorder(onum);
		return query();

	}

	public float set() {
		float sum = 0;
		ShucaiInfo shucai = new ShucaiInfo();
		for (int i = 0; i < info2.size(); i++) {
			shucai = s.getShucaiInfo(info2.get(i).getSCid());
			info2.get(i).setImg(shucai.getImg());// 蔬菜图片
			info2.get(i).setName(shucai.getName());// 蔬菜名字
			info2.get(i).setPrice(shucai.getPrice());// 蔬菜价格
			info2.get(i).setID(shucai.getId());
			info3 = s.getListsort((shucai.getName()));
			sum = (shucai.getPrice()) * (info2.get(i).getSCnum()) + sum;
		}
		return sum;

	}

	public String print() {
		float sum = 0;
		int onum = Integer.parseInt(request.getParameter("ts"));
		info2 = o.getListdetailorder(onum);
		OrderInfo order = o.getOrderInfo(onum);
		SaleInfo sale = u.getsaleinfo(order.getUserID());
		String name=sale.getSaddress();
		request.setAttribute("tele", sale.getTele());
		request.setAttribute("name", name);
		request.setAttribute("time", order.getOtime());
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		sum = set();
		request.setAttribute("sum", sum);
		return "print";
	}

	public String edit1(String num) {
		float sum;
		int onum = Integer.parseInt(num);// 得到订单号
		info2 = o.getListdetailorder(onum);// 向defaultinfo中输入蔬菜数量和蔬菜id
		sum = set();
		request.setAttribute("nameinfo", info3);
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		request.setAttribute("sum", sum);
		return "edit";

	}

	public String detailquery() {
		float sum = 0;
		int onum = Integer.parseInt(request.getParameter("ts"));
		info2 = o.getListdetailorder(onum);
		sum = set();
		request.setAttribute("num", onum);
		request.setAttribute("detailinfo", info2);
		request.setAttribute("sum", sum);
		return "detail";

	}

}
