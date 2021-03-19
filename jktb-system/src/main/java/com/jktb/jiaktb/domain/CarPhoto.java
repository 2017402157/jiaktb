package com.jktb.jiaktb.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 车辆图片对象 car_photo
 * 
 * @author jktb
 * @date 2021-03-18
 */
public class CarPhoto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片标识 */
    private Long carPhotoId;

    /** 图片标题 */
    @Excel(name = "图片标题")
    private Long carInfoId;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private Long photosId;

    /** 图片信息信息 */
    private List<Photos> photosList;

    public void setCarPhotoId(Long carPhotoId) 
    {
        this.carPhotoId = carPhotoId;
    }

    public Long getCarPhotoId() 
    {
        return carPhotoId;
    }
    public void setCarInfoId(Long carInfoId) 
    {
        this.carInfoId = carInfoId;
    }

    public Long getCarInfoId() 
    {
        return carInfoId;
    }
    public void setPhotosId(Long photosId) 
    {
        this.photosId = photosId;
    }

    public Long getPhotosId() 
    {
        return photosId;
    }

    public List<Photos> getPhotosList()
    {
        return photosList;
    }

    public void setPhotosList(List<Photos> photosList)
    {
        this.photosList = photosList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("carPhotoId", getCarPhotoId())
            .append("carInfoId", getCarInfoId())
            .append("photosId", getPhotosId())
            .append("photosList", getPhotosList())
            .toString();
    }
}
