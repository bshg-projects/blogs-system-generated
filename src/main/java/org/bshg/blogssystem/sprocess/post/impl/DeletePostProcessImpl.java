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

public class DeletePostProcessImpl extends AbstractDeleteProcessImpl<Post, PostService> implements DeletePostProcess {
    public DeletePostProcessImpl(PostService service, CategoryService categoryService, AdminService adminService, CommentService commentService, LikeDislikeService likeDislikeService, TagService tagService, CostumerService costumerService) {
        super(service);
        this.categoryService = categoryService;
        this.adminService = adminService;
        this.commentService = commentService;
        this.likeDislikeService = likeDislikeService;
        this.tagService = tagService;
        this.costumerService = costumerService;
    }

    @Override
    protected void process(Post item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByAdmin(Admin admin) {
        if (admin != null && admin.getId() != null) {
            service.deleteByAdminId(admin.getId());
        }
    }

    public void deleteByCostumer(Costumer costumer) {
        if (costumer != null && costumer.getId() != null) {
            service.deleteByCostumerId(costumer.getId());
        }
    }

    public void deleteByCategory(Category category) {
        if (category != null && category.getId() != null) {
            service.deleteByCategoryId(category.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Post item) {
        DeleteAdminProcess.deleteByAdmin(item);
        DeleteCostumerProcess.deleteByCostumer(item);
        DeleteCategoryProcess.deleteByCategory(item);
    }

    @Override
    public void configure() {
        configure(Post.class);
    }

    private final CategoryService categoryService;
    private DeleteCategoryProcess deleteCategoryProcess;

    public void setDeleteCategoryProcess(DeleteCategoryProcess value) {
        this.deleteCategoryProcess = value;
    }

    private final AdminService adminService;
    private DeleteAdminProcess deleteAdminProcess;

    public void setDeleteAdminProcess(DeleteAdminProcess value) {
        this.deleteAdminProcess = value;
    }

    private final CommentService commentService;
    private DeleteCommentProcess deleteCommentProcess;

    public void setDeleteCommentProcess(DeleteCommentProcess value) {
        this.deleteCommentProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;

    public void setDeleteLikeDislikeProcess(DeleteLikeDislikeProcess value) {
        this.deleteLikeDislikeProcess = value;
    }

    private final TagService tagService;
    private DeleteTagProcess deleteTagProcess;

    public void setDeleteTagProcess(DeleteTagProcess value) {
        this.deleteTagProcess = value;
    }

    private final CostumerService costumerService;
    private DeleteCostumerProcess deleteCostumerProcess;

    public void setDeleteCostumerProcess(DeleteCostumerProcess value) {
        this.deleteCostumerProcess = value;
    }
}