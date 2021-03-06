package com.kingdee.eas.fdc.finance.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.util.Map;
import com.kingdee.eas.fdc.finance.FDCProDepConPayPlanInfo;
import com.kingdee.eas.fdc.basedata.app.FDCBillController;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.fdc.finance.FDCProDepConPayPlanCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.BOSUuid;
import java.util.List;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FDCProDepConPayPlanController extends FDCBillController
{
    public Map fetchData(Context ctx, Map param) throws BOSException, EASBizException, RemoteException;
    public FDCProDepConPayPlanInfo getFDCProDepConPayPlanInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FDCProDepConPayPlanCollection getFDCProDepConPayPlanCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public Map statisticsPay(Context ctx, Map valuse) throws BOSException, RemoteException;
    public Map getPlanPay(Context ctx, Map value) throws BOSException, RemoteException;
    public void publish(Context ctx, List ids) throws BOSException, EASBizException, RemoteException;
    public void back(Context ctx, List ids) throws BOSException, EASBizException, RemoteException;
    public void setPublish(Context ctx, BOSUuid billid) throws BOSException, EASBizException, RemoteException;
    public void setBack(Context ctx, BOSUuid billid) throws BOSException, EASBizException, RemoteException;
    public void setConPlanBack(Context ctx, String pk) throws BOSException, RemoteException;
}