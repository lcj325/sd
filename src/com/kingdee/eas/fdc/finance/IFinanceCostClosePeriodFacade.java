package com.kingdee.eas.fdc.finance;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import java.util.List;

public interface IFinanceCostClosePeriodFacade extends IBizCtrl
{
    public String traceFinanceCostClose(List idList) throws BOSException, EASBizException;
    public void frozenProject(List idList) throws BOSException, EASBizException;
    public String antiCostClose(List idList) throws BOSException, EASBizException;
}