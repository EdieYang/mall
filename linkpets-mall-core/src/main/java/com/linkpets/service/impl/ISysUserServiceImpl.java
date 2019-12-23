package com.linkpets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.ShopUserRelMapper;
import com.linkpets.dao.SysUserMapper;
import com.linkpets.model.ShopUserRel;
import com.linkpets.model.SysUser;
import com.linkpets.responseModel.SysUserInfo;
import com.linkpets.service.ISysUserService;
import com.linkpets.utils.CommonUtil;
import com.linkpets.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ISysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getSysUserByUserAccount(String userAcc) {
        return sysUserMapper.getSysUserByUserAccount(userAcc);
    }

    @Override
    public String crtSysUser(SysUser sysUser) {
        String userId = UUIDUtils.getId();
        sysUser.setCreateTime(new Date());
        sysUser.setUserId(userId);
        sysUserMapper.insertSelective(sysUser);
        return userId;
    }

    @Override
    public void uptSysUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void delSysUser(String userId) {
        sysUserMapper.delSysUser(userId);
    }


}
