package org.bshg.blogssystem.service.impl;

import jakarta.transaction.Transactional;
import org.bshg.blogssystem.bean.core.Comment;
import org.bshg.blogssystem.dao.CommentDao;
import org.bshg.blogssystem.service.facade.AdminService;
import org.bshg.blogssystem.service.facade.CommentService;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.PostService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends AbstractServiceImpl<Comment, CommentDao> implements CommentService {
    public CommentServiceImpl(CommentDao dao) {
        super(dao);
    }

    @Transactional
    @Override
    public int deleteByAdminId(Long id) {
        return dao.deleteByAdminId(id);
    }

    @Override
    public List<Comment> findByAdminId(Long id) {
        return dao.findByAdminId(id);
    }

    @Transactional
    @Override
    public int deleteByCostumerId(Long id) {
        return dao.deleteByCostumerId(id);
    }

    @Override
    public List<Comment> findByCostumerId(Long id) {
        return dao.findByCostumerId(id);
    }

    @Transactional
    @Override
    public int deleteByPostId(Long id) {
        return dao.deleteByPostId(id);
    }

    @Override
    public List<Comment> findByPostId(Long id) {
        return dao.findByPostId(id);
    }

    public void configure() {
        super.configure(Comment.class);
    }

    @Autowired
    private AdminService adminService;
    @Autowired
    private CostumerService costumerService;
    @Autowired
    private PostService postService;
}