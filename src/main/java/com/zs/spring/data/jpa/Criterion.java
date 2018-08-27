package com.zs.spring.data.jpa;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public interface Criterion {


    public Predicate toPredicate(Root<?> paramRoot, CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder);


    public static enum Operator{

        EQ,NE,LIKE,GE,LT,GTE,LTE,IN,BETWEEN,ISNULL,ISNOTNULL,AND,OR;

    }
}
