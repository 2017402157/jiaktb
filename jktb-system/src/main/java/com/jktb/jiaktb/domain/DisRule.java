package com.jktb.jiaktb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 优惠配置对象 dis_rule
 * 
 * @author jktb
 * @date 2021-03-15
 */
public class DisRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 优惠配置标识 */
    private Long disRuleId;

    /** 优惠名称 */
    @Excel(name = "优惠名称")
    private String disName;

    /** 活动简介 */
    @Excel(name = "活动简介")
    private String disBrief;

    /** 折扣 */
    @Excel(name = "折扣")
    private Double disRu;

    /** 图片 */
    @Excel(name = "图片")
    private String disPhoto;

    /** 生效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date impDate;

    /** 失效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expDate;

    /** 人数 */
    @Excel(name = "人数")
    private Long userNum;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 状态时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "状态时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statusDate;

    public void setDisRuleId(Long disRuleId) 
    {
        this.disRuleId = disRuleId;
    }

    public Long getDisRuleId() 
    {
        return disRuleId;
    }
    public void setDisName(String disName) 
    {
        this.disName = disName;
    }

    public String getDisName() 
    {
        return disName;
    }
    public void setDisBrief(String disBrief) 
    {
        this.disBrief = disBrief;
    }

    public String getDisBrief() 
    {
        return disBrief;
    }
    public void setDisRu(Double disRu) 
    {
        this.disRu = disRu;
    }

    public Double getDisRu() 
    {
        return disRu;
    }
    public void setDisPhoto(String disPhoto) 
    {
        this.disPhoto = disPhoto;
    }

    public String getDisPhoto() 
    {
        return disPhoto;
    }
    public void setImpDate(Date impDate) 
    {
        this.impDate = impDate;
    }

    public Date getImpDate() 
    {
        return impDate;
    }
    public void setExpDate(Date expDate) 
    {
        this.expDate = expDate;
    }

    public Date getExpDate() 
    {
        return expDate;
    }
    public void setUserNum(Long userNum) 
    {
        this.userNum = userNum;
    }

    public Long getUserNum() 
    {
        return userNum;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setStatusDate(Date statusDate) 
    {
        this.statusDate = statusDate;
    }

    public Date getStatusDate() 
    {
        return statusDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("disRuleId", getDisRuleId())
            .append("disName", getDisName())
            .append("disBrief", getDisBrief())
            .append("disRu", getDisRu())
            .append("disPhoto", getDisPhoto())
            .append("impDate", getImpDate())
            .append("expDate", getExpDate())
            .append("userNum", getUserNum())
            .append("status", getStatus())
            .append("statusDate", getStatusDate())
            .toString();
    }
}
