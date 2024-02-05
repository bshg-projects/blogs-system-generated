package org.bshg.blogssystem.sprocess.costumer;

import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.impl.CreateCostumerProcessImpl;
import org.bshg.blogssystem.sprocess.costumer.impl.DeleteCostumerProcessImpl;
import org.bshg.blogssystem.sprocess.costumer.impl.UpdateCostumerProcessImpl;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.notification.facade.CreateNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.facade.DeleteNotificationProcess;
import org.bshg.blogssystem.sprocess.notification.facade.UpdateNotificationProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.CreateUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.DeleteUserProfileProcess;
import org.bshg.blogssystem.sprocess.userprofile.facade.UpdateUserProfileProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Costumer Processes (Create, Update, Delete).
 */
@Configuration
public class CostumerInjector {
    @Bean
    public CreateCostumerProcess createCostumerProcess(CostumerService service, UserProfileService userProfileService, NotificationService notificationService, CommentService commentService, LikeDislikeService likeDislikeService, PostService postService) {
        var bean = new CreateCostumerProcessImpl(service, userProfileService, notificationService, commentService, likeDislikeService, postService);
        bean.setCreateUserProfileProcess(this.createUserProfileProcess);
        bean.setCreateNotificationProcess(this.createNotificationProcess);
        bean.setCreateCommentProcess(this.createCommentProcess);
        bean.setCreateLikeDislikeProcess(this.createLikeDislikeProcess);
        bean.setCreatePostProcess(this.createPostProcess);
        return bean;
    }

    @Bean
    public UpdateCostumerProcess updateCostumerProcess(CostumerService service, UserProfileService userProfileService, NotificationService notificationService, CommentService commentService, LikeDislikeService likeDislikeService, PostService postService) {
        var bean = new UpdateCostumerProcessImpl(service, userProfileService, notificationService, commentService, likeDislikeService, postService);
        bean.setUpdateUserProfileProcess(this.updateUserProfileProcess);
        bean.setDeleteUserProfileProcess(this.deleteUserProfileProcess);
        bean.setUpdateNotificationProcess(this.updateNotificationProcess);
        bean.setDeleteNotificationProcess(this.deleteNotificationProcess);
        bean.setUpdateCommentProcess(this.updateCommentProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
        bean.setUpdateLikeDislikeProcess(this.updateLikeDislikeProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setUpdatePostProcess(this.updatePostProcess);
        bean.setDeletePostProcess(this.deletePostProcess);
        return bean;
    }

    @Bean
    public DeleteCostumerProcess deleteCostumerProcess(CostumerService service, UserProfileService userProfileService, NotificationService notificationService, CommentService commentService, LikeDislikeService likeDislikeService, PostService postService) {
        var bean = new DeleteCostumerProcessImpl(service, userProfileService, notificationService, commentService, likeDislikeService, postService);
        bean.setDeleteUserProfileProcess(this.deleteUserProfileProcess);
        bean.setDeleteNotificationProcess(this.deleteNotificationProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setDeletePostProcess(this.deletePostProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateUserProfileProcess createUserProfileProcess;
    @Autowired
    @Lazy
    private UpdateUserProfileProcess updateUserProfileProcess;
    @Autowired
    @Lazy
    private DeleteUserProfileProcess deleteUserProfileProcess;
    @Autowired
    @Lazy
    private CreateNotificationProcess createNotificationProcess;
    @Autowired
    @Lazy
    private UpdateNotificationProcess updateNotificationProcess;
    @Autowired
    @Lazy
    private DeleteNotificationProcess deleteNotificationProcess;
    @Autowired
    @Lazy
    private CreateCommentProcess createCommentProcess;
    @Autowired
    @Lazy
    private UpdateCommentProcess updateCommentProcess;
    @Autowired
    @Lazy
    private DeleteCommentProcess deleteCommentProcess;
    @Autowired
    @Lazy
    private CreateLikeDislikeProcess createLikeDislikeProcess;
    @Autowired
    @Lazy
    private UpdateLikeDislikeProcess updateLikeDislikeProcess;
    @Autowired
    @Lazy
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;
    @Autowired
    @Lazy
    private CreatePostProcess createPostProcess;
    @Autowired
    @Lazy
    private UpdatePostProcess updatePostProcess;
    @Autowired
    @Lazy
    private DeletePostProcess deletePostProcess;
}