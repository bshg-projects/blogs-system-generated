package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends AbstractRepository<Category, Long> {
    @Query("SELECT NEW Category(item.id,item.name) FROM Category item")
    List<Category> findAllOptimized();
}