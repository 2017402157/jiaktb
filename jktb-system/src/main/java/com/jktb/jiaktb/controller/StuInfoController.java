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
import com.jktb.jiaktb.domain.StuInfo;
import com.jktb.jiaktb.service.IStuInfoService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 学员信息Controller
 * 
 * @author jktb
 * @date 2021-03-15
 */
@RestController
@RequestMapping("/jiaktb/stuinfo")
public class StuInfoController extends BaseController
{
    @Autowired
    private IStuInfoService stuInfoService;

    /**
     * 查询学员信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:stuinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuInfo stuInfo)
    {
        startPage();
        List<StuInfo> list = stuInfoService.selectStuInfoList(stuInfo);
        return getDataTable(list);
    }

    /**
     * 导出学员信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:stuinfo:export')")
    @Log(title = "学员信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(StuInfo stuInfo)
    {
        List<StuInfo> list = stuInfoService.selectStuInfoList(stuInfo);
        ExcelUtil<StuInfo> util = new ExcelUtil<StuInfo>(StuInfo.class);
        return util.exportExcel(list, "stuinfo");
    }

    /**
     * 获取学员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:stuinfo:query')")
    @GetMapping(value = "/{stuInfoId}")
    public AjaxResult getInfo(@PathVariable("stuInfoId") Long stuInfoId)
    {
        return AjaxResult.success(stuInfoService.selectStuInfoById(stuInfoId));
    }

    /**
     * 新增学员信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:stuinfo:add')")
    @Log(title = "学员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuInfo stuInfo)
    {
        return toAjax(stuInfoService.insertStuInfo(stuInfo));
    }

    /**
     * 修改学员信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:stuinfo:edit')")
    @Log(title = "学员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuInfo stuInfo)
    {
        return toAjax(stuInfoService.updateStuInfo(stuInfo));
    }

    /**
     * 删除学员信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:stuinfo:remove')")
    @Log(title = "学员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stuInfoIds}")
    public AjaxResult remove(@PathVariable Long[] stuInfoIds)
    {
        return toAjax(stuInfoService.deleteStuInfoByIds(stuInfoIds));
    }
}
