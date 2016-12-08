package com.cs.dao;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Created by 举 on 2016/11/29.
 */
public class SAdminDAOImpl implements SAdminDAO {


    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public SAdmin add(SAdmin admin) {
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();//开始事物
        session.save(admin);//执行
        tran.commit();//提交
        session.close();
        return admin;
    }

    /**
     * 根据id查询所有数据
     */
    @Override
    public SAdmin queryById(Serializable id) {
        Session session = sessionFactory.openSession();
        SAdmin sAdmin = (SAdmin)session.get(SAdmin.class, id);
        session.close();
        return sAdmin;
    }

    /**
     * 分页查询管理员
     * @param pager
     * @return
     */
    @Override
    public Pager4EasyUI<SAdmin> queryAll(Pager4EasyUI<SAdmin> pager){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM SAdmin");
        query.setFirstResult(pager.getBeginIndex());
        query.setMaxResults(pager.getPageSize());
        List<SAdmin> admins = query.list();
        pager.setRows(admins);
        session.close();
        return pager;
    }

    /**
     * 查询管理员
     * @return
     */
    public int count() {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select count(*) from t_admin");
        BigInteger count = (BigInteger) query.uniqueResult();
        session.close();
        return count.intValue();
    }


    /**
     * 修改管理员
     * @param admin
     */
    @Override
    public void update(SAdmin admin) {
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();//开始事物
        session.update(admin); //修改对象
        tran.commit();//提交
        session.close();
    }

    /**
     * 删除管理员
     * @param
     */
    @Override
    public void delete() {
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();//开始事物
        SAdmin sAdmin = new SAdmin();
        session.delete(sAdmin);
        tran.commit();//提交
        session.close();
    }

    /**
     * 禁用管理员
     * @param status
     */
    @Override
    public void update(String status) {
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        session.update(status);
        tran.commit();
    }
}
