package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zutils.webservice.dto.AuditBaseDto;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDto extends AuditBaseDto {
    public NotificationDto() {
        super();
    }

    private String message;
    private LocalDateTime createdDate;
    private AdminDto admin;
    private CostumerDto costumer;

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime value) {
        this.createdDate = value;
    }

    public AdminDto getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDto value) {
        this.admin = value;
    }

    public CostumerDto getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerDto value) {
        this.costumer = value;
    }
}