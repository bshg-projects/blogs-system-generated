package org.bshg.blogssystem.sprocess.post.facade;

import org.bshg.blogssystem.bean.core.Admin;
import org.bshg.blogssystem.bean.core.Category;
import org.bshg.blogssystem.bean.core.Costumer;
import org.bshg.blogssystem.bean.core.Post;
import org.bshg.blogssystem.zutils.sprocess.facade.IDeleteProcess;

public interface DeletePostProcess extends IDeleteProcess<Post> {
    void deleteByAdmin(Admin admin);

    void deleteByCostumer(Costumer costumer);

    void deleteByCategory(Category category);
}