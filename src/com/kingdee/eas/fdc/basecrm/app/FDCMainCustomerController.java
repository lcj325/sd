package com.kingdee.eas.fdc.basecrm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.fdc.basecrm.FDCMainCustomerCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.fdc.basecrm.FDCMainCustomerInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FDCMainCustomerController extends FDCBaseCustomerController
{
    public FDCMainCustomerInfo getFDCMainCustomerInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FDCMainCustomerInfo getFDCMainCustomerInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FDCMainCustomerInfo getFDCMainCustomerInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FDCMainCustomerCollection getFDCMainCustomerCollection(Context ctx) throws BOSException, RemoteException;
    public FDCMainCustomerCollection getFDCMainCustomerCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FDCMainCustomerCollection getFDCMainCustomerCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void addToSysCustomer(Context ctx, FDCMainCustomerInfo mainCus) throws BOSException, EASBizException, RemoteException;
}