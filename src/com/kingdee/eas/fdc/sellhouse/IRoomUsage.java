package com.kingdee.eas.fdc.sellhouse;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.fdc.basedata.IFDCDataBase;
import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IRoomUsage extends IFDCDataBase
{
    public RoomUsageInfo getRoomUsageInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RoomUsageInfo getRoomUsageInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RoomUsageInfo getRoomUsageInfo(String oql) throws BOSException, EASBizException;
    public RoomUsageCollection getRoomUsageCollection() throws BOSException;
    public RoomUsageCollection getRoomUsageCollection(EntityViewInfo view) throws BOSException;
    public RoomUsageCollection getRoomUsageCollection(String oql) throws BOSException;
}