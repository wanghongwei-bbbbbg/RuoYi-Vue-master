package com.ruoyi.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.store.mapper.TbBrandMapper;
import com.ruoyi.store.domain.TbBrand;
import com.ruoyi.store.service.ITbBrandService;

/**
 * 品牌管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@Service
public class TbBrandServiceImpl implements ITbBrandService 
{
    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 查询品牌管理
     * 
     * @param brandId 品牌管理主键
     * @return 品牌管理
     */
    @Override
    public TbBrand selectTbBrandByBrandId(Long brandId)
    {
        return tbBrandMapper.selectTbBrandByBrandId(brandId);
    }

    /**
     * 查询品牌管理列表
     * 
     * @param tbBrand 品牌管理
     * @return 品牌管理
     */
    @Override
    public List<TbBrand> selectTbBrandList(TbBrand tbBrand)
    {
        return tbBrandMapper.selectTbBrandList(tbBrand);
    }

    /**
     * 新增品牌管理
     * 
     * @param tbBrand 品牌管理
     * @return 结果
     */
    @Override
    public int insertTbBrand(TbBrand tbBrand)
    {
        return tbBrandMapper.insertTbBrand(tbBrand);
    }

    /**
     * 修改品牌管理
     * 
     * @param tbBrand 品牌管理
     * @return 结果
     */
    @Override
    public int updateTbBrand(TbBrand tbBrand)
    {
        return tbBrandMapper.updateTbBrand(tbBrand);
    }

    /**
     * 批量删除品牌管理
     * 
     * @param brandIds 需要删除的品牌管理主键
     * @return 结果
     */
    @Override
    public int deleteTbBrandByBrandIds(Long[] brandIds)
    {
        return tbBrandMapper.deleteTbBrandByBrandIds(brandIds);
    }

    /**
     * 删除品牌管理信息
     * 
     * @param brandId 品牌管理主键
     * @return 结果
     */
    @Override
    public int deleteTbBrandByBrandId(Long brandId)
    {
        return tbBrandMapper.deleteTbBrandByBrandId(brandId);
    }
}
