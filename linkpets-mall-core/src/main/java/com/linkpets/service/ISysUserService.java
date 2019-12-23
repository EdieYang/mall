package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysUser;
import com.linkpets.responseModel.SysUserInfo;

public interface ISysUserService {

    /**
     * 根据登录账号获取用户信息
     *
     * @param userAcc
     * @return
     */
    SysUser getSysUserByUserAccount(String userAcc);

    /**
     * 创建系统用户
     *
     * @param sysUser
     * @return
     */
    String crtSysUser(SysUser sysUser);

    /**
     * 更新系统用户
     *
     * @param sysUser
     */
    void uptSysUser(SysUser sysUser);

    /**
     * 删除系统用户
     *
     * @param userId
     */
    void delSysUser(String userId);

}
