package com.ruoyi.store.service;

import java.util.List;
import com.ruoyi.store.domain.TbOrder;

/**
 * 订单管理Service接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface ITbOrderService 
{
    /**
     * 查询订单管理
     * 
     * @param orderId 订单管理主键
     * @return 订单管理
     */
    public TbOrder selectTbOrderByOrderId(Long orderId);

    /**
     * 查询订单管理列表
     * 
     * @param tbOrder 订单管理
     * @return 订单管理集合
     */
    public List<TbOrder> selectTbOrderList(TbOrder tbOrder);

    /**
     * 新增订单管理
     * 
     * @param tbOrder 订单管理
     * @return 结果
     */
    public int insertTbOrder(TbOrder tbOrder);

    /**
     * 修改订单管理
     * 
     * @param tbOrder 订单管理
     * @return 结果
     */
    public int updateTbOrder(TbOrder tbOrder);

    /**
     * 批量删除订单管理
     * 
     * @param orderIds 需要删除的订单管理主键集合
     * @return 结果
     */
    public int deleteTbOrderByOrderIds(Long[] orderIds);

    /**
     * 删除订单管理信息
     * 
     * @param orderId 订单管理主键
     * @return 结果
     */
    public int deleteTbOrderByOrderId(Long orderId);
}
