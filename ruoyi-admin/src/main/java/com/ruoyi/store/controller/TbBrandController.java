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
import com.ruoyi.store.domain.TbBrand;
import com.ruoyi.store.service.ITbBrandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌管理Controller
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@RestController
@RequestMapping("/store/brand")
public class TbBrandController extends BaseController
{
    @Autowired
    private ITbBrandService tbBrandService;

    /**
     * 查询品牌管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbBrand tbBrand)
    {
        startPage();
        List<TbBrand> list = tbBrandService.selectTbBrandList(tbBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:brand:export')")
    @Log(title = "品牌管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbBrand tbBrand)
    {
        List<TbBrand> list = tbBrandService.selectTbBrandList(tbBrand);
        ExcelUtil<TbBrand> util = new ExcelUtil<TbBrand>(TbBrand.class);
        util.exportExcel(response, list, "品牌管理数据");
    }

    /**
     * 获取品牌管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:brand:query')")
    @GetMapping(value = "/{brandId}")
    public AjaxResult getInfo(@PathVariable("brandId") Long brandId)
    {
        return success(tbBrandService.selectTbBrandByBrandId(brandId));
    }

    /**
     * 新增品牌管理
     */
    @PreAuthorize("@ss.hasPermi('store:brand:add')")
    @Log(title = "品牌管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbBrand tbBrand)
    {
        return toAjax(tbBrandService.insertTbBrand(tbBrand));
    }

    /**
     * 修改品牌管理
     */
    @PreAuthorize("@ss.hasPermi('store:brand:edit')")
    @Log(title = "品牌管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbBrand tbBrand)
    {
        return toAjax(tbBrandService.updateTbBrand(tbBrand));
    }

    /**
     * 删除品牌管理
     */
    @PreAuthorize("@ss.hasPermi('store:brand:remove')")
    @Log(title = "品牌管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{brandIds}")
    public AjaxResult remove(@PathVariable Long[] brandIds)
    {
        return toAjax(tbBrandService.deleteTbBrandByBrandIds(brandIds));
    }
}
