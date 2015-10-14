package com.department.model;

import com.department.dao.department.DepartmentDao;
import com.department.dao.department.impl.DepartmentDaoImpl;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.ValidateWithMethod;

import javax.persistence.*;

/**
 * Created on 16.09.2015.
 */

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull (message = "Field name is empty")
    @NotEmpty (message = "Field name is empty")
    @Length(min = 1, max = 20, message = "insert minimum 1 char")
    @ValidateWithMethod(methodName = "existName", parameterType = String.class, message = "This name already exist")

    @Column(name = "name")
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

    public boolean existName(String name) {
        DepartmentDao dao = new DepartmentDaoImpl();
        return !dao.getNames().contains(name);
    }
}
