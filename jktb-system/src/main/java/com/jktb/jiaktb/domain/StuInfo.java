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
 * 学员信息对象 stu_info
 * 
 * @author jktb
 * @date 2021-03-15
 */
public class StuInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学员标识 */
    private Long stuInfoId;

    /** 学员姓名 */
    @Excel(name = "学员姓名")
    private String stuName;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String cardId;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /** 准驾车型 */
    @Excel(name = "准驾车型")
    private Long chCarType;

    /** 申请车型 */
    @Excel(name = "申请车型")
    private Long appCarType;

    /** 右眼视力 */
    @Excel(name = "右眼视力")
    private Double rigthEye;

    /** 左眼视力 */
    @Excel(name = "左眼视力")
    private Double leftEye;

    /** 地址 */
    @Excel(name = "地址")
    private String addr;

    /** 照片 */
    @Excel(name = "照片")
    private String phone;

    /** 状态 */
    @Excel(name = "状态")
    private Long statusCd;

    /** 报名时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报名时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date impDate;

    /** 毕业时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expDate;

    /** 教员编号 */
    @Excel(name = "教员编号")
    private Long coachInfoId;

    /** 所属驾校 */
    @Excel(name = "所属驾校")
    private Long deptId;

    /** 是否是本地户口(1000是，1100否) */
    @Excel(name = "是否是本地户口(1000是，1100否)")
    private Long isLocal;

    /** 暂住证 */
    @Excel(name = "暂住证")
    private String prove;

    /** 身份证正面 */
    @Excel(name = "身份证正面")
    private String zCard;

    /** 身份证反面 */
    @Excel(name = "身份证反面")
    private String fCard;

    /** 所属团体 */
    @Excel(name = "所属团体")
    private Long groupUserId;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String appStatus;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appStatusTime;

    private Long userId;

    private SysUser userList;
    private DriveType driveTypeList;
    private GroupUser groupUserList;
    private SysDept deptList;
    private CoachInfo coachInfoList;

    public void setStuInfoId(Long stuInfoId) 
    {
        this.stuInfoId = stuInfoId;
    }

    public Long getStuInfoId() 
    {
        return stuInfoId;
    }
    public void setStuName(String stuName) 
    {
        this.stuName = stuName;
    }

    public String getStuName() 
    {
        return stuName;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setChCarType(Long chCarType) 
    {
        this.chCarType = chCarType;
    }

    public Long getChCarType() 
    {
        return chCarType;
    }
    public void setAppCarType(Long appCarType) 
    {
        this.appCarType = appCarType;
    }

    public Long getAppCarType() 
    {
        return appCarType;
    }
    public void setRigthEye(Double rigthEye) 
    {
        this.rigthEye = rigthEye;
    }

    public Double getRigthEye() 
    {
        return rigthEye;
    }
    public void setLeftEye(Double leftEye) 
    {
        this.leftEye = leftEye;
    }

    public Double getLeftEye() 
    {
        return leftEye;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setStatusCd(Long statusCd) 
    {
        this.statusCd = statusCd;
    }

    public Long getStatusCd() 
    {
        return statusCd;
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
    public void setCoachInfoId(Long coachInfoId)
    {
        this.coachInfoId = coachInfoId;
    }

    public Long getCoachInfoId()
    {
        return coachInfoId;
    }
    public void setDeptId(String Long)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setIsLocal(Long isLocal) 
    {
        this.isLocal = isLocal;
    }

    public Long getIsLocal() 
    {
        return isLocal;
    }
    public void setProve(String prove) 
    {
        this.prove = prove;
    }

    public String getProve() 
    {
        return prove;
    }
    public void setzCard(String zCard) 
    {
        this.zCard = zCard;
    }

    public String getzCard() 
    {
        return zCard;
    }
    public void setfCard(String fCard) 
    {
        this.fCard = fCard;
    }

    public String getfCard() 
    {
        return fCard;
    }
    public void setGroupUserId(Long groupUserId) 
    {
        this.groupUserId = groupUserId;
    }

    public Long getGroupUserId() 
    {
        return groupUserId;
    }
    public void setAppStatus(String appStatus) 
    {
        this.appStatus = appStatus;
    }

    public String getAppStatus() 
    {
        return appStatus;
    }
    public void setAppStatusTime(Date appStatusTime) 
    {
        this.appStatusTime = appStatusTime;
    }

    public Date getAppStatusTime() 
    {
        return appStatusTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public GroupUser getGroupUserList() {
        return groupUserList;
    }

    public void setGroupUserList(GroupUser groupUserList) {
        this.groupUserList = groupUserList;
    }

    public SysDept getDeptList() {
        return deptList;
    }

    public void setDeptList(SysDept deptList) {
        this.deptList = deptList;
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
            .append("stuInfoId", getStuInfoId())
            .append("stuName", getStuName())
            .append("cardId", getCardId())
            .append("sex", getSex())
            .append("chCarType", getChCarType())
            .append("appCarType", getAppCarType())
            .append("rigthEye", getRigthEye())
            .append("leftEye", getLeftEye())
            .append("addr", getAddr())
            .append("phone", getPhone())
            .append("statusCd", getStatusCd())
            .append("impDate", getImpDate())
            .append("expDate", getExpDate())
            .append("coachInfoId", getCoachInfoId())
            .append("deptId", getDeptId())
            .append("isLocal", getIsLocal())
            .append("prove", getProve())
            .append("zCard", getzCard())
            .append("fCard", getfCard())
            .append("groupUserId", getGroupUserId())
            .append("appStatus", getAppStatus())
            .append("appStatusTime", getAppStatusTime())
            .append("userId", getUserId())
            .toString();
    }
}
