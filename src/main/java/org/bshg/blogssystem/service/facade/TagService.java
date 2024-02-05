package org.bshg.blogssystem.service.facade;

import org.bshg.blogssystem.bean.core.Tag;
import org.bshg.blogssystem.zutils.service.IService;

import java.util.List;

public interface TagService extends IService<Tag> {
    int deleteByPostId(Long id);

    List<Tag> findByPostId(Long id);
}