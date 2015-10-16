package com.department.model;

import com.department.utils.validator.ValidateEmail;
import net.sf.oval.constraint.*;

import java.util.Date;

/**
 * Created on 16.09.2015.
 */
public class Employee {
    private Integer id;

    @NotEmpty(message = "Field name is empty")
    @NotNull(message = "Field name is empty")
    @Length(min = 1, max = 20, message = "insert minimum 1 char")
    private String name;

    @NotNull(message = "Incorrect date format")
    @NotEmpty(message = "Field date is empty")
    private Date date;
    private Integer departmentId;

    @NotNull(message = "Field email is empty")
    @NotEmpty(message = "Field email is empty")
    @Email(message = "incorrect email format")
    @CheckWith(value = ValidateEmail.class, message = "This email already exist")
    private String email;

    @NotNull (message = "Field salary is empty")
    @NotEmpty (message = "Field salary is empty")
    @Length (min = 1, message = "insert minimum 1 int")
    @NotNegative (message = "Salary can't be negative")
    private Float salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }



}
