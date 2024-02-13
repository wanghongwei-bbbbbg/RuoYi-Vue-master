package com.ruoyi.store.service;

import java.util.List;
import com.ruoyi.store.domain.TbGood;

/**
 * 商品管理Service接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface ITbGoodService 
{
    /**
     * 查询商品管理
     * 
     * @param goodId 商品管理主键
     * @return 商品管理
     */
    public TbGood selectTbGoodByGoodId(Long goodId);

    /**
     * 查询商品管理列表
     * 
     * @param tbGood 商品管理
     * @return 商品管理集合
     */
    public List<TbGood> selectTbGoodList(TbGood tbGood);

    /**
     * 新增商品管理
     * 
     * @param tbGood 商品管理
     * @return 结果
     */
    public int insertTbGood(TbGood tbGood);

    /**
     * 修改商品管理
     * 
     * @param tbGood 商品管理
     * @return 结果
     */
    public int updateTbGood(TbGood tbGood);

    /**
     * 批量删除商品管理
     * 
     * @param goodIds 需要删除的商品管理主键集合
     * @return 结果
     */
    public int deleteTbGoodByGoodIds(Long[] goodIds);

    /**
     * 删除商品管理信息
     * 
     * @param goodId 商品管理主键
     * @return 结果
     */
    public int deleteTbGoodByGoodId(Long goodId);
}
