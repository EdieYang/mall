package com.linkpets.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author edie
 */
public class CommodityInfo {

    private String commodityId;

    private String commodityName;

    private String commodityType;

    private String commodityStatus;

    private String commodityPattern;

    private String displayImg;

    private String saleDate;

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

    private String csContact;

    private String csWxcode;

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
    private Date createTime;

    private String delFlag;

    public CommodityInfo() {
    }

    public CommodityInfo(String commodityId, String commodityName, String commodityType, String commodityStatus, String commodityPattern, String displayImg, String saleDate, Integer marketPrice, Integer sellingPrice, Integer purchasePrice, Integer stock, Integer stockWarn, String distributed, String commodityRules, String commodityUsage, String commodityDetail, String multiSpec, String recommended, String shopId, Integer saleCount, Integer browseCount, String showStock, String showSale, String verificationType, String verificationDate, Integer purchaseLimit, String csContact, String csWxcode, String shareTitle, String shareInfo, String shareWapImg, String shareMiniImg, String sharePost, Integer purchasePoints, String refundType, String appointment, String createBy, Date createTime, String delFlag) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityType = commodityType;
        this.commodityStatus = commodityStatus;
        this.commodityPattern = commodityPattern;
        this.displayImg = displayImg;
        this.saleDate = saleDate;
        this.marketPrice = marketPrice;
        this.sellingPrice = sellingPrice;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.stockWarn = stockWarn;
        this.distributed = distributed;
        this.commodityRules = commodityRules;
        this.commodityUsage = commodityUsage;
        this.commodityDetail = commodityDetail;
        this.multiSpec = multiSpec;
        this.recommended = recommended;
        this.shopId = shopId;
        this.saleCount = saleCount;
        this.browseCount = browseCount;
        this.showStock = showStock;
        this.showSale = showSale;
        this.verificationType = verificationType;
        this.verificationDate = verificationDate;
        this.purchaseLimit = purchaseLimit;
        this.csContact = csContact;
        this.csWxcode = csWxcode;
        this.shareTitle = shareTitle;
        this.shareInfo = shareInfo;
        this.shareWapImg = shareWapImg;
        this.shareMiniImg = shareMiniImg;
        this.sharePost = sharePost;
        this.purchasePoints = purchasePoints;
        this.refundType = refundType;
        this.appointment = appointment;
        this.createBy = createBy;
        this.createTime = createTime;
        this.delFlag = delFlag;
    }

    public CommodityInfo(String commodityId, String commodityName, String commodityType, String commodityStatus, String commodityPattern, String displayImg, String saleDate,
                         String distributed, String commodityRules, String commodityUsage, String commodityDetail, String multiSpec, String recommended, String shopId,
                         String showStock, String showSale, String verificationType, String verificationDate, Integer purchaseLimit, String csContact, String csWxcode,
                         String shareTitle, String shareInfo, String shareWapImg, String shareMiniImg, String sharePost, Integer purchasePoints, String refundType, String appointment,
                         String createBy, Date createTime, String delFlag) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityType = commodityType;
        this.commodityStatus = commodityStatus;
        this.commodityPattern = commodityPattern;
        this.displayImg = displayImg;
        this.saleDate = saleDate;
        this.marketPrice = new Integer(0);
        this.sellingPrice = new Integer(0);
        this.purchasePrice = new Integer(0);
        this.stock = 0;
        this.stockWarn = 0;
        this.distributed = distributed;
        this.commodityRules = commodityRules;
        this.commodityUsage = commodityUsage;
        this.commodityDetail = commodityDetail;
        this.multiSpec = multiSpec;
        this.recommended = recommended;
        this.shopId = shopId;
        this.saleCount = 0;
        this.browseCount = 0;
        this.showStock = showStock;
        this.showSale = showSale;
        this.verificationType = verificationType;
        this.verificationDate = verificationDate;
        this.purchaseLimit = purchaseLimit;
        this.csContact = csContact;
        this.csWxcode = csWxcode;
        this.shareTitle = shareTitle;
        this.shareInfo = shareInfo;
        this.shareWapImg = shareWapImg;
        this.shareMiniImg = shareMiniImg;
        this.sharePost = sharePost;
        this.purchasePoints = purchasePoints;
        this.refundType = refundType;
        this.appointment = appointment;
        this.createBy = createBy;
        this.createTime = createTime;
        this.delFlag = delFlag;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(String commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public String getCommodityPattern() {
        return commodityPattern;
    }

    public void setCommodityPattern(String commodityPattern) {
        this.commodityPattern = commodityPattern;
    }

    public String getDisplayImg() {
        return displayImg;
    }

    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockWarn() {
        return stockWarn;
    }

    public void setStockWarn(Integer stockWarn) {
        this.stockWarn = stockWarn;
    }

    public String getDistributed() {
        return distributed;
    }

    public void setDistributed(String distributed) {
        this.distributed = distributed;
    }

    public String getCommodityRules() {
        return commodityRules;
    }

    public void setCommodityRules(String commodityRules) {
        this.commodityRules = commodityRules;
    }

    public String getCommodityUsage() {
        return commodityUsage;
    }

    public void setCommodityUsage(String commodityUsage) {
        this.commodityUsage = commodityUsage;
    }

    public String getCommodityDetail() {
        return commodityDetail;
    }

    public void setCommodityDetail(String commodityDetail) {
        this.commodityDetail = commodityDetail;
    }

    public String getMultiSpec() {
        return multiSpec;
    }

    public void setMultiSpec(String multiSpec) {
        this.multiSpec = multiSpec;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public String getShowStock() {
        return showStock;
    }

    public void setShowStock(String showStock) {
        this.showStock = showStock;
    }

    public String getShowSale() {
        return showSale;
    }

    public void setShowSale(String showSale) {
        this.showSale = showSale;
    }

    public String getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(String verificationType) {
        this.verificationType = verificationType;
    }

    public String getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public Integer getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setPurchaseLimit(Integer purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public String getCsContact() {
        return csContact;
    }

    public void setCsContact(String csContact) {
        this.csContact = csContact;
    }

    public String getCsWxcode() {
        return csWxcode;
    }

    public void setCsWxcode(String csWxcode) {
        this.csWxcode = csWxcode;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(String shareInfo) {
        this.shareInfo = shareInfo;
    }

    public String getShareWapImg() {
        return shareWapImg;
    }

    public void setShareWapImg(String shareWapImg) {
        this.shareWapImg = shareWapImg;
    }

    public String getShareMiniImg() {
        return shareMiniImg;
    }

    public void setShareMiniImg(String shareMiniImg) {
        this.shareMiniImg = shareMiniImg;
    }

    public String getSharePost() {
        return sharePost;
    }

    public void setSharePost(String sharePost) {
        this.sharePost = sharePost;
    }

    public Integer getPurchasePoints() {
        return purchasePoints;
    }

    public void setPurchasePoints(Integer purchasePoints) {
        this.purchasePoints = purchasePoints;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}