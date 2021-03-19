package com.jktb.jiaktb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 图片信息对象 photos
 * 
 * @author jktb
 * @date 2021-03-18
 */
public class Photos extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片标识 */
    private Long photosId;

    /** 图片标题 */
    @Excel(name = "图片标题")
    private String photosTitle;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String photosUri;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date upTime;

    public void setPhotosId(Long photosId) 
    {
        this.photosId = photosId;
    }

    public Long getPhotosId() 
    {
        return photosId;
    }
    public void setPhotosTitle(String photosTitle) 
    {
        this.photosTitle = photosTitle;
    }

    public String getPhotosTitle() 
    {
        return photosTitle;
    }
    public void setPhotosUri(String photosUri) 
    {
        this.photosUri = photosUri;
    }

    public String getPhotosUri() 
    {
        return photosUri;
    }
    public void setUpTime(Date upTime) 
    {
        this.upTime = upTime;
    }

    public Date getUpTime() 
    {
        return upTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("photosId", getPhotosId())
            .append("photosTitle", getPhotosTitle())
            .append("photosUri", getPhotosUri())
            .append("upTime", getUpTime())
            .toString();
    }
}
