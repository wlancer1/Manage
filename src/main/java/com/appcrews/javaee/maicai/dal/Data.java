package com.appcrews.javaee.maicai.dal;

import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.model.base.TypeInfo;

import java.util.List;

/**
 * Created by micheal on 2017/2/5.
 */
public interface Data {
    List<WareInfo> getListWare(String key);
    List<WareInfo> getListWare(int pageNo,int pageSize,int flag);//flag 0为down 1为up
    List<WareInfo> getListWare(int pageNo,int pageSize);
//    int delete(int id);
    //    List<WareInfo> getListshucai();
//    int getSCid(String name);
//    List<TypeInfo> getListType(String TYPE);
    List<TypeInfo> getListType();
    int getLength();


}
