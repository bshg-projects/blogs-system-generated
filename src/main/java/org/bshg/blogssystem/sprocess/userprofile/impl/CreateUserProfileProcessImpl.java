package org.bshg.blogssystem.sprocess.userprofile.impl;

import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.sprocess.userprofile.facade.CreateUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateUserProfileProcessImpl extends AbstractCreateProcessImpl<UserProfile, UserProfileService> implements CreateUserProfileProcess {
    public CreateUserProfileProcessImpl(UserProfileService service) {
        super(service);
    }

    @Override
    public UserProfile run(UserProfile item) {
// Your Insert Logic For 'UserProfile'
        item = service.create(item);
        return item;
    }

    @Override
    public void configure() {
        configure(UserProfile.class);
    }
}