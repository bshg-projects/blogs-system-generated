package org.bshg.blogssystem.sprocess.page.impl;

import org.bshg.blogssystem.bean.core.Page;
import org.bshg.blogssystem.service.facade.PageService;
import org.bshg.blogssystem.sprocess.page.facade.DeletePageProcess;
import org.bshg.blogssystem.zutils.sprocess.impl.processes.AbstractDeleteProcessImpl;

public class DeletePageProcessImpl extends AbstractDeleteProcessImpl<Page, PageService> implements DeletePageProcess {
    public DeletePageProcessImpl(PageService service) {
        super(service);
    }

    @Override
    protected void process(Page item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void configure() {
        configure(Page.class);
    }
}