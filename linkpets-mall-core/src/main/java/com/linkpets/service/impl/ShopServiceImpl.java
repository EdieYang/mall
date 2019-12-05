package com.linkpets.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.ShopImgMapper;
import com.linkpets.dao.ShopInfoMapper;
import com.linkpets.mallEnum.SerialNumberEnum;
import com.linkpets.service.IShopService;
import com.linkpets.model.ShopImg;
import com.linkpets.model.ShopInfo;
import com.linkpets.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements IShopService {

    @Resource
    ShopInfoMapper shopInfoMapper;

    @Resource
    ShopImgMapper shopImgMapper;

    @Override
    public JSONObject getShopInfo(String shopId) {
        //商铺信息
        ShopInfo shopInfo = shopInfoMapper.getShopInfo(shopId);
        JSONObject data = new JSONObject();
        data.put("shopInfo", shopInfo);
        //商铺图片
        data.put("imgList", shopImgMapper.getImgList(shopId));
        return data;
    }

    @Override
    public PageInfo<Map<String, Object>> getShopPage(Map<String, Object> param, int pageNum, int pageSize, String orderBy) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Map<String, Object>> list = shopInfoMapper.getListByParam(param);
        return new PageInfo<>(list);
    }

    @Override
    public List<Map<String, Object>> getShopList() {
        return shopInfoMapper.getList();
    }

    @Transactional
    @Override
    public void crtShop(JSONObject shop) {
        String shopId = CommonUtil.getSerialNumberByPrefix(SerialNumberEnum.SHOP_PREFIX);
        ShopInfo info = JSONObject.toJavaObject(shop, ShopInfo.class);
        info.setShopId(shopId);
        info.setCreateDate(new Date());
        shopInfoMapper.insertSelective(info);

        JSONArray list = shop.getJSONArray("imgList");
        for (int i = 0; null != list && i < list.size(); i++) {
            JSONObject in = list.getJSONObject(i);
            ShopImg img = JSONObject.toJavaObject(in, ShopImg.class);
            img.setShopId(shopId);
            shopImgMapper.insertSelective(img);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void uptShop(JSONObject shop) {
        ShopInfo info = JSONObject.toJavaObject(shop, ShopInfo.class);
        shopInfoMapper.updateByPrimaryKeySelective(info);

        //删除原有图片
        shopImgMapper.delImg(info.getShopId());

        JSONArray list = shop.getJSONArray("imgList");
        for (int i = 0; null != list && i < list.size(); i++) {
            JSONObject in = list.getJSONObject(i);
            ShopImg img = JSONObject.toJavaObject(in, ShopImg.class);
            //如果图片id存在，更改图片失效状态
            if (img.getPkId() != null) {
                img.setDelFlag("0");
                shopImgMapper.updateByPrimaryKeySelective(img);
            } else {
                img.setShopId(info.getShopId());
                shopImgMapper.insertSelective(img);
            }

        }

    }

    @Override
    public void saveShopImg(List<ShopImg> list) {
        // TODO Auto-generated method stub

    }

}
