package com.ruoyi.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.store.mapper.TbGoodMapper;
import com.ruoyi.store.domain.TbGood;
import com.ruoyi.store.service.ITbGoodService;

/**
 * 商品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@Service
public class TbGoodServiceImpl implements ITbGoodService 
{
    @Autowired
    private TbGoodMapper tbGoodMapper;

    /**
     * 查询商品管理
     * 
     * @param goodId 商品管理主键
     * @return 商品管理
     */
    @Override
    public TbGood selectTbGoodByGoodId(Long goodId)
    {
        return tbGoodMapper.selectTbGoodByGoodId(goodId);
    }

    /**
     * 查询商品管理列表
     * 
     * @param tbGood 商品管理
     * @return 商品管理
     */
    @Override
    public List<TbGood> selectTbGoodList(TbGood tbGood)
    {
        return tbGoodMapper.selectTbGoodList(tbGood);
    }

    /**
     * 新增商品管理
     * 
     * @param tbGood 商品管理
     * @return 结果
     */
    @Override
    public int insertTbGood(TbGood tbGood)
    {
        return tbGoodMapper.insertTbGood(tbGood);
    }

    /**
     * 修改商品管理
     * 
     * @param tbGood 商品管理
     * @return 结果
     */
    @Override
    public int updateTbGood(TbGood tbGood)
    {
        return tbGoodMapper.updateTbGood(tbGood);
    }

    /**
     * 批量删除商品管理
     * 
     * @param goodIds 需要删除的商品管理主键
     * @return 结果
     */
    @Override
    public int deleteTbGoodByGoodIds(Long[] goodIds)
    {
        return tbGoodMapper.deleteTbGoodByGoodIds(goodIds);
    }

    /**
     * 删除商品管理信息
     * 
     * @param goodId 商品管理主键
     * @return 结果
     */
    @Override
    public int deleteTbGoodByGoodId(Long goodId)
    {
        return tbGoodMapper.deleteTbGoodByGoodId(goodId);
    }
}
