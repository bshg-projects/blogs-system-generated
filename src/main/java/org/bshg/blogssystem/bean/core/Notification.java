package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@SequenceGenerator(name = "notifications_seq", sequenceName = "notifications_seq", allocationSize = 1)
public class Notification extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notifications_seq")
    private Long id;
    private String message;
    private LocalDateTime createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Costumer costumer;

    public Notification() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin value) {
        this.admin = value;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer value) {
        this.costumer = value;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}