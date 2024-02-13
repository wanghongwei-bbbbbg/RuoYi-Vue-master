package com.ruoyi.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.store.domain.TbOrderDetail;
import com.ruoyi.store.mapper.TbOrderMapper;
import com.ruoyi.store.domain.TbOrder;
import com.ruoyi.store.service.ITbOrderService;

/**
 * 订单管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@Service
public class TbOrderServiceImpl implements ITbOrderService 
{
    @Autowired
    private TbOrderMapper tbOrderMapper;

    /**
     * 查询订单管理
     * 
     * @param orderId 订单管理主键
     * @return 订单管理
     */
    @Override
    public TbOrder selectTbOrderByOrderId(Long orderId)
    {
        return tbOrderMapper.selectTbOrderByOrderId(orderId);
    }

    /**
     * 查询订单管理列表
     * 
     * @param tbOrder 订单管理
     * @return 订单管理
     */
    @Override
    public List<TbOrder> selectTbOrderList(TbOrder tbOrder)
    {
        return tbOrderMapper.selectTbOrderList(tbOrder);
    }

    /**
     * 新增订单管理
     * 
     * @param tbOrder 订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTbOrder(TbOrder tbOrder)
    {
        int rows = tbOrderMapper.insertTbOrder(tbOrder);
        insertTbOrderDetail(tbOrder);
        return rows;
    }

    /**
     * 修改订单管理
     * 
     * @param tbOrder 订单管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTbOrder(TbOrder tbOrder)
    {
        tbOrderMapper.deleteTbOrderDetailByOrderId(tbOrder.getOrderId());
        insertTbOrderDetail(tbOrder);
        return tbOrderMapper.updateTbOrder(tbOrder);
    }

    /**
     * 批量删除订单管理
     * 
     * @param orderIds 需要删除的订单管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbOrderByOrderIds(Long[] orderIds)
    {
        tbOrderMapper.deleteTbOrderDetailByOrderIds(orderIds);
        return tbOrderMapper.deleteTbOrderByOrderIds(orderIds);
    }

    /**
     * 删除订单管理信息
     * 
     * @param orderId 订单管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbOrderByOrderId(Long orderId)
    {
        tbOrderMapper.deleteTbOrderDetailByOrderId(orderId);
        return tbOrderMapper.deleteTbOrderByOrderId(orderId);
    }

    /**
     * 新增${subTable.functionName}信息
     * 
     * @param tbOrder 订单管理对象
     */
    public void insertTbOrderDetail(TbOrder tbOrder)
    {
        List<TbOrderDetail> tbOrderDetailList = tbOrder.getTbOrderDetailList();
        Long orderId = tbOrder.getOrderId();
        if (StringUtils.isNotNull(tbOrderDetailList))
        {
            List<TbOrderDetail> list = new ArrayList<TbOrderDetail>();
            for (TbOrderDetail tbOrderDetail : tbOrderDetailList)
            {
                tbOrderDetail.setOrderId(orderId);
                list.add(tbOrderDetail);
            }
            if (list.size() > 0)
            {
                tbOrderMapper.batchTbOrderDetail(list);
            }
        }
    }
}
