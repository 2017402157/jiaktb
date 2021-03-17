package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.AchievementMapper;
import com.jktb.jiaktb.domain.Achievement;
import com.jktb.jiaktb.service.IAchievementService;

/**
 * 成绩Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-15
 */
@Service
public class AchievementServiceImpl implements IAchievementService 
{
    @Autowired
    private AchievementMapper achievementMapper;

    /**
     * 查询成绩
     * 
     * @param achievementId 成绩ID
     * @return 成绩
     */
    @Override
    public Achievement selectAchievementById(Long achievementId)
    {
        return achievementMapper.selectAchievementById(achievementId);
    }

    /**
     * 查询成绩列表
     * 
     * @param achievement 成绩
     * @return 成绩
     */
    @Override
    public List<Achievement> selectAchievementList(Achievement achievement)
    {
        return achievementMapper.selectAchievementList(achievement);
    }

    /**
     * 新增成绩
     * 
     * @param achievement 成绩
     * @return 结果
     */
    @Override
    public int insertAchievement(Achievement achievement)
    {
        return achievementMapper.insertAchievement(achievement);
    }

    /**
     * 修改成绩
     * 
     * @param achievement 成绩
     * @return 结果
     */
    @Override
    public int updateAchievement(Achievement achievement)
    {
        return achievementMapper.updateAchievement(achievement);
    }

    /**
     * 批量删除成绩
     * 
     * @param achievementIds 需要删除的成绩ID
     * @return 结果
     */
    @Override
    public int deleteAchievementByIds(Long[] achievementIds)
    {
        return achievementMapper.deleteAchievementByIds(achievementIds);
    }

    /**
     * 删除成绩信息
     * 
     * @param achievementId 成绩ID
     * @return 结果
     */
    @Override
    public int deleteAchievementById(Long achievementId)
    {
        return achievementMapper.deleteAchievementById(achievementId);
    }
}
