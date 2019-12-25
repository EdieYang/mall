package com.linkpets.service;

import com.linkpets.dao.SysRouteMapper;
import com.linkpets.model.SysRoute;
import com.linkpets.responseModel.system.SysLoginRouteRes;
import com.linkpets.responseModel.system.SysRouteRes;

import javax.annotation.Resource;
import java.util.List;

public interface ISysRouteService {

    List<SysRouteRes> getSysRouteList();

    List<SysLoginRouteRes> getSysLoginRouteList();

    SysRouteRes getSysRoute(String id);

    String crtSysRoute(SysRoute sysRoute);

    void uptSysRoute(SysRoute sysRoute);

    void delSysRoute(String routeId);
}
