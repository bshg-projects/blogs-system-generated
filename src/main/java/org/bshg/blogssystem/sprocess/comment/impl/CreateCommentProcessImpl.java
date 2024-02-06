package org.bshg.blogssystem.sprocess.comment.impl;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateCommentProcessImpl extends AbstractCreateProcessImpl<Comment, CommentService> implements CreateCommentProcess {
    public CreateCommentProcessImpl(CommentService service, PostService postService, LikeDislikeService likeDislikeService, CostumerService costumerService, AdminService adminService) {
        super(service);
        this.postService = postService;
        this.likeDislikeService = likeDislikeService;
        this.costumerService = costumerService;
        this.adminService = adminService;
    }

    @Override
    public Comment run(Comment item) {
// Your Insert Logic For 'Comment'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Comment item) {
        ProcessHelper.createList(item, Comment::getLikesDislikes, LikeDislike::setComment, createLikeDislikeProcess);
    }

    @Override
    public void configure() {
        configure(Comment.class);
    }

    private final PostService postService;
    private CreatePostProcess createPostProcess;

    public void setCreatePostProcess(CreatePostProcess value) {
        this.createPostProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private CreateLikeDislikeProcess createLikeDislikeProcess;

    public void setCreateLikeDislikeProcess(CreateLikeDislikeProcess value) {
        this.createLikeDislikeProcess = value;
    }

    private final CostumerService costumerService;
    private CreateCostumerProcess createCostumerProcess;

    public void setCreateCostumerProcess(CreateCostumerProcess value) {
        this.createCostumerProcess = value;
    }

    private final AdminService adminService;
    private CreateAdminProcess createAdminProcess;

    public void setCreateAdminProcess(CreateAdminProcess value) {
        this.createAdminProcess = value;
    }
}