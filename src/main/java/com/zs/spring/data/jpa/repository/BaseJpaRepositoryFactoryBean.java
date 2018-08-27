package com.zs.spring.data.jpa.repository;


import com.zs.spring.data.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;


import javax.persistence.EntityManager;
import java.io.Serializable;


public class BaseJpaRepositoryFactoryBean<T extends Repository<S,ID>,S extends BaseEntity,ID extends Serializable>
 extends JpaRepositoryFactoryBean<T,S,ID> {

    public BaseJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager)
    {
        return new BaseJpaRepositoryFactory(entityManager);
    }


}
