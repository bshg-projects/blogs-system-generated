package org.bshg.blogssystem.sprocess.post.impl;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.category.facade.DeleteCategoryProcess;
import org.bshg.blogssystem.sprocess.category.facade.UpdateCategoryProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.DeleteTagProcess;
import org.bshg.blogssystem.sprocess.tag.facade.UpdateTagProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdatePostProcessImpl extends AbstractUpdateProcessImpl<Post, PostService> implements UpdatePostProcess {
    public UpdatePostProcessImpl(PostService service, CategoryService categoryService, AdminService adminService, CommentService commentService, LikeDislikeService likeDislikeService, TagService tagService, CostumerService costumerService) {
        super(service);
        this.categoryService = categoryService;
        this.adminService = adminService;
        this.commentService = commentService;
        this.likeDislikeService = likeDislikeService;
        this.tagService = tagService;
        this.costumerService = costumerService;
    }

    public Post run(Post item) {
// Your Update Logic For 'Post'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Post item) {
        if (item != null && item.getId() != null) {
            ProcessHelper.updateList(
                    item,
                    tagService::findByPostId,
                    Post::getTags,
                    Tag::setPost,
                    updateTagProcess,
                    deleteTagProcess
            );
            ProcessHelper.updateList(
                    item,
                    commentService::findByPostId,
                    Post::getComments,
                    Comment::setPost,
                    updateCommentProcess,
                    deleteCommentProcess
            );
            ProcessHelper.updateList(
                    item,
                    likeDislikeService::findByPostId,
                    Post::getLikesDislikes,
                    LikeDislike::setPost,
                    updateLikeDislikeProcess,
                    deleteLikeDislikeProcess
            );
        }
    }

    @Override
    public void configure() {
        this.configure(Post.class);
    }

    private final CategoryService categoryService;
    private UpdateCategoryProcess updateCategoryProcess;
    private DeleteCategoryProcess deleteCategoryProcess;

    public void setUpdateCategoryProcess(UpdateCategoryProcess value) {
        this.updateCategoryProcess = value;
    }

    public void setDeleteCategoryProcess(DeleteCategoryProcess value) {
        this.deleteCategoryProcess = value;
    }

    private final AdminService adminService;
    private UpdateAdminProcess updateAdminProcess;
    private DeleteAdminProcess deleteAdminProcess;

    public void setUpdateAdminProcess(UpdateAdminProcess value) {
        this.updateAdminProcess = value;
    }

    public void setDeleteAdminProcess(DeleteAdminProcess value) {
        this.deleteAdminProcess = value;
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

    private final TagService tagService;
    private UpdateTagProcess updateTagProcess;
    private DeleteTagProcess deleteTagProcess;

    public void setUpdateTagProcess(UpdateTagProcess value) {
        this.updateTagProcess = value;
    }

    public void setDeleteTagProcess(DeleteTagProcess value) {
        this.deleteTagProcess = value;
    }

    private final CostumerService costumerService;
    private UpdateCostumerProcess updateCostumerProcess;
    private DeleteCostumerProcess deleteCostumerProcess;

    public void setUpdateCostumerProcess(UpdateCostumerProcess value) {
        this.updateCostumerProcess = value;
    }

    public void setDeleteCostumerProcess(DeleteCostumerProcess value) {
        this.deleteCostumerProcess = value;
    }
}