package com._like.DAO.impl;

import com._like.DAO.IOutputFormDAO;
import com._like.Domain.OutputDrugs;
import com._like.Domain.OutputForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class OutputFormDAOImpl implements IOutputFormDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(OutputForm d) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(d);
    }

    public void save(OutputForm d) {
        Session session = sessionFactory.getCurrentSession();
        session.save(d);
    }

    public void update(OutputForm d) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.update(d);
        }
    }

    public OutputForm get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OutputForm.class,id);
    }

    public List<OutputForm> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(OutputForm.class).list();
    }

    public String queryCount(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM OutputForm";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<OutputForm> listPage(int currentPage,int moveValue,int limitSize) {
        int startNum = (currentPage - 1) * limitSize;
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT o FROM OutputForm o";
        return session.createQuery(hql).setFirstResult(startNum).setMaxResults(limitSize).list();
    }

    public List<OutputForm> mostNew() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT o FROM OutputForm o";
        String test = "SELECT max(o.id) FROM OutputForm o";
        int x = Integer.valueOf(session.createQuery(test).uniqueResult().toString());
        if(session.createQuery(hql).list().size() > 7) {
            System.out.println(x);
            return session.createQuery(hql).setFirstResult(x - 7).setMaxResults(7).list();
        } else {
            return session.createQuery(hql).setMaxResults(session.createQuery(hql).list().size()).list();
        }
    }
}
