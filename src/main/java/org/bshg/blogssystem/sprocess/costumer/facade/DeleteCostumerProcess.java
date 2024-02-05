package org.bshg.blogssystem.sprocess.costumer.facade;

import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;

public interface DeleteCostumerProcess extends IDeleteProcess<Costumer> {
    void deleteByProfile(UserProfile profile);
}