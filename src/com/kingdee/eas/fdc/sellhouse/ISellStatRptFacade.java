package com.kingdee.eas.fdc.sellhouse;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.bos.framework.*;

public interface ISellStatRptFacade extends IBizCtrl
{
    public Map getSellStatRptData(Map map) throws BOSException, EASBizException;
}