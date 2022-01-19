package com.example.kehou.common.utils;

/**
 * @author ShuangLian
 * @date 2021/11/24 11:15
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {
    public static boolean isNull(Object o){
        return o == null;
    }
     public static boolean isNotNull(Object o){
        return o != null;
    }

}
