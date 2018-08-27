package com.zs.spring.data.jpa.entity;

import java.io.Serializable;


@FunctionalInterface
public interface IDGenerator<PK extends Serializable> {

    PK generator();

    IDGenerator<String> UUID = () -> java.util.UUID.randomUUID().toString().replace("-","");
}
