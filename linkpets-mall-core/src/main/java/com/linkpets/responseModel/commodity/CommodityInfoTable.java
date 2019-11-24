package com.linkpets.responseModel.commodity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author edie
 * @desc 商品详情table列表
 */
@Data
public class CommodityInfoTable {
    private String commodityId;
    private String commodityName;
    private String commodityType;
    private String commodityStatus;
    private String displayImg;
    private int stock;
    private String distributed;
    private String recommended;
    private int browseCount;
    private int saleCount;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 分销佣金总金额
     */
    private BigDecimal commissionAmount;
    private String createBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 核销日期类型
     */
    private String verificationType;
    /**
     * 核销日期
     */
    private String verificationDate;
}
