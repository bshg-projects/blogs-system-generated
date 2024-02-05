package org.bshg.blogssystem.sprocess.likedislike.facade;

import org.bshg.blogssystem.bean.core.*;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;

public interface DeleteLikeDislikeProcess extends IDeleteProcess<LikeDislike> {
    void deleteByAdmin(Admin admin);

    void deleteByCostumer(Costumer costumer);

    void deleteByPost(Post post);

    void deleteByComment(Comment comment);
}