package com.cs.dao;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by 举 on 2016/11/29.
 */
public class SAdminDAOImpl extends BaseDAO implements SAdminDAO {


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
     * 分页查询管理员
     * @param pager
     * @return
     */
    @Override
    public Pager4EasyUI<SAdmin> queryAll(Pager4EasyUI<SAdmin> pager){
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from t_admin");
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
     * @param id
     */
    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();//开始事物
        SAdmin p = (SAdmin)session.get(SAdmin.class, id); //获取id
        System.out.print(p);
        session.delete(p);
        tran.commit();//提交
        session.close();
    }
}
