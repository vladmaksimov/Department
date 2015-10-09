package com.department.service.employee;

import com.department.exeption.ValidateException;
import com.department.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addOrUpdateEmployee(Employee employee) throws ValidateException;

    void deleteEmployee(Integer id);

    List<Employee> getAllEmployees(Integer id);

    Employee getOneEmployee(Integer id);

}
