package com.linkpets.service.impl;

import java.util.List;
import java.util.Map;

import com.linkpets.mallEnum.SerialNumberEnum;
import com.linkpets.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.ActivityCommodityMapper;
import com.linkpets.dao.ActivityInfoMapper;
import com.linkpets.model.ActivityCommodity;
import com.linkpets.model.ActivityInfo;
import com.linkpets.service.IActivityService;

@Service
public class ActivityServiceImpl implements IActivityService{
	
	@Autowired
	ActivityInfoMapper activityInfoMapper;
	
	@Autowired
	ActivityCommodityMapper activityCommodityMapper;

	@Override
	public JSONObject getActivityInfo(String ActivityId) {
		JSONObject data = activityInfoMapper.getActivityInfo(ActivityId);//活动信息
		data.put("commodityList", activityCommodityMapper.getCommodityList(ActivityId));//活动商品
		return data;
	}

	@Override
	public JSONObject getActivityListForPage(Map<String, Object> param, int pageNum, int pageSize, String orderBy) {
		JSONObject result = new JSONObject();
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Map<String, Object>> list = activityInfoMapper.getList(param);
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        result.put("page", page.getPageNum());
        result.put("total", page.getTotal());
        result.put("rows", list);
        return result;
	}

	@Transactional
	@Override
	public void crtActivity(JSONObject activity) {
		String activityId = CommonUtil.getSerialNumberByPrefix(SerialNumberEnum.ACTIVITY_PREFIX);
		ActivityInfo info = JSONObject.toJavaObject(activity, ActivityInfo.class);
		info.setActivityId(activityId);
		activityInfoMapper.insertSelective(info);
		
		JSONArray list = activity.getJSONArray("commodityList");
		for (int i = 0; null != list && i < list.size(); i++) {
			JSONObject in = list.getJSONObject(i);
			ActivityCommodity commodity = JSONObject.toJavaObject(in, ActivityCommodity.class);
			commodity.setActivityId(activityId);
			activityCommodityMapper.insertSelective(commodity);
		}
		
	}

	@Transactional
	@Override
	public void uptActivity(JSONObject activity) {
		ActivityInfo info = JSONObject.toJavaObject(activity, ActivityInfo.class);
		activityInfoMapper.updateByPrimaryKeySelective(info);
		
		//删除原有图片
		activityCommodityMapper.delCommodity(info.getActivityId());
		
		JSONArray list = activity.getJSONArray("commodityList");
		for (int i = 0; null != list && i < list.size(); i++) {
			JSONObject in = list.getJSONObject(i);
			ActivityCommodity commodity = JSONObject.toJavaObject(in, ActivityCommodity.class);
			commodity.setActivityId(info.getActivityId());
			activityCommodityMapper.insertSelective(commodity);
		}
		
	}

	@Override
	public void saveActivityCommodity(List<ActivityCommodity> list) {
		// TODO Auto-generated method stub
		
	}

}
