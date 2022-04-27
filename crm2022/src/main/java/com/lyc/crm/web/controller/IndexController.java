package com.lyc.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 2022/4/25
 * Author: 3378
 * Description:
 */
@Controller     //springmvc注册为控制器
public class IndexController {


    /**
     * 访问首页控制器
     * @return 请求转发首页名，跳转首页
     */
    @RequestMapping("/")    //访问路径为“/”时跳转首页
    public String index(){
        return "index";
    }

}
