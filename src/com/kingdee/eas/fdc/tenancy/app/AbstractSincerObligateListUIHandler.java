/**
 * output package name
 */
package com.kingdee.eas.fdc.tenancy.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractSincerObligateListUIHandler extends com.kingdee.eas.fdc.tenancy.app.TenBillBaseListUIHandler

{
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	abstract protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context)
		throws Exception;
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	abstract protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context)
		throws Exception;
	public void handleActionExecute(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExecute(request,response,context);
	}
	abstract protected void _handleActionExecute(RequestContext request,ResponseContext response, Context context)
		throws Exception;
	public void handleActionBlankOut(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionBlankOut(request,response,context);
	}
	abstract protected void _handleActionBlankOut(RequestContext request,ResponseContext response, Context context)
		throws Exception;
	public void handleActionCancelSincer(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCancelSincer(request,response,context);
	}
	abstract protected void _handleActionCancelSincer(RequestContext request,ResponseContext response, Context context)
		throws Exception;
	public void handleActionToTenancy(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionToTenancy(request,response,context);
	}
	abstract protected void _handleActionToTenancy(RequestContext request,ResponseContext response, Context context)
		throws Exception;
}