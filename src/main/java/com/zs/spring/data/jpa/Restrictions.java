package com.zs.spring.data.jpa;


import org.springframework.util.StringUtils;

public class Restrictions {

    public static SimpleExpression eq(String propertyName,Object obj){
        return StringUtils.isEmpty(obj) ? null :
                new SimpleExpression(propertyName,obj,Criterion.Operator.EQ);
    }

    public static SimpleExpression ne(String propertyName,Object obj){
        return StringUtils.isEmpty(obj) ? null : new SimpleExpression(propertyName,obj,Criterion.Operator.NE);
    }

    public static SimpleExpression like(String propertyName,String str){
        return StringUtils.isEmpty(str) ? null : new SimpleExpression(propertyName,MatchMode.ANYWHERE.toMatchString(str),Criterion.Operator.LIKE);
    }

    public static SimpleExpression like(String propertyName,String pattern,MatchMode matchMode){
        return StringUtils.isEmpty(pattern) ? null : new SimpleExpression(propertyName,matchMode.toMatchString(pattern),Criterion.Operator.LIKE);
    }

    public static SimpleExpression gt(String propertyName,Comparable comparable){
        return StringUtils.isEmpty(comparable) ? null : new SimpleExpression(propertyName,comparable,Criterion.Operator.GE);
    }

    public static SimpleExpression lt(String propertyName,Comparable comparable){
        return StringUtils.isEmpty(comparable) ? null : new SimpleExpression(propertyName,comparable,Criterion.Operator.LT);
    }

    public static SimpleExpression lte(String propertyName,Comparable comparable){
        return StringUtils.isEmpty(comparable) ? null : new SimpleExpression(propertyName,comparable,Criterion.Operator.LTE);
    }

    public static SimpleExpression gte(String propertyName,Comparable comparable){
        return StringUtils.isEmpty(comparable) ? null : new SimpleExpression(propertyName,comparable,Criterion.Operator.GTE);
    }

    public static SimpleExpression in(String propertyName,Comparable comparable){
        return StringUtils.isEmpty(comparable) ? null : new SimpleExpression(propertyName,comparable,Criterion.Operator.IN);
    }

    public static SimpleExpression between(String propertyName,Comparable comparable){
        return StringUtils.isEmpty(comparable) ? null : new SimpleExpression(propertyName,comparable,Criterion.Operator.BETWEEN);
    }

    public static SimpleExpression isNull(String propertyName){
        return new SimpleExpression(propertyName,null,Criterion.Operator.ISNULL);
    }

    public static SimpleExpression isNotNull(String propertyName){
        return new SimpleExpression(propertyName,null,Criterion.Operator.ISNOTNULL);
    }

    public static LogicalExpression or(Criterion... criteria){
        return criteria.length == 0 ? null : new LogicalExpression(criteria,Criterion.Operator.OR);
    }
}
