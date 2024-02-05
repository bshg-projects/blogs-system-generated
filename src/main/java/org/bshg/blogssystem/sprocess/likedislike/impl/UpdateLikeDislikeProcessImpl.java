package org.bshg.blogssystem.sprocess.likedislike.impl;

import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.admin.facade.UpdateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.comment.facade.UpdateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.UpdateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.UpdateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateLikeDislikeProcessImpl extends AbstractUpdateProcessImpl<LikeDislike, LikeDislikeService> implements UpdateLikeDislikeProcess {
    public UpdateLikeDislikeProcessImpl(LikeDislikeService service, AdminService adminService, CommentService commentService, CostumerService costumerService, PostService postService) {
        super(service);
        this.adminService = adminService;
        this.commentService = commentService;
        this.costumerService = costumerService;
        this.postService = postService;
    }

    public LikeDislike run(LikeDislike item) {
// Your Update Logic For 'LikeDislike'
        item = service.edit(item);
        return item;
    }

    @Override
    public void configure() {
        this.configure(LikeDislike.class);
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