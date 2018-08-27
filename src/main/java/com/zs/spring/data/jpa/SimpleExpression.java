package com.zs.spring.data.jpa;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.criteria.*;
import java.util.Collection;


@Getter
@AllArgsConstructor
@Slf4j
public class SimpleExpression implements Criterion{


    private String propertyName;

    private Object value;

    private Criterion.Operator operator;

    @Override
    public Predicate toPredicate(Root<?> paramRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Path path = PathUtils.getPath(paramRoot,this.propertyName);

        switch (this.operator.ordinal()){
            case 0:
                return criteriaBuilder.equal(path,this.value);
            case 1:
                return criteriaBuilder.notEqual(path,this.value);
            case 2:
                return criteriaBuilder.like(path,(String) this.value);
            case 3:
                return criteriaBuilder.lessThan(path,(Comparable) this.value);
            case 4:
                return criteriaBuilder.greaterThan(path,(Comparable) this.value);
            case 5:
                return criteriaBuilder.lessThanOrEqualTo(path,(Comparable) this.value);
            case 6:
                return criteriaBuilder.greaterThanOrEqualTo(path,(Comparable) this.value);
            case 7:
                if (this.value instanceof Collection){
                    CriteriaBuilder.In<Object> in = criteriaBuilder.in(path);
                    Collection collection = (Collection) this.value;
                    for (Object o : collection){
                        in = in.value(0);
                    }
                    return in;
                }
                return null;
            case 8:
                if (this.value instanceof  Comparable[]){
                    Comparable[] values = (Comparable[]) this.value;
                    if (values.length == 2){
                        return criteriaBuilder.between(path,values[0],values[1]);
                    }
                }
                return null;
            case 9:
                return criteriaBuilder.isNull(path);
            case 10:
                return criteriaBuilder.isNotNull(path);
            default:
                return null;
        }

    }


}
