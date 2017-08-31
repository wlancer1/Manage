package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.model.base.TypeInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
public interface dataService  extends baseService<WareInfo>{

    List getType();
    TypeInfo getTypeInfo(int id);
    int saveType(TypeInfo typeInfo);



}
