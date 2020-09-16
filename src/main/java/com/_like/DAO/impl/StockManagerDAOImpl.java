package com._like.DAO.impl;

import com._like.DAO.IStockManagerDAO;
import com._like.Domain.StockManager;
import com._like.Domain.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StockManagerDAOImpl implements IStockManagerDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(StockManager se) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(se);
    }

    public void save(StockManager se) {
        Session session = sessionFactory.getCurrentSession();
        session.save(se);
    }

    public void update(StockManager se) {
        Session session = sessionFactory.getCurrentSession();
        session.update(se);
    }

    public StockManager get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StockManager.class,id);
    }

    public List<StockManager> getName(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM StockManager d WHERE d.name LIKE '"+ name +"'";
        return session.createQuery(hql).list();
    }

    public List<StockManager> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(StockManager.class).list();
    }

    public String queryCount() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM StockManager d";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<StockManager> get(String username) {
       Session session = sessionFactory.getCurrentSession();
       String hql = "SELECT d FROM StockManager d WHERE d.username = '"+ username +"'";
       return session.createQuery(hql).list();
    }

}
