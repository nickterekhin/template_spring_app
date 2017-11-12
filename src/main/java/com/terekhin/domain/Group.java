package com.terekhin.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Nick on 09.11.17.
 */
@Entity
@Table(name="groups")
public class Group implements IBaseModel {


    private long id;
    private String roleName;
    private boolean active;

    @ManyToMany(mappedBy = "userRoles")
    private Collection<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="groups_permissions",joinColumns = @JoinColumn(name="group_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"))
    private Collection<Permission> permissions;

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions = permissions;
    }
}
