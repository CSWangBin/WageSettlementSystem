package com.cs.service;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;
import com.cs.dao.SAdminDAO;
import com.cs.dao.SAdminDAOImpl;

/**
 * Created by 举 on 2016/12/6.
 */
public class SAdminServiceImpl implements SAdminService {

    private SAdminDAO adminDAO;

    public SAdminServiceImpl() {
        adminDAO = new SAdminDAOImpl();
    }
    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public SAdmin add(SAdmin admin) {
        return adminDAO.add(admin);
    }

    /**
     * 分页查询管理员
     * @param pager
     * @return
     */
    @Override
    public Pager4EasyUI<SAdmin> queryAll(Pager4EasyUI<SAdmin> pager){
        return adminDAO.queryAll(pager);
    }

    /**
     * 查询管理员
     * @return
     */
    public int count() {
        return adminDAO.count();
    }


    /**
     * 修改管理员
     * @param admin
     */
    @Override
    public void update(SAdmin admin) {
        adminDAO.update(admin);
    }

    /**
     * 删除管理员
     * @param id
     */
    @Override
    public void deleteById(int id) {
        adminDAO.deleteById(id);
    }
}
