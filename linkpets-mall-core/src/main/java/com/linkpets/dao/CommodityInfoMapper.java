package com.linkpets.dao;

import com.linkpets.model.CommodityInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CommodityInfoMapper {
    @Delete({
        "delete from commodity_info",
        "where commodity_id = #{commodityId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String commodityId);

    @Insert({
        "insert into commodity_info (commodity_id, commodity_name, ",
        "commodity_type, commodity_channel, ",
        "commodity_status, commodity_pattern, ",
        "display_img, sale_date, ",
        "charity_price, market_price, ",
        "selling_price, purchase_price, ",
        "stock, stock_warn, ",
        "distributed, commodity_rules, ",
        "commodity_usage, commodity_detail, ",
        "multi_spec, recommended, ",
        "shop_id, sale_count, ",
        "browse_count, show_stock, ",
        "show_sale, verification_type, ",
        "verification_date, purchase_limit, ",
        "customer_support_id, share_title, ",
        "share_info, share_wap_img, ",
        "share_mini_img, share_post, ",
        "purchase_points, refund_type, ",
        "appointment, create_by, ",
        "create_time, update_time, ",
        "del_flag)",
        "values (#{commodityId,jdbcType=VARCHAR}, #{commodityName,jdbcType=VARCHAR}, ",
        "#{commodityType,jdbcType=VARCHAR}, #{commodityChannel,jdbcType=CHAR}, ",
        "#{commodityStatus,jdbcType=VARCHAR}, #{commodityPattern,jdbcType=VARCHAR}, ",
        "#{displayImg,jdbcType=VARCHAR}, #{saleDate,jdbcType=VARCHAR}, ",
        "#{charityPrice,jdbcType=INTEGER}, #{marketPrice,jdbcType=INTEGER}, ",
        "#{sellingPrice,jdbcType=INTEGER}, #{purchasePrice,jdbcType=INTEGER}, ",
        "#{stock,jdbcType=INTEGER}, #{stockWarn,jdbcType=INTEGER}, ",
        "#{distributed,jdbcType=VARCHAR}, #{commodityRules,jdbcType=VARCHAR}, ",
        "#{commodityUsage,jdbcType=VARCHAR}, #{commodityDetail,jdbcType=VARCHAR}, ",
        "#{multiSpec,jdbcType=VARCHAR}, #{recommended,jdbcType=VARCHAR}, ",
        "#{shopId,jdbcType=VARCHAR}, #{saleCount,jdbcType=INTEGER}, ",
        "#{browseCount,jdbcType=INTEGER}, #{showStock,jdbcType=VARCHAR}, ",
        "#{showSale,jdbcType=VARCHAR}, #{verificationType,jdbcType=VARCHAR}, ",
        "#{verificationDate,jdbcType=VARCHAR}, #{purchaseLimit,jdbcType=INTEGER}, ",
        "#{customerSupportId,jdbcType=VARCHAR}, #{shareTitle,jdbcType=VARCHAR}, ",
        "#{shareInfo,jdbcType=VARCHAR}, #{shareWapImg,jdbcType=VARCHAR}, ",
        "#{shareMiniImg,jdbcType=VARCHAR}, #{sharePost,jdbcType=VARCHAR}, ",
        "#{purchasePoints,jdbcType=INTEGER}, #{refundType,jdbcType=VARCHAR}, ",
        "#{appointment,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(CommodityInfo record);

    int insertSelective(CommodityInfo record);

    @Select({
        "select",
        "commodity_id, commodity_name, commodity_type, commodity_channel, commodity_status, ",
        "commodity_pattern, display_img, sale_date, charity_price, market_price, selling_price, ",
        "purchase_price, stock, stock_warn, distributed, commodity_rules, commodity_usage, ",
        "commodity_detail, multi_spec, recommended, shop_id, sale_count, browse_count, ",
        "show_stock, show_sale, verification_type, verification_date, purchase_limit, ",
        "customer_support_id, share_title, share_info, share_wap_img, share_mini_img, ",
        "share_post, purchase_points, refund_type, appointment, create_by, create_time, ",
        "update_time, del_flag",
        "from commodity_info",
        "where commodity_id = #{commodityId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.CommodityInfoMapper.BaseResultMap")
    CommodityInfo selectByPrimaryKey(String commodityId);

    int updateByPrimaryKeySelective(CommodityInfo record);

    @Update({
        "update commodity_info",
        "set commodity_name = #{commodityName,jdbcType=VARCHAR},",
          "commodity_type = #{commodityType,jdbcType=VARCHAR},",
          "commodity_channel = #{commodityChannel,jdbcType=CHAR},",
          "commodity_status = #{commodityStatus,jdbcType=VARCHAR},",
          "commodity_pattern = #{commodityPattern,jdbcType=VARCHAR},",
          "display_img = #{displayImg,jdbcType=VARCHAR},",
          "sale_date = #{saleDate,jdbcType=VARCHAR},",
          "charity_price = #{charityPrice,jdbcType=INTEGER},",
          "market_price = #{marketPrice,jdbcType=INTEGER},",
          "selling_price = #{sellingPrice,jdbcType=INTEGER},",
          "purchase_price = #{purchasePrice,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "stock_warn = #{stockWarn,jdbcType=INTEGER},",
          "distributed = #{distributed,jdbcType=VARCHAR},",
          "commodity_rules = #{commodityRules,jdbcType=VARCHAR},",
          "commodity_usage = #{commodityUsage,jdbcType=VARCHAR},",
          "commodity_detail = #{commodityDetail,jdbcType=VARCHAR},",
          "multi_spec = #{multiSpec,jdbcType=VARCHAR},",
          "recommended = #{recommended,jdbcType=VARCHAR},",
          "shop_id = #{shopId,jdbcType=VARCHAR},",
          "sale_count = #{saleCount,jdbcType=INTEGER},",
          "browse_count = #{browseCount,jdbcType=INTEGER},",
          "show_stock = #{showStock,jdbcType=VARCHAR},",
          "show_sale = #{showSale,jdbcType=VARCHAR},",
          "verification_type = #{verificationType,jdbcType=VARCHAR},",
          "verification_date = #{verificationDate,jdbcType=VARCHAR},",
          "purchase_limit = #{purchaseLimit,jdbcType=INTEGER},",
          "customer_support_id = #{customerSupportId,jdbcType=VARCHAR},",
          "share_title = #{shareTitle,jdbcType=VARCHAR},",
          "share_info = #{shareInfo,jdbcType=VARCHAR},",
          "share_wap_img = #{shareWapImg,jdbcType=VARCHAR},",
          "share_mini_img = #{shareMiniImg,jdbcType=VARCHAR},",
          "share_post = #{sharePost,jdbcType=VARCHAR},",
          "purchase_points = #{purchasePoints,jdbcType=INTEGER},",
          "refund_type = #{refundType,jdbcType=VARCHAR},",
          "appointment = #{appointment,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "del_flag = #{delFlag,jdbcType=VARCHAR}",
        "where commodity_id = #{commodityId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CommodityInfo record);
}