package com.ruoyi.store.service;

import java.util.List;
import com.ruoyi.store.domain.TbClass;

/**
 * 类型管理Service接口
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
public interface ITbClassService 
{
    /**
     * 查询类型管理
     * 
     * @param classId 类型管理主键
     * @return 类型管理
     */
    public TbClass selectTbClassByClassId(Long classId);

    /**
     * 查询类型管理列表
     * 
     * @param tbClass 类型管理
     * @return 类型管理集合
     */
    public List<TbClass> selectTbClassList(TbClass tbClass);

    /**
     * 新增类型管理
     * 
     * @param tbClass 类型管理
     * @return 结果
     */
    public int insertTbClass(TbClass tbClass);

    /**
     * 修改类型管理
     * 
     * @param tbClass 类型管理
     * @return 结果
     */
    public int updateTbClass(TbClass tbClass);

    /**
     * 批量删除类型管理
     * 
     * @param classIds 需要删除的类型管理主键集合
     * @return 结果
     */
    public int deleteTbClassByClassIds(Long[] classIds);

    /**
     * 删除类型管理信息
     * 
     * @param classId 类型管理主键
     * @return 结果
     */
    public int deleteTbClassByClassId(Long classId);
}
