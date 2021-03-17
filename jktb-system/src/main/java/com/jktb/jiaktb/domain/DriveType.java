package com.jktb.jiaktb.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 驾驶证种类对象 drive_type
 * 
 * @author jktb
 * @date 2021-03-16
 */
public class DriveType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 驾照类型标识 */
    private Long driveTypeId;

    /** 驾照类型名称 */
    @Excel(name = "驾照类型名称")
    private String driverName;

    /** 驾照类型编码 */
    @Excel(name = "驾照类型编码")
    private String driverCode;

    /** 驾照类型简介 */
    @Excel(name = "驾照类型简介")
    private String driverDes;

    public void setDriveTypeId(Long driveTypeId) 
    {
        this.driveTypeId = driveTypeId;
    }

    public Long getDriveTypeId() 
    {
        return driveTypeId;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setDriverCode(String driverCode) 
    {
        this.driverCode = driverCode;
    }

    public String getDriverCode() 
    {
        return driverCode;
    }
    public void setDriverDes(String driverDes) 
    {
        this.driverDes = driverDes;
    }

    public String getDriverDes() 
    {
        return driverDes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("driveTypeId", getDriveTypeId())
            .append("driverName", getDriverName())
            .append("driverCode", getDriverCode())
            .append("driverDes", getDriverDes())
            .toString();
    }
}
