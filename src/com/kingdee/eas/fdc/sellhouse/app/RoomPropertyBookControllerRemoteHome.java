package com.kingdee.eas.fdc.sellhouse.app;

import javax.ejb.*;
import java.rmi.RemoteException;

public interface RoomPropertyBookControllerRemoteHome extends EJBHome
{
    RoomPropertyBookControllerRemote create() throws CreateException, RemoteException;
}