package com.kingdee.eas.fdc.tenancy;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IAttachRentAdjustEntrys extends IDataBase
{
    public AttachRentAdjustEntrysInfo getAttachRentAdjustEntrysInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AttachRentAdjustEntrysInfo getAttachRentAdjustEntrysInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AttachRentAdjustEntrysInfo getAttachRentAdjustEntrysInfo(String oql) throws BOSException, EASBizException;
    public AttachRentAdjustEntrysCollection getAttachRentAdjustEntrysCollection() throws BOSException;
    public AttachRentAdjustEntrysCollection getAttachRentAdjustEntrysCollection(EntityViewInfo view) throws BOSException;
    public AttachRentAdjustEntrysCollection getAttachRentAdjustEntrysCollection(String oql) throws BOSException;
}