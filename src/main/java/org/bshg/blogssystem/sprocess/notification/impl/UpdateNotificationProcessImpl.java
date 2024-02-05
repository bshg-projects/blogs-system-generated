package org.bshg.blogssystem.sprocess.notification.impl;

import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.NotificationService;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.notification.facade.UpdateNotificationProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateNotificationProcessImpl extends AbstractUpdateProcessImpl<Notification, NotificationService> implements UpdateNotificationProcess {
    public UpdateNotificationProcessImpl(NotificationService service, AdminService adminService, CostumerService costumerService) {
        super(service);
        this.adminService = adminService;
        this.costumerService = costumerService;
    }

    public Notification run(Notification item) {
// Your Update Logic For 'Notification'
        item = service.edit(item);
        return item;
    }

    @Override
    public void configure() {
        this.configure(Notification.class);
    }

    private final AdminService adminService;
    private UpdateAdminProcess updateAdminProcess;
    private DeleteAdminProcess deleteAdminProcess;

    public void setUpdateAdminProcess(UpdateAdminProcess value) {
        this.updateAdminProcess = value;
    }

    public void setDeleteAdminProcess(DeleteAdminProcess value) {
        this.deleteAdminProcess = value;
    }

    private final CostumerService costumerService;
    private UpdateCostumerProcess updateCostumerProcess;
    private DeleteCostumerProcess deleteCostumerProcess;

    public void setUpdateCostumerProcess(UpdateCostumerProcess value) {
        this.updateCostumerProcess = value;
    }

    public void setDeleteCostumerProcess(DeleteCostumerProcess value) {
        this.deleteCostumerProcess = value;
    }
}