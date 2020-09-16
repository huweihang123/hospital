package com._like.Service.impl;

import com._like.DAO.IDrugsDAO;
import com._like.DAO.IWarehouseDAO;
import com._like.DAO.impl.DrugsDAOImpl;
import com._like.DAO.impl.WarehouseDAOImpl;
import com._like.Domain.Drug;
import com._like.Domain.Warehouse;
import com._like.Service.IDrugsService;
import com._like.Service.IWarehouseService;

import java.util.List;

public class WarehouseServiceImpl implements IWarehouseService {

    private IWarehouseDAO warehouseDAO = new WarehouseDAOImpl();

    public void setWarehouseDAO(IWarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }
    public void delete(Warehouse we) {
        warehouseDAO.delete(we);
    }

    public void save(Warehouse we) {
        warehouseDAO.save(we);
    }

    public void update(Warehouse we) {
        warehouseDAO.update(we);
    }

    public Warehouse get(Long id) {
        return warehouseDAO.get(id);
    }

    public List<Warehouse> list() {
        return warehouseDAO.list();
    }

    public String queryCount(String keyfind) {
        return warehouseDAO.queryCount(keyfind);
    }

    public List<Warehouse> listPage(int currentPage,int moveValue, int limitSize,String keyfind) {
        return warehouseDAO.listPage(currentPage,moveValue,limitSize,keyfind);
    }

    public List<Warehouse> get(String name) {
        return warehouseDAO.get(name);
    }


}
