package com.kingdee.eas.fdc.market;

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
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBillBase;

public interface ISellSupplyPlan extends ICoreBillBase
{
    public SellSupplyPlanCollection getSellSupplyPlanCollection() throws BOSException;
    public SellSupplyPlanCollection getSellSupplyPlanCollection(EntityViewInfo view) throws BOSException;
    public SellSupplyPlanCollection getSellSupplyPlanCollection(String oql) throws BOSException;
    public SellSupplyPlanInfo getSellSupplyPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SellSupplyPlanInfo getSellSupplyPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SellSupplyPlanInfo getSellSupplyPlanInfo(String oql) throws BOSException, EASBizException;
}