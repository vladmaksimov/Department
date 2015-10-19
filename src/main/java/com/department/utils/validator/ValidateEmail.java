package com.department.utils.validator;

import com.department.dao.EmployeeDao;
import com.department.dao.impl.EmployeeDaoImpl;
import com.department.exeption.ErrorException;
import com.department.model.Employee;
import net.sf.oval.constraint.CheckWithCheck;

public class ValidateEmail implements CheckWithCheck.SimpleCheck{

    public boolean isSatisfied(Object o, Object o1) {
        EmployeeDao dao = new EmployeeDaoImpl(Employee.class);
        Employee employee = (Employee)o;
        Employee dbEmployee = null;
        try {
            dbEmployee = dao.getByEmail(o1.toString());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new ErrorException("Error getting data from the database");
            } catch (ErrorException ignored) {}
        }
        if(dbEmployee != null){
            return !dbEmployee.getId().equals(employee.getId());
        }
        return true;
    }
}
