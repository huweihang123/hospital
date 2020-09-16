package com._like.Service.impl;

import com._like.DAO.IDrugsDAO;
import com._like.DAO.impl.DrugsDAOImpl;
import com._like.Domain.Drug;
import com._like.Service.IDrugsService;

import java.util.List;

public class DrugsServiceImpl implements IDrugsService {

    private IDrugsDAO drugsDAO = new DrugsDAOImpl();

    public void setDrugsDAO(IDrugsDAO drugsDAO) {
        this.drugsDAO = drugsDAO;
    }
    public void delete(Drug d) {
        drugsDAO.delete(d);
    }

    public void save(Drug d) {
        drugsDAO.save(d);
    }

    public void update(Drug d) {
        drugsDAO.update(d);
    }

    public Drug get(Long id) {
        return drugsDAO.get(id);
    }

    public List<Drug> list() {
        return drugsDAO.list();
    }

    public String queryCount(String keyfind) {
        return drugsDAO.queryCount(keyfind);
    }

    public List<Drug> listPage(int currentPage,int moveValue, int limitSize,String keyfind) {
        return drugsDAO.listPage(currentPage,moveValue,limitSize,keyfind);
    }

    public List<Drug> getName(String name) {
        return drugsDAO.getName(name);
    }

}
