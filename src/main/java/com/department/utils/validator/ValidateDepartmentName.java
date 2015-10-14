package com.department.utils.validator;

import com.department.dao.department.DepartmentDao;
import com.department.dao.department.impl.DepartmentDaoImpl;
import com.department.model.Department;
import net.sf.oval.constraint.CheckWithCheck;

import java.util.HashSet;
import java.util.Set;

public class ValidateDepartmentName implements CheckWithCheck.SimpleCheck {
//    private Set<String> nameSet = new HashSet<String>();
//    private DepartmentDao dao = new DepartmentDaoImpl();
//    private Department department;
    public boolean isSatisfied(Object o, Object o1) {
//        department = (Department) o;
//        nameSet = dao.getNames();
//        return !nameSet.contains(department.getName());
        return true;
    }
}
