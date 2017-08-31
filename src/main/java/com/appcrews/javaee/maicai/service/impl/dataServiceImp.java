package com.appcrews.javaee.maicai.service.impl;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.dal.Data;
import com.appcrews.javaee.maicai.model.base.PageInfo;
import com.appcrews.javaee.maicai.model.base.WareInfo;
import com.appcrews.javaee.maicai.model.base.TypeInfo;
import com.appcrews.javaee.maicai.service.dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
@Transactional
@Service
public class dataServiceImp extends baseServiceImp<WareInfo> implements dataService {
@Autowired
    private Data data;

@Autowired
    private BaseDaoI baseDaoI;

    @Override
    public List<TypeInfo> getType() {
        return this.data.getListType();
    }

    @Override
    public TypeInfo getTypeInfo(int id) {

        return (TypeInfo) baseDaoI.get(TypeInfo.class,id);
    }

    @Override
    public int saveType(TypeInfo typeInfo) {
        try {
            this.baseDaoI.save(typeInfo);
            return 1;
        }catch(Exception e){
            return 0;
        }

    }
    //
//    @Override
//    public void inserttype(String type) {
//        this.data.inserttype(type);
//    }

//    @Override
//    public void insert(WareInfo info) {
//        this.baseDaoI.save(info);
//    }
//
//    @Override
//    public void update(int id, WareInfo info) throws SQLException {
//        info.setId(id);
//        this.baseDaoI.update(info);
//    }


//    @Override
//    public int delete(int id) throws SQLException {
//        return data.delete(id);
//    }

}
