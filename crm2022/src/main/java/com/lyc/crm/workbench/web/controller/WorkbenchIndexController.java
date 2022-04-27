package com.lyc.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 2022/4/26
 * Author: 3378
 * Description:
 */
@Controller
public class WorkbenchIndexController {

    /**
     * 登录成功跳转主页面的方法
     * @return 主页面
     */
    @RequestMapping("/workbench/index.do")
    public String index(){
        return "workbench/index";
    }


}
