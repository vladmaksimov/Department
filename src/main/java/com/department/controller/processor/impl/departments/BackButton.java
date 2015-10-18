package com.department.controller.processor.impl.departments;

import com.department.controller.processor.Processor;
import com.department.exeption.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BackButton implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ValidateException {
        resp.sendRedirect("/");
    }
}
