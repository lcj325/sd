package com.kingdee.eas.fdc.market;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.market.app.*;
import com.kingdee.eas.framework.ICoreBillBase;

public class SellSupplyPlan extends CoreBillBase implements ISellSupplyPlan
{
    public SellSupplyPlan()
    {
        super();
        registerInterface(ISellSupplyPlan.class, this);
    }
    public SellSupplyPlan(Context ctx)
    {
        super(ctx);
        registerInterface(ISellSupplyPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("66ED29BB");
    }
    private SellSupplyPlanController getController() throws BOSException
    {
        return (SellSupplyPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SellSupplyPlanCollection getSellSupplyPlanCollection() throws BOSException
    {
        try {
            return getController().getSellSupplyPlanCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public SellSupplyPlanCollection getSellSupplyPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSellSupplyPlanCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public SellSupplyPlanCollection getSellSupplyPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getSellSupplyPlanCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SellSupplyPlanInfo getSellSupplyPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSellSupplyPlanInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public SellSupplyPlanInfo getSellSupplyPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSellSupplyPlanInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public SellSupplyPlanInfo getSellSupplyPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSellSupplyPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}