package com.ruoyi.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.store.mapper.TbCustomerMapper;
import com.ruoyi.store.domain.TbCustomer;
import com.ruoyi.store.service.ITbCustomerService;

/**
 * 用户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@Service
public class TbCustomerServiceImpl implements ITbCustomerService 
{
    @Autowired
    private TbCustomerMapper tbCustomerMapper;

    /**
     * 查询用户管理
     * 
     * @param customerId 用户管理主键
     * @return 用户管理
     */
    @Override
    public TbCustomer selectTbCustomerByCustomerId(Long customerId)
    {
        return tbCustomerMapper.selectTbCustomerByCustomerId(customerId);
    }

    /**
     * 查询用户管理列表
     * 
     * @param tbCustomer 用户管理
     * @return 用户管理
     */
    @Override
    public List<TbCustomer> selectTbCustomerList(TbCustomer tbCustomer)
    {
        return tbCustomerMapper.selectTbCustomerList(tbCustomer);
    }

    /**
     * 新增用户管理
     * 
     * @param tbCustomer 用户管理
     * @return 结果
     */
    @Override
    public int insertTbCustomer(TbCustomer tbCustomer)
    {
        return tbCustomerMapper.insertTbCustomer(tbCustomer);
    }

    /**
     * 修改用户管理
     * 
     * @param tbCustomer 用户管理
     * @return 结果
     */
    @Override
    public int updateTbCustomer(TbCustomer tbCustomer)
    {
        return tbCustomerMapper.updateTbCustomer(tbCustomer);
    }

    /**
     * 批量删除用户管理
     * 
     * @param customerIds 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteTbCustomerByCustomerIds(Long[] customerIds)
    {
        return tbCustomerMapper.deleteTbCustomerByCustomerIds(customerIds);
    }

    /**
     * 删除用户管理信息
     * 
     * @param customerId 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteTbCustomerByCustomerId(Long customerId)
    {
        return tbCustomerMapper.deleteTbCustomerByCustomerId(customerId);
    }
}
