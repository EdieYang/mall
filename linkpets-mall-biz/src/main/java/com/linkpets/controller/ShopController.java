package com.linkpets.controller;

import java.util.HashMap;
import java.util.Map;

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
	public String getShopId(){
		return CommonUtil.getSerialNumberByPrefix("shop");
	}
	/**
	 *
	* @Title: getShopList 
	* @Description: 获取商铺列表（分页）
	* @param @param pageNum
	* @param @param pageSize
	* @param @param search
	* @param @param sortCol
	* @param @param sort
	* @param @return
	* @return JSONObject
	* @author wando 
	* @throws
	* @date 2019年9月24日 下午6:33:28 
	* @version V1.0   
	 */
	@GetMapping("/list")
	public JSONObject getShopList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "sortCol", required = false, defaultValue = "shopName") String sortCol,
			@RequestParam(value = "sort", required = false, defaultValue = "asc") String sort) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		JSONObject data = shopService.getShopListForPage(param, pageNum, pageSize, sortCol + " " + sort);
		return data;
	}

	/**
	 * 获取商铺详细信息
	 * @param shopId
	 * @return
	 */
	@GetMapping("/{shopId}/info")
	public JSONObject getShopInfo(@PathVariable("shopId") String shopId){
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
	 *
	* @Title: uptShop 
	* @Description: 更新商铺信息
	* @param @param data
	* @return void
	* @author wando 
	* @throws
	* @date 2019年9月24日 下午6:32:40 
	* @version V1.0   
	 */
	@PutMapping("/info")
	public void uptShop(@RequestBody JSONObject data) {
		shopService.uptShop(data);
	}


}
