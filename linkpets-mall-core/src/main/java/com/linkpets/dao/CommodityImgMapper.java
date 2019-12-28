package com.linkpets.dao;

import com.linkpets.model.CommodityImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommodityImgMapper {
    @Delete({
            "delete from commodity_img",
            "where commodity_img_id = #{commodityImgId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String commodityImgId);

    @Insert({
            "insert into commodity_img (commodity_img_id, commodity_id, ",
            "img_name, img_url, ",
            "del_flag)",
            "values (#{commodityImgId,jdbcType=VARCHAR}, #{commodityId,jdbcType=VARCHAR}, ",
            "#{imgName,jdbcType=VARCHAR}, #{imgUrl,jdbcType=VARCHAR}, ",
            "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(CommodityImg record);

    int insertSelective(CommodityImg record);

    @Select({
            "select",
            "commodity_img_id, commodity_id, img_name, img_url, del_flag",
            "from commodity_img",
            "where commodity_img_id = #{commodityImgId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.CommodityImgMapper.BaseResultMap")
    CommodityImg selectByPrimaryKey(String commodityImgId);

    int updateByPrimaryKeySelective(CommodityImg record);

    @Update({
            "update commodity_img",
            "set commodity_id = #{commodityId,jdbcType=VARCHAR},",
            "img_name = #{imgName,jdbcType=VARCHAR},",
            "img_url = #{imgUrl,jdbcType=VARCHAR},",
            "del_flag = #{delFlag,jdbcType=VARCHAR}",
            "where commodity_img_id = #{commodityImgId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CommodityImg record);

    @Select({
            "select",
            "commodity_img_id, commodity_id, img_name, img_url, del_flag",
            "from commodity_img",
            "where commodity_id = #{commodityId,jdbcType=VARCHAR}",
            "and del_flag = '1'"
    })
    @ResultMap("com.linkpets.dao.CommodityImgMapper.BaseResultMap")
    List<CommodityImg> getCommodityImgList(String commodityId);

    @Update({
            "update commodity_img",
            "set del_flag = '0'",
            "where commodity_id = #{commodityId,jdbcType=VARCHAR}"
    })
    void delCommodityImg(String commodityId);
}