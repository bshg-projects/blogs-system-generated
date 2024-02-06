package org.bshg.blogssystem.sprocess.admin.impl;

import org.bshg.blogssystem.bean.core.*;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.notification.facade.DeleteNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.facade.UpdateNotificationProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.DeleteUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.UpdateUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateAdminProcessImpl extends AbstractUpdateProcessImpl<Admin, AdminService> implements UpdateAdminProcess {
    public UpdateAdminProcessImpl(AdminService service, PostService postService, LikeDislikeService likeDislikeService, NotificationService notificationService, UserProfileService userProfileService, CommentService commentService) {
        super(service);
        this.postService = postService;
        this.likeDislikeService = likeDislikeService;
        this.notificationService = notificationService;
        this.userProfileService = userProfileService;
        this.commentService = commentService;
    }

    public Admin run(Admin item) {
// Your Update Logic For 'Admin'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Admin item) {
        if (item != null && item.getId() != null) {
            ProcessHelper.updateList(
                    item,
                    likeDislikeService::findByAdminId,
                    Admin::getLikeDislikes,
                    LikeDislike::setAdmin,
                    updateLikeDislikeProcess,
                    deleteLikeDislikeProcess
            );
            ProcessHelper.updateList(
                    item,
                    notificationService::findByAdminId,
                    Admin::getNotifications,
                    Notification::setAdmin,
                    updateNotificationProcess,
                    deleteNotificationProcess
            );
            ProcessHelper.updateList(
                    item,
                    postService::findByAdminId,
                    Admin::getPosts,
                    Post::setAdmin,
                    updatePostProcess,
                    deletePostProcess
            );
            ProcessHelper.updateList(
                    item,
                    commentService::findByAdminId,
                    Admin::getComments,
                    Comment::setAdmin,
                    updateCommentProcess,
                    deleteCommentProcess
            );
        }
    }

    @Override
    public void configure() {
        this.configure(Admin.class);
    }

    private final PostService postService;
    private UpdatePostProcess updatePostProcess;
    private DeletePostProcess deletePostProcess;

    public void setUpdatePostProcess(UpdatePostProcess value) {
        this.updatePostProcess = value;
    }

    public void setDeletePostProcess(DeletePostProcess value) {
        this.deletePostProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private UpdateLikeDislikeProcess updateLikeDislikeProcess;
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;

    public void setUpdateLikeDislikeProcess(UpdateLikeDislikeProcess value) {
        this.updateLikeDislikeProcess = value;
    }

    public void setDeleteLikeDislikeProcess(DeleteLikeDislikeProcess value) {
        this.deleteLikeDislikeProcess = value;
    }

    private final NotificationService notificationService;
    private UpdateNotificationProcess updateNotificationProcess;
    private DeleteNotificationProcess deleteNotificationProcess;

    public void setUpdateNotificationProcess(UpdateNotificationProcess value) {
        this.updateNotificationProcess = value;
    }

    public void setDeleteNotificationProcess(DeleteNotificationProcess value) {
        this.deleteNotificationProcess = value;
    }

    private final UserProfileService userProfileService;
    private UpdateUserProfileProcess updateUserProfileProcess;
    private DeleteUserProfileProcess deleteUserProfileProcess;

    public void setUpdateUserProfileProcess(UpdateUserProfileProcess value) {
        this.updateUserProfileProcess = value;
    }

    public void setDeleteUserProfileProcess(DeleteUserProfileProcess value) {
        this.deleteUserProfileProcess = value;
    }

    private final CommentService commentService;
    private UpdateCommentProcess updateCommentProcess;
    private DeleteCommentProcess deleteCommentProcess;

    public void setUpdateCommentProcess(UpdateCommentProcess value) {
        this.updateCommentProcess = value;
    }

    public void setDeleteCommentProcess(DeleteCommentProcess value) {
        this.deleteCommentProcess = value;
    }
}