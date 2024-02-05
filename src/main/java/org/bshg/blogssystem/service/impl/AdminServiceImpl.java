package org.bshg.blogssystem.service.impl;

import jakarta.transaction.Transactional;
import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.dao.AdminDao;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends AbstractServiceImpl<Admin, AdminDao> implements AdminService {
    public AdminServiceImpl(AdminDao dao) {
        super(dao);
    }

    @Transactional
    @Override
    public int deleteByProfileId(Long id) {
        return dao.deleteByProfileId(id);
    }

    @Override
    public Admin findByProfileId(Long id) {
        return dao.findByProfileId(id);
    }

    public void configure() {
        super.configure(Admin.class);
    }

    @Autowired
    private UserProfileService profileService;
}