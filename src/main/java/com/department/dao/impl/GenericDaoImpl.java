package com.department.dao.impl;

import com.department.dao.GenericDao;
import com.department.exeption.ErrorException;
import com.department.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created on 19.10.15.
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private final Class<T> entityClass;

    protected GenericDaoImpl(Class<T> aClass) {
        this.entityClass = aClass;
    }

    public void delete(Object o) throws ErrorException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ErrorException("Failed to remove object from database");
        } finally {
            HibernateUtil.closeConnection();
        }
    }

    public void save(Object o) throws ErrorException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(o);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ErrorException("Failed to add object");
        } finally {
            HibernateUtil.closeConnection();
        }
    }

    public T get(Integer id) throws ErrorException {
        Session session = HibernateUtil.getSessionFactory().openSession();;
        try {
            return (T) session.load(entityClass, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ErrorException("Error getting data from the database");
        } finally {
            HibernateUtil.closeConnection();
        }
    }

    public List<T> getAll() throws ErrorException {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createCriteria(entityClass).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ErrorException("Error getting data from the database");
        } finally {
            HibernateUtil.closeConnection();
        }
    }


}
