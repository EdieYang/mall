package com.linkpets.controller.rbac;


import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysRole;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author edie
 */
@Api(tags = "系统角色")
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;

    @ApiOperation("分页获取角色列表")
    @GetMapping("page")
    public ApiResult getSysRolePage(@RequestParam("roleName") String roleName,
                                    @RequestParam("roleDescription") String roleDescription,
                                    @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize) {
        PageInfo<SysRole> rolePage = sysRoleService.getSysRolePage(roleName, roleDescription, pageNum, pageSize);
        return ApiResult.valueOf(rolePage);
    }


    @ApiOperation("新增角色")
    @PostMapping()
    public ApiResult crtSysRole(@RequestBody SysRole sysRole) {
        String roleId = sysRoleService.crtSysRole(sysRole);
        return ApiResult.valueOf(roleId);
    }

    @ApiOperation("修改角色")
    @PutMapping()
    public ApiResult uptSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.uptSysRole(sysRole);
        return ApiResult.success();
    }


    @ApiOperation("删除角色")
    @DeleteMapping()
    public ApiResult delSysRole(@RequestParam("roleId") String roleId) {
        sysRoleService.delSysRole(roleId);
        return ApiResult.success();
    }


}
