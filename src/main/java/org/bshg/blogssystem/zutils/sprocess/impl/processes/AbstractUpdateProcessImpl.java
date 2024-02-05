package org.bshg.blogssystem.zutils.sprocess.impl.processes;

import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;
import org.bshg.blogssystem.zutils.service.IService;
import org.bshg.blogssystem.zutils.sprocess.impl.AbstractProcessImpl;

import java.util.List;

public abstract class AbstractUpdateProcessImpl<T extends AuditBusinessObject, S extends IService<T>> extends AbstractProcessImpl<T, S> {
    protected AbstractUpdateProcessImpl(S service) {
        super(service);
        this.configure();
    }

    public abstract T run(T item);

    public List<T> run(List<T> items) {
        items.forEach(this::run);
        return items;
    }

    public void updateAssociatedList(T item) {
    }
}
