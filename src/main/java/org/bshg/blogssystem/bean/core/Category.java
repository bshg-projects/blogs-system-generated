package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

import java.util.List;

@Entity
@Table(name = "categories")
@SequenceGenerator(name = "categories_seq", sequenceName = "categories_seq", allocationSize = 1)
public class Category extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    public Category() {
        super();
    }

    public Category(Long id, String label) {
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> value) {
        this.posts = value;
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