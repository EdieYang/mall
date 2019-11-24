package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.*;
import com.linkpets.responseModel.commodity.CommodityInfoTable;

import java.util.List;

public interface ICommodityService {

    /**
     * 获取商品table列表
     *
     * @param commodityName
     * @param commodityId
     * @param shopId
     * @param commodityPattern
     * @param commodityStatus
     * @param recommended
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<CommodityInfoTable> listCommodityInfoTable(String commodityName, String commodityId, String shopId, String commodityPattern, String commodityStatus, String recommended, int pageNum, int pageSize);

    /**
     * 创建商品信息
     *
     * @param commodityInfo
     * @param commodityImgList
     * @return
     */
    String crtCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList, List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList);

    /**
     * 更新商品信息
     *
     * @param commodityInfo
     * @param commodityImgList
     */
    void uptCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList, List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList);
}
