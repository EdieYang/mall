package com.linkpets.dao;

import com.linkpets.model.ShopInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ShopInfoMapper {
    @Delete({
            "delete from shop_info",
            "where shop_id = #{shopId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String shopId);

    @Insert({
            "insert into shop_info (shop_id, shop_name, ",
            "linkman, mobile, ",
            "wechat, open_time, ",
            "shop_phone, ",
            "address_district, address_detail, ",
            "shop_status, sale_show, online_settle, settle_rate, create_date, del_flag)",
            "values (#{shopId,jdbcType=VARCHAR}, #{shopName,jdbcType=VARCHAR}, ",
            "#{linkman,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
            "#{wechat,jdbcType=VARCHAR}, #{openTime,jdbcType=VARCHAR}, ",
            "#{shopPhone,jdbcType=VARCHAR}, ",
            "#{addressDistrict,jdbcType=VARCHAR}, #{addressDetail,jdbcType=VARCHAR}, ",
            "#{shopStatus,jdbcType=VARCHAR}, #{saleShow},#{onlineSettle},#{settleRate},#{createDate},#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    @Select({
            "select",
            "shop_id, shop_name, linkman, mobile, wechat, open_time, shop_phone, ",
            "address_district, address_detail, shop_status, sale_show, online_settle, settle_rate, create_date,del_flag",
            "from shop_info",
            "where shop_id = #{shopId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.ShopInfoMapper.BaseResultMap")
    ShopInfo selectByPrimaryKey(String shopId);

    int updateByPrimaryKeySelective(ShopInfo record);

    @Update({
            "update shop_info",
            "set shop_name = #{shopName,jdbcType=VARCHAR},",
            "linkman = #{linkman,jdbcType=VARCHAR},",
            "mobile = #{mobile,jdbcType=VARCHAR},",
            "wechat = #{wechat,jdbcType=VARCHAR},",
            "open_time = #{openTime,jdbcType=VARCHAR},",
            "shop_phone = #{shopPhone,jdbcType=VARCHAR},",
            "address_district = #{addressDistrict,jdbcType=VARCHAR},",
            "address_detail = #{addressDetail,jdbcType=VARCHAR},",
            "shop_status = #{shopStatus,jdbcType=VARCHAR},",
            "sale_show = #{saleShow,jdbcType=VARCHAR},",
            "online_settle = #{onlineSettle,jdbcType=VARCHAR},",
            "settle_rate = #{settleRate,jdbcType=INTEGER},",
            "create_date = #{createDate,jdbcType=DATE},",
            "del_flag = #{delFlag,jdbcType=VARCHAR}",
            "where shop_id = #{shopId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ShopInfo record);

    List<Map<String, Object>> getList(Map<String, Object> param);

    @Select({
            "select",
            "shop_id, shop_name, linkman, mobile, wechat, open_time, shop_phone, address_district, address_detail, ",
            "shop_status, sale_show, online_settle, settle_rate, create_date, del_flag",
            "from shop_info",
            "where shop_id = #{shopId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.ShopInfoMapper.BaseResultMap")
    ShopInfo getShopInfo(String shopId);
}