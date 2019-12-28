package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.*;
import com.linkpets.responseModel.commodity.CommodityInfoRes;
import com.linkpets.responseModel.commodity.CommodityInfoTable;
import com.linkpets.responseModel.commodity.CommodityPage;

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
    PageInfo<CommodityPage> getCommodityInfoPage(String commodityName, String commodityId, String shopId, String commodityPattern, String commodityStatus, String recommended, int pageNum, int pageSize);


    /**
     * 获取商品信心
     * @param commodityId
     * @return
     */
    CommodityInfoRes getCommodityInfo(String commodityId);

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


    /**
     * 更新商品状态（下架、待审核、过审、上架）
     *
     * @param commodityId
     * @param commodityStatus
     */
    void uptCommodityStatus(String commodityId, String commodityStatus);
}
