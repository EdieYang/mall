package com.linkpets.service;

import com.linkpets.model.SysRole;

public interface ISysRoleService {

    String crtSysRole(SysRole sysRole);

    void uptSysRole(SysRole sysRole);

    void delSysRole(String roleId);


}
