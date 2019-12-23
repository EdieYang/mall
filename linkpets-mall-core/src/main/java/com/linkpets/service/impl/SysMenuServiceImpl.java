package com.linkpets.service.impl;

import com.linkpets.dao.SysMenuMapper;
import com.linkpets.model.SysMenu;
import com.linkpets.service.ISysMenuService;
import com.linkpets.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public String crtSysMenu(SysMenu sysMenu) {
        String menuId = UUIDUtils.getId();
        sysMenu.setId(menuId);
        sysMenu.setCreateDate(new Date());
        sysMenuMapper.insertSelective(sysMenu);
        return menuId;
    }

    @Override
    public void uptSysMenu(SysMenu sysMenu) {
        sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public void delSysMenu(String menuId) {
        sysMenuMapper.delSysMenu(menuId);
    }
}
