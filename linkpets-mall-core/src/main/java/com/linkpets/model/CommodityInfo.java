package com.linkpets.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class CommodityInfo {
    private String commodityId;

    private String commodityName;

    private String commodityType;

    private String commodityChannel;

    private String commodityStatus;

    private String commodityPattern;

    private String displayImg;

    private String saleDate;

    private Integer charityPrice;

    private Integer marketPrice;

    private Integer sellingPrice;

    private Integer purchasePrice;

    private Integer stock;

    private Integer stockWarn;

    private String distributed;

    private String commodityRules;

    private String commodityUsage;

    private String commodityDetail;

    private String multiSpec;

    private String recommended;

    private String shopId;

    private Integer saleCount;

    private Integer browseCount;

    private String showStock;

    private String showSale;

    private String verificationType;

    private String verificationDate;

    private Integer purchaseLimit;

    private String customerSupportId;

    private String shareTitle;

    private String shareInfo;

    private String shareWapImg;

    private String shareMiniImg;

    private String sharePost;

    private Integer purchasePoints;

    private String refundType;

    private String appointment;

    private String createBy;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    private String delFlag;


}