package com.department.utils.validator;

import com.department.dao.employees.EmployeeDao;
import com.department.dao.employees.impl.EmployeeDaoImpl;
import com.department.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

public class ValidateEmail implements CheckWithCheck.SimpleCheck{
        EmployeeDao dao = new EmployeeDaoImpl();
    public boolean isSatisfied(Object o, Object o1) {

        Employee employee = (Employee)o;
//        dao.getOneEmployee()
//        session = HibernateUtil.getSessionFactory().openSession();
//        Employee employee = (Employee)o;
//        dao.getOneEmployee(employee.getId());
//        return !emails.contains(employee.getEmail());
        return true;
    }
}
