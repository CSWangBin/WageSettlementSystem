package com.cs.dao;

import com.cs.util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * Created by 举 on 2016/12/6.
 */
public class BaseDAO {
    public SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
}
