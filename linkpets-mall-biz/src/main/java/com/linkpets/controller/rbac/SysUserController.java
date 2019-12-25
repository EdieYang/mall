package com.linkpets.controller.rbac;


import com.github.pagehelper.PageInfo;
import com.linkpets.annotate.UserLoginToken;
import com.linkpets.model.SysRole;
import com.linkpets.model.SysUser;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysUserService;
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
@Api(tags = "系统用户")
@UserLoginToken
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @ApiOperation("分页获取用户列表")
    @GetMapping("page")
    public ApiResult getSysUserPage(@RequestParam(value = "userAccount", required = false) String userAccount,
                                    @RequestParam(value = "userName", required = false) String userName,
                                    @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize) {
        PageInfo<SysUser> userPage = sysUserService.getSysUserPage(userAccount, userName, pageNum, pageSize);
        return ApiResult.valueOf(userPage);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("")
    public ApiResult getSysUser(@RequestParam(value = "userId") String userId) {
        SysUser sysUser = sysUserService.getSysUser(userId);
        return ApiResult.valueOf(sysUser);
    }

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

    @ApiOperation("批量删除用户")
    @DeleteMapping("batch")
    public ApiResult batchDelSysUser(@RequestParam("ids") String ids) {
        List<String> userIdList = Arrays.asList(ids.split(","));
        if (userIdList.size() > 0) {
            sysUserService.batchDelSysUser(userIdList);
        }
        return ApiResult.success();
    }

}
