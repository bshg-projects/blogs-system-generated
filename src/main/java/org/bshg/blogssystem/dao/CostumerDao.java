package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;

public interface CostumerDao extends AbstractRepository<Costumer, Long> {
    int deleteByProfileId(Long id);

    Costumer findByProfileId(Long id);
}