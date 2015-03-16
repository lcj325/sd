package com.kingdee.eas.fdc.sellhouse;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerGradeFactory
{
    private CustomerGradeFactory()
    {
    }
    public static com.kingdee.eas.fdc.sellhouse.ICustomerGrade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ICustomerGrade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4FFB5F9E") ,com.kingdee.eas.fdc.sellhouse.ICustomerGrade.class);
    }
    
    public static com.kingdee.eas.fdc.sellhouse.ICustomerGrade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ICustomerGrade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4FFB5F9E") ,com.kingdee.eas.fdc.sellhouse.ICustomerGrade.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.sellhouse.ICustomerGrade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ICustomerGrade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4FFB5F9E"));
    }
    public static com.kingdee.eas.fdc.sellhouse.ICustomerGrade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.sellhouse.ICustomerGrade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4FFB5F9E"));
    }
}