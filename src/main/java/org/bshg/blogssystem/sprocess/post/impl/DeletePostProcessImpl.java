package org.bshg.blogssystem.sprocess.post.impl;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.category.facade.DeleteCategoryProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.DeleteTagProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

import java.util.List;

public class DeletePostProcessImpl extends AbstractDeleteProcessImpl<Post, PostService> implements DeletePostProcess {
    public DeletePostProcessImpl(PostService service, TagService tagService, LikeDislikeService likeDislikeService, CategoryService categoryService, CostumerService costumerService, CommentService commentService, AdminService adminService) {
        super(service);
        this.tagService = tagService;
        this.likeDislikeService = likeDislikeService;
        this.categoryService = categoryService;
        this.costumerService = costumerService;
        this.commentService = commentService;
        this.adminService = adminService;
    }

    @Override
    protected void process(Post item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByAdmin(Admin admin) {
        if (admin != null && admin.getId() != null) {
            List<Post> found = this.service.findByAdminId(admin.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByAdminId(admin.getId());
        }
    }

    public void deleteByCostumer(Costumer costumer) {
        if (costumer != null && costumer.getId() != null) {
            List<Post> found = this.service.findByCostumerId(costumer.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByCostumerId(costumer.getId());
        }
    }

    public void deleteByCategory(Category category) {
        if (category != null && category.getId() != null) {
            List<Post> found = this.service.findByCategoryId(category.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByCategoryId(category.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Post item) {
        deleteTagProcess.deleteByPost(item);
        deleteCommentProcess.deleteByPost(item);
        deleteLikeDislikeProcess.deleteByPost(item);
    }

    @Override
    public void configure() {
        configure(Post.class);
    }

    private final TagService tagService;
    private DeleteTagProcess deleteTagProcess;

    public void setDeleteTagProcess(DeleteTagProcess value) {
        this.deleteTagProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;

    public void setDeleteLikeDislikeProcess(DeleteLikeDislikeProcess value) {
        this.deleteLikeDislikeProcess = value;
    }

    private final CategoryService categoryService;
    private DeleteCategoryProcess deleteCategoryProcess;

    public void setDeleteCategoryProcess(DeleteCategoryProcess value) {
        this.deleteCategoryProcess = value;
    }

    private final CostumerService costumerService;
    private DeleteCostumerProcess deleteCostumerProcess;

    public void setDeleteCostumerProcess(DeleteCostumerProcess value) {
        this.deleteCostumerProcess = value;
    }

    private final CommentService commentService;
    private DeleteCommentProcess deleteCommentProcess;

    public void setDeleteCommentProcess(DeleteCommentProcess value) {
        this.deleteCommentProcess = value;
    }

    private final AdminService adminService;
    private DeleteAdminProcess deleteAdminProcess;

    public void setDeleteAdminProcess(DeleteAdminProcess value) {
        this.deleteAdminProcess = value;
    }
}