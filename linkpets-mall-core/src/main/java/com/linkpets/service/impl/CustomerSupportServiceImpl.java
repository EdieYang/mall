package com.linkpets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linkpets.dao.CustomerSupportMapper;
import com.linkpets.model.CustomerSupport;
import com.linkpets.service.ICustomerSupportService;
import com.linkpets.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author Edie
 */

@Service
public class CustomerSupportServiceImpl implements ICustomerSupportService {

    @Resource
    private CustomerSupportMapper customerSupportMapper;

    @Override
    public String crtCustomerSupport(CustomerSupport customerService) {
        String id = UUIDUtils.getId();
        customerService.setId(id);
        customerService.setCreateDate(new Date());
        customerSupportMapper.insertSelective(customerService);
        return id;
    }

    @Override
    public void uptCustomerSupport(CustomerSupport customerService) {
        customerSupportMapper.updateByPrimaryKeySelective(customerService);
    }

    @Override
    public void delCustomerSupport(String id) {
        customerSupportMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<CustomerSupport> getCustomerSupportPage(String belongType, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerSupport> customerServiceList = customerSupportMapper.getCustomerSupportList(belongType);
        return new PageInfo<>(customerServiceList);
    }

    @Override
    public List<CustomerSupport> getCustomerSupportList(String belongType) {
        return customerSupportMapper.getCustomerSupportList(belongType);
    }

    @Override
    public CustomerSupport getCustomerSupport(String id) {
        return customerSupportMapper.selectByPrimaryKey(id);
    }
}
