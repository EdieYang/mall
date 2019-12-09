package com.linkpets.dao;

import com.linkpets.model.CommodityDistribute;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CommodityDistributeMapper {
    @Delete({
            "delete from commodity_distribute",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into commodity_distribute (id, commodity_id, ",
            "grade, commission, ",
            "del_flag, create_date)",
            "values (#{id,jdbcType=VARCHAR}, #{commodityId,jdbcType=VARCHAR}, ",
            "#{grade,jdbcType=INTEGER}, #{commission,jdbcType=DECIMAL}, ",
            "#{delFlag,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(CommodityDistribute record);

    int insertSelective(CommodityDistribute record);

    @Select({
            "select",
            "id, commodity_id, grade, commission, del_flag, create_date",
            "from commodity_distribute",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.CommodityDistributeMapper.BaseResultMap")
    CommodityDistribute selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommodityDistribute record);

    @Update({
            "update commodity_distribute",
            "set commodity_id = #{commodityId,jdbcType=VARCHAR},",
            "grade = #{grade,jdbcType=INTEGER},",
            "commission = #{commission,jdbcType=DECIMAL},",
            "del_flag = #{delFlag,jdbcType=VARCHAR},",
            "create_date = #{createDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CommodityDistribute record);

    @Update({
            "update commodity_distribute",
            "set del_flag = '0'",
            "where commodity_id = #{commodityId,jdbcType=VARCHAR}"
    })
    void delDistribute(String commodityId);
}