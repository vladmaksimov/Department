package com.department.controller.processor.impl.departments;

import com.department.controller.processor.Processor;
import com.department.exeption.ValidateException;
import com.department.model.Department;
import com.department.service.department.DepartmentService;
import com.department.service.department.impl.DepartmentServiceImpl;
import com.department.utils.GetDataUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 16.09.2015.
 */
public class AddOrEditDepartment implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ValidateException {
        Department department = new Department();
        DepartmentService service = new DepartmentServiceImpl();
        if (GetDataUtil.getInteger(req,"id")!= null){
            department.setId(Integer.parseInt(req.getParameter("id")));
        }
        department.setName(req.getParameter("name").trim());
        try {
            service.addOrUpdateDepartment(department);
            req.setAttribute("departmentsList", service.getAllDepartments());
            req.getRequestDispatcher("jsp/departments/showDepartments.jsp").forward(req, resp);
        } catch (ValidateException e) {
            req.setAttribute("department", department);
            req.setAttribute("errors", e.getErrors());
            req.getRequestDispatcher("jsp/departments/addDepartments.jsp").include(req, resp);
        }
    }
}
