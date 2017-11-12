package com.terekhin.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by Nick on 12.11.17.
 */
@Entity
@Table(name="permissions")
public class Permission implements IBaseModel {

    private long id;
    private String name;
    private boolean active;
    @ManyToMany(mappedBy = "permissions")
    private Collection<Group> groups;

    public Permission(long id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
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
}
