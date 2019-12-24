package com.linkpets.dao;

import com.linkpets.model.SysUserRoleRel;
import com.linkpets.responseModel.system.SysRoleUserRes;
import com.linkpets.responseModel.system.SysUserRoleRes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserRoleRelMapper {
    @Delete({
            "delete from sys_user_role_rel",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into sys_user_role_rel (id, user_id, ",
            "role_id, del_flag, ",
            "create_date)",
            "values (#{id,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
            "#{roleId,jdbcType=VARCHAR}, #{delFlag,jdbcType=INTEGER}, ",
            "#{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(SysUserRoleRel record);

    int insertSelective(SysUserRoleRel record);

    @Select({
            "select",
            "id, user_id, role_id, del_flag, create_date",
            "from sys_user_role_rel",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.SysUserRoleRelMapper.BaseResultMap")
    SysUserRoleRel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserRoleRel record);

    @Update({
            "update sys_user_role_rel",
            "set user_id = #{userId,jdbcType=VARCHAR},",
            "role_id = #{roleId,jdbcType=VARCHAR},",
            "del_flag = #{delFlag,jdbcType=INTEGER},",
            "create_date = #{createDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysUserRoleRel record);

    List<SysRoleUserRes> getSysRoleUserPage(String roleId, String userAccount, String userName);

    @Select({
            "select",
            "id, user_id, role_id, del_flag, create_date",
            "from sys_user_role_rel",
            "where user_id = #{userId,jdbcType=VARCHAR}",
            "and role_id = #{roleId,jdbcType=VARCHAR}",
            "and del_flag = 1",
    })
    @ResultMap("com.linkpets.dao.SysUserRoleRelMapper.BaseResultMap")
    SysUserRoleRel selectByUserIdAndRoleId(String userId, String roleId);

    List<SysUserRoleRes> getSysUserRolePage(String userId, String roleName, String roleCode);
}