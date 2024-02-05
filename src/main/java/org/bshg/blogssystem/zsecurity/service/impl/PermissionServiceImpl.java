package org.bshg.blogssystem.zsecurity.service.impl;

import org.bshg.blogssystem.zsecurity.bean.Permission;
import org.bshg.blogssystem.zsecurity.dao.PermissionDao;
import org.bshg.blogssystem.zsecurity.service.facade.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionDao permissionDao;

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }
}