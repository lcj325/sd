package com.kingdee.eas.fdc.aimcost.app;

import javax.ejb.*;
import java.rmi.RemoteException;

public interface VoucherForDynamicControllerRemoteHome extends EJBHome
{
    VoucherForDynamicControllerRemote create() throws CreateException, RemoteException;
}