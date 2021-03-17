package com.jktb.jiaktb.service;

import java.util.List;
import com.jktb.jiaktb.domain.DriveType;

/**
 * 驾驶证种类Service接口
 * 
 * @author jktb
 * @date 2021-03-15
 */
public interface IDriveTypeService 
{
    /**
     * 查询驾驶证种类
     * 
     * @param driveTypeId 驾驶证种类ID
     * @return 驾驶证种类
     */
    public DriveType selectDriveTypeById(Long driveTypeId);

    /**
     * 查询驾驶证种类列表
     * 
     * @param driveType 驾驶证种类
     * @return 驾驶证种类集合
     */
    public List<DriveType> selectDriveTypeList(DriveType driveType);

    /**
     * 新增驾驶证种类
     * 
     * @param driveType 驾驶证种类
     * @return 结果
     */
    public int insertDriveType(DriveType driveType);

    /**
     * 修改驾驶证种类
     * 
     * @param driveType 驾驶证种类
     * @return 结果
     */
    public int updateDriveType(DriveType driveType);

    /**
     * 批量删除驾驶证种类
     * 
     * @param driveTypeIds 需要删除的驾驶证种类ID
     * @return 结果
     */
    public int deleteDriveTypeByIds(Long[] driveTypeIds);

    /**
     * 删除驾驶证种类信息
     * 
     * @param driveTypeId 驾驶证种类ID
     * @return 结果
     */
    public int deleteDriveTypeById(Long driveTypeId);
}
