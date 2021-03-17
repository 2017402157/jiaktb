package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.CoachInfoMapper;
import com.jktb.jiaktb.domain.CoachInfo;
import com.jktb.jiaktb.service.ICoachInfoService;

/**
 * 教练信息Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-16
 */
@Service
public class CoachInfoServiceImpl implements ICoachInfoService 
{
    @Autowired
    private CoachInfoMapper coachInfoMapper;

    /**
     * 查询教练信息
     * 
     * @param coachInfoId 教练信息ID
     * @return 教练信息
     */
    @Override
    public CoachInfo selectCoachInfoById(Long coachInfoId)
    {
        return coachInfoMapper.selectCoachInfoById(coachInfoId);
    }

    /**
     * 查询教练信息列表
     * 
     * @param coachInfo 教练信息
     * @return 教练信息
     */
    @Override
    public List<CoachInfo> selectCoachInfoList(CoachInfo coachInfo)
    {
        return coachInfoMapper.selectCoachInfoList(coachInfo);
    }

    /**
     * 新增教练信息
     * 
     * @param coachInfo 教练信息
     * @return 结果
     */
    @Override
    public int insertCoachInfo(CoachInfo coachInfo)
    {
        return coachInfoMapper.insertCoachInfo(coachInfo);
    }

    /**
     * 修改教练信息
     * 
     * @param coachInfo 教练信息
     * @return 结果
     */
    @Override
    public int updateCoachInfo(CoachInfo coachInfo)
    {
        return coachInfoMapper.updateCoachInfo(coachInfo);
    }

    /**
     * 批量删除教练信息
     * 
     * @param coachInfoIds 需要删除的教练信息ID
     * @return 结果
     */
    @Override
    public int deleteCoachInfoByIds(Long[] coachInfoIds)
    {
        return coachInfoMapper.deleteCoachInfoByIds(coachInfoIds);
    }

    /**
     * 删除教练信息信息
     * 
     * @param coachInfoId 教练信息ID
     * @return 结果
     */
    @Override
    public int deleteCoachInfoById(Long coachInfoId)
    {
        return coachInfoMapper.deleteCoachInfoById(coachInfoId);
    }
}
