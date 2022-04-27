package com.lyc.crm.settings.service;

import com.lyc.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Date: 2022/4/25
 * Author: 3378
 * Description:
 */
public interface UserService {
    User getUserByActAndPwd(Map<String,Object> map);

    List<User> getAllUser();
}
