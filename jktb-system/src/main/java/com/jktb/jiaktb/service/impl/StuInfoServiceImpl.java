package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.StuInfoMapper;
import com.jktb.jiaktb.domain.StuInfo;
import com.jktb.jiaktb.service.IStuInfoService;

/**
 * 学员信息Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-15
 */
@Service
public class StuInfoServiceImpl implements IStuInfoService 
{
    @Autowired
    private StuInfoMapper stuInfoMapper;

    /**
     * 查询学员信息
     * 
     * @param stuInfoId 学员信息ID
     * @return 学员信息
     */
    @Override
    public StuInfo selectStuInfoById(Long stuInfoId)
    {
        return stuInfoMapper.selectStuInfoById(stuInfoId);
    }

    /**
     * 查询学员信息列表
     * 
     * @param stuInfo 学员信息
     * @return 学员信息
     */
    @Override
    public List<StuInfo> selectStuInfoList(StuInfo stuInfo)
    {
        return stuInfoMapper.selectStuInfoList(stuInfo);
    }

    /**
     * 新增学员信息
     * 
     * @param stuInfo 学员信息
     * @return 结果
     */
    @Override
    public int insertStuInfo(StuInfo stuInfo)
    {
        return stuInfoMapper.insertStuInfo(stuInfo);
    }

    /**
     * 修改学员信息
     * 
     * @param stuInfo 学员信息
     * @return 结果
     */
    @Override
    public int updateStuInfo(StuInfo stuInfo)
    {
        return stuInfoMapper.updateStuInfo(stuInfo);
    }

    /**
     * 批量删除学员信息
     * 
     * @param stuInfoIds 需要删除的学员信息ID
     * @return 结果
     */
    @Override
    public int deleteStuInfoByIds(Long[] stuInfoIds)
    {
        return stuInfoMapper.deleteStuInfoByIds(stuInfoIds);
    }

    /**
     * 删除学员信息信息
     * 
     * @param stuInfoId 学员信息ID
     * @return 结果
     */
    @Override
    public int deleteStuInfoById(Long stuInfoId)
    {
        return stuInfoMapper.deleteStuInfoById(stuInfoId);
    }
}
