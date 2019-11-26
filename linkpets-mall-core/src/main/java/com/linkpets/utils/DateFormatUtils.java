package com.linkpets.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
 * @author edie
 */
public class DateFormatUtils {

    public static String getFormatDateStr(String pattern){
        if(StringUtils.isEmpty(pattern)){
           pattern="yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }


}
