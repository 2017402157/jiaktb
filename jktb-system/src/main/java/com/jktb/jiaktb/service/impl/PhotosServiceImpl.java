package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.PhotosMapper;
import com.jktb.jiaktb.domain.Photos;
import com.jktb.jiaktb.service.IPhotosService;

/**
 * 图片信息Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-18
 */
@Service
public class PhotosServiceImpl implements IPhotosService 
{
    @Autowired
    private PhotosMapper photosMapper;

    /**
     * 查询图片信息
     * 
     * @param photosId 图片信息ID
     * @return 图片信息
     */
    @Override
    public Photos selectPhotosById(Long photosId)
    {
        return photosMapper.selectPhotosById(photosId);
    }

    /**
     * 查询图片信息列表
     * 
     * @param photos 图片信息
     * @return 图片信息
     */
    @Override
    public List<Photos> selectPhotosList(Photos photos)
    {
        return photosMapper.selectPhotosList(photos);
    }

    /**
     * 新增图片信息
     * 
     * @param photos 图片信息
     * @return 结果
     */
    @Override
    public int insertPhotos(Photos photos)
    {
        return photosMapper.insertPhotos(photos);
    }

    /**
     * 修改图片信息
     * 
     * @param photos 图片信息
     * @return 结果
     */
    @Override
    public int updatePhotos(Photos photos)
    {
        return photosMapper.updatePhotos(photos);
    }

    /**
     * 批量删除图片信息
     * 
     * @param photosIds 需要删除的图片信息ID
     * @return 结果
     */
    @Override
    public int deletePhotosByIds(Long[] photosIds)
    {
        return photosMapper.deletePhotosByIds(photosIds);
    }

    /**
     * 删除图片信息信息
     * 
     * @param photosId 图片信息ID
     * @return 结果
     */
    @Override
    public int deletePhotosById(Long photosId)
    {
        return photosMapper.deletePhotosById(photosId);
    }
}
