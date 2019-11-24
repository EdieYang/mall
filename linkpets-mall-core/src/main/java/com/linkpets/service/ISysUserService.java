package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysUser;
import com.linkpets.responseModel.SysUserInfo;

public interface ISysUserService {

    SysUser getSysUserByUserAccount(String userAcc);

    String crtSysUser(SysUser sysUser);

    void uptSysUser(SysUser sysUser);

    SysUserInfo getShopSysUser(String userId);

    PageInfo<SysUserInfo> listShopSysUser(String shopId, String search, int pageNum, int pageSize);

    void uptShopSysUser(SysUser sysUser,String shopId);

    void crtShopSysUser(SysUser sysUser,String shopId);
}
