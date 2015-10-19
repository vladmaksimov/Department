package com.department.dao.impl;

import com.department.dao.EmployeeDao;
import com.department.exeption.ErrorException;
import com.department.model.Department;
import com.department.model.Employee;
import com.department.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDaoImpl extends GenericDaoImpl<Employee> implements EmployeeDao   {

    public EmployeeDaoImpl(Class<Employee> aClass) {
        super(aClass);
    }

    public List<Employee> getAllEmployees(Department department) throws ErrorException {
        List<Employee> list;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            list = session.createQuery(GET_ALL).setParameter("department", department).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ErrorException("Error getting data from the database");
        } finally {
            HibernateUtil.closeConnection();
        }
        return list;
    }

    public Employee getByEmail(String email) throws ErrorException {
        Employee employee;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            employee = (Employee) session.createQuery(GET_BY_NAME).setString("email", email).uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ErrorException("Error getting data from the database");
        } finally {
            HibernateUtil.closeConnection();
        }
        return employee;
    }
}
