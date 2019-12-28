package com.linkpets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.CommodityDistributeMapper;
import com.linkpets.dao.CommodityImgMapper;
import com.linkpets.dao.CommodityInfoMapper;
import com.linkpets.dao.CommoditySpecMapper;
import com.linkpets.model.*;
import com.linkpets.responseModel.commodity.CommodityInfoRes;
import com.linkpets.responseModel.commodity.CommodityPage;
import com.linkpets.service.ICommodityService;
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


    @Override
    public PageInfo<CommodityPage> getCommodityInfoPage(String commodityName, String commodityId, String shopId, String commodityPattern, String commodityStatus, String recommended, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "create_date DESC");
        List<CommodityPage> commodityInfoTables = commodityInfoMapper.getCommodityInfoPage(commodityName, commodityId, shopId, commodityStatus, commodityPattern, recommended);
        PageInfo<CommodityPage> commodityPage = new PageInfo<>(commodityInfoTables);
        return commodityPage;
    }

    @Override
    public CommodityInfoRes getCommodityInfo(String commodityId) {
        CommodityInfoRes commodityInfoRes = new CommodityInfoRes();
        CommodityInfo commodityInfo = commodityInfoMapper.selectByPrimaryKey(commodityId);
        List<CommodityImg> commodityImgList = commodityImgMapper.getCommodityImgList(commodityId);
        if (commodityInfo.getMultiSpec().equals("1")) {
            List<CommoditySpec> commoditySpecList = commoditySpecMapper.getCommoditySpecList(commodityId);
            commodityInfoRes.setCommoditySpecList(commoditySpecList);
        }
        if (commodityInfo.getDistributed().equals("1")) {
            List<CommodityDistribute> commodityDistributeList = commodityDistributeMapper.getCommodityDistributeList(commodityId);
            commodityInfoRes.setCommodityDistributeList(commodityDistributeList);
        }
        commodityInfoRes.setCommodityInfo(commodityInfo);
        commodityInfoRes.setCommodityImgList(commodityImgList);
        return commodityInfoRes;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String crtCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList,
                                   List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList) {
        String commodityId = commodityInfo.getCommodityId();
        commodityInfo.setCreateDate(new Date());
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void uptCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList, List<CommoditySpec> commoditySpecList,
                                 List<CommodityDistribute> commodityDistributeList, List<CommodityAppointment> commodityAppointmentList) {
        String commodityId = commodityInfo.getCommodityId();
        commodityInfo.setUpdateDate(new Date());
        commodityInfoMapper.updateByPrimaryKeySelective(commodityInfo);
        commodityImgMapper.delCommodityImg(commodityId);
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
