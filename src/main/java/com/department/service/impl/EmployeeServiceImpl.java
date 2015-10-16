package com.department.service.impl;


import com.department.dao.EmployeeDao;
import com.department.dao.impl.EmployeeDaoImpl;
import com.department.exeption.ValidateException;
import com.department.model.Employee;
import com.department.service.EmployeeService;
import com.department.utils.validator.DataValidator;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao = new EmployeeDaoImpl();
    private DataValidator validator = new DataValidator();


    public void addOrUpdateEmployee(Employee employee) throws ValidateException {
        Map<String, String> errors = validator.validate(employee);
        if (errors.size() > 0) {
            throw new ValidateException("error", errors);
        }
        dao.addOrEditEmployee(employee);
    }

    public void deleteEmployee(Integer id) {
        dao.delete(id);
    }

    public List<Employee> getAllEmployees(Integer id) {
        return dao.getAllEmployees(id);
    }

    public Employee getOneEmployee(Integer id) {
        return dao.getOneEmployee(id);
    }

//    public static boolean existEmail(String email) {
//        return !dao.getEmails().contains(email);
//    }
}
