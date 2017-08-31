package com.appcrews.javaee.maicai.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appcrews.javaee.maicai.model.base.PageInfo;
import com.appcrews.javaee.maicai.model.easyui.Json;
import com.appcrews.javaee.maicai.service.dataService;
import com.appcrews.javaee.maicai.tool.HqlFilter;
import com.appcrews.javaee.maicai.tool.Util;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.model.base.TypeInfo;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller
public class ManagerAction extends BaseAction implements ModelDriven<WareInfo> {

    private WareInfo info = new WareInfo();
    private Map map;
    private  TypeInfo typeInfo;
    private String key;
    List<WareInfo> WareInfoList;
    List<TypeInfo> TypeInfoList;
    private String leibie;

    @Autowired
    public void setService(dataService service) {
        this.service = service;
    }

    public List<WareInfo> getWareInfoList() {
        return WareInfoList;
    }

    public void setWareInfoList(List<WareInfo> WareInfoList) {
        this.WareInfoList = WareInfoList;
    }

    public WareInfo getModel() {
        // TODO Auto-generated method stub
        return info;
    }


    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }




    public String search() {
        map = new HashMap();
        Json json = new Json();
        HqlFilter hqlFilter=new HqlFilter();
        hqlFilter.addFilter("QUERY_t#name_S_LK",key);
        WareInfoList =service.findByFilter(hqlFilter,pageInfo.getPageNo(),pageInfo.getPageSize());
        map.put("datalist", WareInfoList);
        map.put("allpage", 1);
        json.setSuccess(true);
        json.setMsg("搜索成功！");
        json.setObj(map);
        writeJson(json);
        return "success";
    }


    public String query() {
        return "success";
    }

    public void queryWay() {
        Json json = new Json();
        pageInfo.setAllpage(service.getcountTotalPage(pageInfo.getPageSize()));
        if(sort!=null){
            HqlFilter hqlFilter=new HqlFilter();
            hqlFilter.addOrder(order);
            hqlFilter.addOrder(sort);
            WareInfoList = service.findByFilter(hqlFilter,pageInfo.getPageNo(),pageInfo.getPageSize());
        } else
            WareInfoList = service.find(pageInfo.getPageNo(),pageInfo.getPageSize());

        map = new HashMap();
        map.put("datalist", WareInfoList);
        map.put("allpage",pageInfo.getAllpage());
        json.setSuccess(true);
        json.setMsg("查询成功！");
        json.setObj(map);
        writeJson(json);

    }

    public String queryedit() {
        info =(WareInfo) service.getById(getId());
        TypeInfoList = ((dataService)service).getType();
        getRequest().setAttribute("ts", getId());
        getRequest().setAttribute("typeinfo", TypeInfoList);
        getRequest().setAttribute("wareinfo", info);
        return "edit";

    }

//    public String querytype() {
////        TypeInfoList = ((dataService)service).gettype();
//        getRequest().setAttribute("typeinfo", TypeInfoList);
//        return "type";
//
//    }
//
    public String inserttype() {
        typeInfo=new TypeInfo();
        typeInfo.setType(leibie);
        if(((dataService)service).saveType(typeInfo)==1)
            getRequest().setAttribute("flag", 1);
        else
            getRequest().setAttribute("flag", 0);
        return "type";
    }//插入类型

    public void save() {
        ServletContext sc = ServletActionContext.getServletContext();
        Json json = new Json();
        String path = sc.getRealPath("/fileupload");
        String Name = info.getUploadImageFileName();
        typeInfo=((dataService)service).getTypeInfo(info.getType());
        info.setTypeInfo(typeInfo);
        if (Name == null) {
            info.setImg(Name);
            service.save(info);
            json.setSuccess(true);
            json.setMsg("添加成功！");
            writeJson(json);
            return;
        }
        File file = new File(path, Name);
        File uploadimage = info.getUploadImage();
        try {
            FileUtils.copyFile(uploadimage, file);
            uploadimage.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        info.setImg(Name);
        service.save(info);
        json.setSuccess(true);
        json.setMsg("添加成功！");
        writeJson(json);

    }

    public String delet() throws SQLException {
        json=new Json();
            info.setFid(getId());
        if (service.getById(getId())!=null) {
            service.delete(info);
            json.setMsg("删除成功！");
            json.setSuccess(true);
            writeJson(json);
            return "success";
        } else {
            return "input1";
        }
    }

    public String insert() {
        TypeInfoList = ((dataService)service).getType();
        getRequest().setAttribute("typeinfo", TypeInfoList);
        return "insert";

    }

    public String edit() {
        try {
            String Name = info.getUploadImageFileName();
            typeInfo=((dataService)service).getTypeInfo(info.getType());
            info.setTypeInfo(typeInfo);
            info.setFid(getId());
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

                service.update(info);
            } else {
            service.update(info);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
        return "success";
    }



}
