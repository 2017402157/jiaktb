package com.jktb.jiaktb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jktb.common.core.domain.entity.SysDept;
import com.jktb.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 教练信息对象 coach_info
 * 
 * @author jktb
 * @date 2021-03-16
 */
public class CoachInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教练标识 */
    private Long coachInfoId;

    /** 教练姓名 */
    @Excel(name = "教练姓名")
    private String chName;

    /** 教练年龄 */
    @Excel(name = "教练年龄")
    private Long chAge;

    /** 教练性别（1男，0女） */
    @Excel(name = "教练性别", readConverterExp = "1=男，0女")
    private Long chSex;

    /** 评分 */
    private Double chEvaluate;

    /** 使用状态 */
    @Excel(name = "使用状态")
    private Long status;

    /** 状态时间 */
    private Date statusDate;

    /** 准驾车型 */
    @Excel(name = "准驾车型")
    private Long chCarType;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 薪水 */
    @Excel(name = "薪水")
    private String salary;

    /** 入职时间 */
    private Date impDate;

    /** 离职时间 */
    private Date expDate;

    /** 身份证号码 */
    private String cardId;

    /** 所属驾校 */
    private Long deptId;

    /** 用户id */
    private Long userId;

    private SysDept deptList;

    private SysUser userList;

    private DriveType driveTypeList;

    public void setCoachInfoId(Long coachInfoId) 
    {
        this.coachInfoId = coachInfoId;
    }

    public Long getCoachInfoId() 
    {
        return coachInfoId;
    }
    public void setChName(String chName) 
    {
        this.chName = chName;
    }

    public String getChName() 
    {
        return chName;
    }
    public void setChAge(Long chAge) 
    {
        this.chAge = chAge;
    }

    public Long getChAge() 
    {
        return chAge;
    }
    public void setChSex(Long chSex) 
    {
        this.chSex = chSex;
    }

    public Long getChSex() 
    {
        return chSex;
    }
    public void setChEvaluate(Double chEvaluate) 
    {
        this.chEvaluate = chEvaluate;
    }

    public Double getChEvaluate() 
    {
        return chEvaluate;
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
    public void setChCarType(Long chCarType) 
    {
        this.chCarType = chCarType;
    }

    public Long getChCarType() 
    {
        return chCarType;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSalary(String salary) 
    {
        this.salary = salary;
    }

    public String getSalary() 
    {
        return salary;
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
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public SysDept getDeptList() {
        return deptList;
    }

    public void setDeptList(SysDept deptList) {
        this.deptList = deptList;
    }

    public SysUser getUserList() {
        return userList;
    }

    public void setUserList(SysUser userList) {
        this.userList = userList;
    }

    public DriveType getDriveTypeList() {
        return driveTypeList;
    }

    public void setDriveTypeList(DriveType driveTypeList) {
        this.driveTypeList = driveTypeList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("coachInfoId", getCoachInfoId())
            .append("chName", getChName())
            .append("chAge", getChAge())
            .append("chSex", getChSex())
            .append("chEvaluate", getChEvaluate())
            .append("status", getStatus())
            .append("statusDate", getStatusDate())
            .append("chCarType", getChCarType())
            .append("phone", getPhone())
            .append("salary", getSalary())
            .append("impDate", getImpDate())
            .append("expDate", getExpDate())
            .append("cardId", getCardId())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
