package com.cs.service;


import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;

/**
 * Created by 举 on 2016/12/6.
 */
public interface SAdminService {
    /**
     * 添加管理员
     * @param admin
     * @return
     */
    public SAdmin add(SAdmin admin);

    /**
     * 根据id查询数据
     */

    public SAdmin queryById(String id);

    /**
     * 分页查询管理员
     * @param pager
     * @return
     */
    public Pager4EasyUI<SAdmin> queryAll(Pager4EasyUI<SAdmin> pager);

    /**
     * 查询管理员总数
     * @return
     */
    public int count();

    /**
     * 修改管理员
     * @param product
     */
    public void update(SAdmin product);

    /**
     * 删除管理员
     * @param
     */
    public void delete();
}
