package com.linkpets.dao;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.model.MallTest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MallTestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_test
     *
     * @mbg.generated Tue Sep 17 13:44:32 GMT+08:00 2019
     */
    @Delete({
        "delete from mall_test",
        "where pk_id = #{pkId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_test
     *
     * @mbg.generated Tue Sep 17 13:44:32 GMT+08:00 2019
     */
    @Insert({
        "insert into mall_test (pk_id, name, ",
        "info)",
        "values (#{pkId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{info,jdbcType=VARCHAR})"
    })
    int insert(MallTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_test
     *
     * @mbg.generated Tue Sep 17 13:44:32 GMT+08:00 2019
     */
    int insertSelective(MallTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_test
     *
     * @mbg.generated Tue Sep 17 13:44:32 GMT+08:00 2019
     */
    @Select({
        "select",
        "pk_id, name, info",
        "from mall_test",
        "where pk_id = #{pkId,jdbcType=INTEGER}"
    })
    @ResultMap("com.linkpets.dao.MallTestMapper.BaseResultMap")
    MallTest selectByPrimaryKey(Integer pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_test
     *
     * @mbg.generated Tue Sep 17 13:44:32 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(MallTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_test
     *
     * @mbg.generated Tue Sep 17 13:44:32 GMT+08:00 2019
     */
    @Update({
        "update mall_test",
        "set name = #{name,jdbcType=VARCHAR},",
          "info = #{info,jdbcType=VARCHAR}",
        "where pk_id = #{pkId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MallTest record);

    @Select({
        "select",
        "pk_id, name, info",
        "from mall_test",
        "where pk_id = #{pkId,jdbcType=INTEGER}"
    })
//    @ResultType(JSONObject.class)
	JSONObject getTestInfo(int pkId);
}