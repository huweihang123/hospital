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

public class InputFormAction extends ActionSupport {

    @Getter
    @Autowired
    private IIntputFormService inputFormService;

    public void setInputFormService(IIntputFormService inputFormService) {
        this.inputFormService = inputFormService;
    }

    @Getter
    @Autowired
    private ISupplierService supplierService;

    public void setSupplierService(ISupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Getter
    @Autowired
    private IInputDrugsService inputDrugsService;

    public void setInputDrugsService(IInputDrugsService inputDrugsService) {
        this.inputDrugsService = inputDrugsService;
    }

    @Getter
    @Autowired
    private IPurchaseManagerService purchaseManagerService;

    public void setPurchaseManagerService(IPurchaseManagerService purchaseManagerService) {
        this.purchaseManagerService = purchaseManagerService;
    }

    @Getter
    @Autowired
    private IDrugsService drugsService;

    public void setDrugsService(IDrugsService drugsService) {
        this.drugsService = drugsService;
    }

    @Getter
    @Autowired
    private IWarehouseService warehouseService;

    public void setWarehouseService(IWarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Getter
    @Setter
    private InputForm inputForm = new InputForm();

    @Getter
    @Setter
    private int limitSize;

    @Setter
    @Getter
    private int currentPage;

    @Setter
    @Getter
    private PurchaseManager purchaseManager;

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
    private Long informID;


    //查询列表
    public String execute() throws Exception {
        if(gotype!=null) {
            return "InputForm";
        }else {
            currentPage = (currentPage == 0) ? 1 : currentPage;
            int count = Integer.valueOf(inputFormService.queryCount());
            limitSize = (limitSize == 0 || limitSize == 5) ? 5 : limitSize;
            PageSize pagesize = new PageSize(count, currentPage, limitSize);
            ActionContext.getContext().put("pagesize", pagesize);
            System.out.println(inputFormService.get(1L).getTime().toString());
            ActionContext.getContext().put("inputForms", inputFormService.listPage(pagesize.getCurrentPage(), (pagesize.getCurrentPage() * pagesize.getLimitSize()), pagesize.getLimitSize()));
            return "list";
        }
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
        if(inputForm.getId() != null){
            inputFormService.update(inputForm);
        }else {
            inputFormService.save(inputForm);
        }
        return SUCCESS;
    }

    public String findCareful(){
        InputForm inputForm = inputFormService.get(informID);
        List<InputDrugs> list = inputDrugsService.list();
        List<InputDrugs> drugsList = inputDrugsService.list();
        drugsList.clear();
        for(int i = 0;i < list.size(); i ++){
            InputDrugs inputDrugs = list.get(i);
            Long formID = inputDrugs.getFrom().getId();
            if(Objects.equals(informID,formID)){
                drugsList.add(inputDrugs);
            }
        }
        ActionContext.getContext().put("inputDurges",drugsList);
        return "inlist";
    }

    public String echarts() throws Exception{
       List<InputForm> inputForms = inputFormService.mostNew();
        String[] arrayString = new String[]{"one","two","three","four","five","six","serven"};
        for (int i = 0; i < inputForms.size(); i++) {
          ActionContext.getContext().put(arrayString[i],Long.valueOf(inputDrugsService.list(inputForms.get(i).getId())));
        }
        return "echarts";
    }

    public String oneself() throws Exception{
        PurchaseManager purchaseManager = purchaseManagerService.getName(name).get(0);
        ActionContext.getContext().put("information",purchaseManager);
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
            inputForm.setTime(date);
            List<PurchaseManager> purchaseManagers = (purchaseManagerService.getName(tablePerson));
            List<Warehouse> warehouses = warehouseService.get(tableWarehouse);
            if (purchaseManagers.size() >= 1){
            inputForm.setManager(purchaseManagers.get(0));
            }
            if (warehouses.size() >= 1){
                inputForm.setWarehouse(warehouses.get(0));
            }
            inputFormService.save(inputForm);
            List<InputForm> inputForms = inputFormService.list();
            InputForm inputFormclone = null;
            a:for (int i = 0; i < inputForms.size(); i++) {
                if(inputForms.get(i).getTime().equals(date)){
                    inputFormclone = inputForms.get(i);
                    List<InputDrugs> inputDrugs = inputDrugsService.list();
                    for (int y = 0; y < inputDrugs.size(); y++) {
                        if(Objects.equals((inputDrugs.get(y).getFrom()),null)){
                            inputDrugs.get(y).setFrom(inputFormclone);
                            inputDrugsService.update(inputDrugs.get(y));
                        }
                    }
                    break a;
                }
            }
        }
        if (stringDome != null) {
            String[] stringArray = stringDome.split(",");
            int y = stringArray.length / 10;
            for (int x = 1; x <= y; x++) {
                int i = x * 10;
                InputDrugs inputDrugs = new InputDrugs();
                inputDrugs.setName(stringArray[i + 1]);
                if (stringArray[i + 2] == null) {
                    inputDrugs.setType("未填写");
                } else {
                    inputDrugs.setType(stringArray[i + 2]);
                }
                if (stringArray[i + 3].equals("null")) {
                    inputDrugs.setNumber(0L);
                } else {
                    Long w = Long.valueOf(stringArray[i + 3].substring(0, stringArray[i + 3].length() - 2));
                    inputDrugs.setNumber(w);
                }
                if (stringArray[i + 4].equals("null")) {
                    inputDrugs.setPrice(new BigDecimal("0"));
                } else {
                    BigDecimal w2 = BigDecimal.valueOf(Long.valueOf(stringArray[i + 4].substring(0, stringArray[i + 4].length() - 2)));
                    BigDecimal w22 = new BigDecimal(String.valueOf(w2));
                    inputDrugs.setPrice(w22);
                }
                if (stringArray[i + 6] == null) {
                    inputDrugs.setProductionDate(null);
                } else {
                    inputDrugs.setProductionDate(Date.valueOf(stringArray[i + 6]));
                }
                if (stringArray[i + 7] == null) {
                    inputDrugs.setLifeDate(null);
                } else {
                    inputDrugs.setLifeDate(Date.valueOf(stringArray[i + 7]));
                }
                if (stringArray[i + 8] == null) {
                    inputDrugs.setRemarks("无");
                } else {
                    inputDrugs.setRemarks(stringArray[i + 8]);
                }
                if (stringArray[i + 9] == "null") {
                    inputDrugs.setSupplier(null);
                } else {
                    List<Supplier> list = supplierService.getName(stringArray[i + 9]);
                    if(!list.isEmpty()){
                        inputDrugs.setSupplier(list.get(0));
                    } else {
                        inputDrugs.setSupplier(null);
                    }
                }
                Warehouse warehouse = warehouseService.get(1L);
                warehouse.setSize(warehouse.getSize() + inputDrugs.getNumber());
                warehouse.setDrugsCost(warehouse.getDrugsCost().add(inputDrugs.getPrice()));
                warehouseService.update(warehouse);
                Drug drug = new Drug();
                drug.setSellPrice(inputDrugs.getPrice().divide(BigDecimal.valueOf(inputDrugs.getNumber())));
                drug.setSuppliers(inputDrugs.getSupplier());
                drug.setNumber(inputDrugs.getNumber());
                drug.setName(inputDrugs.getName());
                drug.setWarehouses(warehouse);
                drug.setState(true);
                drug.setCostPrice(inputDrugs.getPrice());
                drug.setType(inputDrugs.getType());
                drug.setProductionDate(inputDrugs.getProductionDate());
                drug.setLifeDate(inputDrugs.getLifeDate());
                drugsService.save(drug);
                inputDrugsService.save(inputDrugs);
            }
        }
            return "tablesuccess";
        }
}
