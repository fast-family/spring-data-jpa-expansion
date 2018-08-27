package com.zs.spring.data.jpa;



import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public class PathUtils {

    public static <T>Path<T> getPath(Root<T> root,String propertyName){

        Path<T> path = null;

        if (propertyName.contains(".")){
            String[] names = StringUtils.split(propertyName,".");
            Path<T> paths = root.get(names[0]);
            for (int i = 1;i < names.length;i++){
                path = paths.get(names[i]);
            }
        } else {
            path = root.get(propertyName);
        }
        return path;
    }
}
