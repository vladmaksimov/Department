package com.department.dao.employees.impl;

import com.department.dao.employees.EmployeeDao;
import com.department.model.Department;
import com.department.model.Employee;
import com.department.utils.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    public void addOrEditEmployee(Employee employee) {
        Session session;
        try {
                session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if(employee.getId() != null) {
                session.update(employee);
            } else {
                session.save(employee);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    public void delete(Employee employee) {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    public Employee getOneEmployee(Integer id) {
        Employee employee = null;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            employee = (Employee) session.load(Employee.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
        return employee;
    }

    public Employee getByEmail(String email) {
        Employee employee = null;
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            employee = (Employee) session.createQuery(GET_BY_EMAIL).setParameter("email", email).uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
        return employee;
    }

    public List<Employee> getAllEmployees(Department department) {
        List<Employee> list = new ArrayList<Employee>();
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list =  session.createQuery(GET_ALL).setParameter("department", department).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
        return list;
    }


}
