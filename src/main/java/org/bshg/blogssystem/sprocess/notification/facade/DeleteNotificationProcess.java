package org.bshg.blogssystem.sprocess.notification.facade;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;

public interface DeleteNotificationProcess extends IDeleteProcess<Notification> {
    void deleteByAdmin(Admin admin);

    void deleteByCostumer(Costumer costumer);
}