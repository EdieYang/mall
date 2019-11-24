package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.ShopBusinessArea;

public interface IShopBusinessAreaService {

    PageInfo<ShopBusinessArea> listShopBusinessArea(int pageNum, int pageSize);

    ShopBusinessArea getShopBusinessArea(String id);

    void uptShopBusinessArea(ShopBusinessArea shopBusinessArea);

    void crtShopBusinessArea(ShopBusinessArea shopBusinessArea);
}
