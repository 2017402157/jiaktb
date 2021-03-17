package com.jktb.jiaktb.mapper;

import java.util.List;
import com.jktb.jiaktb.domain.GroupUser;

/**
 * 团体信息Mapper接口
 * 
 * @author jktb
 * @date 2021-03-17
 */
public interface GroupUserMapper 
{
    /**
     * 查询团体信息
     * 
     * @param groupUserId 团体信息ID
     * @return 团体信息
     */
    public GroupUser selectGroupUserById(Long groupUserId);

    /**
     * 查询团体信息列表
     * 
     * @param groupUser 团体信息
     * @return 团体信息集合
     */
    public List<GroupUser> selectGroupUserList(GroupUser groupUser);

    /**
     * 新增团体信息
     * 
     * @param groupUser 团体信息
     * @return 结果
     */
    public int insertGroupUser(GroupUser groupUser);

    /**
     * 修改团体信息
     * 
     * @param groupUser 团体信息
     * @return 结果
     */
    public int updateGroupUser(GroupUser groupUser);

    /**
     * 删除团体信息
     * 
     * @param groupUserId 团体信息ID
     * @return 结果
     */
    public int deleteGroupUserById(Long groupUserId);

    /**
     * 批量删除团体信息
     * 
     * @param groupUserIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGroupUserByIds(Long[] groupUserIds);
}
