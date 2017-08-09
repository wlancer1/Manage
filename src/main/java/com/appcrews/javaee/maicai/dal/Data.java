package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface Data {
    List<WareInfo> getList(int index);
    List<WareInfo> getListsearch(String key);
    List<WareInfo> getListsort(String name);
    WareInfo getShucaiInfo(int id);
    List<WareInfo> getListshucaisort(int index, int flag, int pageSize);
    List<WareInfo> getListshucai();
    int getSCid(String name);
    List<TypeInfo> getType(String TYPE);
    List<TypeInfo> gettype();
    void inserttype(String type);
    void insert(WareInfo info);
    void update(int id, WareInfo info) throws SQLException;
    String delete(int id) throws SQLException;


}
