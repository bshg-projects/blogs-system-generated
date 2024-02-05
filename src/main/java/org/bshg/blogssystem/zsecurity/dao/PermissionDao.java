package org.bshg.blogssystem.zsecurity.dao;

import org.bshg.blogssystem.zsecurity.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}