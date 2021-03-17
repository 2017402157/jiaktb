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
import com.jktb.jiaktb.domain.CarPhoto;
import com.jktb.jiaktb.service.ICarPhotoService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 车辆图片Controller
 * 
 * @author jktb
 * @date 2021-03-15
 */
@RestController
@RequestMapping("/jiaktb/carphoto")
public class CarPhotoController extends BaseController
{
    @Autowired
    private ICarPhotoService carPhotoService;

    /**
     * 查询车辆图片列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carphoto:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarPhoto carPhoto)
    {
        startPage();
        List<CarPhoto> list = carPhotoService.selectCarPhotoList(carPhoto);
        return getDataTable(list);
    }

    /**
     * 导出车辆图片列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carphoto:export')")
    @Log(title = "车辆图片", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarPhoto carPhoto)
    {
        List<CarPhoto> list = carPhotoService.selectCarPhotoList(carPhoto);
        ExcelUtil<CarPhoto> util = new ExcelUtil<CarPhoto>(CarPhoto.class);
        return util.exportExcel(list, "carphoto");
    }

    /**
     * 获取车辆图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carphoto:query')")
    @GetMapping(value = "/{carPhotoId}")
    public AjaxResult getInfo(@PathVariable("carPhotoId") Long carPhotoId)
    {
        return AjaxResult.success(carPhotoService.selectCarPhotoById(carPhotoId));
    }

    /**
     * 新增车辆图片
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carphoto:add')")
    @Log(title = "车辆图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarPhoto carPhoto)
    {
        return toAjax(carPhotoService.insertCarPhoto(carPhoto));
    }

    /**
     * 修改车辆图片
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carphoto:edit')")
    @Log(title = "车辆图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarPhoto carPhoto)
    {
        return toAjax(carPhotoService.updateCarPhoto(carPhoto));
    }

    /**
     * 删除车辆图片
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:carphoto:remove')")
    @Log(title = "车辆图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{carPhotoIds}")
    public AjaxResult remove(@PathVariable Long[] carPhotoIds)
    {
        return toAjax(carPhotoService.deleteCarPhotoByIds(carPhotoIds));
    }
}
