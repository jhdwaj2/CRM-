package com.lyc.crm.workbench.web.controller;

import com.lyc.crm.settings.domain.User;
import com.lyc.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Date: 2022/4/26
 * Author: 3378
 * Description:
 */
@Controller
public class ActivityController {

    @Autowired
    private UserService userService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request){
        List<User> userList = userService.getAllUser();
        request.setAttribute("userList",userList);
        return "/workbench/activity/index";
    }


}
