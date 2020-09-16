package com._like.Service.impl;

import com._like.DAO.IPurchaseManagerDAO;
import com._like.DAO.impl.PurchaseManagerDAOImpl;
import com._like.Domain.Drug;
import com._like.Domain.PurchaseManager;
import com._like.Domain.StockManager;
import com._like.Domain.Supplier;
import com._like.Service.IPurchaseManagerService;

import java.util.List;

public class PurchaseManagerServiceImpl implements IPurchaseManagerService {

    private IPurchaseManagerDAO purchaseManagerDAO = new PurchaseManagerDAOImpl();

    public void setPurchaseManagerDAO(IPurchaseManagerDAO purchaseManagerDAO) {
        this.purchaseManagerDAO = purchaseManagerDAO;
    }
    public void delete(PurchaseManager pr) {

        purchaseManagerDAO.delete(pr);
    }

    public void save(PurchaseManager pr) {
        purchaseManagerDAO.save(pr);
    }

    public void update(PurchaseManager pr) {
        purchaseManagerDAO.update(pr);
    }

    public PurchaseManager get(Long id) {
        return purchaseManagerDAO.get(id);
    }

    public List<PurchaseManager> list() {
        return purchaseManagerDAO.list();
    }

    public String queryCount() {
        return purchaseManagerDAO.queryCount();
    }

    public List<PurchaseManager> get(String username) {
        return purchaseManagerDAO.get(username);
    }


    public List<PurchaseManager> getName(String name) {
        return purchaseManagerDAO.getName(name);
    }
}
