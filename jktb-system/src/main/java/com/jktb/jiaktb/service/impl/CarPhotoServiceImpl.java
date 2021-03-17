package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.CarPhotoMapper;
import com.jktb.jiaktb.domain.CarPhoto;
import com.jktb.jiaktb.service.ICarPhotoService;

/**
 * 车辆图片Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-15
 */
@Service
public class CarPhotoServiceImpl implements ICarPhotoService 
{
    @Autowired
    private CarPhotoMapper carPhotoMapper;

    /**
     * 查询车辆图片
     * 
     * @param carPhotoId 车辆图片ID
     * @return 车辆图片
     */
    @Override
    public CarPhoto selectCarPhotoById(Long carPhotoId)
    {
        return carPhotoMapper.selectCarPhotoById(carPhotoId);
    }

    /**
     * 查询车辆图片列表
     * 
     * @param carPhoto 车辆图片
     * @return 车辆图片
     */
    @Override
    public List<CarPhoto> selectCarPhotoList(CarPhoto carPhoto)
    {
        return carPhotoMapper.selectCarPhotoList(carPhoto);
    }

    /**
     * 新增车辆图片
     * 
     * @param carPhoto 车辆图片
     * @return 结果
     */
    @Override
    public int insertCarPhoto(CarPhoto carPhoto)
    {
        return carPhotoMapper.insertCarPhoto(carPhoto);
    }

    /**
     * 修改车辆图片
     * 
     * @param carPhoto 车辆图片
     * @return 结果
     */
    @Override
    public int updateCarPhoto(CarPhoto carPhoto)
    {
        return carPhotoMapper.updateCarPhoto(carPhoto);
    }

    /**
     * 批量删除车辆图片
     * 
     * @param carPhotoIds 需要删除的车辆图片ID
     * @return 结果
     */
    @Override
    public int deleteCarPhotoByIds(Long[] carPhotoIds)
    {
        return carPhotoMapper.deleteCarPhotoByIds(carPhotoIds);
    }

    /**
     * 删除车辆图片信息
     * 
     * @param carPhotoId 车辆图片ID
     * @return 结果
     */
    @Override
    public int deleteCarPhotoById(Long carPhotoId)
    {
        return carPhotoMapper.deleteCarPhotoById(carPhotoId);
    }
}
