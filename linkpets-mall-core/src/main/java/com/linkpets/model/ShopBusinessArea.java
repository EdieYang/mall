package com.linkpets.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ShopBusinessArea {

    private Integer id;

    private String areaName;

    private String delFlag;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

}