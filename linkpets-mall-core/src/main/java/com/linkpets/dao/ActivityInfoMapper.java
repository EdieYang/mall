package com.linkpets.dao;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.model.ActivityInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ActivityInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_info
     *
     * @mbg.generated Wed Oct 09 18:40:51 GMT+08:00 2019
     */
    @Delete({
        "delete from activity_info",
        "where activity_id = #{activityId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String activityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_info
     *
     * @mbg.generated Wed Oct 09 18:40:51 GMT+08:00 2019
     */
    @Insert({
        "insert into activity_info (activity_id, activity_name, ",
        "activity_status, shop_id, ",
        "start_time, end_time, ",
        "remark, create_by, ",
        "create_time, del_flag)",
        "values (#{activityId,jdbcType=VARCHAR}, #{activityName,jdbcType=VARCHAR}, ",
        "#{activityStatus,jdbcType=VARCHAR}, #{shopId,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{remark,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{delFlag,jdbcType=VARCHAR})"
    })
    int insert(ActivityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_info
     *
     * @mbg.generated Wed Oct 09 18:40:51 GMT+08:00 2019
     */
    int insertSelective(ActivityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_info
     *
     * @mbg.generated Wed Oct 09 18:40:51 GMT+08:00 2019
     */
    @Select({
        "select",
        "activity_id, activity_name, activity_status, shop_id, start_time, end_time, ",
        "remark, create_by, create_time, del_flag",
        "from activity_info",
        "where activity_id = #{activityId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.ActivityInfoMapper.BaseResultMap")
    ActivityInfo selectByPrimaryKey(String activityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_info
     *
     * @mbg.generated Wed Oct 09 18:40:51 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(ActivityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_info
     *
     * @mbg.generated Wed Oct 09 18:40:51 GMT+08:00 2019
     */
    @Update({
        "update activity_info",
        "set activity_name = #{activityName,jdbcType=VARCHAR},",
          "activity_status = #{activityStatus,jdbcType=VARCHAR},",
          "shop_id = #{shopId,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "del_flag = #{delFlag,jdbcType=VARCHAR}",
        "where activity_id = #{activityId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ActivityInfo record);
    
    
    @Select({
    	"SELECT ",
    	"t_a.activity_id AS activityId,",
    	"t_a.activity_name AS activityName,",
    	"t_a.activity_status AS activityStatus,",
    	"t_a.shop_id AS shopId,",
    	"t_s.shop_name AS shopName,",
    	"t_a.start_time AS startTime,",
    	"t_a.end_time AS endTime,",
    	"t_a.remark AS remark,",
    	"t_a.create_time AS createTime ",
    	"FROM activity_info t_a ",
    	"LEFT JOIN shop_info t_s ",
    	"ON t_a.shop_id = t_s.shop_id ",
    	"where activity_id = #{activityId,jdbcType=VARCHAR}"
    })
	@ResultType(JSONObject.class)
	JSONObject getActivityInfo(String activityId);

	List<Map<String, Object>> getList(Map<String, Object> param);
}