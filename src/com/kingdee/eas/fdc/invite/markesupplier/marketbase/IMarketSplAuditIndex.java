package com.kingdee.eas.fdc.invite.markesupplier.marketbase;

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

public interface IMarketSplAuditIndex extends IDataBase
{
    public MarketSplAuditIndexInfo getMarketSplAuditIndexInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarketSplAuditIndexInfo getMarketSplAuditIndexInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarketSplAuditIndexInfo getMarketSplAuditIndexInfo(String oql) throws BOSException, EASBizException;
    public MarketSplAuditIndexCollection getMarketSplAuditIndexCollection() throws BOSException;
    public MarketSplAuditIndexCollection getMarketSplAuditIndexCollection(EntityViewInfo view) throws BOSException;
    public MarketSplAuditIndexCollection getMarketSplAuditIndexCollection(String oql) throws BOSException;
}