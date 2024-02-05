package org.bshg.blogssystem.sprocess.comment.impl;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateCommentProcessImpl extends AbstractUpdateProcessImpl<Comment, CommentService> implements UpdateCommentProcess {
    public UpdateCommentProcessImpl(CommentService service, AdminService adminService, LikeDislikeService likeDislikeService, CostumerService costumerService, PostService postService) {
        super(service);
        this.adminService = adminService;
        this.likeDislikeService = likeDislikeService;
        this.costumerService = costumerService;
        this.postService = postService;
    }

    public Comment run(Comment item) {
// Your Update Logic For 'Comment'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Comment item) {
        if (item != null && item.getId() != null) {
            ProcessHelper.updateList(
                    item,
                    likeDislikeService::findByCommentId,
                    Comment::getLikesDislikes,
                    LikeDislike::setComment,
                    updateLikeDislikeProcess,
                    deleteLikeDislikeProcess
            );
        }
    }

    @Override
    public void configure() {
        this.configure(Comment.class);
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

    private final LikeDislikeService likeDislikeService;
    private UpdateLikeDislikeProcess updateLikeDislikeProcess;
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;

    public void setUpdateLikeDislikeProcess(UpdateLikeDislikeProcess value) {
        this.updateLikeDislikeProcess = value;
    }

    public void setDeleteLikeDislikeProcess(DeleteLikeDislikeProcess value) {
        this.deleteLikeDislikeProcess = value;
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