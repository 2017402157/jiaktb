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
import com.jktb.jiaktb.domain.GroupUser;
import com.jktb.jiaktb.service.IGroupUserService;
import com.jktb.common.utils.poi.ExcelUtil;
import com.jktb.common.core.page.TableDataInfo;

/**
 * 团体信息Controller
 * 
 * @author jktb
 * @date 2021-03-17
 */
@RestController
@RequestMapping("/jiaktb/groupuser")
public class GroupUserController extends BaseController
{
    @Autowired
    private IGroupUserService groupUserService;

    /**
     * 查询团体信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:groupuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(GroupUser groupUser)
    {
        startPage();
        List<GroupUser> list = groupUserService.selectGroupUserList(groupUser);
        return getDataTable(list);
    }

    /**
     * 导出团体信息列表
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:groupuser:export')")
    @Log(title = "团体信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(GroupUser groupUser)
    {
        List<GroupUser> list = groupUserService.selectGroupUserList(groupUser);
        ExcelUtil<GroupUser> util = new ExcelUtil<GroupUser>(GroupUser.class);
        return util.exportExcel(list, "groupuser");
    }

    /**
     * 获取团体信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:groupuser:query')")
    @GetMapping(value = "/{groupUserId}")
    public AjaxResult getInfo(@PathVariable("groupUserId") Long groupUserId)
    {
        return AjaxResult.success(groupUserService.selectGroupUserById(groupUserId));
    }

    /**
     * 新增团体信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:groupuser:add')")
    @Log(title = "团体信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GroupUser groupUser)
    {
        return toAjax(groupUserService.insertGroupUser(groupUser));
    }

    /**
     * 修改团体信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:groupuser:edit')")
    @Log(title = "团体信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GroupUser groupUser)
    {
        return toAjax(groupUserService.updateGroupUser(groupUser));
    }

    /**
     * 删除团体信息
     */
    @PreAuthorize("@ss.hasPermi('jiaktb:groupuser:remove')")
    @Log(title = "团体信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groupUserIds}")
    public AjaxResult remove(@PathVariable Long[] groupUserIds)
    {
        return toAjax(groupUserService.deleteGroupUserByIds(groupUserIds));
    }
}
