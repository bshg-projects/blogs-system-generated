package org.bshg.blogssystem.service.facade;

import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.zutils.service.IService;

import java.util.List;

public interface PostService extends IService<Post> {
    int deleteByAdminId(Long id);

    List<Post> findByAdminId(Long id);

    int deleteByCostumerId(Long id);

    List<Post> findByCostumerId(Long id);

    int deleteByCategoryId(Long id);

    List<Post> findByCategoryId(Long id);
}