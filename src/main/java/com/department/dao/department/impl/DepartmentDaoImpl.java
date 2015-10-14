package com.department.dao.department.impl;

import com.department.dao.department.DepartmentDao;
import com.department.model.Department;
import com.department.utils.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    public void add(Department department) {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (department.getId() != null) {
                session.update(department);
            } else {
                session.save(department);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    public void delete(Integer id) {
        Department department = new Department();
        department.setId(id);
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(department);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    public Department getOne(Integer id) {
        Department department = null;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            department = (Department) session.load(Department.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
        return department;
    }

    public List<Department> getAll() {
        List<Department> list = null;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Department.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
        return list;
    }

//    public Set<String> getNames() {
//        return null;
//    }
}
