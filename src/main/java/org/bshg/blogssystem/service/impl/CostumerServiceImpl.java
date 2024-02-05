package org.bshg.blogssystem.service.impl;

import jakarta.transaction.Transactional;
import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.dao.CostumerDao;
import org.bshg.blogssystem.service.facade.CostumerService;
import org.bshg.blogssystem.service.facade.UserProfileService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerServiceImpl extends AbstractServiceImpl<Costumer, CostumerDao> implements CostumerService {
    public CostumerServiceImpl(CostumerDao dao) {
        super(dao);
    }

    @Transactional
    @Override
    public int deleteByProfileId(Long id) {
        return dao.deleteByProfileId(id);
    }

    @Override
    public Costumer findByProfileId(Long id) {
        return dao.findByProfileId(id);
    }

    public void configure() {
        super.configure(Costumer.class);
    }

    @Autowired
    private UserProfileService profileService;
}