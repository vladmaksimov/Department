package com.department.utils.validator;

import com.department.dao.employees.EmployeeDao;
import com.department.dao.employees.impl.EmployeeDaoImpl;
import com.department.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

public class ValidateEmail implements CheckWithCheck.SimpleCheck {
    EmployeeDao dao = new EmployeeDaoImpl();

    public boolean isSatisfied(Object o, Object o1) {
        Employee employee = (Employee) o;
        Employee bdEmployee = dao.getByEmail(o1.toString());
        if (bdEmployee != null) {
            return bdEmployee.getId().equals(employee.getId());
        } else {
            return true;
        }
    }
}
