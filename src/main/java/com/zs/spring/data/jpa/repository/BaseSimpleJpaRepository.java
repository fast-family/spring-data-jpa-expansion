package com.zs.spring.data.jpa.repository;

import com.zs.spring.data.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;


@NoRepositoryBean
public class BaseSimpleJpaRepository<T extends BaseEntity,ID extends Serializable>
        extends SimpleJpaRepository<T,ID> implements BaseJpaRepository<T,ID> {

    public BaseSimpleJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseSimpleJpaRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }




}
