package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface Data {
//    List<WareInfo> getList(int index);
    List<WareInfo> getListWare(String key);
//    List<WareInfo> getListsort(String name);
    List<WareInfo> getListWare(int pageNo,int pageSize,int flag);//flag 0为down 1为up
    List<WareInfo> getListWare(int pageNo,int pageSize);
    int delete(int id);
    //    List<WareInfo> getListshucai();
//    int getSCid(String name);
//    List<TypeInfo> getType(String TYPE);
//    List<TypeInfo> gettype();
    int getLength();


}
