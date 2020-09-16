package com._like.Service.impl;

import com._like.DAO.IDrugsDAO;
import com._like.DAO.ISupplierDAO;
import com._like.DAO.impl.DrugsDAOImpl;
import com._like.DAO.impl.SupplierDAOImpl;
import com._like.Domain.Drug;
import com._like.Domain.Supplier;
import com._like.Service.IDrugsService;
import com._like.Service.ISupplierService;

import java.util.List;

public class SupplierServiceImpl implements ISupplierService {

    private ISupplierDAO supplierDAO = new SupplierDAOImpl();

    public void setSupplierDAO(ISupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }
    public void delete(Supplier sr) {
        supplierDAO.delete(sr);
    }

    public void save(Supplier sr) {
        supplierDAO.save(sr);
    }

    public void update(Supplier sr) {
        supplierDAO.update(sr);
    }

    public Supplier get(Long id) {
        return supplierDAO.get(id);
    }

    public List<Supplier> list() {
        return supplierDAO.list();
    }

    public String queryCount(String keyfind) {
        return supplierDAO.queryCount(keyfind);
    }

    public List<Supplier> listPage(int currentPage,int moveValue, int limitSize,String keyfind) {
        return supplierDAO.listPage(currentPage,moveValue,limitSize,keyfind);
    }

    public List<Supplier> getName(String name) {
        return supplierDAO.getName(name);
    }


}
