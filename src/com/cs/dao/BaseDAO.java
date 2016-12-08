package com.cs.dao;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;
import com.cs.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.io.Serializable;

/**
 * Created by 举 on 2016/12/6.
 */
public interface BaseDAO<T> {
    public SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * 添加管理员
     * @param t
     * @return
     */
    public T add(T t);


    /**
     * 根据id查询所有
     * @param id
     * @return
     */
    public T queryById(Serializable id);

    /**
     * 分页查询管理员
     * @param pager
     * @return
     */
    public Pager4EasyUI<T> queryAll(Pager4EasyUI<T> pager);

    /**
     * 查询管理员总数
     * @return
     */
    public int count();

    /**
     * 修改管理员
     * @param t
     */
    public void update(T t);

    /**
     * 删除管理员
     * @param
     */
    public void delete();
}
