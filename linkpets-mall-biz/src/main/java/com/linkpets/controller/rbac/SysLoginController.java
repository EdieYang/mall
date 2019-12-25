package com.linkpets.controller.rbac;

import com.linkpets.model.SysPermission;
import com.linkpets.model.SysRole;
import com.linkpets.model.SysUser;
import com.linkpets.responseModel.system.SysLoginRes;
import com.linkpets.responseModel.system.SysLoginRouteRes;
import com.linkpets.responseModel.system.SysMenuRes;
import com.linkpets.responseModel.system.SysRouteRes;
import com.linkpets.result.ApiResult;
import com.linkpets.result.ApiResultCode;
import com.linkpets.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Edie
 */
@Api(tags = "系统用户登录")
@RestController
@RequestMapping("/sys/login")
public class SysLoginController {

    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysPermissionService sysPermissionService;
    @Resource
    private ISysMenuService sysMenuService;
    @Resource
    private ISysRouteService sysRouteService;

    @ApiOperation("分页获取用户列表")
    @GetMapping("")
    public ApiResult sysUserLogin(@RequestParam("userAccount") String userAccount,
                                  @RequestParam("password") String password) {
        SysUser sysUser = sysUserService.getSysUserByUserAccount(userAccount);
        if (sysUser == null) {
            return ApiResult.errorOf(ApiResultCode.VALID_USER_ACCOUNT);
        }

        if (!sysUser.getPassword().equals(password)) {
            return ApiResult.errorOf(ApiResultCode.VALID_USER_ACCOUNT_PASSWORD);
        }

        String userId = sysUser.getUserId();
        SysLoginRes sysLoginRes = new SysLoginRes();
        sysLoginRes.setUserId(userId);
        sysLoginRes.setUserName(sysUser.getUserName());
        //查询此用户系统角色
        List<SysRole> sysRoleList = sysRoleService.getSysRoleListByUserId(userId);
        List<String> userRoles = new ArrayList<>();
        sysRoleList.forEach(sysRole -> {
            userRoles.add(sysRole.getRoleCode());
        });
        //查询此用户系统权限
        List<SysPermission> sysPermissionList = sysPermissionService.getSysPermissionListByUserId(userId);
        List<String> userPermissions = new ArrayList<>();
        sysPermissionList.forEach(sysPermission -> {
            userPermissions.add(sysPermission.getPermissionCode());
        });
        //查询所有系统Route
        List<SysLoginRouteRes> sysRouteResList = sysRouteService.getSysLoginRouteList();
        //查询此用户系统菜单
        List<SysMenuRes> sysMenuResList = sysMenuService.getSysMenuListByUserId(userId);
        sysLoginRes.setUserRoles(userRoles);
        sysLoginRes.setUserPermissions(userPermissions);
        sysLoginRes.setAccessRoutes(sysRouteResList);
        sysLoginRes.setAccessMenus(sysMenuResList);
        return ApiResult.valueOf(sysLoginRes);
    }


}
