package com._like.Action;

import com._like.Domain.PageSize;
import com._like.Domain.Warehouse;
import com._like.Service.IWarehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class WarehouseAction extends ActionSupport {

    @Autowired
    @Getter
    private IWarehouseService warehouseService;

    public void setWarehouseService(IWarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Getter
    @Setter
    private Warehouse warehouse = new Warehouse();

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
        int count = Integer.valueOf(warehouseService.queryCount(keyGo));
        limitSize = (limitSize == 0 || limitSize == 5) ? 5 : limitSize;
        PageSize pagesize = new PageSize(count,currentPage,limitSize);
        ActionContext.getContext().put("pagesize",pagesize);
        ActionContext.getContext().put("limitSize",pagesize.getLimitSize());
        ActionContext.getContext().put("keyGo",keyGo);
        ActionContext.getContext().put("warehouses",warehouseService.listPage(pagesize.getCurrentPage(),(pagesize.getCurrentPage() * pagesize.getLimitSize()),pagesize.getLimitSize(),keyGo));
        return "list";
    }
    //进入录入界面
    public String input() throws Exception{
        ActionContext.getContext().put("warehouse",warehouse);
        return "input";
    }
    //新增或更新操作
    public String saveOrUpdate() throws Exception{
        if(warehouse.getId() != null){
            warehouseService.update(warehouse);
        }else{
            warehouseService.save(warehouse);
        }
        ActionContext.getContext().put("warehouses",warehouseService.list());
        return "list";
    }
    //删除操作
    public String delete() throws Exception{
        warehouseService.delete(warehouse);
        ActionContext.getContext().put("warehouses", warehouseService.list());
        return "list";
    }
}
