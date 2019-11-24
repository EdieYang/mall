package com.linkpets.dao;

import com.linkpets.model.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SysRoleMapper {
    @Delete({
        "delete from sys_role",
        "where role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String roleId);

    @Insert({
        "insert into sys_role (role_id, role_type, ",
        "role_name, create_date, ",
        "del_flag)",
        "values (#{roleId,jdbcType=VARCHAR}, #{roleType,jdbcType=VARCHAR}, ",
        "#{roleName,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(SysRole record);

    int insertSelective(SysRole record);

    @Select({
        "select",
        "role_id, role_type, role_name, create_date, del_flag",
        "from sys_role",
        "where role_id = #{roleId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.SysRoleMapper.BaseResultMap")
    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set role_type = #{roleType,jdbcType=VARCHAR},",
          "role_name = #{roleName,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "del_flag = #{delFlag,jdbcType=VARCHAR}",
        "where role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysRole record);
}