package com.department.utils.validator;

import com.department.dao.department.DepartmentDao;
import com.department.dao.department.impl.DepartmentDaoImpl;
import com.department.model.Department;
import net.sf.oval.constraint.CheckWithCheck;

public class ValidateDepartmentName implements CheckWithCheck.SimpleCheck {
    DepartmentDao dao = new DepartmentDaoImpl();

    public boolean isSatisfied(Object o, Object o1) {
        Department department = (Department) o;
        Department dbDepartment = dao.getByName(o1.toString());
        if (dbDepartment != null) {
            return dbDepartment.getId().equals(department.getId());
        } else {
            return true;
        }
    }
}
