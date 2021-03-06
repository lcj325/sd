package com.kingdee.eas.fdc.sellhouse;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SHECusAssistantDataGroupFactory
{
    private SHECusAssistantDataGroupFactory()
    {
    }
    public static com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("808912E3") ,com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup.class);
    }
    
    public static com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("808912E3") ,com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("808912E3"));
    }
    public static com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ISHECusAssistantDataGroup)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("808912E3"));
    }
}