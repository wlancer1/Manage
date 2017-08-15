package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
public interface dataService {
    List<WareInfo> getqueryForPage(int pageno,int pagesize);
    int getcountTotalPage(int pagesize);
    List<WareInfo> getListWaresort(int pageNo, int pageSize,int flag);
    List<WareInfo> getListWaresearch(String key);
    void update(int id, WareInfo info) throws SQLException;
    int delete(int id) throws SQLException;
    WareInfo getWareInfo(int id);
    void insert(WareInfo info);

//    List<TypeInfo> getType(String TYPE);
//    List<TypeInfo> gettype();
//    void inserttype(String type);


}
