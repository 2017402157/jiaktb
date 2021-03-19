package com.jktb.jiaktb.mapper;

import java.util.List;
import com.jktb.jiaktb.domain.CarPhoto;
import com.jktb.jiaktb.domain.Photos;

/**
 * 车辆图片Mapper接口
 * 
 * @author jktb
 * @date 2021-03-18
 */
public interface CarPhotoMapper 
{
    /**
     * 查询车辆图片
     * 
     * @param carInfoId 车辆图片ID
     * @return 车辆图片
     */
    public List<CarPhoto> selectCarPhotoById(Long carInfoId);

    /**
     * 查询车辆图片列表
     * 
     * @param carPhoto 车辆图片
     * @return 车辆图片集合
     */
    public List<CarPhoto> selectCarPhotoList(CarPhoto carPhoto);

    /**
     * 新增车辆图片
     * 
     * @param carPhoto 车辆图片
     * @return 结果
     */
    public int insertCarPhoto(CarPhoto carPhoto);

    /**
     * 修改车辆图片
     * 
     * @param carPhoto 车辆图片
     * @return 结果
     */
    public int updateCarPhoto(CarPhoto carPhoto);

    /**
     * 删除车辆图片
     * 
     * @param carPhotoId 车辆图片ID
     * @return 结果
     */
    public int deleteCarPhotoById(Long carPhotoId);

    int deleteCarPhotoByCarInfoId(Long carInfoId);

    /**
     * 批量删除车辆图片
     * 
     * @param carPhotoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarPhotoByIds(Long[] carPhotoIds);

    /**
     * 批量删除图片信息
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePhotosByPhotosIds(Long[] carPhotoIds);
    
    /**
     * 批量新增图片信息
     * 
     * @param photosList 图片信息列表
     * @return 结果
     */
    public int batchPhotos(List<Photos> photosList);

    public int batchCarPhotos(List<CarPhoto> carPhotoList);
    

    /**
     * 通过车辆图片ID删除图片信息信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deletePhotosByPhotosId(Long carPhotoId);
}
