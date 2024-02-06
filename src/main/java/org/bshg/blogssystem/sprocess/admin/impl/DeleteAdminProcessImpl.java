package org.bshg.blogssystem.sprocess.admin.impl;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.notification.facade.DeleteNotificationProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.DeleteUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeleteAdminProcessImpl extends AbstractDeleteProcessImpl<Admin, AdminService> implements DeleteAdminProcess {
    public DeleteAdminProcessImpl(AdminService service, PostService postService, LikeDislikeService likeDislikeService, NotificationService notificationService, UserProfileService userProfileService, CommentService commentService) {
        super(service);
        this.postService = postService;
        this.likeDislikeService = likeDislikeService;
        this.notificationService = notificationService;
        this.userProfileService = userProfileService;
        this.commentService = commentService;
    }

    @Override
    protected void process(Admin item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByProfile(UserProfile profile) {
        if (profile != null && profile.getId() != null) {
            Admin found = this.service.findByProfileId(profile.getId());
            if (found == null) return;
            this.deleteAssociatedList(found);
            service.deleteByProfileId(profile.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Admin item) {
        deleteLikeDislikeProcess.deleteByAdmin(item);
        deleteNotificationProcess.deleteByAdmin(item);
        deletePostProcess.deleteByAdmin(item);
        deleteCommentProcess.deleteByAdmin(item);
    }

    @Override
    public void configure() {
        configure(Admin.class);
    }

    private final PostService postService;
    private DeletePostProcess deletePostProcess;

    public void setDeletePostProcess(DeletePostProcess value) {
        this.deletePostProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;

    public void setDeleteLikeDislikeProcess(DeleteLikeDislikeProcess value) {
        this.deleteLikeDislikeProcess = value;
    }

    private final NotificationService notificationService;
    private DeleteNotificationProcess deleteNotificationProcess;

    public void setDeleteNotificationProcess(DeleteNotificationProcess value) {
        this.deleteNotificationProcess = value;
    }

    private final UserProfileService userProfileService;
    private DeleteUserProfileProcess deleteUserProfileProcess;

    public void setDeleteUserProfileProcess(DeleteUserProfileProcess value) {
        this.deleteUserProfileProcess = value;
    }

    private final CommentService commentService;
    private DeleteCommentProcess deleteCommentProcess;

    public void setDeleteCommentProcess(DeleteCommentProcess value) {
        this.deleteCommentProcess = value;
    }
}