package org.bshg.blogssystem.sprocess.admin.impl;

import org.bshg.blogssystem.bean.core.*;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.notification.facade.CreateNotificationProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.CreateUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateAdminProcessImpl extends AbstractCreateProcessImpl<Admin, AdminService> implements CreateAdminProcess {
    public CreateAdminProcessImpl(AdminService service, UserProfileService userProfileService, NotificationService notificationService, CommentService commentService, LikeDislikeService likeDislikeService, PostService postService) {
        super(service);
        this.userProfileService = userProfileService;
        this.notificationService = notificationService;
        this.commentService = commentService;
        this.likeDislikeService = likeDislikeService;
        this.postService = postService;
    }

    @Override
    public Admin run(Admin item) {
// Your Insert Logic For 'Admin'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Admin item) {
        ProcessHelper.createList(item, Admin::getLikeDislikes, LikeDislike::setAdmin, createLikeDislikeProcess);
        ProcessHelper.createList(item, Admin::getNotifications, Notification::setAdmin, createNotificationProcess);
        ProcessHelper.createList(item, Admin::getPosts, Post::setAdmin, createPostProcess);
        ProcessHelper.createList(item, Admin::getComments, Comment::setAdmin, createCommentProcess);
    }

    @Override
    public void configure() {
        configure(Admin.class);
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