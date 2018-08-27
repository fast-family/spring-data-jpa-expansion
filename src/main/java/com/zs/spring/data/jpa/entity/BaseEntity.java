package com.zs.spring.data.jpa.entity;


import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<ID extends Serializable> implements Persistable<ID>
            ,IDGenerator<ID>{



    @Override
    public boolean isNew() {
        return this.getId() == null;
    }

    @Override
    public ID generator() {
        return (ID) IDGenerator.UUID.generator();
    }
}
