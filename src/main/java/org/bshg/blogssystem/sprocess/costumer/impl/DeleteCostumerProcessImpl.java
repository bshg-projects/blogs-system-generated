package org.bshg.blogssystem.sprocess.costumer.impl;

import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.UserProfile;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.notification.facade.DeleteNotificationProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.DeleteUserProfileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeleteCostumerProcessImpl extends AbstractDeleteProcessImpl<Costumer, CostumerService> implements DeleteCostumerProcess {
    public DeleteCostumerProcessImpl(CostumerService service, PostService postService, LikeDislikeService likeDislikeService, UserProfileService userProfileService, NotificationService notificationService, CommentService commentService) {
        super(service);
        this.postService = postService;
        this.likeDislikeService = likeDislikeService;
        this.userProfileService = userProfileService;
        this.notificationService = notificationService;
        this.commentService = commentService;
    }

    @Override
    protected void process(Costumer item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByProfile(UserProfile profile) {
        if (profile != null && profile.getId() != null) {
            Costumer found = this.service.findByProfileId(profile.getId());
            if (found == null) return;
            this.deleteAssociatedList(found);
            service.deleteByProfileId(profile.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Costumer item) {
        deleteLikeDislikeProcess.deleteByCostumer(item);
        deleteNotificationProcess.deleteByCostumer(item);
        deletePostProcess.deleteByCostumer(item);
        deleteCommentProcess.deleteByCostumer(item);
    }

    @Override
    public void configure() {
        configure(Costumer.class);
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

    private final UserProfileService userProfileService;
    private DeleteUserProfileProcess deleteUserProfileProcess;

    public void setDeleteUserProfileProcess(DeleteUserProfileProcess value) {
        this.deleteUserProfileProcess = value;
    }

    private final NotificationService notificationService;
    private DeleteNotificationProcess deleteNotificationProcess;

    public void setDeleteNotificationProcess(DeleteNotificationProcess value) {
        this.deleteNotificationProcess = value;
    }

    private final CommentService commentService;
    private DeleteCommentProcess deleteCommentProcess;

    public void setDeleteCommentProcess(DeleteCommentProcess value) {
        this.deleteCommentProcess = value;
    }
}