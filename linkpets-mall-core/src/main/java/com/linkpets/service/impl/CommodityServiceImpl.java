package com.linkpets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.CommodityImgMapper;
import com.linkpets.dao.CommodityInfoMapper;
import com.linkpets.model.*;
import com.linkpets.responseModel.commodity.CommodityInfoTable;
import com.linkpets.service.ICommodityService;
import com.linkpets.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author edie
 */
@Service
public class CommodityServiceImpl implements ICommodityService {

    @Resource
    private CommodityInfoMapper commodityInfoMapper;
    @Resource
    private CommodityImgMapper commodityImgMapper;


    @Override
    public PageInfo<CommodityInfoTable> listCommodityInfoTable(String commodityName, String commodityId, String shopId, String commodityPattern, String commodityStatus, String recommended, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "create_time DESC");
        List<CommodityInfoTable> commodityInfoTables = commodityInfoMapper.listCommodityInfoTable(commodityName, commodityId, shopId, commodityStatus, commodityPattern, recommended);
        PageInfo<CommodityInfoTable> commodityInfoTablePageInfo = new PageInfo<>(commodityInfoTables);
        return commodityInfoTablePageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String crtCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList,
                                   List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList) {
        String commodityId = CommonUtil.getSerialNumberByPrefix("CO");
        commodityInfo.setCommodityId(commodityId);
        commodityInfoMapper.insertSelective(commodityInfo);
        commodityImgList.forEach(commodityImg -> {
            commodityImg.setCommodityId(commodityId);
            commodityImgMapper.insertSelective(commodityImg);
        });
        return commodityId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uptCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList,
                                 List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList) {
        commodityInfoMapper.updateByPrimaryKeySelective(commodityInfo);
        commodityImgMapper.delImg(commodityInfo.getCommodityId());
        commodityImgList.forEach(commodityImg -> {
            commodityImg.setCommodityId(commodityInfo.getCommodityId());
            commodityImgMapper.insertSelective(commodityImg);
        });

    }


}
