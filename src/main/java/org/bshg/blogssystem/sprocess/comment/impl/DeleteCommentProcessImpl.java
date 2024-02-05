package org.bshg.blogssystem.sprocess.comment.impl;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.DeleteAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.DeleteCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.DeleteCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.DeleteLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeleteCommentProcessImpl extends AbstractDeleteProcessImpl<Comment, CommentService> implements DeleteCommentProcess {
    public DeleteCommentProcessImpl(CommentService service, AdminService adminService, LikeDislikeService likeDislikeService, CostumerService costumerService, PostService postService) {
        super(service);
        this.adminService = adminService;
        this.likeDislikeService = likeDislikeService;
        this.costumerService = costumerService;
        this.postService = postService;
    }

    @Override
    protected void process(Comment item) {
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

    public void deleteByPost(Post post) {
        if (post != null && post.getId() != null) {
            service.deleteByPostId(post.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Comment item) {
        DeleteAdminProcess.deleteByAdmin(item);
        DeleteCostumerProcess.deleteByCostumer(item);
        DeletePostProcess.deleteByPost(item);
    }

    @Override
    public void configure() {
        configure(Comment.class);
    }

    private final AdminService adminService;
    private DeleteAdminProcess deleteAdminProcess;

    public void setDeleteAdminProcess(DeleteAdminProcess value) {
        this.deleteAdminProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private DeleteLikeDislikeProcess deleteLikeDislikeProcess;

    public void setDeleteLikeDislikeProcess(DeleteLikeDislikeProcess value) {
        this.deleteLikeDislikeProcess = value;
    }

    private final CostumerService costumerService;
    private DeleteCostumerProcess deleteCostumerProcess;

    public void setDeleteCostumerProcess(DeleteCostumerProcess value) {
        this.deleteCostumerProcess = value;
    }

    private final PostService postService;
    private DeletePostProcess deletePostProcess;

    public void setDeletePostProcess(DeletePostProcess value) {
        this.deletePostProcess = value;
    }
}