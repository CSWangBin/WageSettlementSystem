package com.cs.action;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.Pager4EasyUI;
import com.cs.service.SAdminService;
import com.cs.service.SAdminServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 举 on 2016/12/6.
 */
public class SAdminAction extends ActionSupport implements ServletRequestAware {
    private SAdminService adminService;

    private int total;
    private List<SAdmin> rows;


    private String id;
    private HttpServletRequest req;


    public int getTotal() {
        return total;
    }

    public List<SAdmin> getRows() {
        return rows;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setServletRequest(HttpServletRequest req) {
        this.req = req;
    }

    public SAdminAction() {
        adminService = new SAdminServiceImpl();
    }

    public String queryAll() {
        String pageNoStr = req.getParameter("page");
        String pageSizeStr = req.getParameter("rows");
        Pager4EasyUI<SAdmin> pager = new Pager4EasyUI<SAdmin>();
        if (pageNoStr != null) {
            pager.setPageNo(Integer.valueOf(pageNoStr));
            pager.setPageSize(Integer.valueOf(pageSizeStr));
        }
        pager = adminService.queryAll(pager);

        pager.setTotal(adminService.count());
        rows = pager.getRows();
        total = pager.getTotal();
        return "all";
    }
}
