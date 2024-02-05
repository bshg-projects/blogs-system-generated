package org.bshg.blogssystem.zutils.repository;

import org.bshg.blogssystem.zutils.audit.AuditBusinessObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface AbstractRepository<T extends AuditBusinessObject, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    int deleteByIdIn(List<ID> ids);
}
