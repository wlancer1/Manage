package com.appcrews.javaee.maicai.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.orderService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;
import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class OrderAction extends BaseAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	private orderService orderService;
//	int allpage, pageSize=5;
	List<OrderInfo> OrderInfoList;
//	List<DetailInfo> info2;
//	List<WareInfo> info3;
	private OrderInfo orderInfo;
	Map map;
	private Set<DetailInfo> detailInfo;
	@Autowired
	public void setService(orderService service) {
		this.service = service;
	}



	public String query() {

		return "success";

	}
	public  void queryWay(){
		Json json = new Json();
		pageInfo.setAllpage(service.getcountTotalPage(pageInfo.getPageSize()));
			OrderInfoList = service.find(pageInfo.getPageNo(),pageInfo.getPageSize());
		map = new HashMap();
		map.put("datalist", OrderInfoList);
		map.put("allpage",pageInfo.getAllpage());
		json.setSuccess(true);
		json.setMsg("查询成功！");
		json.setObj(map);
		writeJson(json);

	}

//	public int size() {
//		int size = orderService.getListorder().size();
//		return size;
//	}

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
		orderInfo=((orderService)service).getDetail(getId());

		getRequest().setAttribute("editDetail", orderInfo);
		getRequest().setAttribute("sum", sum);
		return "edit";

	}

	public void deletWare() {
		Json json = new Json();
		int wareid = Integer.parseInt(getRequest().getParameter("wareid"));
		((orderService)service).wareDelete(id, wareid);
		json.setSuccess(true);
		json.setMsg("删除成功！");
		json.setObj(map);
		writeJson(json);

	}
//
//	public String deletorder() {
//		String onum = request.getParameter("de");
//		orderService.deleteorder(onum);
//		return query();
//
//	}
//
//
//	public String print() {
//		float sum = 0;
//		int onum = Integer.parseInt(request.getParameter("ts"));
//		info2 = orderService.getListdetailorder(onum);
//		OrderInfo order = orderService.getOrderInfo(onum);
//		SaleInfo sale = orderService.getsaleinfo(order.getUserID());
//		String name=sale.getSaddress();
//		request.setAttribute("tele", sale.getTele());
//		request.setAttribute("name", name);
//		request.setAttribute("time", order.getOtime());
//		request.setAttribute("num", onum);
//		request.setAttribute("detailinfo", info2);
//		request.setAttribute("sum", sum);
//		return "print";
//	}

	public String detailquery() {
		orderInfo=((orderService)service).getDetail(getId());
		getRequest().setAttribute("OrderDetail", orderInfo);
		return "detail";

	}

}
