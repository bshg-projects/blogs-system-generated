package org.bshg.blogssystem.sprocess.category;

import org.bshg.blogssystem.service.facade.CategoryService;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.sprocess.category.facade.CreateCategoryProcess;
import org.bshg.blogssystem.sprocess.category.facade.DeleteCategoryProcess;
import org.bshg.blogssystem.sprocess.category.facade.UpdateCategoryProcess;
import org.bshg.blogssystem.sprocess.category.impl.CreateCategoryProcessImpl;
import org.bshg.blogssystem.sprocess.category.impl.DeleteCategoryProcessImpl;
import org.bshg.blogssystem.sprocess.category.impl.UpdateCategoryProcessImpl;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Category Processes (Create, Update, Delete).
 */
@Configuration
public class CategoryInjector {
    @Bean
    public CreateCategoryProcess createCategoryProcess(CategoryService service, PostService postService) {
        var bean = new CreateCategoryProcessImpl(service, postService);
        bean.setCreatePostProcess(this.createPostProcess);
        return bean;
    }

    @Bean
    public UpdateCategoryProcess updateCategoryProcess(CategoryService service, PostService postService) {
        var bean = new UpdateCategoryProcessImpl(service, postService);
        bean.setUpdatePostProcess(this.updatePostProcess);
        bean.setDeletePostProcess(this.deletePostProcess);
        return bean;
    }

    @Bean
    public DeleteCategoryProcess deleteCategoryProcess(CategoryService service, PostService postService) {
        var bean = new DeleteCategoryProcessImpl(service, postService);
        bean.setDeletePostProcess(this.deletePostProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreatePostProcess createPostProcess;
    @Autowired
    @Lazy
    private UpdatePostProcess updatePostProcess;
    @Autowired
    @Lazy
    private DeletePostProcess deletePostProcess;
}