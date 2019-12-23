package com.linkpets.controller.rbac;

import com.linkpets.model.SysMenu;
import com.linkpets.model.SysRole;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author edie
 */
@Api(tags = "系统菜单")
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    @ApiOperation("新增菜单")
    @PostMapping()
    public ApiResult crtSysMenu(@RequestBody SysMenu sysMenu) {
        String menuId = sysMenuService.crtSysMenu(sysMenu);
        return ApiResult.valueOf(menuId);
    }

    @ApiOperation("修改菜单")
    @PutMapping()
    public ApiResult uptSysMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.uptSysMenu(sysMenu);
        return ApiResult.success();
    }


    @ApiOperation("删除菜单")
    @DeleteMapping()
    public ApiResult delSysMenu(@RequestParam("menuId") String menuId) {
        sysMenuService.delSysMenu(menuId);
        return ApiResult.success();
    }


}
