package org.bshg.blogssystem.sprocess.likedislike.impl;

import org.bshg.blogssystem.bean.core.*;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

import java.util.List;

public class DeleteLikeDislikeProcessImpl extends AbstractDeleteProcessImpl<LikeDislike, LikeDislikeService> implements DeleteLikeDislikeProcess {
    public DeleteLikeDislikeProcessImpl(LikeDislikeService service, PostService postService, CostumerService costumerService, CommentService commentService, AdminService adminService) {
        super(service);
        this.postService = postService;
        this.costumerService = costumerService;
        this.commentService = commentService;
        this.adminService = adminService;
    }

    @Override
    protected void process(LikeDislike item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByAdmin(Admin admin) {
        if (admin != null && admin.getId() != null) {
            List<LikeDislike> found = this.service.findByAdminId(admin.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByAdminId(admin.getId());
        }
    }

    public void deleteByCostumer(Costumer costumer) {
        if (costumer != null && costumer.getId() != null) {
            List<LikeDislike> found = this.service.findByCostumerId(costumer.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByCostumerId(costumer.getId());
        }
    }

    public void deleteByPost(Post post) {
        if (post != null && post.getId() != null) {
            List<LikeDislike> found = this.service.findByPostId(post.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByPostId(post.getId());
        }
    }

    public void deleteByComment(Comment comment) {
        if (comment != null && comment.getId() != null) {
            List<LikeDislike> found = this.service.findByCommentId(comment.getId());
            if (found == null) return;
            found.forEach(this::deleteAssociatedList);
            service.deleteByCommentId(comment.getId());
        }
    }

    @Override
    public void configure() {
        configure(LikeDislike.class);
    }

    private final PostService postService;
    private DeletePostProcess deletePostProcess;

    public void setDeletePostProcess(DeletePostProcess value) {
        this.deletePostProcess = value;
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