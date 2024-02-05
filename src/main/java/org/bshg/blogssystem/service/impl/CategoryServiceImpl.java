package org.bshg.blogssystem.service.impl;

import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.dao.CategoryDao;
import org.bshg.blogssystem.service.facade.CategoryService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends AbstractServiceImpl<Category, CategoryDao> implements CategoryService {
    public CategoryServiceImpl(CategoryDao dao) {
        super(dao);
    }

    @Override
    public List<Category> findAllOptimized() {
        return dao.findAllOptimized();
    }

    public void configure() {
        super.configure(Category.class);
    }
}