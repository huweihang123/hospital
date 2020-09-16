package com._like.Action;

import com._like.Domain.*;
import com._like.Service.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class OutputFormAction extends ActionSupport {

    @Getter
    @Autowired
    private IOutputFormService outputFormService;

    public void setOutputFormService(IOutputFormService outputFormService) {
        this.outputFormService = outputFormService;
    }

    @Getter
    @Autowired
    private IOutputDrugsService outputDrugsService;

    public void setOutputDrugsService(IOutputDrugsService outputDrugsService) {
        this.outputDrugsService = outputDrugsService;
    }

    @Getter
    @Autowired
    private IDrugsService drugsService;

    public void setDrugsService(IDrugsService drugsService) {
        this.drugsService = drugsService;
    }

    @Getter
    @Autowired
    private IStockManagerService stockManagerService;

    public void setStockManagerService(IStockManagerService stockManagerService) {
        this.stockManagerService = stockManagerService;
    }

    @Getter
    @Autowired
    private IWarehouseService warehouseService;

    public void setWarehouseService(IWarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Getter
    @Setter
    private OutputForm outputForm = new OutputForm();

    @Getter
    @Setter
    private int limitSize;

    @Setter
    @Getter
    private int currentPage;

    @Setter
    @Getter
    private StockManager stockManager;

    @Setter
    @Getter
    private String tableTime;

    @Setter
    @Getter
    private String tablePerson;

    @Setter
    @Getter
    private String tableWarehouse;

    @Setter
    @Getter
    private String gotype;

    @Setter
    @Getter
    private String stringDome;

    @Setter
    @Getter
    private String name;


    @Setter
    @Getter
    private Long outformID;

    //查询列表
    public String execute() throws Exception {
        if(gotype!=null) {
            return "OutputForm";
        }else {
            currentPage = (currentPage == 0) ? 1 : currentPage;
            int count = Integer.valueOf(outputFormService.queryCount());
            limitSize = (limitSize == 0 || limitSize == 5) ? 5 : limitSize;
            PageSize pagesize = new PageSize(count, currentPage, limitSize);
            ActionContext.getContext().put("pagesize", pagesize);
            ActionContext.getContext().put("limitSize", pagesize.getLimitSize());
            ActionContext.getContext().put("outputForms", outputFormService.listPage(pagesize.getCurrentPage(), (pagesize.getCurrentPage() * pagesize.getLimitSize()), pagesize.getLimitSize()));
            return "list";
        }
    }

    public String findCareful(){
        OutputForm outputForm = outputFormService.get(outformID);
        List<OutputDrugs> list = outputDrugsService.list();
        List<OutputDrugs> drugsList = outputDrugsService.list();
        drugsList.clear();
        for(int i = 0;i < list.size(); i ++){
            OutputDrugs outputDrugs = list.get(i);
            Long formID = outputDrugs.getFrom().getId();
            if(Objects.equals(outformID,formID)){
                drugsList.add(outputDrugs);
            }
        }
        ActionContext.getContext().put("outputDurges",drugsList);
        return "outlist";
    }
    
    
    public String upload() throws Exception{
        return "file";
    }


    //进入录入界面
    public String input() throws Exception{
        return INPUT;
    }
    //新增或更新操作
    public String saveOrUpdate() throws Exception{
        if(outputForm.getId() != null){
            outputFormService.update(outputForm);
        }else {
            outputFormService.save(outputForm);
        }
        return SUCCESS;
    }

    public String echarts() throws Exception{
        List<OutputForm> outputForms = outputFormService.mostNew();
        String[] arrayString = new String[]{"one","two","three","four","five","six","serven"};
        for (int i = 0; i < outputForms.size(); i++) {
          ActionContext.getContext().put(arrayString[i],Long.valueOf(outputDrugsService.list(outputForms.get(i).getId())));
        }
        return "echarts";
    }

    public String oneself() throws Exception{
        StockManager stockInformations = stockManagerService.getName(name).get(0);
        ActionContext.getContext().put("information",stockInformations);
        return "oneself";
    }

    //处理报表数据
    public String dealTable() throws Exception {
        if (stringDome == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            stringDome = request.getParameter("stringDome");
        }
        if (tablePerson != null) {
            Date date = Date.valueOf(tableTime);
            outputForm.setTime(date);
            List<StockManager> stockManagers = (stockManagerService.getName(tablePerson));
            List<Warehouse> warehouses = warehouseService.get(tableWarehouse);
            if (stockManagers.size() >= 1){
            outputForm.setManager(stockManagers.get(0));
            }
            if (warehouses.size() >= 1){
                outputForm.setWarehouse(warehouses.get(0));
            }
            outputFormService.save(outputForm);
            List<OutputForm> outputForms = outputFormService.list();
            OutputForm outputFormclone = null;
            a:for (int i = 0; i < outputForms.size(); i++) {
                if(outputForms.get(i).getTime().equals(date)){
                    outputFormclone = outputForms.get(i);
                    List<OutputDrugs> outputDrugs = outputDrugsService.list();
                    for (int y = 0; y < outputDrugs.size(); y++) {
                        if(Objects.equals((outputDrugs.get(y).getFrom()),null)){
                            outputDrugs.get(y).setFrom(outputFormclone);
                            outputDrugsService.update(outputDrugs.get(y));
                        }
                    }
                    break a;
                }
            }
        }
        if (stringDome != null) {
            String[] stringArray = stringDome.split(",");
            int y = stringArray.length / 7;
            for (int x = 1; x <= y; x++) {
                int i = x * 7;
                OutputDrugs outputDrugs = new OutputDrugs();
                outputDrugs.setName(stringArray[i + 1]);
                if (stringArray[i + 2] == null) {
                    outputDrugs.setType("未填写");
                } else {
                    outputDrugs.setType(stringArray[i + 2]);
                }
                if (stringArray[i + 3].equals("null")) {
                    outputDrugs.setNumber(0L);
                } else {
                    Long w = Long.valueOf(stringArray[i + 3].substring(0, stringArray[i + 3].length() - 2));
                    outputDrugs.setNumber(w);
                }
                if (stringArray[i + 4].equals("null")) {
                    outputDrugs.setPrice(new BigDecimal("0"));
                } else {
                    BigDecimal w2 = BigDecimal.valueOf(Long.valueOf(stringArray[i + 4].substring(0, stringArray[i + 4].length() - 2)));
                    BigDecimal w22 = new BigDecimal(String.valueOf(w2));
                    outputDrugs.setPrice(w22);
                }
                if (stringArray[i + 6] == null) {
                    outputDrugs.setRemarks("无");
                } else {
                    outputDrugs.setRemarks(stringArray[i + 6]);
                }
                Warehouse warehouse = warehouseService.get(1L);
                warehouse.setSize(warehouse.getSize() - outputDrugs.getNumber());
                warehouse.setDrugsCost(warehouse.getDrugsCost().subtract(outputDrugs.getPrice()));
                warehouseService.update(warehouse);
                List<Drug> list = drugsService.getName(outputDrugs.getName());
                if(!list.isEmpty()){
                    for(int w = 0;w < list.size(); w++) {
                        Drug drug = list.get(w);
                        if (drug.getNumber() > outputDrugs.getNumber()) {
                            drug.setNumber(drug.getNumber() - outputDrugs.getNumber());
                            drugsService.update(drug);
                        }
                        if ((drug.getCostPrice()).compareTo(outputDrugs.getPrice()) == 1) {
                            drug.setCostPrice(drug.getCostPrice().subtract(outputDrugs.getPrice()));
                            drugsService.update(drug);
                        }
                    }
                }
                outputDrugsService.save(outputDrugs);
            }
        }
            return "tablesuccess";
        }
}
