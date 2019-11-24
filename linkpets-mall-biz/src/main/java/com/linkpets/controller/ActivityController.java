package com.linkpets.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.service.IActivityService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Resource
	IActivityService activityService;

	/**
	 *
	* @Title: getActivityList 
	* @Description: 获取活动列表（分页）
	* @param @param pageNum
	* @param @param pageSize
	* @param @param search
	* @param @param shopId
	* @param @param activityStatus
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
	public JSONObject getActivityList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "activityStatus", required = false) String activityStatus,
			@RequestParam(value = "shopId", required = false) String shopId,
			@RequestParam(value = "sortCol", required = false, defaultValue = "activityId") String sortCol,
			@RequestParam(value = "sort", required = false, defaultValue = "asc") String sort) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		param.put("activityStatus", activityStatus);
		param.put("shopId", shopId);
		JSONObject data = activityService.getActivityListForPage(param, pageNum, pageSize, sortCol + " " + sort);
		return data;
	}

	/**
	 * 获取活动详细信息
	 * @param activityId
	 * @return
	 */
	@GetMapping("/{activityId}/info")
	public JSONObject getActivityInfo(@PathVariable("activityId") String activityId){
		return activityService.getActivityInfo(activityId);
	}

	/***
	 *
	* @Title: crtActivity 
	* @Description: 新增活动
	* @param @param data
	* @return void
	* @author wando 
	* @throws
	* @date 2019年9月24日 下午6:31:51 
	* @version V1.0   
	 */
	@PostMapping("/info")
	public void crtActivity(@RequestBody JSONObject data) {
		activityService.crtActivity(data);
	}

	/**
	 *
	* @Title: uptActivity 
	* @Description: 更新活动信息
	* @param @param data
	* @return void
	* @author wando 
	* @throws
	* @date 2019年9月24日 下午6:32:40 
	* @version V1.0   
	 */
	@PutMapping("/info")
	public void uptActivity(@RequestBody JSONObject data) {
		activityService.uptActivity(data);
	}


}
