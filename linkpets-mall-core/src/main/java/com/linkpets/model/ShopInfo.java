package com.linkpets.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ShopInfo {

    private String shopId;

    private String shopName;

    private String linkman;

    private String mobile;

    private String wechat;

    private String openTime;

    private String shopPhone;

    private String addressDistrict;

    private String addressDetail;

    private String shopStatus;

    private String saleShow;

    private String onlineSettle;

    private Integer settleRate;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private String delFlag;

}