package org.bshg.blogssystem.sprocess.tag.facade;

import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;

public interface DeleteTagProcess extends IDeleteProcess<Tag> {
    void deleteByPost(Post post);
}