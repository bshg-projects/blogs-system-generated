package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostDao extends AbstractRepository<Post, Long> {
    int deleteByAdminId(Long id);

    List<Post> findByAdminId(Long id);

    int deleteByCostumerId(Long id);

    List<Post> findByCostumerId(Long id);

    int deleteByCategoryId(Long id);

    List<Post> findByCategoryId(Long id);

    @Query("SELECT NEW Post(item.id,item.title) FROM Post item")
    List<Post> findAllOptimized();
}