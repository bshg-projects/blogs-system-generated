package org.bshg.blogssystem.sprocess.page.impl;

import org.bshg.blogssystem.bean.core.Page;
import org.bshg.blogssystem.service.facade.PageService;
import org.bshg.blogssystem.sprocess.page.facade.UpdatePageProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractUpdateProcessImpl;

public class UpdatePageProcessImpl extends AbstractUpdateProcessImpl<Page, PageService> implements UpdatePageProcess {
    public UpdatePageProcessImpl(PageService service) {
        super(service);
    }

    public Page run(Page item) {
// Your Update Logic For 'Page'
        item = service.edit(item);
        return item;
    }

    @Override
    public void configure() {
        this.configure(Page.class);
    }
}