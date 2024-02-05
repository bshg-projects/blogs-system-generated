package org.bshg.blogssystem.sprocess.category.impl;

import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.service.facade.CategoryService;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.sprocess.category.facade.UpdateCategoryProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.ProcessHelper;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateCategoryProcessImpl extends AbstractUpdateProcessImpl<Category, CategoryService> implements UpdateCategoryProcess {
    public UpdateCategoryProcessImpl(CategoryService service, PostService postService) {
        super(service);
        this.postService = postService;
    }

    public Category run(Category item) {
// Your Update Logic For 'Category'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Category item) {
        if (item != null && item.getId() != null) {
            ProcessHelper.updateList(
                    item,
                    postService::findByCategoryId,
                    Category::getPosts,
                    Post::setCategory,
                    updatePostProcess,
                    deletePostProcess
            );
        }
    }

    @Override
    public void configure() {
        this.configure(Category.class);
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