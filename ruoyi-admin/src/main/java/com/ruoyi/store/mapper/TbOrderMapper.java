package com.ruoyi.store.mapper;

import java.util.List;
import com.ruoyi.store.domain.TbOrder;
import com.ruoyi.store.domain.TbOrderDetail;

/**
 * 订单管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface TbOrderMapper 
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
     * 删除订单管理
     * 
     * @param orderId 订单管理主键
     * @return 结果
     */
    public int deleteTbOrderByOrderId(Long orderId);

    /**
     * 批量删除订单管理
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbOrderByOrderIds(Long[] orderIds);

    /**
     * 批量删除${subTable.functionName}
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbOrderDetailByOrderIds(Long[] orderIds);
    
    /**
     * 批量新增${subTable.functionName}
     * 
     * @param tbOrderDetailList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchTbOrderDetail(List<TbOrderDetail> tbOrderDetailList);
    

    /**
     * 通过订单管理主键删除${subTable.functionName}信息
     * 
     * @param orderId 订单管理ID
     * @return 结果
     */
    public int deleteTbOrderDetailByOrderId(Long orderId);
}
