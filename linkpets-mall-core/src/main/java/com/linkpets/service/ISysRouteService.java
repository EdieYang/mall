package com.linkpets.service;

import com.linkpets.dao.SysRouteMapper;
import com.linkpets.model.SysRoute;

import javax.annotation.Resource;

public interface ISysRouteService {

    String crtSysRoute(SysRoute sysRoute);

    void uptSysRoute(SysRoute sysRoute);

    void delSysRoute(String routeId);
}
