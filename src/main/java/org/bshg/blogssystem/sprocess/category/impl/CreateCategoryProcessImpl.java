package org.bshg.blogssystem.sprocess.category.impl;

import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.service.facade.CategoryService;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.sprocess.category.facade.CreateCategoryProcess;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateCategoryProcessImpl extends AbstractCreateProcessImpl<Category, CategoryService> implements CreateCategoryProcess {
    public CreateCategoryProcessImpl(CategoryService service, PostService postService) {
        super(service);
        this.postService = postService;
    }

    @Override
    public Category run(Category item) {
// Your Insert Logic For 'Category'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Category item) {
        ProcessHelper.createList(item, Category::getPosts, Post::setCategory, createPostProcess);
    }

    @Override
    public void configure() {
        configure(Category.class);
    }

    private final PostService postService;
    private CreatePostProcess createPostProcess;

    public void setCreatePostProcess(CreatePostProcess value) {
        this.createPostProcess = value;
    }
}