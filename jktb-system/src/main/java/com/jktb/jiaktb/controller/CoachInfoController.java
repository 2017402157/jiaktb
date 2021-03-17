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
import com.jktb.jiaktb.domain.CoachInfo;
import com.jktb.jiaktb.service.ICoachInfoService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 教练信息Controller
 * 
 * @author jktb
 * @date 2021-03-16
 */
@RestController
@RequestMapping("/jiaktb/coachinfo")
public class CoachInfoController extends BaseController
{
    @Autowired
    private ICoachInfoService coachInfoService;

    /**
     * 查询教练信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:coachinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CoachInfo coachInfo)
    {
        startPage();
        List<CoachInfo> list = coachInfoService.selectCoachInfoList(coachInfo);
        return getDataTable(list);
    }

    /**
     * 导出教练信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:coachinfo:export')")
    @Log(title = "教练信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CoachInfo coachInfo)
    {
        List<CoachInfo> list = coachInfoService.selectCoachInfoList(coachInfo);
        ExcelUtil<CoachInfo> util = new ExcelUtil<CoachInfo>(CoachInfo.class);
        return util.exportExcel(list, "coachinfo");
    }

    /**
     * 获取教练信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:coachinfo:query')")
    @GetMapping(value = "/{coachInfoId}")
    public AjaxResult getInfo(@PathVariable("coachInfoId") Long coachInfoId)
    {
        return AjaxResult.success(coachInfoService.selectCoachInfoById(coachInfoId));
    }

    /**
     * 新增教练信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:coachinfo:add')")
    @Log(title = "教练信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoachInfo coachInfo)
    {
        return toAjax(coachInfoService.insertCoachInfo(coachInfo));
    }

    /**
     * 修改教练信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:coachinfo:edit')")
    @Log(title = "教练信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoachInfo coachInfo)
    {
        return toAjax(coachInfoService.updateCoachInfo(coachInfo));
    }

    /**
     * 删除教练信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:coachinfo:remove')")
    @Log(title = "教练信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{coachInfoIds}")
    public AjaxResult remove(@PathVariable Long[] coachInfoIds)
    {
        return toAjax(coachInfoService.deleteCoachInfoByIds(coachInfoIds));
    }
}
