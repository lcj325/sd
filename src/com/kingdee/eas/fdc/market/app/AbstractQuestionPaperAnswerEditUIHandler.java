/**
 * output package name
 */
package com.kingdee.eas.fdc.market.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractQuestionPaperAnswerEditUIHandler extends com.kingdee.eas.framework.app.BillEditUIHandler

{
	public void handleActionAddCustomer(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAddCustomer(request,response,context);
	}
	protected void _handleActionAddCustomer(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}