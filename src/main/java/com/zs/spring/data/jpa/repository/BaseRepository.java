package com.zs.spring.data.jpa.repository;

import com.zs.spring.data.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseRepository<T extends BaseEntity,PK extends Serializable>
        extends BaseJpaRepository<T,PK>,JpaSpecificationExecutor<T> {
}
