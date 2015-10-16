package com.department.utils.validator;

import com.department.dao.DepartmentDao;
import com.department.dao.impl.DepartmentDaoImpl;
import com.department.model.Department;
import net.sf.oval.constraint.CheckWithCheck;

/**
 * Created by vlad-m on 16.10.15.
 */
public class ValidateDepartmentName implements CheckWithCheck.SimpleCheck {
    DepartmentDao dao = new DepartmentDaoImpl();

    public boolean isSatisfied(Object o, Object o1) {
        Department department = (Department) o;
        Department dbDepartment = dao.getByName(o1.toString());
        if (dbDepartment != null) {
            return !dbDepartment.getId().equals(department.getId());
        } else {
            return true;
        }
    }
}
