package com.lyc.crm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date: 2022/4/26
 * Author: 3378
 * Description:
 */
public class DateUtils {

    /**
     * 将指定的日期对象转换为特定格式(yyyy-MM-dd HH:mm:ss)的String对象
     * @param date 传入的日期对象
     * @return  返回String对象
     */
    public static String formatDateTime(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
