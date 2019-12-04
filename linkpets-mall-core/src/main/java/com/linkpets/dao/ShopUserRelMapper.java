package com.linkpets.dao;

import com.linkpets.model.ShopUserRel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ShopUserRelMapper {
    @Delete({
            "delete from shop_user_rel",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into shop_user_rel (id, shop_id, ",
            "user_id, create_date, ",
            "update_date, del_flag)",
            "values (#{id,jdbcType=VARCHAR}, #{shopId,jdbcType=VARCHAR}, ",
            "#{userId,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
            "#{updateDate,jdbcType=TIMESTAMP}, #{delFlag,jdbcType=VARCHAR})"
    })
    int insert(ShopUserRel record);

    int insertSelective(ShopUserRel record);

    @Select({
            "select",
            "id, shop_id, user_id, create_date, update_date, del_flag",
            "from shop_user_rel",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.ShopUserRelMapper.BaseResultMap")
    ShopUserRel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopUserRel record);

    @Update({
            "update shop_user_rel",
            "set shop_id = #{shopId,jdbcType=VARCHAR},",
            "user_id = #{userId,jdbcType=VARCHAR},",
            "create_date = #{createDate,jdbcType=TIMESTAMP},",
            "update_date = #{updateDate,jdbcType=TIMESTAMP},",
            "del_flag = #{delFlag,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ShopUserRel record);

    @Select({
            "select",
            "id, shop_id, user_id, create_date, update_date, del_flag",
            "from shop_user_rel",
            "where user_id = #{userId} and shop_id = #{shopId} and del_flag = '1' "
    })
    ShopUserRel selectByUserIdAndShopId(String userId, String shopId);
}