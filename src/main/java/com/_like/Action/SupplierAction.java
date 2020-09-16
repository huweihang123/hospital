package com._like.Action;

import com._like.Domain.PageSize;
import com._like.Domain.Supplier;
import com._like.Service.ISupplierService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierAction extends ActionSupport{

    @Autowired
    @Getter
    private ISupplierService supplierService;

    public void setSupplierService(ISupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Getter
    private final Supplier supplier = new Supplier();

    @Getter
    @Setter
    private int limitSize;

    @Setter
    @Getter
    private int currentPage;

    @Setter
    @Getter
    private String keyGo;

    //查询列表
    public String execute() throws Exception {
        currentPage = (currentPage == 0) ? 1 : currentPage;
        int count = Integer.valueOf(supplierService.queryCount(keyGo));
        limitSize = (limitSize == 0 || limitSize == 5) ? 5 : limitSize;
        PageSize pagesize = new PageSize(count,currentPage,limitSize);
        ActionContext.getContext().put("pagesize",pagesize);
        ActionContext.getContext().put("limitSize",pagesize.getLimitSize());
        ActionContext.getContext().put("keyGo",keyGo);
        ActionContext.getContext().put("suppliers",supplierService.listPage(pagesize.getCurrentPage(),(pagesize.getCurrentPage() * pagesize.getLimitSize()),pagesize.getLimitSize(),keyGo));
        return "list";
    }
    //进入录入界面
    public String input() throws Exception{
        return INPUT;
    }
    //新增或更新操作
    public String saveOrUpdate() throws Exception{
        if(supplier.getId() != null){
            supplierService.update(supplier);
        }else {
            supplierService.save(supplier);
        }
        return SUCCESS;
    }

    //删除操作
    public String delete() throws Exception{
        supplierService.delete(supplier);
        ActionContext.getContext().put("suppliers", supplierService.list());
        return "list";
    }
}
