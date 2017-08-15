package com.appcrews.javaee.maicai.service;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.dal.Data;
import com.appcrews.javaee.maicai.model.WareInfo;
import com.appcrews.javaee.maicai.model.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.prefs.BackingStoreException;

/**
 * Created by micheal on 2017/2/22.
 */
@Transactional
@Service
public class dataServiceImp implements dataService {
@Autowired
    private Data data;

@Autowired
    private BaseDaoI baseDaoI;
    @Override
    public List<WareInfo> getqueryForPage(int pageNo,int pageSize) {
        return data.getListWare(pageNo,pageSize);
    }

    @Override
    public int getcountTotalPage(int pagesize) {
        int length=data.getLength();
        return countTotalPage(pagesize,length);
    }

    @Override
    public List<WareInfo> getListWaresearch(String key) {
        if (data.getListWare(key).size()==0)
            return null;
        else
        return this.data.getListWare(key);
    }


    @Override
    public WareInfo getWareInfo(int id) {
        return (WareInfo) this.baseDaoI.get(WareInfo.class,id);
    }

    @Override
    public List<WareInfo> getListWaresort(int pageNo,  int pageSize,int flag) {
        return this.data.getListWare(pageNo,pageSize,flag);
    }



//    @Override
//    public List<TypeInfo> getType(String TYPE) {
//        return this.data.getType(TYPE);
//    }
//
//    @Override
//    public List<TypeInfo> gettype() {
//        return this.data.gettype();
//    }
//
//    @Override
//    public void inserttype(String type) {
//        this.data.inserttype(type);
//    }

    @Override
    public void insert(WareInfo info) {
        this.baseDaoI.save(info);
    }

    @Override
    public void update(int id, WareInfo info) throws SQLException {
    this.baseDaoI.update(info);
    }



    @Override
    public int delete(int id) throws SQLException {
        return data.delete(id);
    }
    public static int countTotalPage(final int pageSize, final int allRow) {
              int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
              return totalPage;
    }
}
