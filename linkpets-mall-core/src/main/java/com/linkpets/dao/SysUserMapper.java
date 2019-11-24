package com.linkpets.dao;

import com.linkpets.responseModel.SysUserInfo;
import com.linkpets.model.SysUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserMapper {
    @Delete({
            "delete from sys_user",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
            "insert into sys_user (user_id, user_acc, ",
            "user_name, password, ",
            "user_status, user_portrait, ",
            "role_id, real_name, ",
            "create_by, create_time, ",
            "update_by, update_time, ",
            "del_flag)",
            "values (#{userId,jdbcType=VARCHAR}, #{userAcc,jdbcType=VARCHAR}, ",
            "#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{userStatus,jdbcType=VARCHAR}, #{userPortrait,jdbcType=VARCHAR}, ",
            "#{roleId,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
            "#{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
            "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(SysUser record);

    int insertSelective(SysUser record);

    @Select({
            "select",
            "user_id, user_acc, user_name, password, user_status, user_portrait, role_id, ",
            "real_name, create_by, create_time, update_by, update_time, del_flag",
            "from sys_user",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.SysUserMapper.BaseResultMap")
    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    @Update({
            "update sys_user",
            "set user_acc = #{userAcc,jdbcType=VARCHAR},",
            "user_name = #{userName,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "user_status = #{userStatus,jdbcType=VARCHAR},",
            "user_portrait = #{userPortrait,jdbcType=VARCHAR},",
            "role_id = #{roleId,jdbcType=VARCHAR},",
            "real_name = #{realName,jdbcType=VARCHAR},",
            "create_by = #{createBy,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_by = #{updateBy,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "del_flag = #{delFlag,jdbcType=VARCHAR}",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysUser record);

    @Select({
            "select",
            "user_id, user_acc, user_name, password, user_status, create_by, create_time, ",
            "update_by, update_time, del_flag",
            "from sys_user",
            "where user_acc = #{userAccount,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.SysUserMapper.BaseResultMap")
    SysUser getSysUserByUserAccount(String userAccount);


    List<SysUserInfo> listShopSysUser(String shopId, String search);

    SysUserInfo getShopSysUser(String userId);
}