package org.bshg.blogssystem.service.impl;

import jakarta.transaction.Transactional;
import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.dao.NotificationDao;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.NotificationService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl extends AbstractServiceImpl<Notification, NotificationDao> implements NotificationService {
    public NotificationServiceImpl(NotificationDao dao) {
        super(dao);
    }

    @Transactional
    @Override
    public int deleteByAdminId(Long id) {
        return dao.deleteByAdminId(id);
    }

    @Override
    public List<Notification> findByAdminId(Long id) {
        return dao.findByAdminId(id);
    }

    @Transactional
    @Override
    public int deleteByCostumerId(Long id) {
        return dao.deleteByCostumerId(id);
    }

    @Override
    public List<Notification> findByCostumerId(Long id) {
        return dao.findByCostumerId(id);
    }

    public void configure() {
        super.configure(Notification.class);
    }

    @Autowired
    private AdminService adminService;
    @Autowired
    private CostumerService costumerService;
}