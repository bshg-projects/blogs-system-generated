package org.bshg.blogssystem.sprocess.category.impl;

import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.service.facade.CategoryService;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.sprocess.category.facade.DeleteCategoryProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeleteCategoryProcessImpl extends AbstractDeleteProcessImpl<Category, CategoryService> implements DeleteCategoryProcess {
    public DeleteCategoryProcessImpl(CategoryService service, PostService postService) {
        super(service);
        this.postService = postService;
    }

    @Override
    protected void process(Category item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void deleteAssociatedList(Category item) {
    }

    @Override
    public void configure() {
        configure(Category.class);
    }

    private final PostService postService;
    private DeletePostProcess deletePostProcess;

    public void setDeletePostProcess(DeletePostProcess value) {
        this.deletePostProcess = value;
    }
}