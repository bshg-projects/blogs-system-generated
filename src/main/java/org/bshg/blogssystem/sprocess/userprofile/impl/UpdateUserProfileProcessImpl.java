package org.bshg.blogssystem.sprocess.userprofile.impl;

import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.sprocess.userprofile.facade.UpdateUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateUserProfileProcessImpl extends AbstractUpdateProcessImpl<UserProfile, UserProfileService> implements UpdateUserProfileProcess {
    public UpdateUserProfileProcessImpl(UserProfileService service) {
        super(service);
    }

    public UserProfile run(UserProfile item) {
// Your Update Logic For 'UserProfile'
        item = service.edit(item);
        return item;
    }

    @Override
    public void configure() {
        this.configure(UserProfile.class);
    }
}