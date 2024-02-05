package org.bshg.blogssystem.bean.core;

import jakarta.persistence.*;
import org.bshg.blogssystem.bean.enums.LikeDislikeTypeEnum;
import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;

@Entity
@Table(name = "likes_dislikes")
@SequenceGenerator(name = "likes_dislikes_seq", sequenceName = "likes_dislikes_seq", allocationSize = 1)
public class LikeDislike extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "likes_dislikes_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private LikeDislikeTypeEnum type;
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Costumer costumer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;

    public LikeDislike() {
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

    public LikeDislikeTypeEnum getType() {
        return type;
    }

    public void setType(LikeDislikeTypeEnum value) {
        this.type = value;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment value) {
        this.comment = value;
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