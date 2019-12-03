package com.linkpets.service;

import com.github.pagehelper.PageInfo;
import com.linkpets.model.CustomerSupport;
import com.linkpets.responseModel.commodity.CommodityInfoTable;

import java.util.List;

/**
 * @Author Edie
 */

public interface ICustomerSupportService {

    /**
     * 新增客服
     *
     * @param customerService
     * @return
     */
    String crtCustomerSupport(CustomerSupport customerService);

    /**
     * 更新客服
     *
     * @param customerService
     */
    void uptCustomerSupport(CustomerSupport customerService);

    /**
     * 删除客服
     * @param id
     */
    void delCustomerSupport(String id);

    /**
     * 分页获取客服信息
     *
     * @param belongType 归属类型 0：商城渠道客服 1：公益渠道客服
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<CustomerSupport> getCustomerSupportPage(String belongType, int pageNum, int pageSize);

    /**
     * 获取客服列表
     *
     * @param belongType
     * @return
     */
    List<CustomerSupport> getCustomerSupportList(String belongType);

    /**
     * 获取客服信息
     *
     * @param id
     * @return
     */
    CustomerSupport getCustomerSupport(String id);


}
