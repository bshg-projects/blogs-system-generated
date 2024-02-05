package org.bshg.blogssystem.service.facade;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.zutils.service.IService;

public interface AdminService extends IService<Admin> {
    int deleteByProfileId(Long id);

    Admin findByProfileId(Long id);
}