package com.linkpets.controller.rbac;

import com.linkpets.model.SysRoute;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysRouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author edie
 */
@Api(tags = "系统路由")
@RestController
@RequestMapping("/sys/route")
public class SysRouteController {

    @Resource
    private ISysRouteService sysRouteService;

    @ApiOperation("新增路由")
    @PostMapping()
    public ApiResult crtSysRoute(@RequestBody SysRoute sysRoute) {
        String routeId = sysRouteService.crtSysRoute(sysRoute);
        return ApiResult.valueOf(routeId);
    }

    @ApiOperation("修改路由")
    @PutMapping()
    public ApiResult uptSysRoute(@RequestBody SysRoute sysRole) {
        sysRouteService.uptSysRoute(sysRole);
        return ApiResult.success();
    }


    @ApiOperation("删除路由")
    @DeleteMapping()
    public ApiResult delSysRoute(@RequestParam("routeId") String routeId) {
        sysRouteService.delSysRoute(routeId);
        return ApiResult.success();
    }


}
