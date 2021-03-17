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
import com.jktb.jiaktb.domain.Achievement;
import com.jktb.jiaktb.service.IAchievementService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 成绩Controller
 * 
 * @author jktb
 * @date 2021-03-15
 */
@RestController
@RequestMapping("/jiaktb/achievement")
public class AchievementController extends BaseController
{
    @Autowired
    private IAchievementService achievementService;

    /**
     * 查询成绩列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:achievement:list')")
    @GetMapping("/list")
    public TableDataInfo list(Achievement achievement)
    {
        startPage();
        List<Achievement> list = achievementService.selectAchievementList(achievement);
        return getDataTable(list);
    }

    /**
     * 导出成绩列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:achievement:export')")
    @Log(title = "成绩", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Achievement achievement)
    {
        List<Achievement> list = achievementService.selectAchievementList(achievement);
        ExcelUtil<Achievement> util = new ExcelUtil<Achievement>(Achievement.class);
        return util.exportExcel(list, "achievement");
    }

    /**
     * 获取成绩详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:achievement:query')")
    @GetMapping(value = "/{achievementId}")
    public AjaxResult getInfo(@PathVariable("achievementId") Long achievementId)
    {
        return AjaxResult.success(achievementService.selectAchievementById(achievementId));
    }

    /**
     * 新增成绩
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:achievement:add')")
    @Log(title = "成绩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Achievement achievement)
    {
        return toAjax(achievementService.insertAchievement(achievement));
    }

    /**
     * 修改成绩
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:achievement:edit')")
    @Log(title = "成绩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Achievement achievement)
    {
        return toAjax(achievementService.updateAchievement(achievement));
    }

    /**
     * 删除成绩
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:achievement:remove')")
    @Log(title = "成绩", businessType = BusinessType.DELETE)
	@DeleteMapping("/{achievementIds}")
    public AjaxResult remove(@PathVariable Long[] achievementIds)
    {
        return toAjax(achievementService.deleteAchievementByIds(achievementIds));
    }
}
