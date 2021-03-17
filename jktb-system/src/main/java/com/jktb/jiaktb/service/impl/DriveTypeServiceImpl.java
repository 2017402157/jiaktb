package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.DriveTypeMapper;
import com.jktb.jiaktb.domain.DriveType;
import com.jktb.jiaktb.service.IDriveTypeService;

/**
 * 驾驶证种类Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-15
 */
@Service
public class DriveTypeServiceImpl implements IDriveTypeService 
{
    @Autowired
    private DriveTypeMapper driveTypeMapper;

    /**
     * 查询驾驶证种类
     * 
     * @param driveTypeId 驾驶证种类ID
     * @return 驾驶证种类
     */
    @Override
    public DriveType selectDriveTypeById(Long driveTypeId)
    {
        return driveTypeMapper.selectDriveTypeById(driveTypeId);
    }

    /**
     * 查询驾驶证种类列表
     * 
     * @param driveType 驾驶证种类
     * @return 驾驶证种类
     */
    @Override
    public List<DriveType> selectDriveTypeList(DriveType driveType)
    {
        return driveTypeMapper.selectDriveTypeList(driveType);
    }

    /**
     * 新增驾驶证种类
     * 
     * @param driveType 驾驶证种类
     * @return 结果
     */
    @Override
    public int insertDriveType(DriveType driveType)
    {
        return driveTypeMapper.insertDriveType(driveType);
    }

    /**
     * 修改驾驶证种类
     * 
     * @param driveType 驾驶证种类
     * @return 结果
     */
    @Override
    public int updateDriveType(DriveType driveType)
    {
        return driveTypeMapper.updateDriveType(driveType);
    }

    /**
     * 批量删除驾驶证种类
     * 
     * @param driveTypeIds 需要删除的驾驶证种类ID
     * @return 结果
     */
    @Override
    public int deleteDriveTypeByIds(Long[] driveTypeIds)
    {
        return driveTypeMapper.deleteDriveTypeByIds(driveTypeIds);
    }

    /**
     * 删除驾驶证种类信息
     * 
     * @param driveTypeId 驾驶证种类ID
     * @return 结果
     */
    @Override
    public int deleteDriveTypeById(Long driveTypeId)
    {
        return driveTypeMapper.deleteDriveTypeById(driveTypeId);
    }
}
