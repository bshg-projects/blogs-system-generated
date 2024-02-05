package org.bshg.blogssystem.service.impl;

import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.dao.UserProfileDao;
import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl extends AbstractServiceImpl<UserProfile, UserProfileDao> implements UserProfileService {
    public UserProfileServiceImpl(UserProfileDao dao) {
        super(dao);
    }

    public void configure() {
        super.configure(UserProfile.class);
    }
}