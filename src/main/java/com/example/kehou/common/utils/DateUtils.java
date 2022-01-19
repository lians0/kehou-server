package com.example.kehou.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ShuangLian
 * @date 2021/12/20 19:47
 */
public class DateUtils {

    /**
     * 获取可以插入数据库的当下时间
     * @return
     */
    public static String now() {

        Date currentDate = new Date();
        //设置日期格式化样式为：yyyy-MM-dd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //格式化当前日期
        return simpleDateFormat.format(currentDate.getTime());
    }
}
