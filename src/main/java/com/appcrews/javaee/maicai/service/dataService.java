package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.ShucaiInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
public interface dataService {
    List<ShucaiInfo> getList(int index);
    List<ShucaiInfo> getListsearch(String key);
    List<ShucaiInfo> getListsort(String name);
    ShucaiInfo getShucaiInfo(int id);
    List<ShucaiInfo> getListshucaisort(int index, int flag);
    List<ShucaiInfo> getListshucai();
    int getSCid(String name);
    List<TypeInfo> getType(String TYPE);
    List<TypeInfo> gettype();
    void inserttype(String type);
    void insert(ShucaiInfo info);
    void update(int id, ShucaiInfo info) throws SQLException;
    String delete(int id) throws SQLException;
}
