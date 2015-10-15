package com.department.dao.employees;

import com.department.model.Department;
import com.department.model.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeDao {

    String GET_ALL = "from Employee where department = :department";
    String GET_BY_EMAIL = "from Employee a where a.email = :email";

    void addOrEditEmployee(Employee employee);
    void delete(Employee employee);
    Employee getOneEmployee(Integer id);
    Employee getByEmail(String email);
    List<Employee> getAllEmployees(Department department);
}
