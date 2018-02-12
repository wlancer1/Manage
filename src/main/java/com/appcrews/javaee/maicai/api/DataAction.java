package com.appcrews.javaee.maicai.api;

import com.appcrews.javaee.maicai.action.BaseAction;
import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.dataService;
import com.appcrews.javaee.maicai.tool.BaseConfig;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller()
public class DataAction extends BaseAction implements ModelDriven<WareInfo> {

    private WareInfo info = new WareInfo();
    List<WareInfo> WareInfoList;
    private Map map;
    private int pageNo;
    @Autowired
    public void setService(dataService service) {
        this.service = service;
    }

    public WareInfo getModel() {
        // TODO Auto-generated method stub
        return info;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    //分页查询
    public void query() {
        Json json = new Json();
        pageInfo.setAllpage(service.getcountTotalPage(pageInfo.getPageSize()));
        WareInfoList = service.find(this.pageNo,pageInfo.getPageSize());
        BaseConfig.setHeader(getResponse());
        json.setSuccess(true);
        json.setMsg(pageInfo.getAllpage()+"");
        json.setObj(WareInfoList);
        writeJson(json);
    }
    public String test(){
        return  "success";
    }





}
