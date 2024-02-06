package org.bshg.blogssystem.sprocess.comment;

import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.comment.impl.CreateCommentProcessImpl;
import org.bshg.blogssystem.sprocess.comment.impl.DeleteCommentProcessImpl;
import org.bshg.blogssystem.sprocess.comment.impl.UpdateCommentProcessImpl;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Comment Processes (Create, Update, Delete).
 */
@Configuration
public class CommentInjector {
    @Bean
    public CreateCommentProcess createCommentProcess(CommentService service, PostService postService, LikeDislikeService likeDislikeService, CostumerService costumerService, AdminService adminService) {
        var bean = new CreateCommentProcessImpl(service, postService, likeDislikeService, costumerService, adminService);
        bean.setCreatePostProcess(this.createPostProcess);
        bean.setCreateLikeDislikeProcess(this.createLikeDislikeProcess);
        bean.setCreateCostumerProcess(this.createCostumerProcess);
        bean.setCreateAdminProcess(this.createAdminProcess);
        return bean;
    }

    @Bean
    public UpdateCommentProcess updateCommentProcess(CommentService service, PostService postService, LikeDislikeService likeDislikeService, CostumerService costumerService, AdminService adminService) {
        var bean = new UpdateCommentProcessImpl(service, postService, likeDislikeService, costumerService, adminService);
        bean.setUpdatePostProcess(this.updatePostProcess);
        bean.setDeletePostProcess(this.deletePostProcess);
        bean.setUpdateLikeDislikeProcess(this.updateLikeDislikeProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setUpdateCostumerProcess(this.updateCostumerProcess);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        bean.setUpdateAdminProcess(this.updateAdminProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        return bean;
    }

    @Bean
    public DeleteCommentProcess deleteCommentProcess(CommentService service, PostService postService, LikeDislikeService likeDislikeService, CostumerService costumerService, AdminService adminService) {
        var bean = new DeleteCommentProcessImpl(service, postService, likeDislikeService, costumerService, adminService);
        bean.setDeletePostProcess(this.deletePostProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
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
    private CreateCostumerProcess createCostumerProcess;
    @Autowired
    @Lazy
    private UpdateCostumerProcess updateCostumerProcess;
    @Autowired
    @Lazy
    private DeleteCostumerProcess deleteCostumerProcess;
    @Autowired
    @Lazy
    private CreateAdminProcess createAdminProcess;
    @Autowired
    @Lazy
    private UpdateAdminProcess updateAdminProcess;
    @Autowired
    @Lazy
    private DeleteAdminProcess deleteAdminProcess;
}