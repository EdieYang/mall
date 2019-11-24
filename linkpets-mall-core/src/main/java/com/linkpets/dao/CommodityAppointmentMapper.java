package com.linkpets.dao;

import com.linkpets.model.CommodityAppointment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CommodityAppointmentMapper {
    @Delete({
        "delete from commodity_appointment",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into commodity_appointment (id, commodity_id, ",
        "appointment_type, appointment_property, ",
        "consume_amount, shop_id, ",
        "del_flag, create_date)",
        "values (#{id,jdbcType=VARCHAR}, #{commodityId,jdbcType=VARCHAR}, ",
        "#{appointmentType,jdbcType=VARCHAR}, #{appointmentProperty,jdbcType=VARCHAR}, ",
        "#{consumeAmount,jdbcType=INTEGER}, #{shopId,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(CommodityAppointment record);

    int insertSelective(CommodityAppointment record);

    @Select({
        "select",
        "id, commodity_id, appointment_type, appointment_property, consume_amount, shop_id, ",
        "del_flag, create_date",
        "from commodity_appointment",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.CommodityAppointmentMapper.BaseResultMap")
    CommodityAppointment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommodityAppointment record);

    @Update({
        "update commodity_appointment",
        "set commodity_id = #{commodityId,jdbcType=VARCHAR},",
          "appointment_type = #{appointmentType,jdbcType=VARCHAR},",
          "appointment_property = #{appointmentProperty,jdbcType=VARCHAR},",
          "consume_amount = #{consumeAmount,jdbcType=INTEGER},",
          "shop_id = #{shopId,jdbcType=VARCHAR},",
          "del_flag = #{delFlag,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CommodityAppointment record);
}