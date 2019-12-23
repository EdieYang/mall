package com.linkpets.service.impl;

import com.linkpets.dao.SysRouteMapper;
import com.linkpets.model.SysRoute;
import com.linkpets.service.ISysRouteService;
import com.linkpets.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SysRouteServiceImpl implements ISysRouteService {

    @Resource
    private SysRouteMapper sysRouteMapper;

    @Override
    public String crtSysRoute(SysRoute sysRoute) {
        String routeId = UUIDUtils.getId();
        sysRoute.setId(routeId);
        sysRoute.setCreateDate(new Date());
        sysRouteMapper.insertSelective(sysRoute);
        return routeId;
    }

    @Override
    public void uptSysRoute(SysRoute sysRoute) {
        sysRouteMapper.updateByPrimaryKeySelective(sysRoute);
    }

    @Override
    public void delSysRoute(String routeId) {
        sysRouteMapper.delSysRoute(routeId);
    }
}
