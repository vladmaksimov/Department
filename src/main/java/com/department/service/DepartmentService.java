package com.department.service;

import com.department.exeption.ErrorException;
import com.department.exeption.ValidateException;
import com.department.model.Department;

import java.util.List;

public interface DepartmentService {

    void addOrUpdateDepartment(Department department) throws ValidateException, ErrorException;
    void deleteDepartment(Department department) throws ErrorException;
    Department getOneDepartment(Integer id) throws ErrorException;
    List<Department> getAllDepartments() throws ErrorException;
}
