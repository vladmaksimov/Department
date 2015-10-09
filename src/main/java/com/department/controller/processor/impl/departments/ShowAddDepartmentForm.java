package com.department.controller.processor.impl.departments;

import com.department.controller.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAddDepartmentForm implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("jsp/departments/addDepartments.jsp").forward(req, resp);
    }
}
