package org.bshg.blogssystem.bean.core;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.bshg.blogssystem.zsecurity.bean.User;

import java.util.List;

@Entity
@Table(name = "costumers")
public class Costumer extends User {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    @OneToOne()
    private UserProfile profile;
    @OneToMany(mappedBy = "costumer")
    private List<LikeDislike> likeDislikes;
    @OneToMany(mappedBy = "costumer")
    private List<Notification> notifications;
    @OneToMany(mappedBy = "costumer")
    private List<Post> posts;
    @OneToMany(mappedBy = "costumer")
    private List<Comment> comments;

    public Costumer() {
        super();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String value) {
        this.firstname = value;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String value) {
        this.lastname = value;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile value) {
        this.profile = value;
    }

    public List<LikeDislike> getLikeDislikes() {
        return likeDislikes;
    }

    public void setLikeDislikes(List<LikeDislike> value) {
        this.likeDislikes = value;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> value) {
        this.notifications = value;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> value) {
        this.posts = value;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> value) {
        this.comments = value;
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