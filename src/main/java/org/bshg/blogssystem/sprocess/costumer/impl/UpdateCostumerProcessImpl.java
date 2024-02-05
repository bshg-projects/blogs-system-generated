package org.bshg.blogssystem.sprocess.costumer.impl;

import org.bshg.blogssystem.bean.core.*;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
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

public class UpdateCostumerProcessImpl extends AbstractUpdateProcessImpl<Costumer, CostumerService> implements UpdateCostumerProcess {
    public UpdateCostumerProcessImpl(CostumerService service, UserProfileService userProfileService, NotificationService notificationService, CommentService commentService, LikeDislikeService likeDislikeService, PostService postService) {
        super(service);
        this.userProfileService = userProfileService;
        this.notificationService = notificationService;
        this.commentService = commentService;
        this.likeDislikeService = likeDislikeService;
        this.postService = postService;
    }

    public Costumer run(Costumer item) {
// Your Update Logic For 'Costumer'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Costumer item) {
        if (item != null && item.getId() != null) {
            ProcessHelper.updateList(
                    item,
                    likeDislikeService::findByCostumerId,
                    Costumer::getLikeDislikes,
                    LikeDislike::setCostumer,
                    updateLikeDislikeProcess,
                    deleteLikeDislikeProcess
            );
            ProcessHelper.updateList(
                    item,
                    notificationService::findByCostumerId,
                    Costumer::getNotifications,
                    Notification::setCostumer,
                    updateNotificationProcess,
                    deleteNotificationProcess
            );
            ProcessHelper.updateList(
                    item,
                    postService::findByCostumerId,
                    Costumer::getPosts,
                    Post::setCostumer,
                    updatePostProcess,
                    deletePostProcess
            );
            ProcessHelper.updateList(
                    item,
                    commentService::findByCostumerId,
                    Costumer::getComments,
                    Comment::setCostumer,
                    updateCommentProcess,
                    deleteCommentProcess
            );
        }
    }

    @Override
    public void configure() {
        this.configure(Costumer.class);
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

    private final NotificationService notificationService;
    private UpdateNotificationProcess updateNotificationProcess;
    private DeleteNotificationProcess deleteNotificationProcess;

    public void setUpdateNotificationProcess(UpdateNotificationProcess value) {
        this.updateNotificationProcess = value;
    }

    public void setDeleteNotificationProcess(DeleteNotificationProcess value) {
        this.deleteNotificationProcess = value;
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

    private final LikeDislikeService likeDislikeService;
    private UpdateLikeDislikeProcess updateLikeDislikeProcess;
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;

    public void setUpdateLikeDislikeProcess(UpdateLikeDislikeProcess value) {
        this.updateLikeDislikeProcess = value;
    }

    public void setDeleteLikeDislikeProcess(DeleteLikeDislikeProcess value) {
        this.deleteLikeDislikeProcess = value;
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
}