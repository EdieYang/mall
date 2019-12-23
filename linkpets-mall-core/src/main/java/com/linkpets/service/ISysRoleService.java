package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysRole;

public interface ISysRoleService {

    /**
     * 分页查询角色列表
     * @param roleName
     * @param roleDescription
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SysRole> getSysRolePage(String roleName, String roleDescription, Integer pageNum, Integer pageSize);

    /**
     * 创建角色
     * @param sysRole
     * @return
     */
    String crtSysRole(SysRole sysRole);

    /**
     * 更新角色
     * @param sysRole
     */
    void uptSysRole(SysRole sysRole);

    /**
     * 删除角色
     * @param roleId
     */
    void delSysRole(String roleId);


}
