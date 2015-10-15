package com.department.dao.department;

import com.department.model.Department;

import java.util.List;

public interface DepartmentDao {

    String GET_BY_NAME = "from Department a where a.name = :name";

    void add(Department department);
    void delete(Integer id);
    Department getOne(Integer id);
    Department getByName(String name);
    List<Department> getAll();

}
