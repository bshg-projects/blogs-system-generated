package org.bshg.blogssystem.service.facade;

import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.zutils.service.IService;

import java.util.List;

public interface NotificationService extends IService<Notification> {
    int deleteByAdminId(Long id);

    List<Notification> findByAdminId(Long id);

    int deleteByCostumerId(Long id);

    List<Notification> findByCostumerId(Long id);
}