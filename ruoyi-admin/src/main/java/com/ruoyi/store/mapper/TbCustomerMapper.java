package com.ruoyi.store.mapper;

import java.util.List;
import com.ruoyi.store.domain.TbCustomer;

/**
 * 用户管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface TbCustomerMapper 
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
     * 删除用户管理
     * 
     * @param customerId 用户管理主键
     * @return 结果
     */
    public int deleteTbCustomerByCustomerId(Long customerId);

    /**
     * 批量删除用户管理
     * 
     * @param customerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbCustomerByCustomerIds(Long[] customerIds);
}
