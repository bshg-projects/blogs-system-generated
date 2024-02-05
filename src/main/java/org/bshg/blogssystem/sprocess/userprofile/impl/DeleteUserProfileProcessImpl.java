package org.bshg.blogssystem.sprocess.userprofile.impl;

import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.sprocess.userprofile.facade.DeleteUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeleteUserProfileProcessImpl extends AbstractDeleteProcessImpl<UserProfile, UserProfileService> implements DeleteUserProfileProcess {
    public DeleteUserProfileProcessImpl(UserProfileService service) {
        super(service);
    }

    @Override
    protected void process(UserProfile item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void configure() {
        configure(UserProfile.class);
    }
}