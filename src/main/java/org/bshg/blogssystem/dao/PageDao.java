package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Page;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PageDao extends AbstractRepository<Page, Long> {
    @Query("SELECT NEW Page(item.id,item.title) FROM Page item")
    List<Page> findAllOptimized();
}