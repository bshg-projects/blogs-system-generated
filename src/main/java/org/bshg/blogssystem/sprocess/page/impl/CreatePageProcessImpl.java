package org.bshg.blogssystem.sprocess.page.impl;

import org.bshg.blogssystem.bean.core.Page;
import org.bshg.blogssystem.service.facade.PageService;
import org.bshg.blogssystem.sprocess.page.facade.CreatePageProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractCreateProcessImpl;

public class CreatePageProcessImpl extends AbstractCreateProcessImpl<Page, PageService> implements CreatePageProcess {
    public CreatePageProcessImpl(PageService service) {
        super(service);
    }

    @Override
    public Page run(Page item) {
// Your Insert Logic For 'Page'
        item = service.create(item);
        return item;
    }

    @Override
    public void configure() {
        configure(Page.class);
    }
}