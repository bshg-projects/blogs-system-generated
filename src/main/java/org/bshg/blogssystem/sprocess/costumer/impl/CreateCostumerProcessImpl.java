package org.bshg.blogssystem.sprocess.costumer.impl;

import org.bshg.blogssystem.bean.core.*;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.notification.facade.CreateNotificationProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.CreateUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateCostumerProcessImpl extends AbstractCreateProcessImpl<Costumer, CostumerService> implements CreateCostumerProcess {
    public CreateCostumerProcessImpl(CostumerService service, UserProfileService userProfileService, NotificationService notificationService, CommentService commentService, LikeDislikeService likeDislikeService, PostService postService) {
        super(service);
        this.userProfileService = userProfileService;
        this.notificationService = notificationService;
        this.commentService = commentService;
        this.likeDislikeService = likeDislikeService;
        this.postService = postService;
    }

    @Override
    public Costumer run(Costumer item) {
// Your Insert Logic For 'Costumer'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Costumer item) {
        ProcessHelper.createList(item, Costumer::getLikeDislikes, LikeDislike::setCostumer, createLikeDislikeProcess);
        ProcessHelper.createList(item, Costumer::getNotifications, Notification::setCostumer, createNotificationProcess);
        ProcessHelper.createList(item, Costumer::getPosts, Post::setCostumer, createPostProcess);
        ProcessHelper.createList(item, Costumer::getComments, Comment::setCostumer, createCommentProcess);
    }

    @Override
    public void configure() {
        configure(Costumer.class);
    }

    private final UserProfileService userProfileService;
    private CreateUserProfileProcess createUserProfileProcess;

    public void setCreateUserProfileProcess(CreateUserProfileProcess value) {
        this.createUserProfileProcess = value;
    }

    private final NotificationService notificationService;
    private CreateNotificationProcess createNotificationProcess;

    public void setCreateNotificationProcess(CreateNotificationProcess value) {
        this.createNotificationProcess = value;
    }

    private final CommentService commentService;
    private CreateCommentProcess createCommentProcess;

    public void setCreateCommentProcess(CreateCommentProcess value) {
        this.createCommentProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private CreateLikeDislikeProcess createLikeDislikeProcess;

    public void setCreateLikeDislikeProcess(CreateLikeDislikeProcess value) {
        this.createLikeDislikeProcess = value;
    }

    private final PostService postService;
    private CreatePostProcess createPostProcess;

    public void setCreatePostProcess(CreatePostProcess value) {
        this.createPostProcess = value;
    }
}