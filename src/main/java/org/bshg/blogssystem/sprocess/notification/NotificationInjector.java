package org.bshg.blogssystem.sprocess.notification;

import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.NotificationService;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.notification.facade.CreateNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.facade.DeleteNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.facade.UpdateNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.impl.CreateNotificationProcessImpl;
import org.bshg.blogssystem.sprocess.notification.impl.DeleteNotificationProcessImpl;
import org.bshg.blogssystem.sprocess.notification.impl.UpdateNotificationProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Notification Processes (Create, Update, Delete).
 */
@Configuration
public class NotificationInjector {
    @Bean
    public CreateNotificationProcess createNotificationProcess(NotificationService service, CostumerService costumerService, AdminService adminService) {
        var bean = new CreateNotificationProcessImpl(service, costumerService, adminService);
        bean.setCreateCostumerProcess(this.createCostumerProcess);
        bean.setCreateAdminProcess(this.createAdminProcess);
        return bean;
    }

    @Bean
    public UpdateNotificationProcess updateNotificationProcess(NotificationService service, CostumerService costumerService, AdminService adminService) {
        var bean = new UpdateNotificationProcessImpl(service, costumerService, adminService);
        bean.setUpdateCostumerProcess(this.updateCostumerProcess);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        bean.setUpdateAdminProcess(this.updateAdminProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        return bean;
    }

    @Bean
    public DeleteNotificationProcess deleteNotificationProcess(NotificationService service, CostumerService costumerService, AdminService adminService) {
        var bean = new DeleteNotificationProcessImpl(service, costumerService, adminService);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateCostumerProcess createCostumerProcess;
    @Autowired
    @Lazy
    private UpdateCostumerProcess updateCostumerProcess;
    @Autowired
    @Lazy
    private DeleteCostumerProcess deleteCostumerProcess;
    @Autowired
    @Lazy
    private CreateAdminProcess createAdminProcess;
    @Autowired
    @Lazy
    private UpdateAdminProcess updateAdminProcess;
    @Autowired
    @Lazy
    private DeleteAdminProcess deleteAdminProcess;
}