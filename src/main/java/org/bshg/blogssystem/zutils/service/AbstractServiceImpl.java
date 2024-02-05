package org.bshg.blogssystem.zutils.service;

import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;
import org.bshg.blogssystem.zutils.repository.AbstractRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractServiceImpl<T extends AuditBusinessObject, REPO extends AbstractRepository<T, Long>> {

    protected REPO dao;
    protected Class<T> itemClass;

    protected AbstractServiceImpl(REPO dao) {
        this.dao = dao;
        this.configure();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(T item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(List<T> list) {
        if (list != null) {
            list.forEach(t -> deleteById(t.getId()));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public T create(T t) {
        return dao.save(t);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public T edit(T t) {
        return dao.save(t);
    }

    public T findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public List<T> findAllOptimized() {
        return dao.findAll();
    }

    public void configure(Class<T> itemClass) {
        this.itemClass = itemClass;
    }

    public abstract void configure();
}
