package com.zs.spring.data.jpa;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.OrderImpl;


import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    private String propertyName;

    private boolean ascending;

    public boolean isAscending(){
        return this.ascending;
    }


    public static Order asc(String propertyName){
        return new Order(propertyName,true);
    }


    public static Order desc(String propertyName){
        return new Order(propertyName,false);
    }


    public OrderImpl toJpaOrder(Root<?> root){
        Path expression = PathUtils.getPath(root,this.propertyName);
        return new OrderImpl(expression,this.ascending);
    }
}
