package com.terekhin.domain;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="users")
public class User implements IBaseModel {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Column(name="user_name")
        private String userName;
        @Column(length = 60)
        private String password;
        private DateTime createdAt;
        private String IP;
        private String email;
        private boolean active;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name="users_roles",joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
        private Set<Group> groups = new HashSet<Group>(0);

        public User() {
        }

        public User(String userName, String password, DateTime createdAt, String IP, String email, boolean active) {
                this.userName = userName;
                this.password = password;
                this.createdAt = createdAt;
                this.IP = IP;
                this.email = email;
                this.active = active;
        }

        @Override
        public long getId() {
                return this.id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public DateTime getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(DateTime createdAt) {
                this.createdAt = createdAt;
        }

        public String getIP() {
                return IP;
        }

        public void setIP(String IP) {
                this.IP = IP;
        }

        public Set<Group> getGroups() {
                return groups;
        }

        public void setGroups(Set<Group> groups) {
                this.groups = groups;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @Override
        public void setActive(boolean isActive) {
                this.active=isActive;
        }

        public boolean isActive() {
                return active;
        }
}
