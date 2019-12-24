package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysUser;
import com.linkpets.responseModel.SysUserInfo;

public interface ISysUserService {

    /**
     * 分页查询用户列表
     *
     * @param userAccount
     * @param userName
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SysUser> getSysUserPage(String userAccount, String userName, Integer pageNum, Integer pageSize);

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    SysUser getSysUser(String userId);

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
