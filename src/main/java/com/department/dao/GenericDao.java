package com.department.dao;

import com.department.exeption.ErrorException;

import java.util.List;

/**
 * Created on 19.10.15.
 */
public interface GenericDao<T> {

    void delete(T o) throws ErrorException;

    void save(T o) throws ErrorException;

    T get(Integer id) throws ErrorException;

    List<T> getAll() throws ErrorException;

}
