package com.ruoyi.store.service;

import java.util.List;
import com.ruoyi.store.domain.TbScheme;

/**
 * 装机方案Service接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface ITbSchemeService 
{
    /**
     * 查询装机方案
     * 
     * @param schemeId 装机方案主键
     * @return 装机方案
     */
    public TbScheme selectTbSchemeBySchemeId(Long schemeId);

    /**
     * 查询装机方案列表
     * 
     * @param tbScheme 装机方案
     * @return 装机方案集合
     */
    public List<TbScheme> selectTbSchemeList(TbScheme tbScheme);

    /**
     * 新增装机方案
     * 
     * @param tbScheme 装机方案
     * @return 结果
     */
    public int insertTbScheme(TbScheme tbScheme);

    /**
     * 修改装机方案
     * 
     * @param tbScheme 装机方案
     * @return 结果
     */
    public int updateTbScheme(TbScheme tbScheme);

    /**
     * 批量删除装机方案
     * 
     * @param schemeIds 需要删除的装机方案主键集合
     * @return 结果
     */
    public int deleteTbSchemeBySchemeIds(Long[] schemeIds);

    /**
     * 删除装机方案信息
     * 
     * @param schemeId 装机方案主键
     * @return 结果
     */
    public int deleteTbSchemeBySchemeId(Long schemeId);
}
