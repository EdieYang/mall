package com.linkpets.controller;


import com.github.pagehelper.PageInfo;
import com.linkpets.model.ShopBusinessArea;
import com.linkpets.result.ApiResult;
import com.linkpets.service.IShopBusinessAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shopBusinessArea")
public class ShopBusinessAreaController {

    @Resource
    private IShopBusinessAreaService shopBusinessAreaService;

    @GetMapping("/list")
    public PageInfo<ShopBusinessArea> listShopBusinessArea(@RequestParam("pageNum") int pageNum,
                                                           @RequestParam("pageSize") int pageSize) {
        return shopBusinessAreaService.listShopBusinessArea(pageNum,pageSize);
    }

    @GetMapping
    public ShopBusinessArea shopBusinessArea(@RequestParam("id") String id) {
        return shopBusinessAreaService.getShopBusinessArea(id);
    }

    @PutMapping
    public ApiResult uptShopBusinessArea(@RequestBody ShopBusinessArea shopBusinessArea) {
        shopBusinessAreaService.uptShopBusinessArea(shopBusinessArea);
        return ApiResult.success();
    }

    @PostMapping
    public ApiResult crtShopBusinessArea(@RequestBody ShopBusinessArea shopBusinessArea) {
        shopBusinessAreaService.crtShopBusinessArea(shopBusinessArea);
        return ApiResult.success();
    }
}
