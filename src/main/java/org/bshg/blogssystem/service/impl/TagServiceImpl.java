package org.bshg.blogssystem.service.impl;

import jakarta.transaction.Transactional;
import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.dao.TagDao;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.service.facade.TagService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl extends AbstractServiceImpl<Tag, TagDao> implements TagService {
    public TagServiceImpl(TagDao dao) {
        super(dao);
    }

    @Override
    public List<Tag> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional
    @Override
    public int deleteByPostId(Long id) {
        return dao.deleteByPostId(id);
    }

    @Override
    public List<Tag> findByPostId(Long id) {
        return dao.findByPostId(id);
    }

    public void configure() {
        super.configure(Tag.class);
    }

    @Autowired
    private PostService postService;
}