package com.linkpets.controller;

import com.github.pagehelper.PageInfo;
import com.linkpets.responseModel.SysUserInfo;
import com.linkpets.model.SysUser;
import com.linkpets.result.ApiResult;
import com.linkpets.result.ApiResultCode;
import com.linkpets.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @GetMapping("/login")
    public ApiResult login(@RequestParam("userAccount") String userAccount,
                           @RequestParam("password") String password) {
        SysUser user = sysUserService.getSysUserByUserAccount(userAccount);
        if (user == null) {
            return ApiResult.errorOf(ApiResultCode.VALID_USER_ACCOUNT, "");
        }
        if (!user.getPassword().equals(password)) {
            return ApiResult.errorOf(ApiResultCode.VALID_USER_ACCOUNT_PASSWORD, "");
        }
        return ApiResult.valueOf(user);
    }

    @GetMapping("/shop/users")
    public PageInfo<SysUserInfo> listShopSysUser(@RequestParam(value = "shopId", required = false) String shopId,
                                                 @RequestParam(value = "search", required = false) String search,
                                                 @RequestParam("pageNum") int pageNum,
                                                 @RequestParam("pageSize") int pageSize) {

        return sysUserService.listShopSysUser(shopId, search, pageNum, pageSize);
    }

    @GetMapping("/shop/user")
    public SysUserInfo getShopSysUser(@RequestParam(value = "user_id") String userId) {
        return sysUserService.getShopSysUser(userId);
    }

    @PutMapping("/shop/user")
    public void uptShopSysUser(@RequestBody SysUser sysUser, @RequestParam("shopId") String shopId) {
        sysUserService.uptShopSysUser(sysUser, shopId);
    }

    @PostMapping("/shop/user")
    public void crtShopSysUser(@RequestBody SysUser sysUser, @RequestParam("shopId") String shopId) {
        sysUserService.crtShopSysUser(sysUser, shopId);
    }

}
