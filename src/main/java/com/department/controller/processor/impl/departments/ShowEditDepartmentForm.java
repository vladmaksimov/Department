package com.department.controller.processor.impl.departments;

import com.department.controller.processor.Processor;
import com.department.model.Department;
import com.department.service.DepartmentService;
import com.department.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowEditDepartmentForm implements Processor{
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department;
        DepartmentService service = new DepartmentServiceImpl();
        department = service.getOneDepartment(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("department", department);
        req.getRequestDispatcher("jsp/departments/addDepartments.jsp").forward(req,resp);
    }
}
