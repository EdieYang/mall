package com.linkpets.dao;

import com.linkpets.model.CustomerSupport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CustomerSupportMapper {
    @Delete({
            "delete from customer_support",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into customer_support (id, wechat, ",
            "phone, wxcode_url, ",
            "available_time, belong_type, ",
            "del_flag, create_date)",
            "values (#{id,jdbcType=VARCHAR}, #{wechat,jdbcType=VARCHAR}, ",
            "#{phone,jdbcType=VARCHAR}, #{wxcodeUrl,jdbcType=VARCHAR}, ",
            "#{availableTime,jdbcType=VARCHAR}, #{belongType,jdbcType=CHAR}, ",
            "#{delFlag,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(CustomerSupport record);

    int insertSelective(CustomerSupport record);

    @Select({
            "select",
            "id, wechat, phone, wxcode_url, available_time, belong_type, del_flag, create_date",
            "from customer_support",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.CustomerSupportMapper.BaseResultMap")
    CustomerSupport selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerSupport record);

    @Update({
            "update customer_support",
            "set wechat = #{wechat,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=VARCHAR},",
            "wxcode_url = #{wxcodeUrl,jdbcType=VARCHAR},",
            "available_time = #{availableTime,jdbcType=VARCHAR},",
            "belong_type = #{belongType,jdbcType=CHAR},",
            "del_flag = #{delFlag,jdbcType=VARCHAR},",
            "create_date = #{createDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CustomerSupport record);

    @Select({
            "select",
            "id, wechat, phone, wxcode_url, available_time, belong_type, del_flag, create_date",
            "from customer_support",
            "where belong_type = #{belongType,jdbcType=VARCHAR}",
            "and del_flag = '1'"
    })
    @ResultMap("com.linkpets.dao.CustomerSupportMapper.BaseResultMap")
    List<CustomerSupport> getCustomerSupportList(String belongType);

}