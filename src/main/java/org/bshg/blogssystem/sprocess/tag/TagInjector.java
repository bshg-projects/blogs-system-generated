package org.bshg.blogssystem.sprocess.tag;

import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.service.facade.TagService;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.CreateTagProcess;
import org.bshg.blogssystem.sprocess.tag.facade.DeleteTagProcess;
import org.bshg.blogssystem.sprocess.tag.facade.UpdateTagProcess;
import org.bshg.blogssystem.sprocess.tag.impl.CreateTagProcessImpl;
import org.bshg.blogssystem.sprocess.tag.impl.DeleteTagProcessImpl;
import org.bshg.blogssystem.sprocess.tag.impl.UpdateTagProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Tag Processes (Create, Update, Delete).
 */
@Configuration
public class TagInjector {
    @Bean
    public CreateTagProcess createTagProcess(TagService service, PostService postService) {
        var bean = new CreateTagProcessImpl(service, postService);
        bean.setCreatePostProcess(this.createPostProcess);
        return bean;
    }

    @Bean
    public UpdateTagProcess updateTagProcess(TagService service, PostService postService) {
        var bean = new UpdateTagProcessImpl(service, postService);
        bean.setUpdatePostProcess(this.updatePostProcess);
        bean.setDeletePostProcess(this.deletePostProcess);
        return bean;
    }

    @Bean
    public DeleteTagProcess deleteTagProcess(TagService service, PostService postService) {
        var bean = new DeleteTagProcessImpl(service, postService);
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