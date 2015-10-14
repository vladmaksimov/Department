package com.department.dao.department.impl;

import com.department.dao.department.DepartmentDao;
import com.department.model.Department;
import com.department.utils.hibernate.HibernateUtil;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DepartmentDaoImpl implements DepartmentDao {



    public void add(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

    public void delete(Integer id) {

    }

    public Department getOne(Integer id) {

        return null;
    }

    public List<Department> getAll() {
        List<Department> list = new ArrayList<Department>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(Department.class).list();
        HibernateUtil.shutdown();
        return list;
    }

    public Set<String> getNames() {
        return null;
    }
}
