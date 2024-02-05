package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Notification;
import org.bshg.blogssystem.ws.dto.NotificationDto;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationConverter extends AbstractConverter<Notification, NotificationDto> {
    @Autowired
    private AdminConverter adminConverter;
    @Autowired
    private CostumerConverter costumerConverter;
    private boolean admin = true;
    private boolean costumer = true;

    @Override
    protected void config() {
        config(Notification.class, NotificationDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.adminConverter.setNotifications(value);
        this.costumerConverter.setNotifications(value);
    }

    @Override
    protected Notification convertToItem(NotificationDto dto) {
        var item = new Notification();
        item.setId(dto.getId());
        item.setMessage(dto.getMessage());
        item.setCreatedDate(dto.getCreatedDate());
        item.setAdmin(adminConverter.toItem(dto.getAdmin()));
        item.setCostumer(costumerConverter.toItem(dto.getCostumer()));
        return item;
    }

    @Override
    protected NotificationDto convertToDto(Notification item) {
        var dto = new NotificationDto();
        dto.setId(item.getId());
        dto.setMessage(item.getMessage());
        dto.setCreatedDate(item.getCreatedDate());
        dto.setAdmin(admin ? adminConverter.toDto(item.getAdmin()) : null);
        dto.setCostumer(costumer ? costumerConverter.toDto(item.getCostumer()) : null);
        return dto;
    }

    public void setAdmin(boolean value) {
        this.admin = value;
    }

    public void setCostumer(boolean value) {
        this.costumer = value;
    }

    public void setAdminConverter(AdminConverter value) {
        this.adminConverter = value;
    }

    public AdminConverter getAdminConverter() {
        return adminConverter;
    }

    public void setCostumerConverter(CostumerConverter value) {
        this.costumerConverter = value;
    }

    public CostumerConverter getCostumerConverter() {
        return costumerConverter;
    }
}