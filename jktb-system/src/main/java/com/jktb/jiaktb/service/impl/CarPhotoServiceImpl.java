package com.jktb.jiaktb.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.jktb.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.jktb.jiaktb.domain.Photos;
import com.jktb.jiaktb.mapper.CarPhotoMapper;
import com.jktb.jiaktb.domain.CarPhoto;
import com.jktb.jiaktb.service.ICarPhotoService;

/**
 * 车辆图片Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-18
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
    public List<CarPhoto> selectCarPhotoById(Long carPhotoId)
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
    @Transactional
    @Override
    public int insertCarPhoto(CarPhoto carPhoto)
    {

        insertPhotos(carPhoto);
        int rows = carPhotoMapper.insertCarPhoto(carPhoto);
        return rows;
    }

    /**
     * 修改车辆图片
     * 
     * @param carPhoto 车辆图片
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCarPhoto(CarPhoto carPhoto)
    {
        carPhotoMapper.deletePhotosByPhotosId(carPhoto.getCarPhotoId());
        insertPhotos(carPhoto);
        return carPhotoMapper.updateCarPhoto(carPhoto);
    }

    /**
     * 批量删除车辆图片
     * 
     * @param carPhotoIds 需要删除的车辆图片ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCarPhotoByIds(Long[] carPhotoIds)
    {
        carPhotoMapper.deletePhotosByPhotosIds(carPhotoIds);
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
        carPhotoMapper.deletePhotosByPhotosId(carPhotoId);
        return carPhotoMapper.deleteCarPhotoById(carPhotoId);
    }

    /**
     * 新增图片信息信息
     * 
     * @param carPhoto 车辆图片对象
     */
    public void insertPhotos(CarPhoto carPhoto)
    {
        List<Photos> photosList = carPhoto.getPhotosList();
        Long carPhotoId = carPhoto.getPhotosId();
        if (StringUtils.isNotNull(photosList))
        {
            List<Photos> list = new ArrayList<Photos>();
            for (Photos photos : photosList)
            {
                photos.setPhotosId(carPhotoId);
                photos.setUpTime(new Date());
                list.add(photos);
            }
            if (list.size() > 0)
            {
                carPhotoMapper.batchPhotos(list);
            }
        }
    }
}
