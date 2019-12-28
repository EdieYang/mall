package com.linkpets.responseModel.commodity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * 商品分页列表
 *
 * @author edie
 */
@Data
public class CommodityPage {

    private String commodityId;

    private String commodityName;

    private String displayImg;

    private String commodityPattern;

    private Integer onSale;

    private String recommended;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private Integer browserAmount;

    private Integer saleAmount;

    private Integer stock;

    private Integer turnover;

    private Integer distributeAmount;

    private String commodityStatus;

}
