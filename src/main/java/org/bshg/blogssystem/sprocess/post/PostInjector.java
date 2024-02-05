package org.bshg.blogssystem.sprocess.post;

import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.category.facade.CreateCategoryProcess;
import org.bshg.blogssystem.sprocess.category.facade.DeleteCategoryProcess;
import org.bshg.blogssystem.sprocess.category.facade.UpdateCategoryProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.sprocess.post.impl.CreatePostProcessImpl;
import org.bshg.blogssystem.sprocess.post.impl.DeletePostProcessImpl;
import org.bshg.blogssystem.sprocess.post.impl.UpdatePostProcessImpl;
import org.bshg.blogssystem.sprocess.tag.facade.CreateTagProcess;
import org.bshg.blogssystem.sprocess.tag.facade.DeleteTagProcess;
import org.bshg.blogssystem.sprocess.tag.facade.UpdateTagProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Post Processes (Create, Update, Delete).
 */
@Configuration
public class PostInjector {
    @Bean
    public CreatePostProcess createPostProcess(PostService service, CategoryService categoryService, AdminService adminService, CommentService commentService, LikeDislikeService likeDislikeService, TagService tagService, CostumerService costumerService) {
        var bean = new CreatePostProcessImpl(service, categoryService, adminService, commentService, likeDislikeService, tagService, costumerService);
        bean.setCreateCategoryProcess(this.createCategoryProcess);
        bean.setCreateAdminProcess(this.createAdminProcess);
        bean.setCreateCommentProcess(this.createCommentProcess);
        bean.setCreateLikeDislikeProcess(this.createLikeDislikeProcess);
        bean.setCreateTagProcess(this.createTagProcess);
        bean.setCreateCostumerProcess(this.createCostumerProcess);
        return bean;
    }

    @Bean
    public UpdatePostProcess updatePostProcess(PostService service, CategoryService categoryService, AdminService adminService, CommentService commentService, LikeDislikeService likeDislikeService, TagService tagService, CostumerService costumerService) {
        var bean = new UpdatePostProcessImpl(service, categoryService, adminService, commentService, likeDislikeService, tagService, costumerService);
        bean.setUpdateCategoryProcess(this.updateCategoryProcess);
        bean.setDeleteCategoryProcess(this.deleteCategoryProcess);
        bean.setUpdateAdminProcess(this.updateAdminProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        bean.setUpdateCommentProcess(this.updateCommentProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
        bean.setUpdateLikeDislikeProcess(this.updateLikeDislikeProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setUpdateTagProcess(this.updateTagProcess);
        bean.setDeleteTagProcess(this.deleteTagProcess);
        bean.setUpdateCostumerProcess(this.updateCostumerProcess);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        return bean;
    }

    @Bean
    public DeletePostProcess deletePostProcess(PostService service, CategoryService categoryService, AdminService adminService, CommentService commentService, LikeDislikeService likeDislikeService, TagService tagService, CostumerService costumerService) {
        var bean = new DeletePostProcessImpl(service, categoryService, adminService, commentService, likeDislikeService, tagService, costumerService);
        bean.setDeleteCategoryProcess(this.deleteCategoryProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        bean.setDeleteCommentProcess(this.deleteCommentProcess);
        bean.setDeleteLikeDislikeProcess(this.deleteLikeDislikeProcess);
        bean.setDeleteTagProcess(this.deleteTagProcess);
        bean.setDeleteCostumerProcess(this.deleteCostumerProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateCategoryProcess createCategoryProcess;
    @Autowired
    @Lazy
    private UpdateCategoryProcess updateCategoryProcess;
    @Autowired
    @Lazy
    private DeleteCategoryProcess deleteCategoryProcess;
    @Autowired
    @Lazy
    private CreateAdminProcess createAdminProcess;
    @Autowired
    @Lazy
    private UpdateAdminProcess updateAdminProcess;
    @Autowired
    @Lazy
    private DeleteAdminProcess deleteAdminProcess;
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
    private CreateTagProcess createTagProcess;
    @Autowired
    @Lazy
    private UpdateTagProcess updateTagProcess;
    @Autowired
    @Lazy
    private DeleteTagProcess deleteTagProcess;
    @Autowired
    @Lazy
    private CreateCostumerProcess createCostumerProcess;
    @Autowired
    @Lazy
    private UpdateCostumerProcess updateCostumerProcess;
    @Autowired
    @Lazy
    private DeleteCostumerProcess deleteCostumerProcess;
}