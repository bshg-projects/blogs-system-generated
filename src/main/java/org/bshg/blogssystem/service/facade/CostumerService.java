package org.bshg.blogssystem.service.facade;

import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.zutils.service.IService;

public interface CostumerService extends IService<Costumer> {
    int deleteByProfileId(Long id);

    Costumer findByProfileId(Long id);
}