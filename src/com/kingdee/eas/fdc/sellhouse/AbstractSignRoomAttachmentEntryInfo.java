package com.kingdee.eas.fdc.sellhouse;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignRoomAttachmentEntryInfo extends com.kingdee.eas.fdc.sellhouse.TranRoomAttachmentEntryInfo implements Serializable 
{
    public AbstractSignRoomAttachmentEntryInfo()
    {
        this("id");
    }
    protected AbstractSignRoomAttachmentEntryInfo(String pkField)
    {
        super(pkField);
        put("signAgioEntry", new com.kingdee.eas.fdc.sellhouse.SignAgioEntryCollection());
    }
    /**
     * Object: 签约附属房产信息分录 's 折扣分录 property 
     */
    public com.kingdee.eas.fdc.sellhouse.SignAgioEntryCollection getSignAgioEntry()
    {
        return (com.kingdee.eas.fdc.sellhouse.SignAgioEntryCollection)get("signAgioEntry");
    }
    /**
     * Object: 签约附属房产信息分录 's 签约单id property 
     */
    public com.kingdee.eas.fdc.sellhouse.SignManageInfo getHead()
    {
        return (com.kingdee.eas.fdc.sellhouse.SignManageInfo)get("head");
    }
    public void setHead(com.kingdee.eas.fdc.sellhouse.SignManageInfo item)
    {
        put("head", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DC57247C");
    }
}