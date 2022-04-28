package com.lyc.crm.workbench.mapper;

import com.lyc.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Wed Apr 27 10:56:37 CST 2022
     */
    int deleteByPrimaryKey(String id);



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Wed Apr 27 10:56:37 CST 2022
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Wed Apr 27 10:56:37 CST 2022
     */
    Activity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Wed Apr 27 10:56:37 CST 2022
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Wed Apr 27 10:56:37 CST 2022
     */
    int updateByPrimaryKey(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *  保存创建的市场活动
     * @mbggenerated Wed Apr 27 10:56:37 CST 2022
     */
    int insertActivity(Activity activity);

    List<Activity> selectActivityByConditionForPage(Map<String,Object> map );

    Integer selectCountOfActivityByCondition(Map<String,Object> map);

}