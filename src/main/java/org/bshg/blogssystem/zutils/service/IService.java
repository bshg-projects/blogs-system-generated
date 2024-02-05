package org.bshg.blogssystem.zutils.service;

import org.bshg.blogssystem.zutils.bean.BusinessObject;

import java.util.List;

public interface IService<T extends BusinessObject> {
    T create(T t);

    T edit(T t);

    T findById(Long id);

    List<T> findAllOptimized();

    void deleteById(Long id);

    void delete(T item);

    void delete(List<T> items);

    void deleteByIdIn(List<Long> ids);

    List<T> findAll();
}
