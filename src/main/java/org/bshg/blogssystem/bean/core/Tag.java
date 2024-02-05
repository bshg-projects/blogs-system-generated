package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

@Entity
@Table(name = "tags")
@SequenceGenerator(name = "tags_seq", sequenceName = "tags_seq", allocationSize = 1)
public class Tag extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_seq")
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Tag() {
        super();
    }

    public Tag(Long id, String label) {
// constructor to get optimized fields
        this.id = id;
        this.name = label;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post value) {
        this.post = value;
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