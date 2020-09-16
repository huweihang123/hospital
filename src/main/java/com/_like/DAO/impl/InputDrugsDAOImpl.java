package com._like.DAO.impl;

import com._like.DAO.IInputDrugsDAO;
import com._like.Domain.InputDrugs;
import com._like.Domain.PurchaseManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class InputDrugsDAOImpl implements IInputDrugsDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(InputDrugs d) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(d);
    }

    public void save(InputDrugs d) {
        Session session = sessionFactory.getCurrentSession();
        session.save(d);
    }

    public void update(InputDrugs d) {
        Session session = sessionFactory.getCurrentSession();
        session.update(d);
    }

    public InputDrugs get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(InputDrugs.class,id);
    }

    public List<InputDrugs> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(InputDrugs.class).list();
    }

    public String list(Long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT SUM(o.number) FROM InputDrugs o WHERE o.from.id =" + id;
        return session.createQuery(hql).uniqueResult().toString();
    }

}
