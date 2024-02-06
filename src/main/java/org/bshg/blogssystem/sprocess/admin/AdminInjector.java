package org.bshg.blogssystem.sprocess.admin;

import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.admin.impl.CreateAdminProcessImpl;
import org.bshg.blogssystem.sprocess.admin.impl.DeleteAdminProcessImpl;
import org.bshg.blogssystem.sprocess.admin.impl.UpdateAdminProcessImpl;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
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
 * Inject Admin Processes (Create, Update, Delete).
 */
@Configuration
public class AdminInjector {
    @Bean
    public CreateAdminProcess createAdminProcess(AdminService service, PostService postService, LikeDislikeService likeDislikeService, NotificationService notificationService, UserProfileService userProfileService, CommentService commentService) {
        var bean = new CreateAdminProcessImpl(service, postService, likeDislikeService, notificationService, userProfileService, commentService);
        bean.setCreatePostProcess(this.createPostProcess);
        bean.setCreateLikeDislikeProcess(this.createLikeDislikeProcess);
        bean.setCreateNotificationProcess(this.createNotificationProcess);
        bean.setCreateUserProfileProcess(this.createUserProfileProcess);
        bean.setCreateCommentProcess(this.createCommentProcess);
        return bean;
    }

    @Bean
    public UpdateAdminProcess updateAdminProcess(AdminService service, PostService postService, LikeDislikeService likeDislikeService, NotificationService notificationService, UserProfileService userProfileService, CommentService commentService) {
        var bean = new UpdateAdminProcessImpl(service, postService, likeDislikeService, notificationService, userProfileService, commentService);
        bean.setUpdatePostProcess(this.updatePostProcess);
        bean.setDeletePostProcess(this.deletePostProcess);
        bean.setUpdateLikeDislikeProcess(this.updateLikeDislikeProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setUpdateNotificationProcess(this.updateNotificationProcess);
        bean.setDeleteNotificationProcess(this.deleteNotificationProcess);
        bean.setUpdateUserProfileProcess(this.updateUserProfileProcess);
        bean.setDeleteUserProfileProcess(this.deleteUserProfileProcess);
        bean.setUpdateCommentProcess(this.updateCommentProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
        return bean;
    }

    @Bean
    public DeleteAdminProcess deleteAdminProcess(AdminService service, PostService postService, LikeDislikeService likeDislikeService, NotificationService notificationService, UserProfileService userProfileService, CommentService commentService) {
        var bean = new DeleteAdminProcessImpl(service, postService, likeDislikeService, notificationService, userProfileService, commentService);
        bean.setDeletePostProcess(this.deletePostProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setDeleteNotificationProcess(this.deleteNotificationProcess);
        bean.setDeleteUserProfileProcess(this.deleteUserProfileProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreatePostProcess createPostProcess;
    @Autowired
    @Lazy
    private UpdatePostProcess updatePostProcess;
    @Autowired
    @Lazy
    private DeletePostProcess deletePostProcess;
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
    private CreateNotificationProcess createNotificationProcess;
    @Autowired
    @Lazy
    private UpdateNotificationProcess updateNotificationProcess;
    @Autowired
    @Lazy
    private DeleteNotificationProcess deleteNotificationProcess;
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
    private CreateCommentProcess createCommentProcess;
    @Autowired
    @Lazy
    private UpdateCommentProcess updateCommentProcess;
    @Autowired
    @Lazy
    private DeleteCommentProcess deleteCommentProcess;
}