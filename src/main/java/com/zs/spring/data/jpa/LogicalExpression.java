package com.zs.spring.data.jpa;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
public class LogicalExpression implements Criterion{

    private Criterion[] criterias;

    private Criterion.Operator operator;

    @Override
    public Predicate toPredicate(Root<?> paramRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        for (Criterion criterion : this.criterias){
            predicateList.add(criterion.toPredicate(paramRoot,criteriaQuery,criteriaBuilder));
        }
        if (predicateList.size() == 0){
            return null;
        }
        switch (this.operator.ordinal()){
            case 12:
                return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
            default:
                return null;
        }
    }
}
