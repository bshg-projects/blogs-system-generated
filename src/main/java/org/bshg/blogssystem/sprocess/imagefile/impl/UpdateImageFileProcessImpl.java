package org.bshg.blogssystem.sprocess.imagefile.impl;

import org.bshg.blogssystem.bean.core.ImageFile;
import org.bshg.blogssystem.service.facade.ImageFileService;
import org.bshg.blogssystem.sprocess.imagefile.facade.UpdateImageFileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdateImageFileProcessImpl extends AbstractUpdateProcessImpl<ImageFile, ImageFileService> implements UpdateImageFileProcess {
    public UpdateImageFileProcessImpl(ImageFileService service) {
        super(service);
    }

    public ImageFile run(ImageFile item) {
// Your Update Logic For 'ImageFile'
        item = service.edit(item);
        return item;
    }

    @Override
    public void configure() {
        this.configure(ImageFile.class);
    }
}