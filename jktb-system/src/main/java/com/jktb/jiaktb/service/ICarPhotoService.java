package com.jktb.jiaktb.service;

import java.util.List;
import com.jktb.jiaktb.domain.CarPhoto;
import com.jktb.jiaktb.domain.Photos;

/**
 * 车辆图片Service接口
 * 
 * @author jktb
 * @date 2021-03-18
 */
public interface ICarPhotoService 
{
    /**
     * 查询车辆图片
     * 
     * @param carPhotoId 车辆图片ID
     * @return 车辆图片
     */
    public List<CarPhoto> selectCarPhotoById(Long carPhotoId);

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
     * 批量删除车辆图片
     * 
     * @param carPhotoIds 需要删除的车辆图片ID
     * @return 结果
     */
    public int deleteCarPhotoByIds(Long[] carPhotoIds);

    /**
     * 删除车辆图片信息
     * 
     * @param carPhotoId 车辆图片ID
     * @return 结果
     */
    public int deleteCarPhotoById(Long carPhotoId);
}
