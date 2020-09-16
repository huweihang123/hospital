package com._like.Service.impl;

import com._like.DAO.IDrugsDAO;
import com._like.DAO.IPurchaseManagerDAO;
import com._like.DAO.ISystemManagerDAO;
import com._like.DAO.impl.DrugsDAOImpl;
import com._like.DAO.impl.PurchaseManagerDAOImpl;
import com._like.DAO.impl.SystemManagerDAOImpl;
import com._like.Domain.Drug;
import com._like.Domain.PurchaseManager;
import com._like.Domain.SystemManager;
import com._like.Service.IDrugsService;
import com._like.Service.ISystemManagerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SystemManagerServiceImpl implements ISystemManagerService {

    private ISystemManagerDAO systemManagerDAO = new SystemManagerDAOImpl();

    public void setSystemManagerDAO(ISystemManagerDAO systemManagerDAO) {
        this.systemManagerDAO = systemManagerDAO;
    }
    public void delete(SystemManager pr) {
        systemManagerDAO.delete(pr);
    }

    public void save(SystemManager pr) {
        systemManagerDAO.save(pr);
    }

    public void update(SystemManager pr) {
        systemManagerDAO.update(pr);
    }

    public SystemManager get(Long id) {
        return systemManagerDAO.get(id);
    }

    public List<SystemManager> list() {
        return systemManagerDAO.list();
    }

    public String queryCount() {
        return systemManagerDAO.queryCount();
    }

    public List<SystemManager> get(String username) {
        return systemManagerDAO.get(username);
    }

    public List<SystemManager> getName(String name) {
        return systemManagerDAO.getName(name);
    }
}
