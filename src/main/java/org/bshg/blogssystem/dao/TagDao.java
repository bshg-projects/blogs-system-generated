package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagDao extends AbstractRepository<Tag, Long> {
    int deleteByPostId(Long id);

    List<Tag> findByPostId(Long id);

    @Query("SELECT NEW Tag(item.id,item.name) FROM Tag item")
    List<Tag> findAllOptimized();
}