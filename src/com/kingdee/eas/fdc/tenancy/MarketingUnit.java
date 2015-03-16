package com.kingdee.eas.fdc.tenancy;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import java.util.Set;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.fdc.tenancy.app.*;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.base.permission.UserInfo;
import java.util.ArrayList;
import com.kingdee.eas.framework.TreeBase;

public class MarketingUnit extends TreeBase implements IMarketingUnit
{
    public MarketingUnit()
    {
        super();
        registerInterface(IMarketingUnit.class, this);
    }
    public MarketingUnit(Context ctx)
    {
        super(ctx);
        registerInterface(IMarketingUnit.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1C059DC1");
    }
    private MarketingUnitController getController() throws BOSException
    {
        return (MarketingUnitController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk pk
     *@return
     */
    public MarketingUnitInfo getMarketingUnitInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarketingUnitInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk pk
     *@param selector selector
     *@return
     */
    public MarketingUnitInfo getMarketingUnitInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarketingUnitInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql oql
     *@return
     */
    public MarketingUnitInfo getMarketingUnitInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarketingUnitInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public MarketingUnitCollection getMarketingUnitCollection() throws BOSException
    {
        try {
            return getController().getMarketingUnitCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view view
     *@return
     */
    public MarketingUnitCollection getMarketingUnitCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarketingUnitCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql oql
     *@return
     */
    public MarketingUnitCollection getMarketingUnitCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarketingUnitCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ָ��������Ա�ܹ��鿴�����г�Ա�ļ��� �����Լ�����Ϊ������������ĳ�Ա���Լ�����Ӫ����Ԫ��������Ӫ����Ԫ�е�������Ա-User defined method
     *@param currSaleMan ָ����Ӫ����Ա
     *@return
     */
    public Set getPermitSaleManIdSet(UserInfo currSaleMan) throws BOSException, EASBizException
    {
        try {
            return getController().getPermitSaleManIdSet(getContext(), currSaleMan);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����鿴������ԱIdSql-User defined method
     *@param currSaleMan Ӫ������
     *@return
     */
    public String getPermitSaleManIdSql(UserInfo currSaleMan) throws BOSException, EASBizException
    {
        try {
            return getController().getPermitSaleManIdSql(getContext(), currSaleMan);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ָ��Ӫ����Ա���ܿ�������Ŀ����-User defined method
     *@param saleMan ָ����Ӫ����Ա
     *@return
     */
    public Set getPermitSellProjectIdSet(UserInfo saleMan) throws BOSException, EASBizException
    {
        try {
            return getController().getPermitSellProjectIdSet(getContext(), saleMan);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��������������ĿIdSql-User defined method
     *@param currSaleMan Ӫ������
     *@return
     */
    public String getPermitSellProjectIdSql(UserInfo currSaleMan) throws BOSException, EASBizException
    {
        try {
            return getController().getPermitSellProjectIdSql(getContext(), currSaleMan);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������������鿴�Ŀͻ�Id�Ĳ�ѯSQL(�����Ƿ��������)-User defined method
     *@param saleMan Ӫ����Ա
     *@param isInCludeDisEnable �Ƿ������Ч�Ŀͻ�
     *@return
     */
    public String getPermitFdcCustomerIdSql(UserInfo saleMan, boolean isInCludeDisEnable) throws BOSException, EASBizException
    {
        try {
            return getController().getPermitFdcCustomerIdSql(getContext(), saleMan, isInCludeDisEnable);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������������鿴�Ŀͻ�Id�Ĳ�ѯSQL(�����Ƿ��������)-User defined method
     *@param saleMan Ӫ����Ա
     *@param isInCludeDisEnable �Ƿ������Ч�Ŀͻ�
     *@param isIncludeShared �Ƿ���������Ŀͻ�
     *@return
     */
    public String getPermitFdcCustomerIdSql(UserInfo saleMan, boolean isInCludeDisEnable, boolean isIncludeShared) throws BOSException, EASBizException
    {
        try {
            return getController().getPermitFdcCustomerIdSql(getContext(), saleMan, isInCludeDisEnable, isIncludeShared);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ͻ���Χ���Լ���Ȩ�޲鿴�ģ����ұ��������ƥ�� (���Ʋ���Ϊ�գ��绰����Ϊ��)-User defined method
     *@param saleMan Ӫ������
     *@param customerName ָ���Ŀͻ�����,����Ϊ��
     *@param customerPhone ָ���Ŀͻ��绰���룬����Ϊ��(��like��ʽ�Ƚϣ����Ϊ����������е�)
     *@return
     */
    public Set getCustomerIdSetByNameAndPhone(UserInfo saleMan, String customerName, String customerPhone) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerIdSetByNameAndPhone(getContext(), saleMan, customerName, customerPhone);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��Ϊ���������ڵ�Ӫ����Ԫ����-User defined method
     *@param saleMan ָ����Ӫ����Ա
     *@return
     */
    public MarketingUnitCollection getMarketUnitCollByDutySaleMan(UserInfo saleMan) throws BOSException, EASBizException
    {
        try {
            return getController().getMarketUnitCollByDutySaleMan(getContext(), saleMan);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��Ϊ��Ա�����ڵ�Ӫ����Ԫ����-User defined method
     *@param saleMan ָ���ĵ�ǰӪ����Ա
     *@return
     */
    public MarketingUnitCollection getMarketUnitCollByMemberSaleMan(UserInfo saleMan) throws BOSException, EASBizException
    {
        try {
            return getController().getMarketUnitCollByMemberSaleMan(getContext(), saleMan);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ָ����OUid�����µ�����Ӫ����Ԫ-User defined method
     *@param ouIdSet OU��id����
     *@return
     */
    public MarketingUnitCollection getMarketUnitCollByOUIdSet(Set ouIdSet) throws BOSException, EASBizException
    {
        try {
            return getController().getMarketUnitCollByOUIdSet(getContext(), ouIdSet);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ǰ�˵�Ӫ��ȫ���¿�������Ŀ�ڵ� ����������������֯�� (�����ͬ����Ŀ�ֱ������ڲ�ͬ����֯��)-User defined method
     *@param detailNodeType SellProject ��SellOrder��Subarea��Building��BuildingUnit��Ϊ�գ�Ϊ�մ�������Ŀ
     *@param isMuPerm �Ƿ��Ӫ��Ȩ���й�
     *@return
     */
    public ArrayList getMuSellProTreeNodes(String detailNodeType, boolean isMuPerm) throws BOSException, EASBizException
    {
        try {
            return getController().getMuSellProTreeNodes(getContext(), detailNodeType, isMuPerm);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}