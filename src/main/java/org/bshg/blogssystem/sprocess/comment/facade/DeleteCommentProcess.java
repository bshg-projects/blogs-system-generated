package org.bshg.blogssystem.sprocess.comment.facade;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;

public interface DeleteCommentProcess extends IDeleteProcess<Comment> {
    void deleteByAdmin(Admin admin);

    void deleteByCostumer(Costumer costumer);

    void deleteByPost(Post post);
}