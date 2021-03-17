package com.jktb.jiaktb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 团体信息对象 group_user
 * 
 * @author jktb
 * @date 2021-03-17
 */
public class GroupUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 团体标识 */
    private Long groupUserId;

    /** 团体名称 */
    @Excel(name = "团体名称")
    private String groupName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date initDate;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effDate;

    public void setGroupUserId(Long groupUserId) 
    {
        this.groupUserId = groupUserId;
    }

    public Long getGroupUserId() 
    {
        return groupUserId;
    }
    public void setGroupName(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() 
    {
        return groupName;
    }
    public void setInitDate(Date initDate) 
    {
        this.initDate = initDate;
    }

    public Date getInitDate() 
    {
        return initDate;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setEffDate(Date effDate) 
    {
        this.effDate = effDate;
    }

    public Date getEffDate() 
    {
        return effDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("groupUserId", getGroupUserId())
            .append("groupName", getGroupName())
            .append("initDate", getInitDate())
            .append("status", getStatus())
            .append("effDate", getEffDate())
            .toString();
    }
}
