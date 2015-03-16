package com.kingdee.eas.fdc.invite;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInquiryResultEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInquiryResultEntryInfo()
    {
        this("id");
    }
    protected AbstractInquiryResultEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.fdc.invite.InquiryResultInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.InquiryResultInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.InquiryResultInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 编码 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("09436832");
    }
}