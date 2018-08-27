package com.zs.spring.data.jpa.repository;

import com.zs.spring.data.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.io.Serializable;


@NoRepositoryBean
public interface BaseJpaRepository<T extends BaseEntity,ID extends Serializable> extends JpaRepository<T,ID> {
}
