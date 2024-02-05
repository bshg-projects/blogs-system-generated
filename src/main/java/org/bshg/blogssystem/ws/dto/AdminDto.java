package org.bshg.blogssystem.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.blogssystem.zsecurity.ws.dto.UserDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminDto extends UserDto {
    public AdminDto() {
        super();
    }

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private List<LikeDislikeDto> likeDislikes;
    private List<NotificationDto> notifications;
    private UserProfileDto profile;
    private List<PostDto> posts;
    private List<CommentDto> comments;

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

    public List<LikeDislikeDto> getLikeDislikes() {
        return likeDislikes;
    }

    public void setLikeDislikes(List<LikeDislikeDto> value) {
        this.likeDislikes = value;
    }

    public List<NotificationDto> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationDto> value) {
        this.notifications = value;
    }

    public UserProfileDto getProfile() {
        return profile;
    }

    public void setProfile(UserProfileDto value) {
        this.profile = value;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> value) {
        this.posts = value;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> value) {
        this.comments = value;
    }
}