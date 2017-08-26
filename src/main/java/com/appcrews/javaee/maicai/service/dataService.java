package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.model.base.TypeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
public interface dataService  extends baseService<WareInfo>{
    List<WareInfo> getQueryForPage(int pageno,int pagesize);
    List<WareInfo> getListWaresort(int pageNo, int pageSize,int flag);
    List<WareInfo> getListWaresearch(String key);
//    void update(int id, WareInfo info) throws SQLException;
//    int delete(int id) throws SQLException;
//    void insert(WareInfo info);
    List getType();
    TypeInfo getTypeInfo(int id);



}
