package org.bshg.blogssystem.zsecurity.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.bean.BusinessObject;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "permissions")
public class Permission extends BusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    List<Role> roles = new ArrayList<>();

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
