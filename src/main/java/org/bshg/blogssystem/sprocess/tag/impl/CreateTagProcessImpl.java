package org.bshg.blogssystem.sprocess.tag.impl;

import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.service.facade.TagService;
import org.bshg.blogssystem.sprocess.post.facade.CreatePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.CreateTagProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateTagProcessImpl extends AbstractCreateProcessImpl<Tag, TagService> implements CreateTagProcess {
    public CreateTagProcessImpl(TagService service, PostService postService) {
        super(service);
        this.postService = postService;
    }

    @Override
    public Tag run(Tag item) {
// Your Insert Logic For 'Tag'
        item = service.create(item);
        return item;
    }

    @Override
    public void configure() {
        configure(Tag.class);
    }

    private final PostService postService;
    private CreatePostProcess createPostProcess;

    public void setCreatePostProcess(CreatePostProcess value) {
        this.createPostProcess = value;
    }
}