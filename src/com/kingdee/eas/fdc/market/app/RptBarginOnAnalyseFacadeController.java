package com.kingdee.eas.fdc.market.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.bireport.app.BireportBaseFacadeController;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface RptBarginOnAnalyseFacadeController extends BireportBaseFacadeController
{
    public String getPurchaseQuerySql(Context ctx) throws BOSException, RemoteException;
}