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

import com.appcrews.javaee.maicai.model.PageInfo;
import com.appcrews.javaee.maicai.service.dataService;
import com.appcrews.javaee.maicai.tool.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller
public class ManagerAction extends ActionSupport implements ModelDriven<WareInfo> {
    @Autowired
    private dataService dataService;
    private WareInfo info = new WareInfo();
    private Map map;
    private PageInfo pageInfo=PageInfo.getPageInfo();
    private int ts;
    private int sort=-1;
    private  TypeInfo typeInfo;
    private String key;
    List<WareInfo> WareInfoList;
    List<TypeInfo> TypeInfoList;
    HttpServletResponse response;
    HttpServletRequest request = ServletActionContext.getRequest();

    public List<WareInfo> getWareInfoList() {
        return WareInfoList;
    }

    public void setWareInfoList(List<WareInfo> WareInfoList) {
        this.WareInfoList = WareInfoList;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public WareInfo getModel() {
        // TODO Auto-generated method stub
        return info;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getSort() {
        return sort;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String search() {
        map = new HashMap();
        this.response = ServletActionContext.getResponse();
        WareInfoList = dataService.getListWaresearch(key);
        pageInfo.setAllpage(dataService.getcountTotalPage(pageInfo.getPageSize()));
        map.put("datalist", WareInfoList);
        map.put("allpage", pageInfo.getAllpage());
        JSONObject jsonObject = JSONObject.fromObject(map);
         Util.renderData(this.response, jsonObject);
        return "success";
    }

//    public String sort() {
//        response=ServletActionContext.getResponse();
//        WareInfoList = dataService.getListWaresort(pageInfo.getPageNo(),pageInfo.getPageSize(),this.sort);
//        JSONArray jsonArray = JSONArray.fromObject(WareInfoList);
//        System.out.println(jsonArray);
//         Util.renderData(response, jsonArray);
//        return "success";
//    }

//    public void initquery() {
//        response = ServletActionContext.getResponse();
//        pageInfo.setAllpage(dataService.getcountTotalPage(pageInfo.getPageSize()));
//        map = new HashMap();
//        WareInfoList = dataService.getQueryForPage(pageInfo.getPageNo(),pageInfo.getPageSize());
//        map.put("datalist", WareInfoList);
//        map.put("allpage",pageInfo.getAllpage());
//        JSONObject jsonObject = JSONObject.fromObject(map);
//         Util.renderData(response, jsonObject);
//    }

    public String query() {
        return "success";
    }

    public void queryWay() {
        response = ServletActionContext.getResponse();
        pageInfo.setAllpage(dataService.getcountTotalPage(pageInfo.getPageSize()));
        if(sort==-1)
        WareInfoList = dataService.getQueryForPage(pageInfo.getPageNo(),pageInfo.getPageSize());
        else
            WareInfoList = dataService.getListWaresort(pageInfo.getPageNo(),pageInfo.getPageSize(),this.sort);
        map = new HashMap();
        map.put("datalist", WareInfoList);
        map.put("allpage",pageInfo.getAllpage());
        JSONObject jsonObject = JSONObject.fromObject(map);
         Util.renderData(response, jsonObject);

    }

    public String queryedit() {
        info = dataService.getWareInfo(ts);
        TypeInfoList = dataService.getType();
        request.setAttribute("ts", ts);
        request.setAttribute("typeinfo", TypeInfoList);
        request.setAttribute("wareinfo", info);
        return "edit";

    }

//    public String querytype() {
////        TypeInfoList = dataService.gettype();
//        request.setAttribute("typeinfo", TypeInfoList);
//        return "type";
//
//    }
//
//    public String inserttype() {
//        String type = request.getParameter("type");
//        dataService.inserttype(type);
//        request.setAttribute("flag", 1);
//        return "type1";
//    }//插入类型

    public String save() {
        ServletContext sc = ServletActionContext.getServletContext();

        String path = sc.getRealPath("/fileupload");
        String Name = info.getUploadImageFileName();
        typeInfo=dataService.getTypeInfo(info.getType());
        info.setTypeInfo(typeInfo);
        if (Name == null) {
            info.setImg(Name);
            dataService.insert(info);
            return "success";
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
        dataService.insert(info);
        return "success";

    }

    public String delet() throws SQLException {
        response = ServletActionContext.getResponse();
        if ((dataService.delete(ts))!=0) {
            dataService.delete(ts);
            Util.renderData(response, "success");
            return "success";
        } else {
           Util.renderData(response, "error");
            return "input1";
        }
    }

    public String insert() {
        TypeInfoList = dataService.getType();
        request.setAttribute("typeinfo", TypeInfoList);
        return "insert";

    }

    public String edit() {
        try {
            String Name = info.getUploadImageFileName();
            typeInfo=dataService.getTypeInfo(info.getType());
            info.setTypeInfo(typeInfo);
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
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return "false";
        }
        return "success";
    }



}
