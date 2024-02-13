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
import com.ruoyi.store.domain.TbGood;
import com.ruoyi.store.service.ITbGoodService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品管理Controller
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@RestController
@RequestMapping("/store/good")
public class TbGoodController extends BaseController
{
    @Autowired
    private ITbGoodService tbGoodService;

    /**
     * 查询商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:good:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbGood tbGood)
    {
        startPage();
        List<TbGood> list = tbGoodService.selectTbGoodList(tbGood);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:good:export')")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbGood tbGood)
    {
        List<TbGood> list = tbGoodService.selectTbGoodList(tbGood);
        ExcelUtil<TbGood> util = new ExcelUtil<TbGood>(TbGood.class);
        util.exportExcel(response, list, "商品管理数据");
    }

    /**
     * 获取商品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:good:query')")
    @GetMapping(value = "/{goodId}")
    public AjaxResult getInfo(@PathVariable("goodId") Long goodId)
    {
        return success(tbGoodService.selectTbGoodByGoodId(goodId));
    }

    /**
     * 新增商品管理
     */
    @PreAuthorize("@ss.hasPermi('store:good:add')")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbGood tbGood)
    {
        return toAjax(tbGoodService.insertTbGood(tbGood));
    }

    /**
     * 修改商品管理
     */
    @PreAuthorize("@ss.hasPermi('store:good:edit')")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbGood tbGood)
    {
        return toAjax(tbGoodService.updateTbGood(tbGood));
    }

    /**
     * 删除商品管理
     */
    @PreAuthorize("@ss.hasPermi('store:good:remove')")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodIds}")
    public AjaxResult remove(@PathVariable Long[] goodIds)
    {
        return toAjax(tbGoodService.deleteTbGoodByGoodIds(goodIds));
    }
}
