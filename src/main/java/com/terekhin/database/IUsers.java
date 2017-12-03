package com.terekhin.database;

import com.terekhin.domain.User;

/**
 * Created by Nick on 13.11.17.
 */
public interface IUsers {
    User findByEmail(String email);
    User findByUserName(String userName);
}
