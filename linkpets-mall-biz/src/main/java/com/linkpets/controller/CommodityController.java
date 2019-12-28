package com.linkpets.controller;

import com.github.pagehelper.PageInfo;
import com.linkpets.entity.CommodityInfoReq;
import com.linkpets.mallEnum.SerialNumberEnum;
import com.linkpets.model.CommodityImg;
import com.linkpets.model.CommodityInfo;
import com.linkpets.responseModel.commodity.CommodityInfoRes;
import com.linkpets.responseModel.commodity.CommodityPage;
import com.linkpets.result.ApiResult;
import com.linkpets.result.ApiResultCode;
import com.linkpets.service.ICommodityService;
import com.linkpets.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品服务")
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Resource
    private ICommodityService commodityService;

    @GetMapping("id")
    public ApiResult getCommodityId() {
        return ApiResult.valueOf(CommonUtil.getSerialNumberByPrefix(SerialNumberEnum.COMMODITY_PREFIX));
    }

    @ApiOperation("分页查询商品列表")
    @GetMapping("page")
    public PageInfo<CommodityPage> getCommodityInfoPage(@RequestParam(value = "commodityName", required = false) String commodityName,
                                                        @RequestParam(value = "commodityId", required = false) String commodityId,
                                                        @RequestParam(value = "shopId", required = false) String shopId,
                                                        @RequestParam(value = "commodityPattern", required = false) String commodityPattern,
                                                        @RequestParam(value = "commodityStatus", required = false) String commodityStatus,
                                                        @RequestParam(value = "recommended", required = false) String recommended,
                                                        @RequestParam(value = "pageNum") int pageNum,
                                                        @RequestParam(value = "pageSize") int pageSize) {
        return commodityService.getCommodityInfoPage(commodityName, commodityId, shopId, commodityPattern, commodityStatus, recommended, pageNum, pageSize);
    }


    @ApiOperation("查询商品信息")
    @GetMapping("")
    public CommodityInfoRes getCommodityInfo(@RequestParam(value = "commodityId") String commodityId) {
        return commodityService.getCommodityInfo(commodityId);
    }


    @PostMapping()
    public ApiResult crtCommodityInfo(@RequestBody CommodityInfoReq commodityInfoReq) {
        ApiResult validResult = validCommodityInfo(commodityInfoReq.getCommodityInfo(), commodityInfoReq.getCommodityImgList());
        if (validResult != null) {
            return validResult;
        }
        String commodityId = commodityService.crtCommodityInfo(commodityInfoReq.getCommodityInfo(), commodityInfoReq.getCommodityImgList(), commodityInfoReq.getCommoditySpecList(), commodityInfoReq.getCommodityDistributeList(), commodityInfoReq.getCommodityAppointmentList());
        return ApiResult.valueOf(commodityId);
    }

    @PutMapping()
    public ApiResult uptCommodityInfo(@RequestBody CommodityInfoReq commodityInfoReq) {
        ApiResult validResult = validCommodityInfo(commodityInfoReq.getCommodityInfo(), commodityInfoReq.getCommodityImgList());
        if (validResult != null) {
            return validResult;
        }
        commodityService.uptCommodityInfo(commodityInfoReq.getCommodityInfo(), commodityInfoReq.getCommodityImgList(), commodityInfoReq.getCommoditySpecList(), commodityInfoReq.getCommodityDistributeList(), commodityInfoReq.getCommodityAppointmentList());
        return ApiResult.success();
    }

    @PutMapping("commodityStatus")
    public ApiResult uptCommodityStatus(@RequestParam("commodityId") String commodityId,
                                        @RequestParam("commodityStatus") String commodityStatus) {
        commodityService.uptCommodityStatus(commodityId, commodityStatus);
        return ApiResult.success();
    }


    private ApiResult validCommodityInfo(CommodityInfo commodityInfo, List<CommodityImg> commodityImgList) {
        if (StringUtils.isEmpty(commodityInfo.getCommodityId())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_ID);
        }
        if (StringUtils.isEmpty(commodityInfo.getCommodityName())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_NAME);
        }
        if (StringUtils.isEmpty(commodityInfo.getCommodityType())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_TYPE);
        }
        if (StringUtils.isEmpty(commodityInfo.getCommodityPattern())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_PATTERN);
        }
        if (StringUtils.isEmpty(commodityInfo.getDisplayImg())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_DISPLAY_IMG);
        }
        if (commodityInfo.getMarketPrice() == null) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_MARKET_PRICE);
        }
        if (commodityInfo.getSellingPrice() == null) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_SELLING_PRICE);
        }
        if (commodityInfo.getPurchasePrice() == null) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_PURCHASE_PRICE);
        }
        if (commodityInfo.getStock() == 0) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_STOCK);
        }
        if (StringUtils.isBlank(commodityInfo.getCommodityRules())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_RULES);
        }
        if (StringUtils.isBlank(commodityInfo.getCommodityUsage())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_USAGE);
        }
        if (StringUtils.isBlank(commodityInfo.getCommodityDetail())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_DETAIL);
        }
        if (StringUtils.isEmpty(commodityInfo.getShopId())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_SHOP_ID);
        }
        if (StringUtils.isBlank(commodityInfo.getShareTitle())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_SHARE_TITLE);
        }
        if (StringUtils.isBlank(commodityInfo.getShareInfo())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_SHARE_INFO);
        }
        if (StringUtils.isEmpty(commodityInfo.getShareWapImg())) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_SHARE_WAP_IMG);
        }
        if (commodityImgList == null || commodityImgList.size() == 0) {
            return ApiResult.errorOf(ApiResultCode.COMMODITY_INVALID_IMG);
        }
        return null;
    }


}
