package com.ruoyi.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.store.domain.TbSchemeReview;
import com.ruoyi.store.mapper.TbSchemeMapper;
import com.ruoyi.store.domain.TbScheme;
import com.ruoyi.store.service.ITbSchemeService;

/**
 * 装机方案Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@Service
public class TbSchemeServiceImpl implements ITbSchemeService 
{
    @Autowired
    private TbSchemeMapper tbSchemeMapper;

    /**
     * 查询装机方案
     * 
     * @param schemeId 装机方案主键
     * @return 装机方案
     */
    @Override
    public TbScheme selectTbSchemeBySchemeId(Long schemeId)
    {
        return tbSchemeMapper.selectTbSchemeBySchemeId(schemeId);
    }

    /**
     * 查询装机方案列表
     * 
     * @param tbScheme 装机方案
     * @return 装机方案
     */
    @Override
    public List<TbScheme> selectTbSchemeList(TbScheme tbScheme)
    {
        return tbSchemeMapper.selectTbSchemeList(tbScheme);
    }

    /**
     * 新增装机方案
     * 
     * @param tbScheme 装机方案
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTbScheme(TbScheme tbScheme)
    {
        int rows = tbSchemeMapper.insertTbScheme(tbScheme);
        insertTbSchemeReview(tbScheme);
        return rows;
    }

    /**
     * 修改装机方案
     * 
     * @param tbScheme 装机方案
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTbScheme(TbScheme tbScheme)
    {
        tbSchemeMapper.deleteTbSchemeReviewBySchemeId(tbScheme.getSchemeId());
        insertTbSchemeReview(tbScheme);
        return tbSchemeMapper.updateTbScheme(tbScheme);
    }

    /**
     * 批量删除装机方案
     * 
     * @param schemeIds 需要删除的装机方案主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbSchemeBySchemeIds(Long[] schemeIds)
    {
        tbSchemeMapper.deleteTbSchemeReviewBySchemeIds(schemeIds);
        return tbSchemeMapper.deleteTbSchemeBySchemeIds(schemeIds);
    }

    /**
     * 删除装机方案信息
     * 
     * @param schemeId 装机方案主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTbSchemeBySchemeId(Long schemeId)
    {
        tbSchemeMapper.deleteTbSchemeReviewBySchemeId(schemeId);
        return tbSchemeMapper.deleteTbSchemeBySchemeId(schemeId);
    }

    /**
     * 新增${subTable.functionName}信息
     * 
     * @param tbScheme 装机方案对象
     */
    public void insertTbSchemeReview(TbScheme tbScheme)
    {
        List<TbSchemeReview> tbSchemeReviewList = tbScheme.getTbSchemeReviewList();
        Long schemeId = tbScheme.getSchemeId();
        if (StringUtils.isNotNull(tbSchemeReviewList))
        {
            List<TbSchemeReview> list = new ArrayList<TbSchemeReview>();
            for (TbSchemeReview tbSchemeReview : tbSchemeReviewList)
            {
                tbSchemeReview.setSchemeId(schemeId);
                list.add(tbSchemeReview);
            }
            if (list.size() > 0)
            {
                tbSchemeMapper.batchTbSchemeReview(list);
            }
        }
    }
}
