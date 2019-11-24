package com.linkpets.entity;

import com.linkpets.model.*;
import lombok.Data;

import java.util.List;

/**
 * @author Edie
 */
@Data
public class CommodityInfoReq {

    private CommodityInfo commodityInfo;
    private List<CommodityImg> commodityImgList;
    private List<CommoditySpec> commoditySpecList;
    private List<CommodityDistribute> commodityDistributeList;
    private List<CommodityAppointment> commodityAppointmentList;


}
