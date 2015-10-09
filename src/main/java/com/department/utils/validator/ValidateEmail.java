package com.department.utils.validator;

import com.department.dao.employees.EmployeeDao;
import com.department.dao.employees.impl.EmployeeDaoImpl;
import com.department.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

import java.util.Set;

public class ValidateEmail implements CheckWithCheck.SimpleCheck{
    EmployeeDao dao = new EmployeeDaoImpl();
    private Set<String> emails = dao.getEmails();
    public boolean isSatisfied(Object o, Object o1) {
        Employee employee = (Employee)o;
        dao.getOneEmployee(employee.getId());
        return !emails.contains(employee.getEmail());
    }
}
