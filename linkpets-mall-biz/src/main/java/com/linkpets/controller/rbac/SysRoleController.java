package com.linkpets.controller.rbac;


import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysRole;
import com.linkpets.model.SysUser;
import com.linkpets.responseModel.system.SysRolePermissionRes;
import com.linkpets.responseModel.system.SysRoleUserRes;
import com.linkpets.responseModel.system.SysUserRoleRes;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


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
    public ApiResult getSysRolePage(@RequestParam(value = "roleName", required = false) String roleName,
                                    @RequestParam(value = "roleCode", required = false) String roleCode,
                                    @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize) {
        PageInfo<SysRole> rolePage = sysRoleService.getSysRolePage(roleName, roleCode, pageNum, pageSize);
        return ApiResult.valueOf(rolePage);
    }


    @ApiOperation("获取角色信息")
    @GetMapping("")
    public ApiResult getSysRolePage(@RequestParam(value = "id") String id) {
        SysRole rolePage = sysRoleService.getSysRole(id);
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
    public ApiResult delSysRole(@RequestParam("id") String id) {
        sysRoleService.delSysRole(id);
        return ApiResult.success();
    }

    @ApiOperation("批量删除角色")
    @DeleteMapping("batch")
    public ApiResult batchDelSysRole(@RequestParam("ids") String ids) {
        List<String> roleIdList = Arrays.asList(ids.split(","));
        if (roleIdList.size() > 0) {
            sysRoleService.batchDelSysRole(roleIdList);
        }
        return ApiResult.success();
    }

    @ApiOperation("分页根据角色获取用户列表")
    @GetMapping("user/page")
    public ApiResult getSysRoleUserPage(@RequestParam(value = "roleId") String roleId,
                                        @RequestParam(value = "userAccount", required = false) String userAccount,
                                        @RequestParam(value = "userName", required = false) String userName,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        PageInfo<SysRoleUserRes> rolePage = sysRoleService.getSysRoleUserPage(roleId, userAccount, userName, pageNum, pageSize);
        return ApiResult.valueOf(rolePage);
    }


    @ApiOperation("新增用户角色")
    @PostMapping("user")
    public ApiResult crtSysUserRole(@RequestParam("userId") String userId,
                                    @RequestParam("roleId") String roleId) {
        sysRoleService.crtSysUserRole(userId, roleId);
        return ApiResult.success();
    }


    @ApiOperation("删除用户角色")
    @DeleteMapping("user")
    public ApiResult delSysUserRole(@RequestParam("userId") String userId,
                                    @RequestParam("roleId") String roleId) {
        sysRoleService.delSysUserRole(userId, roleId);
        return ApiResult.success();
    }


    @ApiOperation("分页获取角色权限列表")
    @GetMapping("permission/page")
    public ApiResult getSysRolePermissionPage(@RequestParam(value = "roleId") String roleId,
                                              @RequestParam(value = "permissionName", required = false) String permissionName,
                                              @RequestParam(value = "permissionCode", required = false) String permissionCode,
                                              @RequestParam("pageNum") int pageNum,
                                              @RequestParam("pageSize") int pageSize) {
        PageInfo<SysRolePermissionRes> rolePage = sysRoleService.getSysRolePermissionPage(roleId, permissionName, permissionCode, pageNum, pageSize);
        return ApiResult.valueOf(rolePage);
    }


    @ApiOperation("新增角色权限")
    @PostMapping("permission")
    public ApiResult crtSysRolePermission(@RequestParam("permissionId") String permissionId,
                                          @RequestParam("roleId") String roleId) {
        sysRoleService.crtSysRolePermission(roleId, permissionId);
        return ApiResult.success();
    }


    @ApiOperation("删除角色权限")
    @DeleteMapping("permission")
    public ApiResult delSysRolePermission(@RequestParam("permissionId") String permissionId,
                                          @RequestParam("roleId") String roleId) {
        sysRoleService.delSysRolePermission(roleId, permissionId);
        return ApiResult.success();
    }


    @ApiOperation("分页根据用户获取角色列表")
    @GetMapping("userRole/page")
    public ApiResult getRolePage(@RequestParam(value = "roleName", required = false) String roleName,
                                 @RequestParam(value = "roleCode", required = false) String roleCode,
                                 @RequestParam(value = "userId") String userId,
                                 @RequestParam("pageNum") int pageNum,
                                 @RequestParam("pageSize") int pageSize) {
        PageInfo<SysUserRoleRes> userRolePage = sysRoleService.getSysUserRolePage(userId, roleName, roleCode, pageNum, pageSize);
        return ApiResult.valueOf(userRolePage);
    }

    @ApiOperation("新增角色菜单")
    @PostMapping("menu")
    public ApiResult crtSysRoleMenus(@RequestParam("menus") String menus,
                                     @RequestParam("roleId") String roleId) {
        sysRoleService.crtSysRoleMenus(roleId, menus);
        return ApiResult.success();
    }

}
