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
import com.jktb.jiaktb.domain.Photos;
import com.jktb.jiaktb.service.IPhotosService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 图片信息Controller
 * 
 * @author jktb
 * @date 2021-03-18
 */
@RestController
@RequestMapping("/jiaktb/photos")
public class PhotosController extends BaseController
{
    @Autowired
    private IPhotosService photosService;

    /**
     * 查询图片信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:photos:list')")
    @GetMapping("/list")
    public TableDataInfo list(Photos photos)
    {
        startPage();
        List<Photos> list = photosService.selectPhotosList(photos);
        return getDataTable(list);
    }

    /**
     * 导出图片信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:photos:export')")
    @Log(title = "图片信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Photos photos)
    {
        List<Photos> list = photosService.selectPhotosList(photos);
        ExcelUtil<Photos> util = new ExcelUtil<Photos>(Photos.class);
        return util.exportExcel(list, "photos");
    }

    /**
     * 获取图片信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:photos:query')")
    @GetMapping(value = "/{photosId}")
    public AjaxResult getInfo(@PathVariable("photosId") Long photosId)
    {
        return AjaxResult.success(photosService.selectPhotosById(photosId));
    }

    /**
     * 新增图片信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:photos:add')")
    @Log(title = "图片信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Photos photos)
    {
        return toAjax(photosService.insertPhotos(photos));
    }

    /**
     * 修改图片信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:photos:edit')")
    @Log(title = "图片信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Photos photos)
    {
        return toAjax(photosService.updatePhotos(photos));
    }

    /**
     * 删除图片信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:photos:remove')")
    @Log(title = "图片信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{photosIds}")
    public AjaxResult remove(@PathVariable Long[] photosIds)
    {
        return toAjax(photosService.deletePhotosByIds(photosIds));
    }
}
