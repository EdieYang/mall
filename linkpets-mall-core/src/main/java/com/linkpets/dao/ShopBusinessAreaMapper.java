package com.linkpets.dao;

import com.linkpets.model.ShopBusinessArea;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShopBusinessAreaMapper {
    @Delete({
        "delete from shop_business_area",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into shop_business_area (id, area_name, ",
        "del_flag, create_date)",
        "values (#{id,jdbcType=VARCHAR}, #{areaName,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(ShopBusinessArea record);

    int insertSelective(ShopBusinessArea record);

    @Select({
        "select",
        "id, area_name, del_flag, create_date",
        "from shop_business_area",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.ShopBusinessAreaMapper.BaseResultMap")
    ShopBusinessArea selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopBusinessArea record);

    @Update({
        "update shop_business_area",
        "set area_name = #{areaName,jdbcType=VARCHAR},",
          "del_flag = #{delFlag,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ShopBusinessArea record);



    @Select({
            "select",
            "id, area_name, del_flag, create_date",
            "from shop_business_area where del_flag = '1'"
    })
    @ResultMap("com.linkpets.dao.ShopBusinessAreaMapper.BaseResultMap")
    List<ShopBusinessArea> listShopBusinessArea();
}