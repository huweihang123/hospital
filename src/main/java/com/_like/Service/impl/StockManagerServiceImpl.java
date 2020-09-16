package com._like.Service.impl;

import com._like.DAO.IStockManagerDAO;
import com._like.DAO.impl.StockManagerDAOImpl;
import com._like.Domain.StockManager;
import com._like.Domain.Warehouse;
import com._like.Service.IStockManagerService;

import java.util.List;

public class StockManagerServiceImpl implements IStockManagerService {

    private IStockManagerDAO stockManagerDAO = new StockManagerDAOImpl();

    public void setStockManagerDAO(IStockManagerDAO stockManagerDAO) {
        this.stockManagerDAO = stockManagerDAO;
    }
    public void delete(StockManager sr) {
        stockManagerDAO.delete(sr);
    }

    public void save(StockManager sr) {
        stockManagerDAO.save(sr);
    }

    public void update(StockManager sr) {
        stockManagerDAO.update(sr);
    }

    public StockManager get(Long id) {
        return stockManagerDAO.get(id);
    }

    public List<StockManager> list() {
        return stockManagerDAO.list();
    }

    public String queryCount() {
       return stockManagerDAO.queryCount();
    }

    public List<StockManager> get(String username) {
        return stockManagerDAO.get(username);
    }

    public List<StockManager> getName(String name) {
       return stockManagerDAO.getName(name);
    }


}
