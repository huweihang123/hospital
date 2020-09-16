package com._like.DAO.impl;

import com._like.DAO.ISystemManagerDAO;
import com._like.Domain.SystemManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SystemManagerDAOImpl implements ISystemManagerDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(SystemManager pe) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(pe);
    }

    public void save(SystemManager pe) {
        Session session = sessionFactory.getCurrentSession();
        session.save(pe);
    }

    public void update(SystemManager pe) {
        Session session = sessionFactory.getCurrentSession();
        session.update(pe);
    }

    public SystemManager get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(SystemManager.class,id);
    }

    public List<SystemManager> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(SystemManager.class).list();
    }

    public String queryCount() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM SystemManager d";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<SystemManager> getName(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM SystemManager d WHERE d.name LIKE '"+ name +"'";
        return session.createQuery(hql).list();
    }

    public List<SystemManager> get(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM SystemManager d WHERE d.username = '"+ username +"'";
        return session.createQuery(hql).list();
    }
}
