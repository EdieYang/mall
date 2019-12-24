package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysPermission;

/**
 * @Author Edie
 */
public interface ISysPermissionService {

    /**
     * 分页查询系统权限列表
     *
     * @param permissionName
     * @param permissionCode
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SysPermission> getSysPermissionPage(String permissionName, String permissionCode, Integer pageNum, Integer pageSize);


    /**
     * 查询系统权限信息
     * @param id
     * @return
     */
    SysPermission getSysPermission(String id);

    /**
     * 新增系统权限
     * @param sysPermission
     * @return
     */
    String crtSysPermission(SysPermission sysPermission);

    /**
     * 更新系统权限
     */
    void uptSysPermission(SysPermission sysPermission);

    /**
     * 删除系统权限
     * @param id
     */
    void delSysPermission(String id);
}
