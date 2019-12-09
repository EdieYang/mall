package com.linkpets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.CommodityDistributeMapper;
import com.linkpets.dao.CommodityImgMapper;
import com.linkpets.dao.CommodityInfoMapper;
import com.linkpets.dao.CommoditySpecMapper;
import com.linkpets.mallEnum.SerialNumberEnum;
import com.linkpets.model.*;
import com.linkpets.responseModel.commodity.CommodityInfoTable;
import com.linkpets.service.ICommodityService;
import com.linkpets.utils.CommonUtil;
import com.linkpets.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
    @Resource
    private CommoditySpecMapper commoditySpecMapper;
    @Resource
    private CommodityDistributeMapper commodityDistributeMapper;

    //公益渠道商品
    private static final String COMMODITY_CHANNEL_CHARITY = "1";

//
//    @Override
//    public PageInfo<CommodityInfoTable> listCommodityInfoTable(String commodityName, String commodityId, String shopId, String commodityPattern, String commodityStatus, String recommended, int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize, "create_time DESC");
//        List<CommodityInfoTable> commodityInfoTables = commodityInfoMapper.listCommodityInfoTable(commodityName, commodityId, shopId, commodityStatus, commodityPattern, recommended);
//        PageInfo<CommodityInfoTable> commodityInfoTablePageInfo = new PageInfo<>(commodityInfoTables);
//        return commodityInfoTablePageInfo;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String crtCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList,
                                   List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList) {
        String commodityId = commodityInfo.getCommodityId();
        commodityInfo.setCreateTime(new Date());
        commodityInfoMapper.insertSelective(commodityInfo);
        commodityImgList.forEach(commodityImg -> {
            commodityImg.setCommodityImgId(UUIDUtils.getId());
            commodityImg.setCommodityId(commodityId);
            commodityImgMapper.insertSelective(commodityImg);
        });
        commoditySpecList.forEach(commoditySpec -> {
            commoditySpec.setId(UUIDUtils.getId());
            commoditySpec.setCommodityId(commodityId);
            commoditySpecMapper.insertSelective(commoditySpec);
        });
        commodityDistributeList.forEach(commodityDistribute -> {
            commodityDistribute.setId(UUIDUtils.getId());
            commodityDistribute.setCommodityId(commodityId);
            commodityDistribute.setCreateDate(new Date());
            commodityDistributeMapper.insertSelective(commodityDistribute);
        });
        return commodityId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uptCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList,
                                 List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList) {
        String commodityId = commodityInfo.getCommodityId();
        commodityInfo.setUpdateTime(new Date());
        commodityInfoMapper.updateByPrimaryKeySelective(commodityInfo);
        commodityImgMapper.delImg(commodityId);
        commoditySpecMapper.delSpec(commodityId);
        commodityDistributeMapper.delDistribute(commodityId);
        commodityImgList.forEach(commodityImg -> {
            commodityImg.setCommodityImgId(UUIDUtils.getId());
            commodityImg.setCommodityId(commodityId);
            commodityImgMapper.insertSelective(commodityImg);
        });
        commoditySpecList.forEach(commoditySpec -> {
            commoditySpec.setId(UUIDUtils.getId());
            commoditySpec.setCommodityId(commodityId);
            commoditySpecMapper.insertSelective(commoditySpec);
        });
        commodityDistributeList.forEach(commodityDistribute -> {
            commodityDistribute.setId(UUIDUtils.getId());
            commodityDistribute.setCommodityId(commodityId);
            commodityDistribute.setCreateDate(new Date());
            commodityDistributeMapper.insertSelective(commodityDistribute);
        });
    }

    @Override
    public void uptCommodityStatus(String commodityId, String commodityStatus) {
        CommodityInfo commodityInfo = new CommodityInfo();
        commodityInfo.setCommodityId(commodityId);
        commodityInfo.setCommodityStatus(commodityStatus);
        commodityInfoMapper.updateByPrimaryKeySelective(commodityInfo);
    }


}
