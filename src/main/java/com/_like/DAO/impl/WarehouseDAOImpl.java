package com._like.DAO.impl;

import com._like.DAO.IWarehouseDAO;
import com._like.Domain.Drug;
import com._like.Domain.Supplier;
import com._like.Domain.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class WarehouseDAOImpl implements IWarehouseDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(Warehouse we) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(we);
    }

    public void save(Warehouse we) {
        Session session = sessionFactory.getCurrentSession();
        session.save(we);
    }

    public void update(Warehouse we) {
        Session session = sessionFactory.getCurrentSession();
        session.update(we);
    }

    public Warehouse get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Warehouse.class,id);
    }

    public List<Warehouse> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Warehouse.class).list();
    }

    public List<Warehouse> get(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT w FROM Warehouse w WHERE w.name = '"+ name +"'";
        return session.createQuery(hql).list();
    }

    public String queryCount(String keyfind) {
        if(keyfind == null){
            keyfind = "";
        }
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM Warehouse w where w.name like '%"+keyfind+"%'";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<Warehouse> listPage(int currentPage, int moveValue, int limitSize, String keyfind) {
        if(keyfind == null){
            keyfind = "";
        }
        int startNum = (currentPage - 1) * limitSize;
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM Warehouse d where d.name like '%"+keyfind+"%'";
        return session.createQuery(hql).setFirstResult(startNum).setMaxResults(limitSize).list();
    }


}
