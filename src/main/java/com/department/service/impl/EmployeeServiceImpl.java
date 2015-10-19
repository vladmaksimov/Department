package com.department.service.impl;


import com.department.dao.EmployeeDao;
import com.department.dao.impl.EmployeeDaoImpl;
import com.department.exeption.ErrorException;
import com.department.exeption.ValidateException;
import com.department.model.Department;
import com.department.model.Employee;
import com.department.service.EmployeeService;
import com.department.utils.validator.DataValidator;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao = new EmployeeDaoImpl(Employee.class);
    private DataValidator validator = new DataValidator();


    public void addOrUpdateEmployee(Employee employee) throws ValidateException, ErrorException {
        Map<String, String> errors = validator.validate(employee);
        if (errors.size() > 0) {
            throw new ValidateException("error", errors);
        }
        dao.save(employee);
    }

    public void deleteEmployee(Employee employee) throws ErrorException {
        dao.delete(employee);
    }

    public List<Employee> getAllEmployees(Department department) throws ErrorException {
        return dao.getAllEmployees(department);
    }

    public Employee getOneEmployee(Integer id) throws ErrorException {
        return dao.get(id);
    }
}
