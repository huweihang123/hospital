package com._like.DAO.impl;

import com._like.DAO.IInputFormDAO;
import com._like.Domain.InputForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class InputFormDAOImpl implements IInputFormDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(InputForm d) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(d);
    }

    public void save(InputForm d) {
        Session session = sessionFactory.getCurrentSession();
        session.save(d);
    }

    public void update(InputForm d) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.update(d);
        }
    }

    public InputForm get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(InputForm.class,id);
    }

    public List<InputForm> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(InputForm.class).list();
    }

    public String queryCount(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM InputForm";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<InputForm> listPage(int currentPage,int moveValue,int limitSize) {
        int startNum = (currentPage - 1) * limitSize;
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT o FROM InputForm o";
        return session.createQuery(hql).setFirstResult(startNum).setMaxResults(limitSize).list();
    }

    public List<InputForm> mostNew() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT o FROM InputForm o";
        String test = "SELECT max(o.id) FROM InputForm o";
        int x = Integer.valueOf(session.createQuery(test).uniqueResult().toString());
        if(session.createQuery(hql).list().size() > 7) {
            System.out.println(x);
            return session.createQuery(hql).setFirstResult(x - 7).setMaxResults(7).list();
        } else {
            return session.createQuery(hql).setMaxResults(session.createQuery(hql).list().size()).list();
        }
    }
}
