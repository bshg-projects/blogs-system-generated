package org.bshg.blogssystem.sprocess.imagefile;

import org.bshg.blogssystem.service.facade.ImageFileService;
import org.bshg.blogssystem.sprocess.imagefile.facade.CreateImageFileProcess;
import org.bshg.blogssystem.sprocess.imagefile.facade.DeleteImageFileProcess;
import org.bshg.blogssystem.sprocess.imagefile.facade.UpdateImageFileProcess;
import org.bshg.blogssystem.sprocess.imagefile.impl.CreateImageFileProcessImpl;
import org.bshg.blogssystem.sprocess.imagefile.impl.DeleteImageFileProcessImpl;
import org.bshg.blogssystem.sprocess.imagefile.impl.UpdateImageFileProcessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Inject ImageFile Processes (Create, Update, Delete).
 */
@Configuration
public class ImageFileInjector {
    @Bean
    public CreateImageFileProcess createImageFileProcess(ImageFileService service) {
        var bean = new CreateImageFileProcessImpl(service);
        return bean;
    }

    @Bean
    public UpdateImageFileProcess updateImageFileProcess(ImageFileService service) {
        var bean = new UpdateImageFileProcessImpl(service);
        return bean;
    }

    @Bean
    public DeleteImageFileProcess deleteImageFileProcess(ImageFileService service) {
        var bean = new DeleteImageFileProcessImpl(service);
        return bean;
    }
}