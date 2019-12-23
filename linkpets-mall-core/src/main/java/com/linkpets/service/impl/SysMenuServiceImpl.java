package com.linkpets.service.impl;

import com.linkpets.dao.SysMenuMapper;
import com.linkpets.model.SysMenu;
import com.linkpets.responseModel.system.SysMenuResp;
import com.linkpets.service.ISysMenuService;
import com.linkpets.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenuResp> getSysMenuList() {
        List<SysMenu> sysMenuList = sysMenuMapper.getSysMenuListByParentId("0");
        List<SysMenuResp> sysMenuRespList = new ArrayList<>();
        sysMenuList.forEach(sysMenu -> {
            SysMenuResp sysMenuResp = new SysMenuResp(sysMenu.getId(), sysMenu.getParentId(), sysMenu.getTitle(), sysMenu.getPath(), sysMenu.getIcon(), sysMenu.getSort());
            List<SysMenu> sysMenuChildrenList = sysMenuMapper.getSysMenuListByParentId(sysMenu.getId());
            sysMenuResp.setChildren(sysMenuChildrenList);
            sysMenuRespList.add(sysMenuResp);
        });
        return sysMenuRespList;
    }

    @Override
    public SysMenu getSusMenuById(String id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

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