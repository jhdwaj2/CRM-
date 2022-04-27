package com.lyc.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 2022/4/26
 * Author: 3378
 * Description:
 */
@Controller
public class MainController {


    @RequestMapping("/workbench/main/index.do")
    public String index(){
        return "/workbench/main/index";
    }


}
