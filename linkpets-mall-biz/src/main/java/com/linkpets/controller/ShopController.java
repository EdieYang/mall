package com.linkpets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.linkpets.mallEnum.SerialNumberEnum;
import com.linkpets.result.ApiResult;
import com.linkpets.service.IShopService;
import com.linkpets.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    IShopService shopService;


    @GetMapping("/id")
    public String getShopId() {
        return CommonUtil.getSerialNumberByPrefix(SerialNumberEnum.SHOP_PREFIX);
    }

    /**
     * @param @param  pageNum
     * @param @param  pageSize
     * @param @param  search
     * @param @param  sortCol
     * @param @param  sort
     * @param @return
     * @return JSONObject
     * @throws
     * @Title: getShopList 
     * @Description: 获取商铺列表（分页）
     * @author wando 
     * @date 2019年9月24日 下午6:33:28 
     * @version V1.0   
     */
    @GetMapping("/page")
    public ApiResult getShopPage(@RequestParam("pageNum") int pageNum,
                                 @RequestParam("pageSize") int pageSize,
                                 @RequestParam(value = "search", required = false) String search,
                                 @RequestParam(value = "sortCol", required = false, defaultValue = "shopName") String sortCol,
                                 @RequestParam(value = "sort", required = false, defaultValue = "asc") String sort) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("search", search);
        PageInfo<Map<String, Object>> shopPage = shopService.getShopPage(param, pageNum, pageSize, sortCol + " " + sort);
        return ApiResult.valueOf(shopPage);
    }


    @GetMapping("/list")
    public ApiResult getShopList() {
        List<Map<String,Object>> shopList = shopService.getShopList();
        return ApiResult.valueOf(shopList);
    }

    /**
     * 获取商铺详细信息
     *
     * @param shopId
     * @return
     */
    @GetMapping("/{shopId}/info")
    public JSONObject getShopInfo(@PathVariable("shopId") String shopId) {
        return shopService.getShopInfo(shopId);
    }

    /***
     *
     * @Title: crtShop 
     * @Description: 新增商铺
     * @param @param data
     * @return void
     * @author wando 
     * @throws
     * @date 2019年9月24日 下午6:31:51 
     * @version V1.0   
     */
    @PostMapping("/info")
    public void crtShop(@RequestBody JSONObject data) {
        shopService.crtShop(data);
    }

    /**
     * @param @param data
     * @return void
     * @throws
     * @Title: uptShop 
     * @Description: 更新商铺信息
     * @author wando 
     * @date 2019年9月24日 下午6:32:40 
     * @version V1.0   
     */
    @PutMapping("/info")
    public void uptShop(@RequestBody JSONObject data) {
        shopService.uptShop(data);
    }

}
