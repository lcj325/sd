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

public interface IRoomModelType extends IFDCDataBase
{
    public RoomModelTypeInfo getRoomModelTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RoomModelTypeInfo getRoomModelTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RoomModelTypeInfo getRoomModelTypeInfo(String oql) throws BOSException, EASBizException;
    public RoomModelTypeCollection getRoomModelTypeCollection() throws BOSException;
    public RoomModelTypeCollection getRoomModelTypeCollection(EntityViewInfo view) throws BOSException;
    public RoomModelTypeCollection getRoomModelTypeCollection(String oql) throws BOSException;
}