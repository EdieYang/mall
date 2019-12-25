package com.linkpets.dao;

import com.linkpets.model.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysRoleMapper {
    @Delete({
        "delete from sys_role",
        "where role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String roleId);

    @Insert({
        "insert into sys_role (role_id, role_name, ",
        "role_code, role_description, ",
        "create_date, del_flag)",
        "values (#{roleId,jdbcType=VARCHAR}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleCode,jdbcType=VARCHAR}, #{roleDescription,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{delFlag,jdbcType=VARCHAR})"
    })
    int insert(SysRole record);

    int insertSelective(SysRole record);

    @Select({
        "select",
        "role_id, role_name, role_code, role_description, create_date, del_flag",
        "from sys_role",
        "where role_id = #{roleId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.SysRoleMapper.BaseResultMap")
    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "role_code = #{roleCode,jdbcType=VARCHAR},",
          "role_description = #{roleDescription,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "del_flag = #{delFlag,jdbcType=VARCHAR}",
        "where role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysRole record);


    @Update({
            "update sys_role",
            "set del_flag = '0' ",
            "where role_id = #{roleId,jdbcType=VARCHAR}"
    })
    void delSysRole(String roleId);


    void batchDelSysRole(List<String> roleIdList);


    List<SysRole> getSysRoleList(String roleName, String roleCode);


    List<SysRole> getSysRoleListByUserId(String userId);

}