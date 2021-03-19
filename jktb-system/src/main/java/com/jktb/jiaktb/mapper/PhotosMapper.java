package com.jktb.jiaktb.mapper;

import java.util.List;
import com.jktb.jiaktb.domain.Photos;

/**
 * 图片信息Mapper接口
 * 
 * @author jktb
 * @date 2021-03-18
 */
public interface PhotosMapper 
{
    /**
     * 查询图片信息
     * 
     * @param photosId 图片信息ID
     * @return 图片信息
     */
    public Photos selectPhotosById(Long photosId);

    List<Photos> selectPhotosByCarInfoId(Long carInfoId);

    /**
     * 查询图片信息列表
     * 
     * @param photos 图片信息
     * @return 图片信息集合
     */
    public List<Photos> selectPhotosList(Photos photos);

    /**
     * 新增图片信息
     * 
     * @param photos 图片信息
     * @return 结果
     */
    public int insertPhotos(Photos photos);

    int batchPhotos(List<Photos> photosList);

    /**
     * 修改图片信息
     * 
     * @param photos 图片信息
     * @return 结果
     */
    public int updatePhotos(Photos photos);

    /**
     * 删除图片信息
     * 
     * @param photosId 图片信息ID
     * @return 结果
     */
    public int deletePhotosById(Long photosId);

    /**
     * 批量删除图片信息
     * 
     * @param photosIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePhotosByIds(Long[] photosIds);
}
