package org.bshg.blogssystem.sprocess.tag.impl;

import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.service.facade.TagService;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.DeleteTagProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeleteTagProcessImpl extends AbstractDeleteProcessImpl<Tag, TagService> implements DeleteTagProcess {
    public DeleteTagProcessImpl(TagService service, PostService postService) {
        super(service);
        this.postService = postService;
    }

    @Override
    protected void process(Tag item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByPost(Post post) {
        if (post != null && post.getId() != null) {
            service.deleteByPostId(post.getId());
        }
    }

    @Override
    public void configure() {
        configure(Tag.class);
    }

    private final PostService postService;
    private DeletePostProcess deletePostProcess;

    public void setDeletePostProcess(DeletePostProcess value) {
        this.deletePostProcess = value;
    }
}