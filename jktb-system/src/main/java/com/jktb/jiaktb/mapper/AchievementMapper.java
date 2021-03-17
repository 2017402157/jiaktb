package com.jktb.jiaktb.mapper;

import java.util.List;
import com.jktb.jiaktb.domain.Achievement;

/**
 * 成绩Mapper接口
 * 
 * @author jktb
 * @date 2021-03-15
 */
public interface AchievementMapper 
{
    /**
     * 查询成绩
     * 
     * @param achievementId 成绩ID
     * @return 成绩
     */
    public Achievement selectAchievementById(Long achievementId);

    /**
     * 查询成绩列表
     * 
     * @param achievement 成绩
     * @return 成绩集合
     */
    public List<Achievement> selectAchievementList(Achievement achievement);

    /**
     * 新增成绩
     * 
     * @param achievement 成绩
     * @return 结果
     */
    public int insertAchievement(Achievement achievement);

    /**
     * 修改成绩
     * 
     * @param achievement 成绩
     * @return 结果
     */
    public int updateAchievement(Achievement achievement);

    /**
     * 删除成绩
     * 
     * @param achievementId 成绩ID
     * @return 结果
     */
    public int deleteAchievementById(Long achievementId);

    /**
     * 批量删除成绩
     * 
     * @param achievementIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAchievementByIds(Long[] achievementIds);
}
