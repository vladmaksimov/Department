package com.department.controller.processor.impl.departments;

import com.department.controller.processor.Processor;
import com.department.exeption.ErrorException;
import com.department.service.DepartmentService;
import com.department.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 16.09.2015.
 */
public class DeleteDepartment implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ErrorException {
        DepartmentService service = new DepartmentServiceImpl();
        service.deleteDepartment(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("departmentsList", service.getAllDepartments());
        req.getRequestDispatcher("jsp/departments/showDepartments.jsp").forward(req, resp);
    }
}
