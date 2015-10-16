package com.department.service;

import com.department.exeption.ValidateException;
import com.department.model.Department;

import java.util.List;

public interface DepartmentService {

    void addOrUpdateDepartment(Department department) throws ValidateException;

    void deleteDepartment(Integer id);

    Department getOneDepartment(Integer id);

    List<Department> getAllDepartments();
}
