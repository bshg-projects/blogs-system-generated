package org.bshg.blogssystem.service.facade;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.zutils.service.IService;

import java.util.List;

public interface CommentService extends IService<Comment> {
    int deleteByAdminId(Long id);

    List<Comment> findByAdminId(Long id);

    int deleteByCostumerId(Long id);

    List<Comment> findByCostumerId(Long id);

    int deleteByPostId(Long id);

    List<Comment> findByPostId(Long id);
}