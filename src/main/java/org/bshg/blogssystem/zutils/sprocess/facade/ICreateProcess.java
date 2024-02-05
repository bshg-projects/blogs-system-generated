package org.bshg.blogssystem.zutils.sprocess.facade;

import java.util.List;

public interface ICreateProcess<T> {
    T run(T item);

    List<T> run(List<T> items);
}
