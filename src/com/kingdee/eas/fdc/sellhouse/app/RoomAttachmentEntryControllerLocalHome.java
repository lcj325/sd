package com.kingdee.eas.fdc.sellhouse.app;

import javax.ejb.*;
import java.rmi.RemoteException;

public interface RoomAttachmentEntryControllerLocalHome extends EJBLocalHome
{
    RoomAttachmentEntryControllerLocal create() throws CreateException;
}