package org.bshg.blogssystem.dao;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;

public interface AdminDao extends AbstractRepository<Admin, Long> {
    int deleteByProfileId(Long id);

    Admin findByProfileId(Long id);
}