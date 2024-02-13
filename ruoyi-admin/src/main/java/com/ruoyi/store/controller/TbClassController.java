package com.ruoyi.store.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.store.domain.TbClass;
import com.ruoyi.store.service.ITbClassService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 类型管理Controller
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@RestController
@RequestMapping("/store/class")
public class TbClassController extends BaseController
{
    @Autowired
    private ITbClassService tbClassService;

    /**
     * 查询类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbClass tbClass)
    {
        startPage();
        List<TbClass> list = tbClassService.selectTbClassList(tbClass);
        return getDataTable(list);
    }

    /**
     * 导出类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:class:export')")
    @Log(title = "类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbClass tbClass)
    {
        List<TbClass> list = tbClassService.selectTbClassList(tbClass);
        ExcelUtil<TbClass> util = new ExcelUtil<TbClass>(TbClass.class);
        util.exportExcel(response, list, "类型管理数据");
    }

    /**
     * 获取类型管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:class:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return success(tbClassService.selectTbClassByClassId(classId));
    }

    /**
     * 新增类型管理
     */
    @PreAuthorize("@ss.hasPermi('store:class:add')")
    @Log(title = "类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbClass tbClass)
    {
        return toAjax(tbClassService.insertTbClass(tbClass));
    }

    /**
     * 修改类型管理
     */
    @PreAuthorize("@ss.hasPermi('store:class:edit')")
    @Log(title = "类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbClass tbClass)
    {
        return toAjax(tbClassService.updateTbClass(tbClass));
    }

    /**
     * 删除类型管理
     */
    @PreAuthorize("@ss.hasPermi('store:class:remove')")
    @Log(title = "类型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(tbClassService.deleteTbClassByClassIds(classIds));
    }
}
