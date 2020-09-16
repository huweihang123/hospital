package com._like.DAO.impl;

import com._like.DAO.IDrugsDAO;
import com._like.Domain.Drug;
import com._like.Domain.PurchaseManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DrugsDAOImpl implements IDrugsDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(Drug d) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(d);
    }

    public void save(Drug d) {
        Session session = sessionFactory.getCurrentSession();
        session.save(d);
    }

    public void update(Drug d) {
        Session session = sessionFactory.getCurrentSession();
        session.update(d);
    }

    public Drug get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Drug.class,id);
    }

    public List<Drug> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Drug.class).list();
    }

    public String queryCount(String keyfind) {
        if(keyfind == null){
            keyfind = "";
        }
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM Drug d where d.name like '%"+keyfind+"%'";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<Drug> listPage(int currentPage,int moveValue,int limitSize,String keyfind) {
        if(keyfind == null){
            keyfind = "";
        }
        int startNum = (currentPage - 1) * limitSize;
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM Drug d where d.name like '%"+keyfind+"%'";
        return session.createQuery(hql).setFirstResult(startNum).setMaxResults(limitSize).list();
    }

    public List<Drug> getName(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM Drug d WHERE d.name = '"+ name +"'";
        return session.createQuery(hql).list();
    }
}