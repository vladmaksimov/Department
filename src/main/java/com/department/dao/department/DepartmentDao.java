package com.department.dao.department;

import com.department.model.Department;

import java.util.List;
import java.util.Set;

public interface DepartmentDao {
    void add(Department department);
    void delete(Integer id);
    Department getOne(Integer id);
    List<Department> getAll();
//    Set<String> getNames();
}
