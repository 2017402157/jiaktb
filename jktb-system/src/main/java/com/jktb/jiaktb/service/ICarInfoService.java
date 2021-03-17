package com.jktb.jiaktb.service;

import java.util.List;
import com.jktb.jiaktb.domain.CarInfo;

/**
 * 车辆信息Service接口
 * 
 * @author jktb
 * @date 2021-03-16
 */
public interface ICarInfoService 
{
    /**
     * 查询车辆信息
     * 
     * @param carInfoId 车辆信息ID
     * @return 车辆信息
     */
    public CarInfo selectCarInfoById(Long carInfoId);

    /**
     * 查询车辆信息列表
     * 
     * @param carInfo 车辆信息
     * @return 车辆信息集合
     */
    public List<CarInfo> selectCarInfoList(CarInfo carInfo);

    /**
     * 新增车辆信息
     * 
     * @param carInfo 车辆信息
     * @return 结果
     */
    public int insertCarInfo(CarInfo carInfo);

    /**
     * 修改车辆信息
     * 
     * @param carInfo 车辆信息
     * @return 结果
     */
    public int updateCarInfo(CarInfo carInfo);

    /**
     * 批量删除车辆信息
     * 
     * @param carInfoIds 需要删除的车辆信息ID
     * @return 结果
     */
    public int deleteCarInfoByIds(Long[] carInfoIds);

    /**
     * 删除车辆信息信息
     * 
     * @param carInfoId 车辆信息ID
     * @return 结果
     */
    public int deleteCarInfoById(Long carInfoId);
}
