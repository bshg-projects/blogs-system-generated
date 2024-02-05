package org.bshg.blogssystem.service.impl;

import org.bshg.blogssystem.bean.core.ImageFile;
import org.bshg.blogssystem.dao.ImageFileDao;
import org.bshg.blogssystem.service.facade.ImageFileService;
import org.bshg.blogssystem.zutils.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ImageFileServiceImpl extends AbstractServiceImpl<ImageFile, ImageFileDao> implements ImageFileService {
    public ImageFileServiceImpl(ImageFileDao dao) {
        super(dao);
    }

    public void configure() {
        super.configure(ImageFile.class);
    }
}