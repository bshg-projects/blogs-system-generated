package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

@Entity
@Table(name = "pages")
@SequenceGenerator(name = "pages_seq", sequenceName = "pages_seq", allocationSize = 1)
public class Page extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pages_seq")
    private Long id;
    private String title;
    private String content;

    public Page() {
        super();
    }

    public Page(Long id, String label) {
// constructor to get optimized fields
        this.id = id;
        this.title = label;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
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