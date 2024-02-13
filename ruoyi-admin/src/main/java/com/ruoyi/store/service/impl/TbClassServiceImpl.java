package com.ruoyi.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.store.mapper.TbClassMapper;
import com.ruoyi.store.domain.TbClass;
import com.ruoyi.store.service.ITbClassService;

/**
 * 类型管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@Service
public class TbClassServiceImpl implements ITbClassService 
{
    @Autowired
    private TbClassMapper tbClassMapper;

    /**
     * 查询类型管理
     * 
     * @param classId 类型管理主键
     * @return 类型管理
     */
    @Override
    public TbClass selectTbClassByClassId(Long classId)
    {
        return tbClassMapper.selectTbClassByClassId(classId);
    }

    /**
     * 查询类型管理列表
     * 
     * @param tbClass 类型管理
     * @return 类型管理
     */
    @Override
    public List<TbClass> selectTbClassList(TbClass tbClass)
    {
        return tbClassMapper.selectTbClassList(tbClass);
    }

    /**
     * 新增类型管理
     * 
     * @param tbClass 类型管理
     * @return 结果
     */
    @Override
    public int insertTbClass(TbClass tbClass)
    {
        return tbClassMapper.insertTbClass(tbClass);
    }

    /**
     * 修改类型管理
     * 
     * @param tbClass 类型管理
     * @return 结果
     */
    @Override
    public int updateTbClass(TbClass tbClass)
    {
        return tbClassMapper.updateTbClass(tbClass);
    }

    /**
     * 批量删除类型管理
     * 
     * @param classIds 需要删除的类型管理主键
     * @return 结果
     */
    @Override
    public int deleteTbClassByClassIds(Long[] classIds)
    {
        return tbClassMapper.deleteTbClassByClassIds(classIds);
    }

    /**
     * 删除类型管理信息
     * 
     * @param classId 类型管理主键
     * @return 结果
     */
    @Override
    public int deleteTbClassByClassId(Long classId)
    {
        return tbClassMapper.deleteTbClassByClassId(classId);
    }
}
