package com.kingdee.eas.fdc.finance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjectYearPlanDateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProjectYearPlanDateEntryInfo()
    {
        this("id");
    }
    protected AbstractProjectYearPlanDateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:项目年度付款规划明细分录's 月份property 
     */
    public int getMonth()
    {
        return getInt("month");
    }
    public void setMonth(int item)
    {
        setInt("month", item);
    }
    /**
     * Object:项目年度付款规划明细分录's 年份property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object: 项目年度付款规划明细分录 's 预算项目 property 
     */
    public com.kingdee.eas.ma.budget.BgItemInfo getBgItem()
    {
        return (com.kingdee.eas.ma.budget.BgItemInfo)get("bgItem");
    }
    public void setBgItem(com.kingdee.eas.ma.budget.BgItemInfo item)
    {
        put("bgItem", item);
    }
    /**
     * Object:项目年度付款规划明细分录's 计划支付property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:项目年度付款规划明细分录's 实际支付property 
     */
    public java.math.BigDecimal getActAmount()
    {
        return getBigDecimal("actAmount");
    }
    public void setActAmount(java.math.BigDecimal item)
    {
        setBigDecimal("actAmount", item);
    }
    /**
     * Object: 项目年度付款规划明细分录 's 项目年度付款计划分录 property 
     */
    public com.kingdee.eas.fdc.finance.ProjectYearPlanEntryInfo getHeadEntry()
    {
        return (com.kingdee.eas.fdc.finance.ProjectYearPlanEntryInfo)get("headEntry");
    }
    public void setHeadEntry(com.kingdee.eas.fdc.finance.ProjectYearPlanEntryInfo item)
    {
        put("headEntry", item);
    }
    /**
     * Object:项目年度付款规划明细分录's 用款说明property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3974FCF4");
    }
}