package com.linkpets.service;

import com.linkpets.model.SysMenu;

public interface ISysMenuService {

    String crtSysMenu(SysMenu sysMenu);

    void uptSysMenu(SysMenu sysMenu);

    void delSysMenu(String menuId);

}
