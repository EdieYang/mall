package com.linkpets.service;

import com.linkpets.model.SysMenu;
import com.linkpets.responseModel.system.SysMenuRes;

import java.util.List;

public interface ISysMenuService {

    List<SysMenuRes> getSysMenuList();

    SysMenu getSusMenuById(String id);

    String crtSysMenu(SysMenu sysMenu);

    void uptSysMenu(SysMenu sysMenu);

    void delSysMenu(String menuId);

}
