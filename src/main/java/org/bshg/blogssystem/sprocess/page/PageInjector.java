package org.bshg.blogssystem.sprocess.page;

import org.bshg.blogssystem.service.facade.PageService;
import org.bshg.blogssystem.sprocess.page.facade.CreatePageProcess;
import org.bshg.blogssystem.sprocess.page.facade.DeletePageProcess;
import org.bshg.blogssystem.sprocess.page.facade.UpdatePageProcess;
import org.bshg.blogssystem.sprocess.page.impl.CreatePageProcessImpl;
import org.bshg.blogssystem.sprocess.page.impl.DeletePageProcessImpl;
import org.bshg.blogssystem.sprocess.page.impl.UpdatePageProcessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Inject Page Processes (Create, Update, Delete).
 */
@Configuration
public class PageInjector {
    @Bean
    public CreatePageProcess createPageProcess(PageService service) {
        var bean = new CreatePageProcessImpl(service);
        return bean;
    }

    @Bean
    public UpdatePageProcess updatePageProcess(PageService service) {
        var bean = new UpdatePageProcessImpl(service);
        return bean;
    }

    @Bean
    public DeletePageProcess deletePageProcess(PageService service) {
        var bean = new DeletePageProcessImpl(service);
        return bean;
    }
}