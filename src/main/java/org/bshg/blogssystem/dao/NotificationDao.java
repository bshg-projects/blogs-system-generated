package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;

import java.util.List;

public interface NotificationDao extends AbstractRepository<Notification, Long> {
    int deleteByAdminId(Long id);

    List<Notification> findByAdminId(Long id);

    int deleteByCostumerId(Long id);

    List<Notification> findByCostumerId(Long id);
}