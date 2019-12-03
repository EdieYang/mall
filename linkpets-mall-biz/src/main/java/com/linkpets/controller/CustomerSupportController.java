package com.linkpets.controller;

import com.linkpets.model.CustomerSupport;
import com.linkpets.result.ApiResult;
import com.linkpets.service.ICustomerSupportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Edie
 */

@Api("客服服务")
@RestController
@RequestMapping("/customerSupportService")
public class CustomerSupportController {

    @Resource
    private ICustomerSupportService customerSupportService;

    @GetMapping("/{id}")
    public ApiResult getCustomerService(@PathVariable("id") String id) {
        return ApiResult.valueOf(customerSupportService.getCustomerSupport(id));
    }

    @GetMapping("/list")
    public ApiResult getCustomerServiceList(@RequestParam("belongType") String belongType) {
        return ApiResult.valueOf(customerSupportService.getCustomerSupportList(belongType));
    }

    @ApiOperation("分页获取客服列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "belongType", value = "归属类型 0：平台客服 1:公益客服", required = true)
    })
    @GetMapping("/page")
    public ApiResult getCustomerServicePage(@RequestParam("belongType") String belongType,
                                            @RequestParam("pageNum") int pageNum,
                                            @RequestParam("pageSize") int pageSize) {
        return ApiResult.valueOf(customerSupportService.getCustomerSupportPage(belongType, pageNum, pageSize));
    }

    @ApiOperation("新增客服")
    @PostMapping()
    public ApiResult crtCustomerService(@RequestBody CustomerSupport customerSupport) {
        return ApiResult.valueOf(customerSupportService.crtCustomerSupport(customerSupport));
    }

    @ApiOperation("更新客服")
    @PutMapping()
    public ApiResult uptCustomerService(@RequestBody CustomerSupport customerSupport) {
        customerSupportService.uptCustomerSupport(customerSupport);
        return ApiResult.success();
    }
}
