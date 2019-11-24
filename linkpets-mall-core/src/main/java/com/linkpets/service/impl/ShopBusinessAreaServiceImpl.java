package com.linkpets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.ShopBusinessAreaMapper;
import com.linkpets.model.ShopBusinessArea;
import com.linkpets.service.IShopBusinessAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShopBusinessAreaServiceImpl implements IShopBusinessAreaService {

    @Resource
    private ShopBusinessAreaMapper shopBusinessAreaMapper;

    @Override
    public PageInfo<ShopBusinessArea> listShopBusinessArea(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ShopBusinessArea> list = shopBusinessAreaMapper.listShopBusinessArea();
        return new PageInfo<>(list);
    }

    @Override
    public ShopBusinessArea getShopBusinessArea(String id) {
        return shopBusinessAreaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void uptShopBusinessArea(ShopBusinessArea shopBusinessArea) {
        shopBusinessAreaMapper.updateByPrimaryKeySelective(shopBusinessArea);
    }

    @Override
    public void crtShopBusinessArea(ShopBusinessArea shopBusinessArea) {
        shopBusinessArea.setCreateDate(new Date());
        shopBusinessAreaMapper.insertSelective(shopBusinessArea);
    }
}
