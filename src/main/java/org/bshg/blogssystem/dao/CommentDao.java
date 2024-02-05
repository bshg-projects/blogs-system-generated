package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;

import java.util.List;

public interface CommentDao extends AbstractRepository<Comment, Long> {
    int deleteByAdminId(Long id);

    List<Comment> findByAdminId(Long id);

    int deleteByCostumerId(Long id);

    List<Comment> findByCostumerId(Long id);

    int deleteByPostId(Long id);

    List<Comment> findByPostId(Long id);
}