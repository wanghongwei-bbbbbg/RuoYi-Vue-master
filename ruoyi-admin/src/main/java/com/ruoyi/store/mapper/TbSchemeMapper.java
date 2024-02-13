package com.ruoyi.store.mapper;

import java.util.List;
import com.ruoyi.store.domain.TbScheme;
import com.ruoyi.store.domain.TbSchemeReview;

/**
 * 装机方案Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface TbSchemeMapper 
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
     * 删除装机方案
     * 
     * @param schemeId 装机方案主键
     * @return 结果
     */
    public int deleteTbSchemeBySchemeId(Long schemeId);

    /**
     * 批量删除装机方案
     * 
     * @param schemeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbSchemeBySchemeIds(Long[] schemeIds);

    /**
     * 批量删除${subTable.functionName}
     * 
     * @param schemeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbSchemeReviewBySchemeIds(Long[] schemeIds);
    
    /**
     * 批量新增${subTable.functionName}
     * 
     * @param tbSchemeReviewList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchTbSchemeReview(List<TbSchemeReview> tbSchemeReviewList);
    

    /**
     * 通过装机方案主键删除${subTable.functionName}信息
     * 
     * @param schemeId 装机方案ID
     * @return 结果
     */
    public int deleteTbSchemeReviewBySchemeId(Long schemeId);
}
