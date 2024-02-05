package org.bshg.blogssystem.sprocess.admin.facade;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;

public interface DeleteAdminProcess extends IDeleteProcess<Admin> {
    void deleteByProfile(UserProfile profile);
}