package com._like.DAO.impl;


import com._like.DAO.IPurchaseManagerDAO;
import com._like.Domain.PurchaseManager;
import com._like.Domain.StockManager;
import com._like.Domain.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PurchaseManagerDAOImpl implements IPurchaseManagerDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(PurchaseManager pe) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(pe);
    }

    public void save(PurchaseManager pe) {
        Session session = sessionFactory.getCurrentSession();
        session.save(pe);
    }

    public void update(PurchaseManager pe) {
        Session session = sessionFactory.getCurrentSession();
        session.update(pe);
    }

    public PurchaseManager get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(PurchaseManager.class,id);
    }

    public List<PurchaseManager> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(PurchaseManager.class).list();
    }

    public String queryCount() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM PurchaseManager d";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<PurchaseManager> getName(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM PurchaseManager d WHERE d.name LIKE '"+ name +"'";
        return session.createQuery(hql).list();
    }


    public List<PurchaseManager> get(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM PurchaseManager d WHERE d.username = '"+ username +"'";
        return session.createQuery(hql).list();
    }


}