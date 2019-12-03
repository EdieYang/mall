package com.linkpets.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class CustomerSupport {
    private String id;

    @ApiModelProperty(value = "微信号", required = true)
    private String wechat;

    @ApiModelProperty(value = "联系方式", required = true, position = 1)
    private String phone;

    @ApiModelProperty(value = "微信号二维码", required = true, position = 2)
    private String wxcodeUrl;

    @ApiModelProperty(value = "服务时间", required = true, position = 3)
    private String availableTime;

    @ApiModelProperty(value = "归属类型  0：平台客服 1：公益客服", required = true, position = 4)
    private String belongType;

    @ApiModelProperty(hidden = true)
    private String delFlag;

    @ApiModelProperty(hidden = true)
    private Date createDate;

    public CustomerSupport() {
        this.createDate = new Date();
    }

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