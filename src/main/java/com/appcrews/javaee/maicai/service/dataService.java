package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
public interface dataService {
    int getcountTotalPage(int pagesize);
    List<WareInfo> getqueryForPage(int pageno,int pagesize);
    List<WareInfo> getListWaresort(int pageNo, int pageSize,int flag);
    List<WareInfo> getListWaresearch(String key);
    WareInfo  getWareInfo(int id);
    void update(int id, WareInfo info) throws SQLException;
    int delete(int id) throws SQLException;
    void insert(WareInfo info);
    List getType();
    TypeInfo getTypeInfo(int id);



}
