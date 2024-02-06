package org.bshg.blogssystem.sprocess.likedislike;

import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.impl.CreateLikeDislikeProcessImpl;
import org.bshg.blogssystem.sprocess.likedislike.impl.DeleteLikeDislikeProcessImpl;
import org.bshg.blogssystem.sprocess.likedislike.impl.UpdateLikeDislikeProcessImpl;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject LikeDislike Processes (Create, Update, Delete).
 */
@Configuration
public class LikeDislikeInjector {
    @Bean
    public CreateLikeDislikeProcess createLikeDislikeProcess(LikeDislikeService service, PostService postService, CostumerService costumerService, CommentService commentService, AdminService adminService) {
        var bean = new CreateLikeDislikeProcessImpl(service, postService, costumerService, commentService, adminService);
        bean.setCreatePostProcess(this.createPostProcess);
        bean.setCreateCostumerProcess(this.createCostumerProcess);
        bean.setCreateCommentProcess(this.createCommentProcess);
        bean.setCreateAdminProcess(this.createAdminProcess);
        return bean;
    }

    @Bean
    public UpdateLikeDislikeProcess updateLikeDislikeProcess(LikeDislikeService service, PostService postService, CostumerService costumerService, CommentService commentService, AdminService adminService) {
        var bean = new UpdateLikeDislikeProcessImpl(service, postService, costumerService, commentService, adminService);
        bean.setUpdatePostProcess(this.updatePostProcess);
        bean.setDeletePostProcess(this.deletePostProcess);
        bean.setUpdateCostumerProcess(this.updateCostumerProcess);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        bean.setUpdateCommentProcess(this.updateCommentProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
        bean.setUpdateAdminProcess(this.updateAdminProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        return bean;
    }

    @Bean
    public DeleteLikeDislikeProcess deleteLikeDislikeProcess(LikeDislikeService service, PostService postService, CostumerService costumerService, CommentService commentService, AdminService adminService) {
        var bean = new DeleteLikeDislikeProcessImpl(service, postService, costumerService, commentService, adminService);
        bean.setDeletePostProcess(this.deletePostProcess);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
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
    private CreateCostumerProcess createCostumerProcess;
    @Autowired
    @Lazy
    private UpdateCostumerProcess updateCostumerProcess;
    @Autowired
    @Lazy
    private DeleteCostumerProcess deleteCostumerProcess;
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
    private CreateAdminProcess createAdminProcess;
    @Autowired
    @Lazy
    private UpdateAdminProcess updateAdminProcess;
    @Autowired
    @Lazy
    private DeleteAdminProcess deleteAdminProcess;
}