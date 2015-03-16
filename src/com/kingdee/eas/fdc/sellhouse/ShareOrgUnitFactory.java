package com.kingdee.eas.fdc.sellhouse;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ShareOrgUnitFactory
{
    private ShareOrgUnitFactory()
    {
    }
    public static com.kingdee.eas.fdc.sellhouse.IShareOrgUnit getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IShareOrgUnit)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D78D6004") ,com.kingdee.eas.fdc.sellhouse.IShareOrgUnit.class);
    }
    
    public static com.kingdee.eas.fdc.sellhouse.IShareOrgUnit getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IShareOrgUnit)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D78D6004") ,com.kingdee.eas.fdc.sellhouse.IShareOrgUnit.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.sellhouse.IShareOrgUnit getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IShareOrgUnit)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D78D6004"));
    }
    public static com.kingdee.eas.fdc.sellhouse.IShareOrgUnit getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IShareOrgUnit)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D78D6004"));
    }
}