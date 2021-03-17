package com.jktb.jiaktb.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jktb.common.annotation.Excel;
import com.jktb.common.core.domain.BaseEntity;

/**
 * 学费明细对象 cost
 * 
 * @author jktb
 * @date 2021-03-15
 */
public class Cost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成绩标识 */
    private Long costId;

    /** 学员ID */
    @Excel(name = "学员ID")
    private Long carInfoId;

    /** 科目名称 */
    @Excel(name = "科目名称")
    private String costName;

    /** 费用 */
    @Excel(name = "费用")
    private Long costNum;

    /** 优惠标识 */
    @Excel(name = "优惠标识")
    private Long discount;

    /** 优惠后费用 */
    @Excel(name = "优惠后费用")
    private Long feeCostNum;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setCostId(Long costId) 
    {
        this.costId = costId;
    }

    public Long getCostId() 
    {
        return costId;
    }
    public void setCarInfoId(Long carInfoId) 
    {
        this.carInfoId = carInfoId;
    }

    public Long getCarInfoId() 
    {
        return carInfoId;
    }
    public void setCostName(String costName) 
    {
        this.costName = costName;
    }

    public String getCostName() 
    {
        return costName;
    }
    public void setCostNum(Long costNum) 
    {
        this.costNum = costNum;
    }

    public Long getCostNum() 
    {
        return costNum;
    }
    public void setDiscount(Long discount) 
    {
        this.discount = discount;
    }

    public Long getDiscount() 
    {
        return discount;
    }
    public void setFeeCostNum(Long feeCostNum) 
    {
        this.feeCostNum = feeCostNum;
    }

    public Long getFeeCostNum() 
    {
        return feeCostNum;
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
            .append("costId", getCostId())
            .append("carInfoId", getCarInfoId())
            .append("costName", getCostName())
            .append("costNum", getCostNum())
            .append("discount", getDiscount())
            .append("feeCostNum", getFeeCostNum())
            .append("remarks", getRemarks())
            .toString();
    }
}
