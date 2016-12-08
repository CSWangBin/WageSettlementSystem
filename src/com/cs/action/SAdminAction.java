package com.cs.action;

import com.cs.bean.SAdmin;
import com.cs.commom.bean.ControllerResult;
import com.cs.commom.bean.Pager4EasyUI;
import com.cs.service.SAdminService;
import com.cs.service.SAdminServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * Created by 举 on 2016/12/6.
 */
public class SAdminAction extends ActionSupport implements ServletRequestAware {
    private String status;
    private SAdminService adminService;
    private SAdmin sAdmin;
    private int total;
    private List<SAdmin> rows;
    private ControllerResult result;

    private String id;
    private HttpServletRequest req;


    public SAdmin getsAdmin() {
        return sAdmin;
    }

    public void setsAdmin(SAdmin sAdmin) {
        this.sAdmin = sAdmin;
    }

    public ControllerResult getResult() {
        return result;
    }

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


    /**
     * 添加管理员
     * @return
     */
    public String add() {
        System.out.println(sAdmin.getName());
        System.out.println();

        if(sAdmin.getStatus()==null){
            sAdmin.setStatus("Y");
        }
        adminService.add(sAdmin);

        result = ControllerResult.getResultSuccess("添加成功");
        return "add";
    }


    /**
     * 根据id查询管理员
     * @return
     */
    public String queryById() {
        sAdmin = adminService.queryById(id);
        return "query";
    }


    /**
     * 分页查询管理员
     * @return
     */
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
        System.out.println(rows.get(1));

        return "all";

    }

    /**
     * 修改管理员
     * @return
     */
    public String update() {
        adminService.update(sAdmin);
        result = ControllerResult.getResultSuccess("修改成功");
        return "update";
    }


}
