package com.linkpets.controller.rbac;


import com.linkpets.model.SysUser;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author edie
 */
@Api(tags = "系统用户")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @ApiOperation("新增用户")
    @PostMapping()
    public ApiResult crtSysUser(@RequestBody SysUser sysUser) {
        String userId = sysUserService.crtSysUser(sysUser);
        return ApiResult.valueOf(userId);
    }

    @ApiOperation("修改用户")
    @PutMapping()
    public ApiResult uptSysUser(@RequestBody SysUser sysUser) {
        sysUserService.uptSysUser(sysUser);
        return ApiResult.success();
    }


    @ApiOperation("删除用户")
    @DeleteMapping()
    public ApiResult delSysUser(@RequestParam("userId") String userId) {
        sysUserService.delSysUser(userId);
        return ApiResult.success();
    }


}
