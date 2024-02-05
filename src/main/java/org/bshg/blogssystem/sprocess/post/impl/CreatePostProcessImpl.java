package org.bshg.blogssystem.sprocess.post.impl;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.sprocess.admin.facade.CreateAdminProcess;
import org.bshg.blogssystem.sprocess.category.facade.CreateCategoryProcess;
import org.bshg.blogssystem.sprocess.comment.facade.CreateCommentProcess;
import org.bshg.blogssystem.sprocess.costumer.facade.CreateCostumerProcess;
import org.bshg.blogssystem.sprocess.likedislike.facade.CreateLikeDislikeProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.CreateTagProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreatePostProcessImpl extends AbstractCreateProcessImpl<Post, PostService> implements CreatePostProcess {
    public CreatePostProcessImpl(PostService service, CategoryService categoryService, AdminService adminService, CommentService commentService, LikeDislikeService likeDislikeService, TagService tagService, CostumerService costumerService) {
        super(service);
        this.categoryService = categoryService;
        this.adminService = adminService;
        this.commentService = commentService;
        this.likeDislikeService = likeDislikeService;
        this.tagService = tagService;
        this.costumerService = costumerService;
    }

    @Override
    public Post run(Post item) {
// Your Insert Logic For 'Post'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Post item) {
        ProcessHelper.createList(item, Post::getTags, Tag::setPost, createTagProcess);
        ProcessHelper.createList(item, Post::getComments, Comment::setPost, createCommentProcess);
        ProcessHelper.createList(item, Post::getLikesDislikes, LikeDislike::setPost, createLikeDislikeProcess);
    }

    @Override
    public void configure() {
        configure(Post.class);
    }

    private final CategoryService categoryService;
    private CreateCategoryProcess createCategoryProcess;

    public void setCreateCategoryProcess(CreateCategoryProcess value) {
        this.createCategoryProcess = value;
    }

    private final AdminService adminService;
    private CreateAdminProcess createAdminProcess;

    public void setCreateAdminProcess(CreateAdminProcess value) {
        this.createAdminProcess = value;
    }

    private final CommentService commentService;
    private CreateCommentProcess createCommentProcess;

    public void setCreateCommentProcess(CreateCommentProcess value) {
        this.createCommentProcess = value;
    }

    private final LikeDislikeService likeDislikeService;
    private CreateLikeDislikeProcess createLikeDislikeProcess;

    public void setCreateLikeDislikeProcess(CreateLikeDislikeProcess value) {
        this.createLikeDislikeProcess = value;
    }

    private final TagService tagService;
    private CreateTagProcess createTagProcess;

    public void setCreateTagProcess(CreateTagProcess value) {
        this.createTagProcess = value;
    }

    private final CostumerService costumerService;
    private CreateCostumerProcess createCostumerProcess;

    public void setCreateCostumerProcess(CreateCostumerProcess value) {
        this.createCostumerProcess = value;
    }
}