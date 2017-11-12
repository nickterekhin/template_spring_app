package com.terekhin.domain;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="users")
public class User {

        private long id;
        private String userName;
        private String password;
        private DateTime createdAt;
        private String IP;
        private boolean active;
        private Set<UserRole> userRoles = new HashSet<UserRole>(0);

}
