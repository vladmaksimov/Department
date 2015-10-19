package com.department.dao.impl;

import com.department.dao.DepartmentDao;
import com.department.exeption.ErrorException;
import com.department.model.Department;
import com.department.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao  {

    public DepartmentDaoImpl(Class<Department> aClass) {
        super(aClass);
    }

    public Department getByName(String name) throws ErrorException {
        Department department = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            department = (Department) session.createQuery(GET_BY_NAME).setString("name", name).uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ErrorException("Error getting data from the database");
        } finally {
            HibernateUtil.closeConnection();
        }
        return department;
    }
}
