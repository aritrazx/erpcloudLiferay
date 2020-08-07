package com.liferay.famocom.erpcloud.tsreport.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.famocom.erpcloud.tsreport.constants.TimeSheetReportPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author hussh
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TimeSheetReport Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TimeSheetReportPortletKeys.TimeSheetReport,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TimeSheetReportPortlet extends MVCPortlet {
	@ProcessAction(name = "employeeTimesheet")
	public void employeeTimesheet(ActionRequest actionRequest, ActionResponse actionResponse) {
		String selectEmployee = ParamUtil.getString(actionRequest, "selectEmployee", StringPool.BLANK);
		String selectProject = ParamUtil.getString(actionRequest, "selectProject", StringPool.BLANK);
		String selectTask = ParamUtil.getString(actionRequest, "selectTask", StringPool.BLANK);
		String fromDate = ParamUtil.getString(actionRequest, "fromDate", StringPool.BLANK);
		String toDate = ParamUtil.getString(actionRequest, "toDate", StringPool.BLANK);
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
}