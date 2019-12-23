package com.linkpets.dao;

import com.linkpets.model.CommoditySpec;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CommoditySpecMapper {
    @Delete({
        "delete from commodity_spec",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into commodity_spec (id, commodity_id, ",
        "spec_name, market_price, ",
        "selling_price, charity_price, ",
        "purchase_price, stock, ",
        "del_flag)",
        "values (#{id,jdbcType=VARCHAR}, #{commodityId,jdbcType=VARCHAR}, ",
        "#{specName,jdbcType=VARCHAR}, #{marketPrice,jdbcType=INTEGER}, ",
        "#{sellingPrice,jdbcType=INTEGER}, #{charityPrice,jdbcType=INTEGER}, ",
        "#{purchasePrice,jdbcType=INTEGER}, #{stock,jdbcType=INTEGER}, ",
        "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(CommoditySpec record);

    int insertSelective(CommoditySpec record);

    @Select({
        "select",
        "id, commodity_id, spec_name, market_price, selling_price, charity_price, purchase_price, ",
        "stock, del_flag",
        "from commodity_spec",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.CommoditySpecMapper.BaseResultMap")
    CommoditySpec selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommoditySpec record);

    @Update({
        "update commodity_spec",
        "set commodity_id = #{commodityId,jdbcType=VARCHAR},",
          "spec_name = #{specName,jdbcType=VARCHAR},",
          "market_price = #{marketPrice,jdbcType=INTEGER},",
          "selling_price = #{sellingPrice,jdbcType=INTEGER},",
          "charity_price = #{charityPrice,jdbcType=INTEGER},",
          "purchase_price = #{purchasePrice,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "del_flag = #{delFlag,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CommoditySpec record);

    @Update({
            "update commodity_spec",
            "set  del_flag = '0'",
            "where id = #{specId,jdbcType=VARCHAR}"
    })
    void delSpec(String specId);
}