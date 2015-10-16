package com.department.utils.validator;

import com.department.dao.EmployeeDao;
import com.department.dao.impl.EmployeeDaoImpl;
import com.department.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

public class ValidateEmail implements CheckWithCheck.SimpleCheck{
    EmployeeDao dao = new EmployeeDaoImpl();
    public boolean isSatisfied(Object o, Object o1) {
        Employee employee = (Employee)o;
        Employee dbEmployee = dao.getByEmail(o1.toString());
        if(dbEmployee != null){
            return dbEmployee.getId().equals(employee.getId());
        }
        return true;
    }
}
