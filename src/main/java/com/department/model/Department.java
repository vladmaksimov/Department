package com.department.model;

import com.department.utils.validator.ValidateDepartmentName;
import net.sf.oval.constraint.*;

/**
 * Created on 16.09.2015.
 */
public class Department {
    private Integer id;
    @NotNull (message = "Field name is empty")
    @NotEmpty (message = "Field name is empty")
    @Length(min = 1, max = 20, message = "insert minimum 1 char")
    @CheckWith(value = ValidateDepartmentName.class, message = "This name already exist")
    private String name;

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
}
