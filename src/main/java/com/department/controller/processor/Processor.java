package com.department.controller.processor;

import com.department.exeption.ErrorException;
import com.department.exeption.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Processor {
    void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ValidateException, ErrorException;
}
