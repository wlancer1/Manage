package com.appcrews.javaee.maicai.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.appcrews.javaee.maicai.action.BaseAction;
import com.appcrews.javaee.maicai.model.base.DetailInfo;
import com.appcrews.javaee.maicai.model.base.OrderInfo;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.orderService;
import com.appcrews.javaee.maicai.tool.BaseConfig;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
@Controller("apiOrder")
@Scope("prototype")
public class OrderAction extends BaseAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	private orderService orderService;
//	int allpage, pageSize=5;
	List<OrderInfo> OrderInfoList;
//	List<DetailInfo> info2;
	private  DetailInfo detailInfo;
	private int uid;
	private  int length=0;
	private OrderInfo orderInfo;
	private String order;
	Map map;
	private Timestamp timestamp;
	@Autowired
	public void setService(orderService service) {
		this.service = service;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

	@Override
	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String getOrder() {
		return order;
	}

	public  void orderquery(){
		Json json = new Json();
		BaseConfig.setHeader(getResponse());

		OrderInfoList = ((orderService)service).getByuserId(uid);
		map = new HashMap();
		map.put("datalist", OrderInfoList);
		json.setSuccess(true);
		json.setMsg("查询成功！");
		json.setObj(map);
		writeJson(json);

	}



	public void  createorder(){

		try {
			order=getRequestPostData(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BaseConfig.setHeader(getResponse());
		if(order!=null){
			Json json = new Json();
			orderInfo=new OrderInfo();

			System.out.println(order);
			order="["+order+"]";
			JSONArray jsonArray = JSON.parseArray(order);
			uid=jsonArray.getJSONObject(0).getInteger("uid");
			long timenow=System.currentTimeMillis();
			timestamp=new Timestamp(timenow);
			String onum=""+timenow%1000000+uid;
			jsonArray=JSON.parseArray(""+jsonArray.getJSONObject(0).getString("order"));
			orderInfo.setOnum(onum);
			orderInfo.setStime(timestamp);
			orderInfo.setUid(uid);
		for (int i = 0; i < jsonArray.size(); i++) {     //遍历json数组内容
			JSONObject object = jsonArray.getJSONObject(i);
			System.out.println(object.getString("fid")+"======"+object.getString("num"));
			detailInfo=new DetailInfo();
			detailInfo.setOnum(onum);
			detailInfo.setWareid(object.getInteger("fid"));
			detailInfo.setWarenum(object.getInteger("num"));
			orderInfo.getDetailInfo().add(detailInfo);
		}

			service.save(orderInfo);
			json.setSuccess(true);
			json.setMsg(""+onum);
			writeJson(json);
		}


		}

//
	public void detailquery() {
		Json json = new Json();
		String onum =request.getParameter("onum");
		OrderInfoList=((orderService)service).getDetail(onum);
		BaseConfig.setHeader(getResponse());
		map = new HashMap();
		map.put("datalist", OrderInfoList);
		json.setSuccess(true);
		json.setMsg("查询成功！");
		json.setObj(map);
		writeJson(json);

	}
	//解析请求的Json数据
	private String getRequestPostData(HttpServletRequest request) throws IOException {
		int contentLength = request.getContentLength();
		if(contentLength<0){
			return null;
		}
		byte buffer[] = new byte[contentLength];
		for (int i = 0; i < contentLength;) {
			int len = 0;
			try {
				len = request.getInputStream().read(buffer, i, contentLength - i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (len == -1) {
				break;
			}
			i += len;
		}
		return new String(buffer, "utf-8");
	}

}
