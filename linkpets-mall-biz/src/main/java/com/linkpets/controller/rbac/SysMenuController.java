package com.linkpets.controller.rbac;

import com.linkpets.model.SysMenu;
import com.linkpets.model.SysRole;
import com.linkpets.responseModel.system.SysMenuRes;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author edie
 */
@Api(tags = "系统菜单")
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;


    @ApiOperation("查询菜单列表")
    @GetMapping("list")
    public ApiResult getSysMenuList() {
        List<SysMenuRes> sysMenuRespList = sysMenuService.getSysMenuList();
        return ApiResult.valueOf(sysMenuRespList);
    }


    @ApiOperation("查询菜单")
    @GetMapping("")
    public ApiResult getSysMenuList(@RequestParam("id") String id) {
        SysMenu sysMenu = sysMenuService.getSusMenuById(id);
        return ApiResult.valueOf(sysMenu);
    }


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
    public ApiResult delSysMenu(@RequestParam("id") String id) {
        sysMenuService.delSysMenu(id);
        return ApiResult.success();
    }

    @ApiOperation("根据角色查询菜单列表")
    @GetMapping("role")
    public ApiResult getSysRoleMenuList(@RequestParam("roleId") String roleId) {
        List<SysMenu> sysMenuList = sysMenuService.getSysRoleMenuList(roleId);
        return ApiResult.valueOf(sysMenuList);
    }

}
