package com.linkpets.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class CustomerSupport {
    private String id;

    @ApiModelProperty("微信号")
    private String wechat;

    @ApiModelProperty("联系方式")
    private String phone;

    @ApiModelProperty("微信号二维码")
    private String wxcodeUrl;

    @ApiModelProperty("服务时间")
    private String availableTime;

    @ApiModelProperty("归属类型  0：平台客服 1：公益客服")
    private String belongType;

    private String delFlag;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWxcodeUrl() {
        return wxcodeUrl;
    }

    public void setWxcodeUrl(String wxcodeUrl) {
        this.wxcodeUrl = wxcodeUrl;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public String getBelongType() {
        return belongType;
    }

    public void setBelongType(String belongType) {
        this.belongType = belongType;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}