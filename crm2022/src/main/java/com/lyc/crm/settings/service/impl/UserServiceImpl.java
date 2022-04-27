package com.lyc.crm.settings.service.impl;

import com.lyc.crm.settings.domain.User;
import com.lyc.crm.settings.mapper.UserMapper;
import com.lyc.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Date: 2022/4/25
 * Author: 3378
 * Description:
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByActAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByActAndPwd(map);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.selectAllUser();
        return users;
    }
}
