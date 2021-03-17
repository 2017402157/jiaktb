package com.jktb.jiaktb.mapper;

import java.util.List;
import com.jktb.jiaktb.domain.StuInfo;

/**
 * 学员信息Mapper接口
 * 
 * @author jktb
 * @date 2021-03-15
 */
public interface StuInfoMapper 
{
    /**
     * 查询学员信息
     * 
     * @param stuInfoId 学员信息ID
     * @return 学员信息
     */
    public StuInfo selectStuInfoById(Long stuInfoId);

    /**
     * 查询学员信息列表
     * 
     * @param stuInfo 学员信息
     * @return 学员信息集合
     */
    public List<StuInfo> selectStuInfoList(StuInfo stuInfo);

    /**
     * 新增学员信息
     * 
     * @param stuInfo 学员信息
     * @return 结果
     */
    public int insertStuInfo(StuInfo stuInfo);

    /**
     * 修改学员信息
     * 
     * @param stuInfo 学员信息
     * @return 结果
     */
    public int updateStuInfo(StuInfo stuInfo);

    /**
     * 删除学员信息
     * 
     * @param stuInfoId 学员信息ID
     * @return 结果
     */
    public int deleteStuInfoById(Long stuInfoId);

    /**
     * 批量删除学员信息
     * 
     * @param stuInfoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteStuInfoByIds(Long[] stuInfoIds);
}
