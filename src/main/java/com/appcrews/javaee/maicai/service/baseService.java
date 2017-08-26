package com.appcrews.javaee.maicai.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by micheal on 2017/8/25.
 */
public interface baseService<T> {
    /**
     * 保存一个对象
     *
     * @param o
     *            对象
     * @return 对象的ID
     */
    public Serializable save(T o);

    /**
     * 删除一个对象
     *
     * @param o
     *            对象
     */
    public void delete(T o);

    /**
     * 更新一个对象
     *
     * @param o
     *            对象
     */
    public void update(T o);

    /**
     * 保存或更新一个对象
     *
     * @param o
     *            对象
     */
    public void saveOrUpdate(T o);
    /**
     * 获取记录数
     *
     * @param o
     *
     */
    public int length();
    /**
     * 通过主键获得对象
     *
     * @param c
     *            类名.class
     * @param id
     *            主键
     * @return 对象
     */
    public T getById(Serializable id);
    /**
     * 获得分页后的对象列表
     *
     * @param hql
     *            HQL语句
     * @param page
     *            要显示第几页
     * @param rows
     *            每页显示多少条
     * @return List
     */
    int getcountTotalPage(int pagesize);

}
