package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.CarInfoMapper;
import com.jktb.jiaktb.domain.CarInfo;
import com.jktb.jiaktb.service.ICarInfoService;

/**
 * 车辆信息Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-16
 */
@Service
public class CarInfoServiceImpl implements ICarInfoService 
{
    @Autowired
    private CarInfoMapper carInfoMapper;

    /**
     * 查询车辆信息
     * 
     * @param carInfoId 车辆信息ID
     * @return 车辆信息
     */
    @Override
    public CarInfo selectCarInfoById(Long carInfoId)
    {
        return carInfoMapper.selectCarInfoById(carInfoId);
    }

    /**
     * 查询车辆信息列表
     * 
     * @param carInfo 车辆信息
     * @return 车辆信息
     */
    @Override
    public List<CarInfo> selectCarInfoList(CarInfo carInfo)
    {
        return carInfoMapper.selectCarInfoList(carInfo);
    }

    /**
     * 新增车辆信息
     * 
     * @param carInfo 车辆信息
     * @return 结果
     */
    @Override
    public int insertCarInfo(CarInfo carInfo)
    {
        return carInfoMapper.insertCarInfo(carInfo);
    }

    /**
     * 修改车辆信息
     * 
     * @param carInfo 车辆信息
     * @return 结果
     */
    @Override
    public int updateCarInfo(CarInfo carInfo)
    {
        return carInfoMapper.updateCarInfo(carInfo);
    }

    /**
     * 批量删除车辆信息
     * 
     * @param carInfoIds 需要删除的车辆信息ID
     * @return 结果
     */
    @Override
    public int deleteCarInfoByIds(Long[] carInfoIds)
    {
        return carInfoMapper.deleteCarInfoByIds(carInfoIds);
    }

    /**
     * 删除车辆信息信息
     * 
     * @param carInfoId 车辆信息ID
     * @return 结果
     */
    @Override
    public int deleteCarInfoById(Long carInfoId)
    {
        return carInfoMapper.deleteCarInfoById(carInfoId);
    }
}
