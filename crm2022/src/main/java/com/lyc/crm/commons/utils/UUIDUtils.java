package com.lyc.crm.commons.utils;

import java.util.UUID;

/**
 * Date: 2022/4/27
 * Author: 3378
 * Description:
 */
public class UUIDUtils {

    /**
     * 获取uuid的工具方法
     * @return 返回String类型无“-”的uuid
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
