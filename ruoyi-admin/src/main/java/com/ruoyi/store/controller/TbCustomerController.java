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
import com.ruoyi.store.domain.TbCustomer;
import com.ruoyi.store.service.ITbCustomerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户管理Controller
 * 
 * @author ruoyi
 * @date 2024-02-13
 */
@RestController
@RequestMapping("/store/customer")
public class TbCustomerController extends BaseController
{
    @Autowired
    private ITbCustomerService tbCustomerService;

    /**
     * 查询用户管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbCustomer tbCustomer)
    {
        startPage();
        List<TbCustomer> list = tbCustomerService.selectTbCustomerList(tbCustomer);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @PreAuthorize("@ss.hasPermi('store:customer:export')")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbCustomer tbCustomer)
    {
        List<TbCustomer> list = tbCustomerService.selectTbCustomerList(tbCustomer);
        ExcelUtil<TbCustomer> util = new ExcelUtil<TbCustomer>(TbCustomer.class);
        util.exportExcel(response, list, "用户管理数据");
    }

    /**
     * 获取用户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:customer:query')")
    @GetMapping(value = "/{customerId}")
    public AjaxResult getInfo(@PathVariable("customerId") Long customerId)
    {
        return success(tbCustomerService.selectTbCustomerByCustomerId(customerId));
    }

    /**
     * 新增用户管理
     */
    @PreAuthorize("@ss.hasPermi('store:customer:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbCustomer tbCustomer)
    {
        return toAjax(tbCustomerService.insertTbCustomer(tbCustomer));
    }

    /**
     * 修改用户管理
     */
    @PreAuthorize("@ss.hasPermi('store:customer:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbCustomer tbCustomer)
    {
        return toAjax(tbCustomerService.updateTbCustomer(tbCustomer));
    }

    /**
     * 删除用户管理
     */
    @PreAuthorize("@ss.hasPermi('store:customer:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{customerIds}")
    public AjaxResult remove(@PathVariable Long[] customerIds)
    {
        return toAjax(tbCustomerService.deleteTbCustomerByCustomerIds(customerIds));
    }
}
