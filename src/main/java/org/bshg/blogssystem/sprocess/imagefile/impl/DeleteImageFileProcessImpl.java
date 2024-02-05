package org.bshg.blogssystem.sprocess.imagefile.impl;

import org.bshg.blogssystem.bean.core.ImageFile;
import org.bshg.blogssystem.service.facade.ImageFileService;
import org.bshg.blogssystem.sprocess.imagefile.facade.DeleteImageFileProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeleteImageFileProcessImpl extends AbstractDeleteProcessImpl<ImageFile, ImageFileService> implements DeleteImageFileProcess {
    public DeleteImageFileProcessImpl(ImageFileService service) {
        super(service);
    }

    @Override
    protected void process(ImageFile item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void configure() {
        configure(ImageFile.class);
    }
}