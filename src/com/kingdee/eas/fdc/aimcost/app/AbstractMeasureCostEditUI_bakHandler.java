/**
 * output package name
 */
package com.kingdee.eas.fdc.aimcost.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractMeasureCostEditUI_bakHandler extends com.kingdee.eas.framework.app.EditUIHandler

{
	public void handleActionAddRow(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAddRow(request,response,context);
	}
	protected void _handleActionAddRow(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionDeleteRow(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionDeleteRow(request,response,context);
	}
	protected void _handleActionDeleteRow(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionImportApportion(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImportApportion(request,response,context);
	}
	protected void _handleActionImportApportion(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}