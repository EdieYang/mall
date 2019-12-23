package com.linkpets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.SysRoleMapper;
import com.linkpets.model.SysRole;
import com.linkpets.service.ISysRoleService;
import com.linkpets.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public PageInfo<SysRole> getSysRolePage(String roleName, String roleDescription, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> roleList = sysRoleMapper.getSysRoleList(roleName, roleDescription);
        return new PageInfo<>(roleList);
    }

    @Override
    public String crtSysRole(SysRole sysRole) {
        String roleId = UUIDUtils.getId();
        sysRole.setRoleId(roleId);
        sysRole.setCreateDate(new Date());
        sysRoleMapper.insertSelective(sysRole);
        return roleId;
    }

    @Override
    public void uptSysRole(SysRole sysRole) {
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public void delSysRole(String roleId) {
        sysRoleMapper.delSysRole(roleId);
    }

}
