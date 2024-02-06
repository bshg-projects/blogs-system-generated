package org.bshg.blogssystem.sprocess.notification.impl;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.NotificationService;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.notification.facade.DeleteNotificationProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

import java.util.List;

public class DeleteNotificationProcessImpl extends AbstractDeleteProcessImpl<Notification, NotificationService> implements DeleteNotificationProcess {
    public DeleteNotificationProcessImpl(NotificationService service, CostumerService costumerService, AdminService adminService) {
        super(service);
        this.costumerService = costumerService;
        this.adminService = adminService;
    }

    @Override
    protected void process(Notification item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByAdmin(Admin admin) {
        if (admin != null && admin.getId() != null) {
            List<Notification> found = this.service.findByAdminId(admin.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByAdminId(admin.getId());
        }
    }

    public void deleteByCostumer(Costumer costumer) {
        if (costumer != null && costumer.getId() != null) {
            List<Notification> found = this.service.findByCostumerId(costumer.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByCostumerId(costumer.getId());
        }
    }

    @Override
    public void configure() {
        configure(Notification.class);
    }

    private final CostumerService costumerService;
    private DeleteCostumerProcess deleteCostumerProcess;

    public void setDeleteCostumerProcess(DeleteCostumerProcess value) {
        this.deleteCostumerProcess = value;
    }

    private final AdminService adminService;
    private DeleteAdminProcess deleteAdminProcess;

    public void setDeleteAdminProcess(DeleteAdminProcess value) {
        this.deleteAdminProcess = value;
    }
}