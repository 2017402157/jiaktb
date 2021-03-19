package com.jktb.jiaktb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jktb.common.utils.StringUtils;
import com.jktb.common.utils.uuid.IdUtils;
import com.jktb.jiaktb.domain.CarPhoto;
import com.jktb.jiaktb.domain.Photos;
import com.jktb.jiaktb.mapper.CarPhotoMapper;
import com.jktb.jiaktb.mapper.PhotosMapper;
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
    @Autowired
    private CarPhotoMapper carPhotoMapper;
    @Autowired
    private PhotosMapper photosMapper;

    /**
     * 查询车辆信息
     * 
     * @param carInfoId 车辆信息ID
     * @return 车辆信息
     */
    @Override
    public CarInfo selectCarInfoById(Long carInfoId)
    {

        CarInfo carInfo = carInfoMapper.selectCarInfoById(carInfoId);
        List<Photos> photosList = photosMapper.selectPhotosByCarInfoId(carInfoId);
        if (photosList.size() > 0) {
            carInfo.setPhotosList(photosList);
        }
        return carInfo;
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
        int rows = carInfoMapper.insertCarInfo(carInfo);
        List<Photos> photosList = carInfo.getPhotosList();
        for (Photos photos : photosList) {
            photos.setPhotosId(IdUtils.getID());
        }
        photosMapper.batchPhotos(photosList);
        insertCarPhoto(carInfo);
        return rows;
    }


    private void insertCarPhoto(CarInfo carInfo) {
        List<Photos> photosList = carInfo.getPhotosList();
        if (photosList.size() > 0) {
            List<CarPhoto> carPhotoList = new ArrayList<>();
            for (Photos photo : photosList) {
                CarPhoto carPhoto = new CarPhoto();
                carPhoto.setPhotosId(photo.getPhotosId());
                carPhoto.setCarInfoId(carInfo.getCarInfoId());
                carPhotoList.add(carPhoto);
            }
            if (carPhotoList.size() >0 ) {
                carPhotoMapper.batchCarPhotos(carPhotoList);
            }
        }
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
        List<CarPhoto> carPhotoList = carPhotoMapper.selectCarPhotoById(carInfo.getCarInfoId());
        if (carPhotoList.size() > 0) {
            for (CarPhoto photoId : carPhotoList) {
                photosMapper.deletePhotosById(photoId.getPhotosId());
            }
        }
        if (!"".equals(carInfo.getCarInfoId()) && carInfo.getCarInfoId() != null) {
            carPhotoMapper.deleteCarPhotoByCarInfoId(carInfo.getCarInfoId());
        }
        List<Photos> photosList = carInfo.getPhotosList();
        for (Photos photos : photosList) {
            Long id = IdUtils.getID();
            photos.setPhotosId(id);
        }
        photosMapper.batchPhotos(photosList);
        insertCarPhoto(carInfo);
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
        for (Long carInfoId : carInfoIds) {
            List<CarPhoto> carPhotoList = carPhotoMapper.selectCarPhotoById(carInfoId);
            carPhotoMapper.deleteCarPhotoByCarInfoId(carInfoId);
            if (carPhotoList.size() > 0) {
                for (CarPhoto photoId : carPhotoList) {
                    photosMapper.deletePhotosById(photoId.getPhotosId());
                }
            }
        }
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
        List<CarPhoto> carPhotoList = carPhotoMapper.selectCarPhotoById(carInfoId);
        carPhotoMapper.deleteCarPhotoByCarInfoId(carInfoId);
        if (carPhotoList.size() > 0) {
            for (CarPhoto photoId : carPhotoList) {
                photosMapper.deletePhotosById(photoId.getPhotosId());
            }
        }
        return carInfoMapper.deleteCarInfoById(carInfoId);
    }
}
