package com.ruoyi.store.mapper;

import java.util.List;
import com.ruoyi.store.domain.TbBrand;

/**
 * 品牌管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface TbBrandMapper 
{
    /**
     * 查询品牌管理
     * 
     * @param brandId 品牌管理主键
     * @return 品牌管理
     */
    public TbBrand selectTbBrandByBrandId(Long brandId);

    /**
     * 查询品牌管理列表
     * 
     * @param tbBrand 品牌管理
     * @return 品牌管理集合
     */
    public List<TbBrand> selectTbBrandList(TbBrand tbBrand);

    /**
     * 新增品牌管理
     * 
     * @param tbBrand 品牌管理
     * @return 结果
     */
    public int insertTbBrand(TbBrand tbBrand);

    /**
     * 修改品牌管理
     * 
     * @param tbBrand 品牌管理
     * @return 结果
     */
    public int updateTbBrand(TbBrand tbBrand);

    /**
     * 删除品牌管理
     * 
     * @param brandId 品牌管理主键
     * @return 结果
     */
    public int deleteTbBrandByBrandId(Long brandId);

    /**
     * 批量删除品牌管理
     * 
     * @param brandIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbBrandByBrandIds(Long[] brandIds);
}
