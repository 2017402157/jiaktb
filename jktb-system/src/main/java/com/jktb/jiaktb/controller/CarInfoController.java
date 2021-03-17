package com.jktb.jiaktb.controller;

import java.util.Date;
import java.util.List;

import com.jktb.jiaktb.service.ICoachInfoService;
import com.jktb.jiaktb.service.IDriveTypeService;
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
import com.jktb.jiaktb.domain.CarInfo;
import com.jktb.jiaktb.service.ICarInfoService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 车辆信息Controller
 * 
 * @author jktb
 * @date 2021-03-16
 */
@RestController
@RequestMapping("/jiaktb/carinfo")
public class CarInfoController extends BaseController
{
    @Autowired
    private ICarInfoService carInfoService;
    @Autowired
    private IDriveTypeService driveTypeService;
    @Autowired
    private ICoachInfoService coachInfoService;

    /**
     * 查询车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarInfo carInfo)
    {
        startPage();
        List<CarInfo> list = carInfoService.selectCarInfoList(carInfo);
        for (CarInfo data : list) {
            data.setDriveTypeList(driveTypeService.selectDriveTypeById(data.getCarType()));
            data.setCoachInfoList(coachInfoService.selectCoachInfoById(data.getCoachInfoId()));
        }
        return getDataTable(list);
    }

    /**
     * 导出车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carinfo:export')")
    @Log(title = "车辆信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarInfo carInfo)
    {
        List<CarInfo> list = carInfoService.selectCarInfoList(carInfo);
        ExcelUtil<CarInfo> util = new ExcelUtil<CarInfo>(CarInfo.class);
        return util.exportExcel(list, "carinfo");
    }

    /**
     * 获取车辆信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carinfo:query')")
    @GetMapping(value = "/{carInfoId}")
    public AjaxResult getInfo(@PathVariable("carInfoId") Long carInfoId)
    {
        return AjaxResult.success(carInfoService.selectCarInfoById(carInfoId));
    }

    /**
     * 新增车辆信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carinfo:add')")
    @Log(title = "车辆信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarInfo carInfo)
    {
        return toAjax(carInfoService.insertCarInfo(carInfo));
    }

    /**
     * 修改车辆信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carinfo:edit')")
    @Log(title = "车辆信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarInfo carInfo)
    {
        if (carInfo.getStatus() == 102) {
            carInfo.setStatusDate(new Date());
        }
        return toAjax(carInfoService.updateCarInfo(carInfo));
    }

    /**
     * 删除车辆信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carinfo:remove')")
    @Log(title = "车辆信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{carInfoIds}")
    public AjaxResult remove(@PathVariable Long[] carInfoIds)
    {
        return toAjax(carInfoService.deleteCarInfoByIds(carInfoIds));
    }
}
