/**
 * output package name
 */
package com.kingdee.eas.fdc.sellhouse.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractPushManageListUIHandler extends com.kingdee.eas.framework.app.TreeListUIHandler

{
	public void handleActionPush(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionPush(request,response,context);
	}
	protected void _handleActionPush(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionPull(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionPull(request,response,context);
	}
	protected void _handleActionPull(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}