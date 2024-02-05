package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.ws.dto.AdminDto;
import org.bshg.blogssystem.zsecurity.ws.converter.UserConverter;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter extends AbstractConverter<Admin, AdminDto> {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserProfileConverter userProfileConverter;
    @Autowired
    private NotificationConverter notificationConverter;
    @Autowired
    private CommentConverter commentConverter;
    @Autowired
    private LikeDislikeConverter likeDislikeConverter;
    @Autowired
    private PostConverter postConverter;
    private boolean likeDislikes = true;
    private boolean notifications = true;
    private boolean profile = true;
    private boolean posts = true;
    private boolean comments = true;

    @Override
    protected void config() {
        config(Admin.class, AdminDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.notificationConverter.setAdmin(value);
        this.commentConverter.setAdmin(value);
        this.likeDislikeConverter.setAdmin(value);
        this.postConverter.setAdmin(value);
    }

    @Override
    protected Admin convertToItem(AdminDto dto) {
        var item = new Admin();
        userConverter.convertToChildItem(dto, item);
        item.setFirstname(dto.getFirstname());
        item.setLastname(dto.getLastname());
        item.setPhoneNumber(dto.getPhoneNumber());
        item.setLikeDislikes(likeDislikeConverter.toItem(dto.getLikeDislikes()));
        item.setNotifications(notificationConverter.toItem(dto.getNotifications()));
        item.setProfile(userProfileConverter.toItem(dto.getProfile()));
        item.setPosts(postConverter.toItem(dto.getPosts()));
        item.setComments(commentConverter.toItem(dto.getComments()));
        return item;
    }

    @Override
    protected AdminDto convertToDto(Admin item) {
        var dto = new AdminDto();
        userConverter.convertToChildDto(item, dto);
        dto.setFirstname(item.getFirstname());
        dto.setLastname(item.getLastname());
        dto.setPhoneNumber(item.getPhoneNumber());
        dto.setLikeDislikes(likeDislikes ? likeDislikeConverter.toDto(item.getLikeDislikes()) : null);
        dto.setNotifications(notifications ? notificationConverter.toDto(item.getNotifications()) : null);
        dto.setProfile(profile ? userProfileConverter.toDto(item.getProfile()) : null);
        dto.setPosts(posts ? postConverter.toDto(item.getPosts()) : null);
        dto.setComments(comments ? commentConverter.toDto(item.getComments()) : null);
        return dto;
    }

    public void setLikeDislikes(boolean value) {
        this.likeDislikes = value;
    }

    public void setNotifications(boolean value) {
        this.notifications = value;
    }

    public void setProfile(boolean value) {
        this.profile = value;
    }

    public void setPosts(boolean value) {
        this.posts = value;
    }

    public void setComments(boolean value) {
        this.comments = value;
    }

    public void setUserProfileConverter(UserProfileConverter value) {
        this.userProfileConverter = value;
    }

    public UserProfileConverter getUserProfileConverter() {
        return userProfileConverter;
    }

    public void setNotificationConverter(NotificationConverter value) {
        this.notificationConverter = value;
    }

    public NotificationConverter getNotificationConverter() {
        return notificationConverter;
    }

    public void setCommentConverter(CommentConverter value) {
        this.commentConverter = value;
    }

    public CommentConverter getCommentConverter() {
        return commentConverter;
    }

    public void setLikeDislikeConverter(LikeDislikeConverter value) {
        this.likeDislikeConverter = value;
    }

    public LikeDislikeConverter getLikeDislikeConverter() {
        return likeDislikeConverter;
    }

    public void setPostConverter(PostConverter value) {
        this.postConverter = value;
    }

    public PostConverter getPostConverter() {
        return postConverter;
    }
}