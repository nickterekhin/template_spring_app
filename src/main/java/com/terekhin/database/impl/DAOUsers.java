package com.terekhin.database.impl;

import com.terekhin.database.DAOService;
import com.terekhin.database.IUsers;
import com.terekhin.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Nick on 13.11.17.
 */
@Repository
@Transactional("hibernate_TX")
public class DAOUsers extends DAOService<User> implements IUsers {

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }
}
