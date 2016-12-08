package com.cs.dao;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;

/**
 * Created by 举 on 2016/11/29.
 */
public interface SAdminDAO extends BaseDAO<SAdmin> {

    /**
     * 禁用管理员
     */
    public void update(String status);

}
