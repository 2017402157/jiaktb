package com.jktb.jiaktb.mapper;

import java.util.List;
import com.jktb.jiaktb.domain.CoachInfo;

/**
 * 教练信息Mapper接口
 * 
 * @author jktb
 * @date 2021-03-16
 */
public interface CoachInfoMapper 
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
     * 删除教练信息
     * 
     * @param coachInfoId 教练信息ID
     * @return 结果
     */
    public int deleteCoachInfoById(Long coachInfoId);

    /**
     * 批量删除教练信息
     * 
     * @param coachInfoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCoachInfoByIds(Long[] coachInfoIds);
}
