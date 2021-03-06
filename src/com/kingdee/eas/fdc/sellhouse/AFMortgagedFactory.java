package com.kingdee.eas.fdc.sellhouse;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AFMortgagedFactory
{
    private AFMortgagedFactory()
    {
    }
    public static com.kingdee.eas.fdc.sellhouse.IAFMortgaged getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IAFMortgaged)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6FE57B08") ,com.kingdee.eas.fdc.sellhouse.IAFMortgaged.class);
    }
    
    public static com.kingdee.eas.fdc.sellhouse.IAFMortgaged getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IAFMortgaged)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6FE57B08") ,com.kingdee.eas.fdc.sellhouse.IAFMortgaged.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.sellhouse.IAFMortgaged getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IAFMortgaged)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6FE57B08"));
    }
    public static com.kingdee.eas.fdc.sellhouse.IAFMortgaged getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.IAFMortgaged)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6FE57B08"));
    }
}