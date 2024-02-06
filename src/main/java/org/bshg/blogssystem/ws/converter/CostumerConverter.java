package org.bshg.blogssystem.ws.converter;

import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.ws.dto.CostumerDto;
import org.bshg.blogssystem.zsecurity.ws.converter.UserConverter;
import org.bshg.blogssystem.zutils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CostumerConverter extends AbstractConverter<Costumer, CostumerDto> {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private PostConverter postConverter;
    @Autowired
    private LikeDislikeConverter likeDislikeConverter;
    @Autowired
    private UserProfileConverter userProfileConverter;
    @Autowired
    private NotificationConverter notificationConverter;
    @Autowired
    private CommentConverter commentConverter;
    private boolean profile = true;
    private boolean likeDislikes = true;
    private boolean notifications = true;
    private boolean posts = true;
    private boolean comments = true;

    @Override
    protected void config() {
        config(Costumer.class, CostumerDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.postConverter.setCostumer(value);
        this.likeDislikeConverter.setCostumer(value);
        this.notificationConverter.setCostumer(value);
        this.commentConverter.setCostumer(value);
    }

    @Override
    protected Costumer convertToItem(CostumerDto dto) {
        var item = new Costumer();
        userConverter.convertToChildItem(dto, item);
        item.setFirstname(dto.getFirstname());
        item.setLastname(dto.getLastname());
        item.setPhoneNumber(dto.getPhoneNumber());
        item.setProfile(userProfileConverter.toItem(dto.getProfile()));
        item.setLikeDislikes(likeDislikeConverter.toItem(dto.getLikeDislikes()));
        item.setNotifications(notificationConverter.toItem(dto.getNotifications()));
        item.setPosts(postConverter.toItem(dto.getPosts()));
        item.setComments(commentConverter.toItem(dto.getComments()));
        return item;
    }

    @Override
    protected CostumerDto convertToDto(Costumer item) {
        var dto = new CostumerDto();
        userConverter.convertToChildDto(item, dto);
        dto.setFirstname(item.getFirstname());
        dto.setLastname(item.getLastname());
        dto.setPhoneNumber(item.getPhoneNumber());
        dto.setProfile(profile ? userProfileConverter.toDto(item.getProfile()) : null);
        dto.setLikeDislikes(likeDislikes ? likeDislikeConverter.toDto(item.getLikeDislikes()) : null);
        dto.setNotifications(notifications ? notificationConverter.toDto(item.getNotifications()) : null);
        dto.setPosts(posts ? postConverter.toDto(item.getPosts()) : null);
        dto.setComments(comments ? commentConverter.toDto(item.getComments()) : null);
        return dto;
    }

    public void setProfile(boolean value) {
        this.profile = value;
    }

    public void setLikeDislikes(boolean value) {
        this.likeDislikes = value;
    }

    public void setNotifications(boolean value) {
        this.notifications = value;
    }

    public void setPosts(boolean value) {
        this.posts = value;
    }

    public void setComments(boolean value) {
        this.comments = value;
    }

    public void setPostConverter(PostConverter value) {
        this.postConverter = value;
    }

    public PostConverter getPostConverter() {
        return postConverter;
    }

    public void setLikeDislikeConverter(LikeDislikeConverter value) {
        this.likeDislikeConverter = value;
    }

    public LikeDislikeConverter getLikeDislikeConverter() {
        return likeDislikeConverter;
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
}