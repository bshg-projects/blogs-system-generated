package org.bshg.blogssystem.service.facade;

import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.zutils.service.IService;

import java.util.List;

public interface LikeDislikeService extends IService<LikeDislike> {
    int deleteByAdminId(Long id);

    List<LikeDislike> findByAdminId(Long id);

    int deleteByCostumerId(Long id);

    List<LikeDislike> findByCostumerId(Long id);

    int deleteByPostId(Long id);

    List<LikeDislike> findByPostId(Long id);

    int deleteByCommentId(Long id);

    List<LikeDislike> findByCommentId(Long id);
}