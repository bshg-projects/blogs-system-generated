package org.bshg.blogssystem.sprocess.imagefile.impl;

import org.bshg.blogssystem.bean.core.ImageFile;
import org.bshg.blogssystem.service.facade.ImageFileService;
import org.bshg.blogssystem.sprocess.imagefile.facade.CreateImageFileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreateImageFileProcessImpl extends AbstractCreateProcessImpl<ImageFile, ImageFileService> implements CreateImageFileProcess {
    public CreateImageFileProcessImpl(ImageFileService service) {
        super(service);
    }

    @Override
    public ImageFile run(ImageFile item) {
// Your Insert Logic For 'ImageFile'
        item = service.create(item);
        return item;
    }

    @Override
    public void configure() {
        configure(ImageFile.class);
    }
}