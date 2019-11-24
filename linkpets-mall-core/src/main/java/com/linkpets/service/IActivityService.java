package com.linkpets.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.model.ActivityCommodity;

public interface IActivityService {

	JSONObject getActivityInfo(String ActivityId);

	JSONObject getActivityListForPage(Map<String, Object> param, int pageNum, int pageSize, String orderBy);

	void crtActivity(JSONObject Activity);

	void uptActivity(JSONObject Activity);

	void saveActivityCommodity(List<ActivityCommodity> list);

}
