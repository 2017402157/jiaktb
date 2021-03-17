package com.jktb.jiaktb.controller;

import java.util.List;
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
import com.jktb.common.annotation.Log;
import com.jktb.common.core.controller.BaseController;
import com.jktb.common.core.domain.AjaxResult;
import com.jktb.common.enums.BusinessType;
import com.jktb.jiaktb.domain.Cost;
import com.jktb.jiaktb.service.ICostService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 学费明细Controller
 * 
 * @author jktb
 * @date 2021-03-15
 */
@RestController
@RequestMapping("/jiaktb/cost")
public class CostController extends BaseController
{
    @Autowired
    private ICostService costService;

    /**
     * 查询学费明细列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:cost:list')")
    @GetMapping("/list")
    public TableDataInfo list(Cost cost)
    {
        startPage();
        List<Cost> list = costService.selectCostList(cost);
        return getDataTable(list);
    }

    /**
     * 导出学费明细列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:cost:export')")
    @Log(title = "学费明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Cost cost)
    {
        List<Cost> list = costService.selectCostList(cost);
        ExcelUtil<Cost> util = new ExcelUtil<Cost>(Cost.class);
        return util.exportExcel(list, "cost");
    }

    /**
     * 获取学费明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:cost:query')")
    @GetMapping(value = "/{costId}")
    public AjaxResult getInfo(@PathVariable("costId") Long costId)
    {
        return AjaxResult.success(costService.selectCostById(costId));
    }

    /**
     * 新增学费明细
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:cost:add')")
    @Log(title = "学费明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Cost cost)
    {
        return toAjax(costService.insertCost(cost));
    }

    /**
     * 修改学费明细
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:cost:edit')")
    @Log(title = "学费明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Cost cost)
    {
        return toAjax(costService.updateCost(cost));
    }

    /**
     * 删除学费明细
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:cost:remove')")
    @Log(title = "学费明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{costIds}")
    public AjaxResult remove(@PathVariable Long[] costIds)
    {
        return toAjax(costService.deleteCostByIds(costIds));
    }
}
