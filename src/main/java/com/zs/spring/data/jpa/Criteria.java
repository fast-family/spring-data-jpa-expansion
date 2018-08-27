package com.zs.spring.data.jpa;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Criteria<T> implements Specification<T> {



    private List<Criterion> criterionList = new ArrayList<>();

    private List<Criterion> havingList = new ArrayList<>();

    private List<Order> orderList = null;

    private List<String> groupByProperyNames = null;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        if (!this.criterionList.isEmpty()){
            List<Predicate> predicateList = new ArrayList<>();
            for (Criterion criterion : this.criterionList){
                if (criterion != null){
                    Predicate predicate = criterion.toPredicate(root,criteriaQuery,criteriaBuilder);

                    if (predicate != null){
                        predicateList.add(predicate);
                    }
                }

            }

            if (predicateList.size() > 0){
                criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[0])));
            }
        }

        if (this.orderList != null){
            List<Order> orderList = new ArrayList<>();
            for (Order order : this.orderList){
                orderList.add(order.toJpaOrder(root));
            }
            criteriaQuery.orderBy(orderList);
        }

        if (this.groupByProperyNames != null){
            List<Expression<?>> paths = new ArrayList<>();
            for (String name : this.groupByProperyNames){
                paths.add(PathUtils.getPath(root,name));
            }
            criteriaQuery.groupBy(paths);
        }

        if (!this.havingList.isEmpty()){
            List<Predicate> predicateList = new ArrayList<>();
            for (Criterion criterion : this.havingList){
                predicateList.add(criterion.toPredicate(root,criteriaQuery,criteriaBuilder));
            }
            if (predicateList.size() > 0){
                criteriaQuery.having(predicateList.toArray(new Predicate[0]));
            }
        }

        return null;
    }


    public Criteria<T> add(Criterion criterion){
        if (criterion != null){
            this.criterionList.add(criterion);
        }
        return this;
    }

    public Criteria<T> having(Criterion criterion){
        if (criterion != null){
            this.havingList.add(criterion);
        }
        return this;
    }

    public void addOrder(Order... orders){
        this.orderList = Arrays.asList(orders);
    }

    public void addOrder(List<Order> orderList){
        this.orderList = orderList;
    }


    public void addGroupBy(String... propertyName){
        this.groupByProperyNames = Arrays.asList(propertyName);
    }

    public void addGroupBy(List<String> propertyNames){
        this.groupByProperyNames = propertyNames;
    }

}
