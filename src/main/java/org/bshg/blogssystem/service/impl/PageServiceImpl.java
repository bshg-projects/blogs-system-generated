package org.bshg.blogssystem.service.impl;

import org.bshg.blogssystem.bean.core.Page;
import org.bshg.blogssystem.dao.PageDao;
import org.bshg.blogssystem.service.facade.PageService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl extends AbstractServiceImpl<Page, PageDao> implements PageService {
    public PageServiceImpl(PageDao dao) {
        super(dao);
    }

    @Override
    public List<Page> findAllOptimized() {
        return dao.findAllOptimized();
    }

    public void configure() {
        super.configure(Page.class);
    }
}