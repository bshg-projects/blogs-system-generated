package org.bshg.blogssystem.sprocess.notification.impl;

import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.NotificationService;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.notification.facade.CreateNotificationProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateNotificationProcessImpl extends AbstractCreateProcessImpl<Notification, NotificationService> implements CreateNotificationProcess {
    public CreateNotificationProcessImpl(NotificationService service, AdminService adminService, CostumerService costumerService) {
        super(service);
        this.adminService = adminService;
        this.costumerService = costumerService;
    }

    @Override
    public Notification run(Notification item) {
// Your Insert Logic For 'Notification'
        item = service.create(item);
        return item;
    }

    @Override
    public void configure() {
        configure(Notification.class);
    }

    private final AdminService adminService;
    private CreateAdminProcess createAdminProcess;

    public void setCreateAdminProcess(CreateAdminProcess value) {
        this.createAdminProcess = value;
    }

    private final CostumerService costumerService;
    private CreateCostumerProcess createCostumerProcess;

    public void setCreateCostumerProcess(CreateCostumerProcess value) {
        this.createCostumerProcess = value;
    }
}