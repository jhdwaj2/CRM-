package com.lyc.crm.workbench.service.impl;

import com.lyc.crm.workbench.domain.Activity;
import com.lyc.crm.workbench.mapper.ActivityMapper;
import com.lyc.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Date: 2022/4/27
 * Author: 3378
 * Description:
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;


    @Override
    public int saveCreateActivity(Activity activity) {
        int result = activityMapper.insertActivity(activity);
        return result;
    }

    @Override
    public List<Activity> queryActivityByConditionForPage(Map<String, Object> map) {
        return activityMapper.selectActivityByConditionForPage(map);
    }

    @Override
    public Integer queryCountOfActivityByCondition(Map<String, Object> map) {
        return activityMapper.selectCountOfActivityByCondition(map);
    }


}
