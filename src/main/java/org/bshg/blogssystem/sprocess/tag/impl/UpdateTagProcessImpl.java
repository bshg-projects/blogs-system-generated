package org.bshg.blogssystem.sprocess.tag.impl;

import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.service.facade.TagService;
import org.bshg.blogssystem.sprocess.post.facade.DeletePostProcess;
import org.bshg.blogssystem.sprocess.post.facade.UpdatePostProcess;
import org.bshg.blogssystem.sprocess.tag.facade.UpdateTagProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateTagProcessImpl extends AbstractUpdateProcessImpl<Tag, TagService> implements UpdateTagProcess {
    public UpdateTagProcessImpl(TagService service, PostService postService) {
        super(service);
        this.postService = postService;
    }

    public Tag run(Tag item) {
// Your Update Logic For 'Tag'
        item = service.edit(item);
        return item;
    }

    @Override
    public void configure() {
        this.configure(Tag.class);
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