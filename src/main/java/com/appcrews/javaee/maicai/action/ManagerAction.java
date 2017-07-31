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

import com.appcrews.javaee.maicai.service.dataService;
import com.appcrews.javaee.maicai.tool.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
    private Map map;
    private int de, ts;
    private int index, allpage, pageNo, pageSize = 5,sort;
    private String key;
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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getAllpage() {
        return allpage;
    }

    public void setAllpage(int allpage) {
        this.allpage = allpage;
    }

    public ShucaiInfo getModel() {
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

    public String search() {
        map = new HashMap();
        this.response = ServletActionContext.getResponse();
        info1 = dataService.getListsearch(key);

        if(info1==null){
            map.put("datalist", "null");
            allpage=0;
          }
        else{
            map.put("datalist", info1);
            allpage = (((info1.size()-1) / this.pageSize) + 1);
        }

        map.put("allpage", allpage);
        JSONObject jsonObject = JSONObject.fromObject(map);
         Util.renderData(this.response, jsonObject);
        return "success";

    }

    public String sort() {
        response=ServletActionContext.getResponse();
        index = (pageNo - 1) * this.pageSize;
        if (this.sort==1) {
            info1 = dataService.getListshucaisort(pageNo, 1,this.pageSize);
        } else {
            info1 = dataService.getListshucaisort(pageNo, 0,this.pageSize);
        }
        JSONArray jsonArray = JSONArray.fromObject(info1);
        System.out.print(jsonArray);
         Util.renderData(response, jsonArray);
        return "success";
    }

    public void initquery() {
        response = ServletActionContext.getResponse();
        allpage = (((dataService.getListshucai().size() -1)/ this.pageSize) + 1);
        map = new HashMap();
        index = (pageNo - 1) * this.pageSize;
        info1 = dataService.getList(index);
        map.put("datalist", info1);
        map.put("allpage", allpage);
        JSONObject jsonObject = JSONObject.fromObject(map);
         Util.renderData(response, jsonObject);
    }

    public String query() {

        allpage = (((dataService.getListshucai().size() -1)/ this.pageSize) + 1);
        return "success";

    }

    public void fanye() {
        response = ServletActionContext.getResponse();
        index = (pageNo - 1) * this.pageSize;
        info1 = dataService.getList(index);
        JSONArray jsonArray = JSONArray.fromObject(info1);
         Util.renderData(response, jsonArray);

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

    public String querytype() {
        info2 = dataService.gettype();
        request.setAttribute("typeinfo", info2);
        return "type";

    }

    public String inserttype() {
        String type = request.getParameter("type");
        dataService.inserttype(type);
        request.setAttribute("flag", 1);
        return "type1";
    }//插入类型

    public String save() {

        ServletContext sc = ServletActionContext.getServletContext();

        String path = sc.getRealPath("/fileupload");
        String Name = info.getUploadImageFileName();
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
        de = Integer.parseInt(ServletActionContext.getRequest().getParameter(
                "de"));
        response = ServletActionContext.getResponse();
        if ((dataService.delete(de)).equals("success")) {
            dataService.delete(de);
            Util.renderData(response, "success");
            return "success";
        } else {
           Util.renderData(response, "error");
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
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
        return "success";
    }



}
