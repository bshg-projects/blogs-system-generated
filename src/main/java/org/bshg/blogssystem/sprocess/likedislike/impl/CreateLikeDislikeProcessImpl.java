package org.bshg.blogssystem.sprocess.likedislike.impl;

import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateLikeDislikeProcessImpl extends AbstractCreateProcessImpl<LikeDislike, LikeDislikeService> implements CreateLikeDislikeProcess {
    public CreateLikeDislikeProcessImpl(LikeDislikeService service, PostService postService, CostumerService costumerService, CommentService commentService, AdminService adminService) {
        super(service);
        this.postService = postService;
        this.costumerService = costumerService;
        this.commentService = commentService;
        this.adminService = adminService;
    }

    @Override
    public LikeDislike run(LikeDislike item) {
// Your Insert Logic For 'LikeDislike'
        item = service.create(item);
        return item;
    }

    @Override
    public void configure() {
        configure(LikeDislike.class);
    }

    private final PostService postService;
    private CreatePostProcess createPostProcess;

    public void setCreatePostProcess(CreatePostProcess value) {
        this.createPostProcess = value;
    }

    private final CostumerService costumerService;
    private CreateCostumerProcess createCostumerProcess;

    public void setCreateCostumerProcess(CreateCostumerProcess value) {
        this.createCostumerProcess = value;
    }

    private final CommentService commentService;
    private CreateCommentProcess createCommentProcess;

    public void setCreateCommentProcess(CreateCommentProcess value) {
        this.createCommentProcess = value;
    }

    private final AdminService adminService;
    private CreateAdminProcess createAdminProcess;

    public void setCreateAdminProcess(CreateAdminProcess value) {
        this.createAdminProcess = value;
    }
}