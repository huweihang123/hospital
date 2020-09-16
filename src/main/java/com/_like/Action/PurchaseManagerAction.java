package com._like.Action;
import com._like.Domain.PurchaseManager;
import com._like.Domain.StockManager;
import com._like.Domain.Warehouse;
import com._like.Service.IPurchaseManagerService;
import com._like.Service.IStockManagerService;
import com._like.Service.IWarehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PurchaseManagerAction extends ActionSupport {

    private static final String MAIN = "main";

    @Autowired
    @Getter
    @Setter
    private IPurchaseManagerService purchaseManagerService;

    @Autowired
    @Getter
    @Setter
    private IWarehouseService warehouseService;

    @Getter
    @Setter
    private String username;

    @Getter@Setter
    private File fileImage;// 必须与表单中的name属性一致
    @Setter@Getter
    private String fileImageContentType;
    @Getter@Setter
    private String fileImageFileName;// 必须是name属性+FileName

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private PurchaseManager purchaseManager = new PurchaseManager();

    @Getter
    @Setter
    private Warehouse warehouse = new Warehouse();

    public String execute() throws Exception {
        return "login";
    }

    public String saveOrUpdate() throws Exception {
        // 将客户端的文件上传到服务端
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
            purchaseManagerService.save(purchaseManager);
            }
            return "oneself";
        }

    public String login() throws Exception {
        List<PurchaseManager> list = purchaseManagerService.get(username);
            if (list.size() != 0) {
                purchaseManager = list.get(0);
                if (purchaseManager != null) {
                    if ((purchaseManager.getPassword()).equals(password)) {
                        ActionContext.getContext().put("purchaseManager", purchaseManager);
                        ActionContext.getContext().put("warehouse", warehouseService.get(1L));
                        return MAIN;
                    } else {
                        this.addFieldError("loginError.password", "请核实您的密码！");
                        return "login";
                    }
                } else {
                    this.addFieldError("loginError.username", "对不起，该用户名不存在！");
                    return "login";
                }
            } else {
                this.addFieldError("loginError.username", "对不起，该用户名不存在！");
                return "login";
            }
        }

   /* public String ValidateLogin() throws Exception {
        if(username != null){
            if(username.length() <= 8 && username.length() >= 10 && username.getBytes().length == username.length()) {
                if (password != null) {
                } else if (password == null) {
                    this.addFieldError("loginError.password", "密码不能为空！");
                }
            } else {
                this.addFieldError("loginError.username","用户名输入不规范！");
            }
        } else {
            this.addFieldError("loginError.username","用户名不能为空！");
            return "login";
        }
        return "main";
    }*/
}
