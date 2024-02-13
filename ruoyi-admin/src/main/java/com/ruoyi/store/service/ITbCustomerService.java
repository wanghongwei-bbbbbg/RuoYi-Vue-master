package com.ruoyi.store.service;

import java.util.List;
import com.ruoyi.store.domain.TbCustomer;

/**
 * 用户管理Service接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface ITbCustomerService 
{
    /**
     * 查询用户管理
     * 
     * @param customerId 用户管理主键
     * @return 用户管理
     */
    public TbCustomer selectTbCustomerByCustomerId(Long customerId);

    /**
     * 查询用户管理列表
     * 
     * @param tbCustomer 用户管理
     * @return 用户管理集合
     */
    public List<TbCustomer> selectTbCustomerList(TbCustomer tbCustomer);

    /**
     * 新增用户管理
     * 
     * @param tbCustomer 用户管理
     * @return 结果
     */
    public int insertTbCustomer(TbCustomer tbCustomer);

    /**
     * 修改用户管理
     * 
     * @param tbCustomer 用户管理
     * @return 结果
     */
    public int updateTbCustomer(TbCustomer tbCustomer);

    /**
     * 批量删除用户管理
     * 
     * @param customerIds 需要删除的用户管理主键集合
     * @return 结果
     */
    public int deleteTbCustomerByCustomerIds(Long[] customerIds);

    /**
     * 删除用户管理信息
     * 
     * @param customerId 用户管理主键
     * @return 结果
     */
    public int deleteTbCustomerByCustomerId(Long customerId);
}
