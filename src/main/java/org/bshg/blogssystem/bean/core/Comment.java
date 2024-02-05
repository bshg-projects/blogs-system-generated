package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comments")
@SequenceGenerator(name = "comments_seq", sequenceName = "comments_seq", allocationSize = 1)
public class Comment extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq")
    private Long id;
    private String text;
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "comment")
    private List<LikeDislike> likesDislikes;
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Costumer costumer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Comment() {
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

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime value) {
        this.createdDate = value;
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