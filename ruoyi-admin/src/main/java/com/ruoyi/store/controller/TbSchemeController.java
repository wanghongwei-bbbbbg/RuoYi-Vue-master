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
import com.ruoyi.store.domain.TbScheme;
import com.ruoyi.store.service.ITbSchemeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 装机方案Controller
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@RestController
@RequestMapping("/store/scheme")
public class TbSchemeController extends BaseController
{
    @Autowired
    private ITbSchemeService tbSchemeService;

    /**
     * 查询装机方案列表
     */
    @PreAuthorize("@ss.hasPermi('store:scheme:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbScheme tbScheme)
    {
        startPage();
        List<TbScheme> list = tbSchemeService.selectTbSchemeList(tbScheme);
        return getDataTable(list);
    }

    /**
     * 导出装机方案列表
     */
    @PreAuthorize("@ss.hasPermi('store:scheme:export')")
    @Log(title = "装机方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbScheme tbScheme)
    {
        List<TbScheme> list = tbSchemeService.selectTbSchemeList(tbScheme);
        ExcelUtil<TbScheme> util = new ExcelUtil<TbScheme>(TbScheme.class);
        util.exportExcel(response, list, "装机方案数据");
    }

    /**
     * 获取装机方案详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:scheme:query')")
    @GetMapping(value = "/{schemeId}")
    public AjaxResult getInfo(@PathVariable("schemeId") Long schemeId)
    {
        return success(tbSchemeService.selectTbSchemeBySchemeId(schemeId));
    }

    /**
     * 新增装机方案
     */
    @PreAuthorize("@ss.hasPermi('store:scheme:add')")
    @Log(title = "装机方案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbScheme tbScheme)
    {
        return toAjax(tbSchemeService.insertTbScheme(tbScheme));
    }

    /**
     * 修改装机方案
     */
    @PreAuthorize("@ss.hasPermi('store:scheme:edit')")
    @Log(title = "装机方案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbScheme tbScheme)
    {
        return toAjax(tbSchemeService.updateTbScheme(tbScheme));
    }

    /**
     * 删除装机方案
     */
    @PreAuthorize("@ss.hasPermi('store:scheme:remove')")
    @Log(title = "装机方案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schemeIds}")
    public AjaxResult remove(@PathVariable Long[] schemeIds)
    {
        return toAjax(tbSchemeService.deleteTbSchemeBySchemeIds(schemeIds));
    }
}
