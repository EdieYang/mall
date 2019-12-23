package com.linkpets.dao;

import com.linkpets.model.SysRoute;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SysRouteMapper {
    @Delete({
            "delete from sys_route",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into sys_route (id, parent_id, ",
            "title, path, name, ",
            "component, component_path, ",
            "cache, sort, create_date, ",
            "del_flag)",
            "values (#{id,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
            "#{title,jdbcType=VARCHAR}, #{path,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{component,jdbcType=VARCHAR}, #{componentPath,jdbcType=VARCHAR}, ",
            "#{cache,jdbcType=INTEGER}, #{sort,jdbcType=INTEGER}, #{createDate,jdbcType=TIMESTAMP}, ",
            "#{delFlag,jdbcType=VARCHAR})"
    })
    int insert(SysRoute record);

    int insertSelective(SysRoute record);

    @Select({
            "select",
            "id, parent_id, title, path, name, component, component_path, cache, sort, create_date, ",
            "del_flag",
            "from sys_route",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.linkpets.dao.SysRouteMapper.BaseResultMap")
    SysRoute selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoute record);

    @Update({
            "update sys_route",
            "set parent_id = #{parentId,jdbcType=VARCHAR},",
            "title = #{title,jdbcType=VARCHAR},",
            "path = #{path,jdbcType=VARCHAR},",
            "name = #{name,jdbcType=VARCHAR},",
            "component = #{component,jdbcType=VARCHAR},",
            "component_path = #{componentPath,jdbcType=VARCHAR},",
            "cache = #{cache,jdbcType=INTEGER},",
            "sort = #{sort,jdbcType=INTEGER},",
            "create_date = #{createDate,jdbcType=TIMESTAMP},",
            "del_flag = #{delFlag,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysRoute record);

    @Update({
            "update sys_route",
            "set del_flag = '0'",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    void delSysRoute(String routeId);
}