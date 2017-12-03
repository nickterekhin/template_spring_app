package com.terekhin.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Nick on 13.11.17.
 */
@Service
public class DBContext implements IDBContext {

    @Autowired
    private IUsers users;

    public DBContext() {
    }

    @Override
    public IUsers getUsers() {
        return users;
    }
}
