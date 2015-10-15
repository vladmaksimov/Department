package com.department.dao.employees;

import com.department.model.Department;
import com.department.model.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeDao {

    String GET_ALL = "from Employee where department = :department";

    void addOrEditEmployee(Employee employee);
    void delete(Employee employee);
    Employee getOneEmployee(Integer id);
    List<Employee> getAllEmployees(Department department);
}
