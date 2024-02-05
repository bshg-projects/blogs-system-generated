package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
@SequenceGenerator(name = "posts_seq", sequenceName = "posts_seq", allocationSize = 1)
public class Post extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_seq")
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    @OneToMany(mappedBy = "post")
    private List<Tag> tags;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    @OneToMany(mappedBy = "post")
    private List<LikeDislike> likesDislikes;
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Costumer costumer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Post() {
        super();
    }

    public Post(Long id, String label) {
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime value) {
        this.createdDate = value;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime value) {
        this.lastModifiedDate = value;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> value) {
        this.tags = value;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> value) {
        this.comments = value;
    }

    public List<LikeDislike> getLikesDislikes() {
        return likesDislikes;
    }

    public void setLikesDislikes(List<LikeDislike> value) {
        this.likesDislikes = value;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category value) {
        this.category = value;
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