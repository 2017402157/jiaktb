package com.jktb.jiaktb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 成绩对象 achievement
 * 
 * @author jktb
 * @date 2021-03-15
 */
public class Achievement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成绩标识 */
    private Long achievementId;

    /** 学员ID */
    @Excel(name = "学员ID")
    private Long stuInfoId;

    /** 科目名称 */
    @Excel(name = "科目名称")
    private String subName;

    /** 成绩 */
    @Excel(name = "成绩")
    private Long cachievement;

    /** 考试时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 使用状态（1000：及格 1100：不及格） */
    @Excel(name = "使用状态", readConverterExp = "1=000：及格,1=100：不及格")
    private Long status;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setAchievementId(Long achievementId) 
    {
        this.achievementId = achievementId;
    }

    public Long getAchievementId() 
    {
        return achievementId;
    }
    public void setStuInfoId(Long stuInfoId) 
    {
        this.stuInfoId = stuInfoId;
    }

    public Long getStuInfoId() 
    {
        return stuInfoId;
    }
    public void setSubName(String subName) 
    {
        this.subName = subName;
    }

    public String getSubName() 
    {
        return subName;
    }
    public void setCachievement(Long cachievement) 
    {
        this.cachievement = cachievement;
    }

    public Long getCachievement() 
    {
        return cachievement;
    }
    public void setTestTime(Date testTime) 
    {
        this.testTime = testTime;
    }

    public Date getTestTime() 
    {
        return testTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("achievementId", getAchievementId())
            .append("stuInfoId", getStuInfoId())
            .append("subName", getSubName())
            .append("cachievement", getCachievement())
            .append("testTime", getTestTime())
            .append("status", getStatus())
            .append("remarks", getRemarks())
            .toString();
    }
}
