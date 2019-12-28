package com.linkpets.responseModel.commodity;

import com.linkpets.model.CommodityDistribute;
import com.linkpets.model.CommodityImg;
import com.linkpets.model.CommodityInfo;
import com.linkpets.model.CommoditySpec;
import lombok.Data;

import java.util.List;

/**
 * 商品信息
 *
 * @author edie
 */
@Data
public class CommodityInfoRes {

    private CommodityInfo commodityInfo;

    private List<CommoditySpec> commoditySpecList;

    private List<CommodityImg> commodityImgList;

    private List<CommodityDistribute> commodityDistributeList;


}
