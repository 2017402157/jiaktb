package com.jktb.jiaktb.service;

import java.util.List;
import com.jktb.jiaktb.domain.CoachInfo;

/**
 * 教练信息Service接口
 * 
 * @author jktb
 * @date 2021-03-16
 */
public interface ICoachInfoService 
{
    /**
     * 查询教练信息
     * 
     * @param coachInfoId 教练信息ID
     * @return 教练信息
     */
    public CoachInfo selectCoachInfoById(Long coachInfoId);

    /**
     * 查询教练信息列表
     * 
     * @param coachInfo 教练信息
     * @return 教练信息集合
     */
    public List<CoachInfo> selectCoachInfoList(CoachInfo coachInfo);

    /**
     * 新增教练信息
     * 
     * @param coachInfo 教练信息
     * @return 结果
     */
    public int insertCoachInfo(CoachInfo coachInfo);

    /**
     * 修改教练信息
     * 
     * @param coachInfo 教练信息
     * @return 结果
     */
    public int updateCoachInfo(CoachInfo coachInfo);

    /**
     * 批量删除教练信息
     * 
     * @param coachInfoIds 需要删除的教练信息ID
     * @return 结果
     */
    public int deleteCoachInfoByIds(Long[] coachInfoIds);

    /**
     * 删除教练信息信息
     * 
     * @param coachInfoId 教练信息ID
     * @return 结果
     */
    public int deleteCoachInfoById(Long coachInfoId);
}
