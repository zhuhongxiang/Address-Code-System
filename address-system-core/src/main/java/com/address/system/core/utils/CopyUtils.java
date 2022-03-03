package com.address.system.core.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class CopyUtils {

    /*
    忽视source里的null的复制属性，适用于更新数据库
     */
    public static void copyPropertiesIgnoreNulls(Object source , Object target){
        BeanUtils.copyProperties(source,target,getNullPropertyNames(source));
    }

    /*
    不忽视source里的null的复制属性，适用于增加数据库
     */
    public static void copyProperties(Object source , Object target){
        BeanUtils.copyProperties(source,target);
    }

    /*
    汇总值为null的字段
     */
    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}

