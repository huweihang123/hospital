package com._like.Action;

import com._like.Domain.*;
import com._like.Service.*;
import com._like.Service.impl.InputFormServiceImpl;
import com._like.Service.impl.OutputFormServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SystemManagerAction extends ActionSupport {



    @Getter@Setter
    private File fileImage;// 必须与表单中的name属性一致
    @Setter@Getter
    private String fileImageContentType;
    @Getter@Setter
    private String fileImageFileName;// 必须是name属性+FileName


    @Getter
    @Setter
    private SystemManager systemManager = new SystemManager();

    @Getter
    @Setter
    private ISystemManagerService systemManagerService;

    @Getter
    @Setter
    private IIntputFormService inputFormService;

    @Getter
    @Setter
    private IOutputFormService outputFormService;


    @Getter
    @Setter
    private IPurchaseManagerService purchaseManagerService;

    @Getter
    @Setter
    private IStockManagerService stockManagerService;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Long inid;


    @Setter
    @Getter
    private PurchaseManager purchaseManager;

    @Setter
    @Getter
    private StockManager stockManager;


    public String login() throws Exception {
        List<SystemManager> list = systemManagerService.get(username);
            if (list.size() != 0) {
                systemManager = list.get(0);
                if (systemManager != null) {
                    if ((systemManager.getPassword()) != null) {
                        if ((systemManager.getPassword()).equals(password)) {
                            ActionContext.getContext().put("systemManager", systemManager);
                            return "main";
                        } else {
                            this.addFieldError("loginError.password", "请核实您的密码！");
                            return "login";
                        }
                    }
                } else {
                    this.addFieldError("loginError.username", "对不起，该用户名不存在！");
                    return "login";
                }
            } else {
                this.addFieldError("loginError.username", "对不起，该用户名不存在！");
                return "login";
            }
            this.addFieldError("loginError.username", "对不起，该用户名不存在！");
            return "login";
        }
    public String oneself() throws Exception{
        SystemManager systemManager = systemManagerService.getName(name).get(0);
        ActionContext.getContext().put("information",systemManager);
        return "oneself";
    }

    public String updatein() throws Exception{
        if(inid != null){
            PurchaseManager inmanager = purchaseManagerService.get(inid);
            ActionContext.getContext().put("inmanager", inmanager);
        }else {
            return "updatein";
        }
        return "updatein";
    }

    public String deletein() throws Exception{
        PurchaseManager inmanager = purchaseManagerService.get(inid);
        List<InputForm> inputForms = inputFormService.list();
        for (int i = 0; i < inputForms.size(); i++) {
            if(inputForms.get(i).getManager().getId() == inid){
                return "deleteerror";
            }
        }
        List<PurchaseManager> purchaseManagers = purchaseManagerService.list();
        ActionContext.getContext().put("purchaseManagers",purchaseManagers);
        purchaseManagerService.delete(inmanager);
        return "deletein";
    }
    public String updateIngo() throws IOException {
        String desPath = ServletActionContext.getServletContext().getRealPath("workpricture");
        String pageName = UUID.randomUUID().toString().substring(0, 12);
        File destFile = new File(desPath, (pageName + ".jpg"));
        if (fileImage != null) {
            FileUtils.copyFile(fileImage, destFile);
        }
        if (purchaseManager.getId() != null) {
            if (fileImage != null) {
                String load = "/workpricture/"+(pageName + ".jpg");
                purchaseManager.setPicture(load);
            }
            purchaseManagerService.update(purchaseManager);
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                builder.append((int) (Math.random() * 10));
            }
            purchaseManager.setUsername(builder.toString());
            purchaseManagerService.save(purchaseManager);
        }
        List<PurchaseManager> purchaseManagers = purchaseManagerService.list();
        ActionContext.getContext().put("purchaseManagers",purchaseManagers);
        return "inmanager";
    }
    public String updateout() throws Exception{
        if(inid != null) {
            StockManager outmanager = stockManagerService.get(inid);
            ActionContext.getContext().put("outmanager", outmanager);
        }else{
            return "updateout";
        }
        return "updateout";
    }

    public String deleteout() throws Exception{
        StockManager outmaneuver = stockManagerService.get(inid);
        List<OutputForm> outputForms = outputFormService.list();
        for (int i = 0; i < outputForms.size(); i++) {
            if(outputForms.get(i).getManager().getId() == inid){
                return "deleteerror";
            }
        }
        stockManagerService.delete(outmaneuver);
        List<StockManager> stockManagers = stockManagerService.list();
        ActionContext.getContext().put("stockManagers",stockManagers);
        return "deleteout";
    }

    public String updateOutgo() throws IOException {
        String desPath = ServletActionContext.getServletContext().getRealPath("workpricture");
        String pageName = UUID.randomUUID().toString().substring(0, 12);
        File destFile = new File(desPath, (pageName + ".jpg"));
        if (fileImage != null) {
            FileUtils.copyFile(fileImage, destFile);
        }
        if (stockManager.getId() != null) {
            if (fileImage != null) {
                String load = "/workpricture/"+(pageName + ".jpg");
                stockManager.setPicture(load);
            }
            stockManagerService.update(stockManager);
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                builder.append((int) (Math.random() * 10));
            }
            stockManager.setUsername(builder.toString());
            stockManagerService.save(stockManager);
        }
        List<StockManager> stockManagers = stockManagerService.list();
        ActionContext.getContext().put("stockManagers",stockManagers);
        return "outmanager";
    }
    public String inmanager() throws Exception{
        List<PurchaseManager> purchaseManagers = purchaseManagerService.list();
        ActionContext.getContext().put("purchaseManagers",purchaseManagers);
        return "inmanager";
    }

    public String outmanager() throws Exception{
        List<StockManager> stockManagers = stockManagerService.list();
        ActionContext.getContext().put("stockManagers",stockManagers);
        return "outmanager";
    }

    public String saveOrUpdate() throws Exception {
        // 将客户端的文件上传到服务端
        String desPath = ServletActionContext.getServletContext().getRealPath("workpricture");
        String pageName = UUID.randomUUID().toString().substring(0, 12);
        File destFile = new File(desPath, (pageName + ".jpg"));
        if (fileImage != null) {
            FileUtils.copyFile(fileImage, destFile);
        }
        if (systemManager.getId() != null) {
            if (fileImage != null) {
                String load = "/workpricture/"+(pageName + ".jpg");
                systemManager.setPicture(load);
            }
            systemManagerService.update(systemManager);
        } else {
            systemManagerService.save(systemManager);
        }
        return "oneselfupdate";
    }
}
