package com._like.DAO.impl;

import com._like.DAO.ISupplierDAO;
import com._like.Domain.PurchaseManager;
import com._like.Domain.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SupplierDAOImpl implements ISupplierDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void delete(Supplier sr) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(sr);
    }

    public void save(Supplier sr) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sr);
    }

    public void update(Supplier sr) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sr);
    }

    public Supplier get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Supplier.class,id);
    }

    public List<Supplier> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Supplier.class).list();
    }

    public String queryCount(String keyfind) {
        if(keyfind == null){
            keyfind = "";
        }

        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT COUNT(*) FROM Supplier d where d.name like '%"+keyfind+"%'";
        return session.createQuery(hql).uniqueResult().toString();
    }

    public List<Supplier> listPage(int currentPage, int moveValue, int limitSize, String keyfind) {
        if(keyfind == null){
            keyfind = "";
        }
        int startNum = (currentPage - 1) * limitSize;
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM Supplier d where d.name like '%"+keyfind+"%'";
        return session.createQuery(hql).setFirstResult(startNum).setMaxResults(limitSize).list();
    }

    public List<Supplier> getName(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT d FROM Supplier d WHERE d.contactPerson = '"+ name +"'";
        return session.createQuery(hql).list();
    }
}
