package org.bshg.blogssystem.service.impl;

import jakarta.transaction.Transactional;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.dao.PostDao;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.CategoryService;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl extends AbstractServiceImpl<Post, PostDao> implements PostService {
    public PostServiceImpl(PostDao dao) {
        super(dao);
    }

    @Override
    public List<Post> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional
    @Override
    public int deleteByAdminId(Long id) {
        return dao.deleteByAdminId(id);
    }

    @Override
    public List<Post> findByAdminId(Long id) {
        return dao.findByAdminId(id);
    }

    @Transactional
    @Override
    public int deleteByCostumerId(Long id) {
        return dao.deleteByCostumerId(id);
    }

    @Override
    public List<Post> findByCostumerId(Long id) {
        return dao.findByCostumerId(id);
    }

    @Transactional
    @Override
    public int deleteByCategoryId(Long id) {
        return dao.deleteByCategoryId(id);
    }

    @Override
    public List<Post> findByCategoryId(Long id) {
        return dao.findByCategoryId(id);
    }

    public void configure() {
        super.configure(Post.class);
    }

    @Autowired
    private AdminService adminService;
    @Autowired
    private CostumerService costumerService;
    @Autowired
    private CategoryService categoryService;
}