package com.department.controller.processor.impl.departments;

import com.department.controller.processor.Processor;
import com.department.model.Department;
import com.department.service.department.DepartmentService;
import com.department.service.department.impl.DepartmentServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 16.09.2015.
 */
public class ShowDepartments implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentService service = new DepartmentServiceImpl();
        List<Department> list = service.getAllDepartments();
        req.setAttribute("departmentsList", list);
        req.getRequestDispatcher("jsp/departments/showDepartments.jsp").forward(req, resp);
    }
}
