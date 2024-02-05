package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

@Entity
@Table(name = "image_files")
@SequenceGenerator(name = "image_files_seq", sequenceName = "image_files_seq", allocationSize = 1)
public class ImageFile extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_files_seq")
    private Long id;
    private String filename;
    private String contentType;
    private String link;

    public ImageFile() {
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String value) {
        this.filename = value;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String value) {
        this.contentType = value;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String value) {
        this.link = value;
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