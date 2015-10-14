package com.department.service.department.impl;



import com.department.dao.department.DepartmentDao;
import com.department.dao.department.impl.DepartmentDaoImpl;
import com.department.exeption.ValidateException;
import com.department.model.Department;
import com.department.service.department.DepartmentService;
import com.department.utils.validator.DataValidator;

import java.util.List;
import java.util.Map;

public class DepartmentServiceImpl implements DepartmentService {
    DataValidator validator = new DataValidator();

    private DepartmentDao dao = new DepartmentDaoImpl();

    public void addOrUpdateDepartment(Department department) throws ValidateException {
        Map<String,String> errors = validator.validate(department);
        if (errors.size() > 0) {
            throw new ValidateException("error", errors);
        }
        dao.add(department);
    }

    public Department getOneDepartment(Integer id) {
        return dao.getOne(id);
    }

    public void deleteDepartment(Integer id) {
        dao.delete(id);
    }

    public List<Department> getAllDepartments() {
        return dao.getAll();
    }
}