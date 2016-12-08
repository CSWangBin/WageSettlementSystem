package com.cs.test;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;
import com.cs.dao.SAdminDAO;
import com.cs.dao.SAdminDAOImpl;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by 举 on 2016/12/7.
 */
public class SAdminTest extends TestCase {

    private SAdminDAO sAdminDAO;

    @Override
    protected void setUp() throws Exception {
        sAdminDAO = new SAdminDAOImpl();
    }

    @Test
    public void testQuery() {
        Pager4EasyUI<SAdmin> pager = new Pager4EasyUI<SAdmin>();
        pager.setPageNo(1);
        pager.setPageSize(1);
        pager = sAdminDAO.queryAll(pager);
        for (SAdmin sAdmin : pager.getRows()) {
            System.out.println(sAdmin.getName());
        }
    }
}
