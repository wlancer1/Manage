package com.appcrews.javaee.maicai.action;

import com.appcrews.javaee.maicai.model.base.ShopInfo;
import com.appcrews.javaee.maicai.model.base.UserInfo;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.baseService;
import com.appcrews.javaee.maicai.service.shopService;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by micheal on 2017/9/1.
 */
@Controller
public class ShopAction extends BaseAction implements ModelDriven<ShopInfo> {
    ShopInfo shopInfo=new ShopInfo();
    Map map;
@Autowired
    public void setService(shopService service) {
    this.service=service;
    }

    public void queryWay() {
        map=new HashMap();
        pageInfo.setAllpage(service.getcountTotalPage(pageInfo.getPageSize()));
        map.put("datalist",service.find(pageInfo.getPageNo(),pageInfo.getPageSize()) );
        map.put("allpage",pageInfo.getAllpage());
        Json json = new Json();
        json.setObj(map);
        json.setMsg("查询成功！");
        writeJson(json);

    }
    public String query() {

        return "success";
    }

    @Override
    public ShopInfo getModel() {
        return shopInfo;
    }

}
