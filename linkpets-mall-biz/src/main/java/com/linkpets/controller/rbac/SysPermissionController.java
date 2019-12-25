package com.linkpets.controller.rbac;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.SysPermission;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ISysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Edie
 */
@Api(tags = "系统权限")
@RestController
@RequestMapping("/sys/permission")
public class SysPermissionController {

    @Resource
    private ISysPermissionService sysPermissionService;

    @ApiOperation("分页获取权限列表")
    @GetMapping("page")
    public ApiResult getSysPermissionPage(@RequestParam(value = "permissionName", required = false) String permissionName,
                                          @RequestParam(value = "permissionCode", required = false) String permissionCode,
                                          @RequestParam("pageNum") int pageNum,
                                          @RequestParam("pageSize") int pageSize) {
        PageInfo<SysPermission> permissionPage = sysPermissionService.getSysPermissionPage(permissionName, permissionCode, pageNum, pageSize);
        return ApiResult.valueOf(permissionPage);
    }

    @ApiOperation("获取权限信息")
    @GetMapping("")
    public ApiResult getSysPermissionPage(@RequestParam(value = "id") String id) {
        SysPermission permissionPage = sysPermissionService.getSysPermission(id);
        return ApiResult.valueOf(permissionPage);
    }

    @ApiOperation("新增权限")
    @PostMapping()
    public ApiResult crtSysPermission(@RequestBody SysPermission sysPermission) {
        String permissionId = sysPermissionService.crtSysPermission(sysPermission);
        return ApiResult.valueOf(permissionId);
    }

    @ApiOperation("修改权限")
    @PutMapping()
    public ApiResult uptSysPermission(@RequestBody SysPermission sysPermission) {
        sysPermissionService.uptSysPermission(sysPermission);
        return ApiResult.success();
    }


    @ApiOperation("删除权限")
    @DeleteMapping()
    public ApiResult delSysPermission(@RequestParam("id") String id) {
        sysPermissionService.delSysPermission(id);
        return ApiResult.success();
    }

    @ApiOperation("批量删除权限")
    @DeleteMapping("batch")
    public ApiResult batchDelSysPermission(@RequestParam("ids") String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        if (idList.size() > 0) {
            sysPermissionService.batchDelSysPermission(idList);
        }
        return ApiResult.success();
    }
}
