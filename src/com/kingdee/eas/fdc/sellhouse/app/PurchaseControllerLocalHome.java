package com.kingdee.eas.fdc.sellhouse.app;

import javax.ejb.*;
import java.rmi.RemoteException;

public interface PurchaseControllerLocalHome extends EJBLocalHome
{
    PurchaseControllerLocal create() throws CreateException;
}