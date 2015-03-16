package com.kingdee.eas.fdc.aimcost;

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

public interface IAimCostProductSplitEntry extends IDataBase
{
    public AimCostProductSplitEntryInfo getAimCostProductSplitEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AimCostProductSplitEntryInfo getAimCostProductSplitEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AimCostProductSplitEntryInfo getAimCostProductSplitEntryInfo(String oql) throws BOSException, EASBizException;
    public AimCostProductSplitEntryCollection getAimCostProductSplitEntryCollection() throws BOSException;
    public AimCostProductSplitEntryCollection getAimCostProductSplitEntryCollection(EntityViewInfo view) throws BOSException;
    public AimCostProductSplitEntryCollection getAimCostProductSplitEntryCollection(String oql) throws BOSException;
}