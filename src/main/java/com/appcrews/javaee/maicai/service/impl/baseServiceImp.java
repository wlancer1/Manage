package com.appcrews.javaee.maicai.service.impl;

import com.appcrews.javaee.maicai.dal.BaseDaoI;
import com.appcrews.javaee.maicai.model.base.PageInfo;
import com.appcrews.javaee.maicai.service.baseService;
import com.appcrews.javaee.maicai.tool.HqlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by micheal on 2017/8/25.
 */
@Transactional
@Service
public class baseServiceImp<T> implements baseService<T> {
    @Autowired
    BaseDaoI baseDaoI;
    @Override
    public Serializable save(Object o) {
        return baseDaoI.save(o);
    }

    @Override
    public void delete(Object o) {
            baseDaoI.delete(o);
    }

    @Override
    public void update(Object o) {
        baseDaoI.update(o);
    }

    @Override
    public void saveOrUpdate(Object o) {
baseDaoI.saveOrUpdate(o);
    }

    @Override
    public int length() {
        String className = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
        String hql = "select count(*) from " + className ;
        return baseDaoI.count(hql);
    }
    @Override
    public T getById(Serializable id) {
        Class<T> c = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return (T) baseDaoI.get(c, id);
    }
    @Override
    public int getcountTotalPage(int pagesize) {
        return PageInfo.countTotalPage(pagesize,length());
    }
    @Override
    public List<T> find(int page, int rows) {
        return findByFilter(new HqlFilter(), page, rows);
    }

    @Override
    public List<T> findByFilter(HqlFilter hqlFilter, int page, int rows) {
        String className = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
        String hql = "select distinct t from " + className + " t";//去重
//       System.out.println(hql+hqlFilter.getWhereAndOrderHql());

        return baseDaoI.find(hql + hqlFilter.getWhereAndOrderHql(), hqlFilter.getParams(), page, rows);
    }

}
