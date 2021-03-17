package com.jktb.jiaktb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 车辆信息对象 car_info
 * 
 * @author jktb
 * @date 2021-03-16
 */
public class CarInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车辆标识 */
    private Long carInfoId;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private Long carType;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNum;

    /** 录入时间 */
    private Date impDate;

    /** 退出时间 */
    private Date expDate;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 所属教练 */
    @Excel(name = "所属教练")
    private Long coachInfoId;

    /** 状态时间 */
    private Date statusDate;

    /** 购入价格 */
    @Excel(name = "购入价格")
    private String carValue;

    /** 用车总人数 */
    @Excel(name = "用车总人数")
    private Long num;

    private DriveType driveTypeList;

    private CoachInfo coachInfoList;

    public void setCarInfoId(Long carInfoId) 
    {
        this.carInfoId = carInfoId;
    }

    public Long getCarInfoId() 
    {
        return carInfoId;
    }
    public void setCarType(Long carType) 
    {
        this.carType = carType;
    }

    public Long getCarType() 
    {
        return carType;
    }
    public void setCarNum(String carNum) 
    {
        this.carNum = carNum;
    }

    public String getCarNum() 
    {
        return carNum;
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
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setCoachInfoId(Long coachInfoId) 
    {
        this.coachInfoId = coachInfoId;
    }

    public Long getCoachInfoId() 
    {
        return coachInfoId;
    }
    public void setStatusDate(Date statusDate) 
    {
        this.statusDate = statusDate;
    }

    public Date getStatusDate() 
    {
        return statusDate;
    }
    public void setCarValue(String carValue) 
    {
        this.carValue = carValue;
    }

    public String getCarValue() 
    {
        return carValue;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }

    public DriveType getDriveTypeList() {
        return driveTypeList;
    }

    public void setDriveTypeList(DriveType driveTypeList) {
        this.driveTypeList = driveTypeList;
    }

    public CoachInfo getCoachInfoList() {
        return coachInfoList;
    }

    public void setCoachInfoList(CoachInfo coachInfoList) {
        this.coachInfoList = coachInfoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("carInfoId", getCarInfoId())
            .append("carType", getCarType())
            .append("carNum", getCarNum())
            .append("impDate", getImpDate())
            .append("expDate", getExpDate())
            .append("status", getStatus())
            .append("coachInfoId", getCoachInfoId())
            .append("statusDate", getStatusDate())
            .append("carValue", getCarValue())
            .append("num", getNum())
            .toString();
    }
}
