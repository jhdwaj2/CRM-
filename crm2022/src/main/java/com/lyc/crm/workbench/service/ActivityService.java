package com.lyc.crm.workbench.service;

import com.lyc.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * Date: 2022/4/27
 * Author: 3378
 * Description:
 */
public interface ActivityService {

    int saveCreateActivity(Activity activity);

    List<Activity> queryActivityByConditionForPage(Map<String,Object> map);

    Integer queryCountOfActivityByCondition(Map<String,Object> map);

}
