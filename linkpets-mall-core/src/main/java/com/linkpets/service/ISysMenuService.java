package com.linkpets.service;

import com.linkpets.model.SysMenu;
import com.linkpets.responseModel.system.SysMenuResp;

import java.util.List;

public interface ISysMenuService {

    List<SysMenuResp> getSysMenuList();

    SysMenu getSusMenuById(String id);

    String crtSysMenu(SysMenu sysMenu);

    void uptSysMenu(SysMenu sysMenu);

    void delSysMenu(String menuId);

}
