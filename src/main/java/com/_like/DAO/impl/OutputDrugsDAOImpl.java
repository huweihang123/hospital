package com._like.DAO.impl;

import com._like.DAO.IOutputDrugsDAO;
import com._like.Domain.OutputDrugs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.List;

public class OutputDrugsDAOImpl implements IOutputDrugsDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(OutputDrugs d) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(d);
    }

    public void save(OutputDrugs d) {
        Session session = sessionFactory.getCurrentSession();
        session.save(d);
    }

    public void update(OutputDrugs d) {
        Session session = sessionFactory.getCurrentSession();
        session.update(d);
    }

    public OutputDrugs get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OutputDrugs.class,id);
    }

    public List<OutputDrugs> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(OutputDrugs.class).list();
    }

    public String list(Long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT SUM(o.number) FROM OutputDrugs o WHERE o.from.id =" + id;
        return session.createQuery(hql).uniqueResult().toString();
    }

}
