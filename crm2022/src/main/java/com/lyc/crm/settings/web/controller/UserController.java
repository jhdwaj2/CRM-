package com.lyc.crm.settings.web.controller;

import com.lyc.crm.commons.constants.Constants;
import com.lyc.crm.commons.domain.ReturnObject;
import com.lyc.crm.commons.utils.DateUtils;
import com.lyc.crm.settings.domain.User;
import com.lyc.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2022/4/25
 * Author: 3378
 * Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面的方法
     * @return 转发登录页面
     */
    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin(){
        return "settings/qx/user/login";
    }


    /**
     * 用户登录方法
     * @param loginAct  用户名
     * @param loginPwd  密码
     * @param request   浏览器请求
     * @return  返回封装好的登录状态对象
     */
    @RequestMapping("/settings/qx/user/login.do")
    public @ResponseBody Object Login(String loginAct, String loginPwd,String isRemPwd,HttpServletRequest request, HttpSession session, HttpServletResponse response){
        Map<String,Object> map=new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        User user = userService.getUserByActAndPwd(map);

        ReturnObject returnObject = new ReturnObject();

        if(user==null){
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        }else{
            String nowStr = DateUtils.formatDateTime(new Date());
            if(nowStr.compareTo(user.getExpireTime())>0){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号已过期");
            }else if("0".equals(user.getLockState())){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号状态被锁定");
            }else if(!user.getAllowIps().contains(request.getRemoteAddr())){
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号ip受限");
            }else{
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                session.setAttribute(Constants.SESSION_USER,user);

                if("true".equals(isRemPwd)){
                    Cookie c1=new Cookie("loginAct",user.getLoginAct());
                    c1.setMaxAge(10*24*60*60);
                    response.addCookie(c1);
                    Cookie c2=new Cookie("loginPwd",user.getLoginPwd());
                    c1.setMaxAge(10*24*60*60);
                    response.addCookie(c2);
                }else{
                    Cookie c1 = new Cookie("loginAct", "1");
                    c1.setMaxAge(0);
                    response.addCookie(c1);
                    Cookie c2 = new Cookie("loginPwd", "1");
                    c2.setMaxAge(0);
                    response.addCookie(c2);
                }

            }
        }

        return returnObject;
    }


    @RequestMapping("/settings/qx/user/logout.do")
    public String logout(HttpServletResponse response,HttpSession session){
//        清空cookie
        Cookie c1 = new Cookie("loginAct", "1");
        c1.setMaxAge(0);
        response.addCookie(c1);
        Cookie c2 = new Cookie("loginPwd", "1");
        c1.setMaxAge(0);
        response.addCookie(c2);
//        销毁session
        session.invalidate();;
        return "redirect:/";
    }
}
