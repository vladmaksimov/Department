package com.department.service.impl;



import com.department.dao.DepartmentDao;
import com.department.dao.GenericDao;
import com.department.dao.impl.GenericDaoImpl;
import com.department.dao.impl.DepartmentDaoImpl;
import com.department.exeption.ErrorException;
import com.department.exeption.ValidateException;
import com.department.model.Department;
import com.department.service.DepartmentService;
import com.department.utils.validator.DataValidator;

import java.util.List;
import java.util.Map;

public class DepartmentServiceImpl implements DepartmentService {
    private DataValidator validator = new DataValidator();

    private DepartmentDao dao = new DepartmentDaoImpl();
    private GenericDao genericDaoImpl = new GenericDaoImpl();

    public void addOrUpdateDepartment(Department department) throws ValidateException, ErrorException {
        Map<String,String> errors = validator.validate(department);
        if (errors.size() > 0) {
            throw new ValidateException("error", errors);
        }
//        dao.add(department);
        genericDaoImpl.save(department);
    }

    public Department getOneDepartment(Integer id) throws ErrorException {
//        return dao.getOne(id);
        return genericDaoImpl.get(Department.class, id);
    }

    public void deleteDepartment(Department department) throws ErrorException {
//        dao.delete(department);
        genericDaoImpl.delete(department);
    }

    public List<Department> getAllDepartments() throws ErrorException {
//        return dao.getAll();
        return genericDaoImpl.getAll(Department.class);
    }

}
