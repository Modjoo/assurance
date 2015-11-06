package com.es.assurance.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Christophe on 05.11.2015.
 */
public interface GenericDAO <T, ID extends Serializable> {

    T findById(ID id, boolean lock);

    List<T> findAll();

    public List<T> findByExample(T exampleInstance, String[] excludeProperty);

    T makePersistent(T entity);

    void makeTransient(T entity);
}