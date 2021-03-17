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
import com.jktb.jiaktb.domain.DriveType;
import com.jktb.jiaktb.service.IDriveTypeService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 驾驶证种类Controller
 * 
 * @author jktb
 * @date 2021-03-15
 */
@RestController
@RequestMapping("/jiaktb/type")
public class DriveTypeController extends BaseController
{
    @Autowired
    private IDriveTypeService driveTypeService;

    /**
     * 查询驾驶证种类列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(DriveType driveType)
    {
        startPage();
        List<DriveType> list = driveTypeService.selectDriveTypeList(driveType);
        return getDataTable(list);
    }

    /**
     * 导出驾驶证种类列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:type:export')")
    @Log(title = "驾驶证种类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DriveType driveType)
    {
        List<DriveType> list = driveTypeService.selectDriveTypeList(driveType);
        ExcelUtil<DriveType> util = new ExcelUtil<DriveType>(DriveType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 获取驾驶证种类详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:type:query')")
    @GetMapping(value = "/{driveTypeId}")
    public AjaxResult getInfo(@PathVariable("driveTypeId") Long driveTypeId)
    {
        return AjaxResult.success(driveTypeService.selectDriveTypeById(driveTypeId));
    }

    /**
     * 新增驾驶证种类
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:type:add')")
    @Log(title = "驾驶证种类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DriveType driveType)
    {
        return toAjax(driveTypeService.insertDriveType(driveType));
    }

    /**
     * 修改驾驶证种类
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:type:edit')")
    @Log(title = "驾驶证种类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DriveType driveType)
    {
        return toAjax(driveTypeService.updateDriveType(driveType));
    }

    /**
     * 删除驾驶证种类
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:type:remove')")
    @Log(title = "驾驶证种类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{driveTypeIds}")
    public AjaxResult remove(@PathVariable Long[] driveTypeIds)
    {
        return toAjax(driveTypeService.deleteDriveTypeByIds(driveTypeIds));
    }
}
