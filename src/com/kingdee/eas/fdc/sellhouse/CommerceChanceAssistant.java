package com.kingdee.eas.fdc.sellhouse;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.eas.fdc.basedata.IFDCDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.sellhouse.app.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.basedata.FDCDataBase;

public class CommerceChanceAssistant extends FDCDataBase implements ICommerceChanceAssistant
{
    public CommerceChanceAssistant()
    {
        super();
        registerInterface(ICommerceChanceAssistant.class, this);
    }
    public CommerceChanceAssistant(Context ctx)
    {
        super(ctx);
        registerInterface(ICommerceChanceAssistant.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9CBC4874");
    }
    private CommerceChanceAssistantController getController() throws BOSException
    {
        return (CommerceChanceAssistantController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param oql oql
     *@return
     */
    public CommerceChanceAssistantInfo getCommerceChanceAssistantInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCommerceChanceAssistantInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@param selector selector
     *@return
     */
    public CommerceChanceAssistantInfo getCommerceChanceAssistantInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCommerceChanceAssistantInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public CommerceChanceAssistantInfo getCommerceChanceAssistantInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCommerceChanceAssistantInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public CommerceChanceAssistantCollection getCommerceChanceAssistantCollection() throws BOSException
    {
        try {
            return getController().getCommerceChanceAssistantCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param view view
     *@return
     */
    public CommerceChanceAssistantCollection getCommerceChanceAssistantCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCommerceChanceAssistantCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param oql oql
     *@return
     */
    public CommerceChanceAssistantCollection getCommerceChanceAssistantCollection(String oql) throws BOSException
    {
        try {
            return getController().getCommerceChanceAssistantCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}