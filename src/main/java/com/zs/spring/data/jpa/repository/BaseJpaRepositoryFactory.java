package com.zs.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;


public class BaseJpaRepositoryFactory extends JpaRepositoryFactory {

    public BaseJpaRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return BaseSimpleJpaRepository.class;
    }
}
