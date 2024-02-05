package org.bshg.blogssystem.service.impl;

import jakarta.transaction.Transactional;
import org.bshg.blogssystem.bean.core.LikeDislike;
import org.bshg.blogssystem.dao.LikeDislikeDao;
import org.bshg.blogssystem.service.facade.*;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeDislikeServiceImpl extends AbstractServiceImpl<LikeDislike, LikeDislikeDao> implements LikeDislikeService {
    public LikeDislikeServiceImpl(LikeDislikeDao dao) {
        super(dao);
    }

    @Transactional
    @Override
    public int deleteByAdminId(Long id) {
        return dao.deleteByAdminId(id);
    }

    @Override
    public List<LikeDislike> findByAdminId(Long id) {
        return dao.findByAdminId(id);
    }

    @Transactional
    @Override
    public int deleteByCostumerId(Long id) {
        return dao.deleteByCostumerId(id);
    }

    @Override
    public List<LikeDislike> findByCostumerId(Long id) {
        return dao.findByCostumerId(id);
    }

    @Transactional
    @Override
    public int deleteByPostId(Long id) {
        return dao.deleteByPostId(id);
    }

    @Override
    public List<LikeDislike> findByPostId(Long id) {
        return dao.findByPostId(id);
    }

    @Transactional
    @Override
    public int deleteByCommentId(Long id) {
        return dao.deleteByCommentId(id);
    }

    @Override
    public List<LikeDislike> findByCommentId(Long id) {
        return dao.findByCommentId(id);
    }

    public void configure() {
        super.configure(LikeDislike.class);
    }

    @Autowired
    private AdminService adminService;
    @Autowired
    private CostumerService costumerService;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
}