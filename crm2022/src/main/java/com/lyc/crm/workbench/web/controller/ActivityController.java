package com.lyc.crm.workbench.web.controller;

import com.lyc.crm.commons.constants.Constants;
import com.lyc.crm.commons.domain.ReturnObject;
import com.lyc.crm.commons.utils.DateUtils;
import com.lyc.crm.commons.utils.UUIDUtils;
import com.lyc.crm.settings.domain.User;
import com.lyc.crm.settings.service.UserService;
import com.lyc.crm.workbench.domain.Activity;
import com.lyc.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request){
        List<User> userList = userService.getAllUser();
        request.setAttribute("userList",userList);
        return "/workbench/activity/index";
    }

    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    public @ResponseBody Object saveCreateActivity(Activity activity, HttpSession session){
//        获取当前登录用户
        User user = (User)session.getAttribute(Constants.SESSION_USER);
//        设置网页中没有填写的数据
//        创建id
        activity.setId(UUIDUtils.getUUID());
//        创建时间
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));
//        创建者
        activity.setCreateBy(user.getId());

        ReturnObject returnObject = new ReturnObject();
        try {
            int result = activityService.saveCreateActivity(activity);
            if(result>0){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            }else{
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后重试...");
            }

        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后重试...");

        }
        return returnObject;
    }

}
