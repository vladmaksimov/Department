package com.department.dao.employees.impl;

import com.department.dao.employees.EmployeeDao;
import com.department.model.Employee;
import com.department.utils.DBConnector;
import com.department.utils.GetDataUtil;
import com.department.utils.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void delete(Integer id) {
        Employee employee = new Employee();
        employee.setId(id);
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

    public List<Employee> getAllEmployees(Integer id) {
        List<Employee> list = new ArrayList<Employee>();
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Employee.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
        return list;
    }

//    public Set<String> getEmails() {
//        Connection connection = DBConnector.getConnection();
//        Set<String> emails = new HashSet<String>();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_EMAILS);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                emails.add(resultSet.getString("email"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return emails;
//    }
}
