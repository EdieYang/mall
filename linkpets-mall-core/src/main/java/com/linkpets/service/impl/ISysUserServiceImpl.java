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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ISysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private ShopUserRelMapper shopUserRelMapper;

    @Override
    public SysUser getSysUserByUserAccount(String userAcc) {
        return sysUserMapper.getSysUserByUserAccount(userAcc);
    }

    @Override
    public String crtSysUser(SysUser sysUser) {
        String userId = CommonUtil.uuid();
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setUserId(userId);
        sysUserMapper.insertSelective(sysUser);
        return userId;
    }

    @Override
    public void uptSysUser(SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public SysUserInfo getShopSysUser(String userId) {
        return sysUserMapper.getShopSysUser(userId);
    }

    @Override
    public PageInfo<SysUserInfo> listShopSysUser(String shopId, String search, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sysUserMapper.listShopSysUser(shopId, search));
    }

    @Override
    public void uptShopSysUser(SysUser sysUser, String shopId) {
        if (sysUser.getDelFlag().equals("1")) {
            ShopUserRel userRel = shopUserRelMapper.selectByUserIdAndShopId(sysUser.getUserId(), shopId);
            if (userRel != null) {
                userRel.setDelFlag("1");
                shopUserRelMapper.updateByPrimaryKeySelective(userRel);
            }
        }
        sysUser.setUpdateTime(new Date());
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void crtShopSysUser(SysUser sysUser, String shopId) {
        String userId = CommonUtil.uuid();
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setUserId(userId);
        sysUserMapper.insertSelective(sysUser);
        ShopUserRel userRel = new ShopUserRel(CommonUtil.uuid(), shopId, sysUser.getUserId(), new Date(), new Date());
        shopUserRelMapper.insertSelective(userRel);
    }
}
