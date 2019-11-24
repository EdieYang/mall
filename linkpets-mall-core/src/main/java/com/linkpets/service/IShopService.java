package com.linkpets.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.model.ShopImg;

public interface IShopService {
	
	JSONObject getShopInfo(String shopId);
	
	JSONObject getShopListForPage(Map<String, Object> param, int pageNum, int pageSize, String orderBy);

	void crtShop(JSONObject shop);
	
	void uptShop(JSONObject shop);
	
	void saveShopImg(List<ShopImg> list);

}
