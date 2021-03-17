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
import com.jktb.jiaktb.domain.DisRule;
import com.jktb.jiaktb.service.IDisRuleService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 优惠配置Controller
 * 
 * @author jktb
 * @date 2021-03-15
 */
@RestController
@RequestMapping("/jiaktb/rule")
public class DisRuleController extends BaseController
{
    @Autowired
    private IDisRuleService disRuleService;

    /**
     * 查询优惠配置列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:rule:list')")
    @GetMapping("/list")
    public TableDataInfo list(DisRule disRule)
    {
        startPage();
        List<DisRule> list = disRuleService.selectDisRuleList(disRule);
        return getDataTable(list);
    }

    /**
     * 导出优惠配置列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:rule:export')")
    @Log(title = "优惠配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DisRule disRule)
    {
        List<DisRule> list = disRuleService.selectDisRuleList(disRule);
        ExcelUtil<DisRule> util = new ExcelUtil<DisRule>(DisRule.class);
        return util.exportExcel(list, "rule");
    }

    /**
     * 获取优惠配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:rule:query')")
    @GetMapping(value = "/{disRuleId}")
    public AjaxResult getInfo(@PathVariable("disRuleId") Long disRuleId)
    {
        return AjaxResult.success(disRuleService.selectDisRuleById(disRuleId));
    }

    /**
     * 新增优惠配置
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:rule:add')")
    @Log(title = "优惠配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DisRule disRule)
    {
        return toAjax(disRuleService.insertDisRule(disRule));
    }

    /**
     * 修改优惠配置
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:rule:edit')")
    @Log(title = "优惠配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DisRule disRule)
    {
        return toAjax(disRuleService.updateDisRule(disRule));
    }

    /**
     * 删除优惠配置
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:rule:remove')")
    @Log(title = "优惠配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{disRuleIds}")
    public AjaxResult remove(@PathVariable Long[] disRuleIds)
    {
        return toAjax(disRuleService.deleteDisRuleByIds(disRuleIds));
    }
}
