package com._like.Action;

import com._like.Domain.Drug;
import com._like.Domain.PageSize;
import com._like.Domain.Warehouse;
import com._like.Service.IDrugsService;
import com._like.Service.IWarehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class DrugsAction extends ActionSupport {


    @Autowired
    @Getter
    private IDrugsService drugsService;

    @Autowired
    @Getter
    @Setter
    private IWarehouseService warehouseService;

    public void setDrugsService(IDrugsService drugsService) {
        this.drugsService = drugsService;
    }

    @Getter
    @Setter
    private Drug drug = new Drug();

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
        int count = Integer.valueOf(drugsService.queryCount(keyGo));
        limitSize = (limitSize == 0 || limitSize == 5) ? 5 : limitSize;
        PageSize pagesize = new PageSize(count,currentPage,limitSize);
        ActionContext.getContext().put("pagesize",pagesize);
        ActionContext.getContext().put("limitSize",pagesize.getLimitSize());
        ActionContext.getContext().put("keyGo",keyGo);
        ActionContext.getContext().put("drugs",drugsService.listPage(pagesize.getCurrentPage(),(pagesize.getCurrentPage() * pagesize.getLimitSize()),pagesize.getLimitSize(),keyGo));
        return "list";
    }

    //进入录入界面
    public String input() throws Exception{
        return INPUT;
    }
    //新增或更新操作
    public String saveOrUpdate() throws Exception{
        if(drug.getId() != null){
            Drug drug1 = drugsService.get(drug.getId());
            Warehouse warehouse = warehouseService.get(1L);
            warehouse.setSize(warehouse.getSize() + (drug.getNumber() - drug1.getNumber()));
            warehouse.setDrugsCost(warehouse.getDrugsCost().add((drug.getCostPrice()).subtract(drug1.getCostPrice())));
            warehouseService.update(warehouse);
            drugsService.update(drug);
       }else {
            Warehouse warehouse = warehouseService.get(1L);
            warehouse.setSize(warehouse.getSize() + drug.getNumber());
            warehouse.setDrugsCost(warehouse.getDrugsCost().add(drug.getCostPrice()));
            warehouseService.update(warehouse);
            drugsService.delete(drug);
            drugsService.save(drug);
        }
        return SUCCESS;
    }
    //删除操作
    public String delete() throws Exception{
        Warehouse warehouse = warehouseService.get(1L);
        warehouse.setSize(warehouse.getSize() - drug.getNumber());
        warehouse.setDrugsCost(warehouse.getDrugsCost().subtract(drug.getCostPrice()));
        warehouseService.update(warehouse);
        drugsService.delete(drug);
        currentPage = (currentPage == 0) ? 1 : currentPage;
        int count = Integer.valueOf(drugsService.queryCount(keyGo));
        limitSize = (limitSize == 0 || limitSize == 5) ? 5 : limitSize;
        PageSize pagesize = new PageSize(count,currentPage,limitSize);
        ActionContext.getContext().put("pagesize",pagesize);
        ActionContext.getContext().put("limitSize",pagesize.getLimitSize());
        ActionContext.getContext().put("drugs",drugsService.listPage(pagesize.getCurrentPage(),(pagesize.getCurrentPage() * pagesize.getLimitSize()),pagesize.getLimitSize(),keyGo));
        return "list";
    }

}
