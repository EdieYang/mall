package com.linkpets.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ShopUserRel {
    private String id;

    private String shopId;

    private String userId;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    private String delFlag;

    public ShopUserRel(){}

    public ShopUserRel(String id, String shopId, String userId, Date createDate, Date updateDate) {
        this.id = id;
        this.shopId = shopId;
        this.userId = userId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}