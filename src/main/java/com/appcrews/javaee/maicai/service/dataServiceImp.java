package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.Data;
import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by micheal on 2017/2/22.
 */
@Service
public class dataServiceImp implements dataService {
@Autowired
    private Data data;
    @Override
    public List<WareInfo> getList(int index) {
        return data.getList(index);
    }

    @Override
    public List<WareInfo> getListsearch(String key) {
        if (data.getListsearch(key).size()==0)
            return null;
        else
        return this.data.getListsearch(key);
    }

    @Override
    public List<WareInfo> getListsort(String name) {
        return null;
    }

    @Override
    public WareInfo getShucaiInfo(int id) {
        return this.data.getShucaiInfo(id);
    }

    @Override
    public List<WareInfo> getListshucaisort(int index, int flag, int pageSize) {
        return this.data.getListshucaisort(index,flag,pageSize);
    }

    @Override
    public List<WareInfo> getListshucai() {
        return data.getListshucai();
    }

    @Override
    public int getSCid(String name) {
        return 0;
    }

    @Override
    public List<TypeInfo> getType(String TYPE) {
        return this.data.getType(TYPE);
    }

    @Override
    public List<TypeInfo> gettype() {
        return this.data.gettype();
    }

    @Override
    public void inserttype(String type) {
        this.data.inserttype(type);
    }

    @Override
    public void insert(WareInfo info) {
        this.data.insert(info);
    }

    @Override
    public void update(int id, WareInfo info) throws SQLException {
    this.data.update(id,info);
    }



    @Override
    public String delete(int id) throws SQLException {
        return this.data.delete(id);
    }
}
