package com.terekhin.database;

import com.terekhin.domain.IDomainObject;
import com.terekhin.exceptions.DBException;

import java.util.List;

/**
 * Created by Nick on 09.11.17.
 */

public interface IDAOService<T> {
    void create(T obj) throws DBException;
    T getById(Long id) throws DBException;
    void delete(T obj) throws DBException;
    void update(T obj) throws DBException;
    List<T> getAll() throws DBException;
    T activate(Long id,boolean status) throws DBException;
}
