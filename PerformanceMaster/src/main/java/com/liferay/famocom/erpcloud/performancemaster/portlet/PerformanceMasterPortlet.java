package com.liferay.famocom.erpcloud.performancemaster.portlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.AppraisalPerformance;
import com.liferay.famocom.erpcloud.model.Performance;
import com.liferay.famocom.erpcloud.model.PerformanceMaster;
import com.liferay.famocom.erpcloud.performancemaster.constants.PerformanceMasterPortletKeys;
import com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PerformanceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=PerformanceMaster Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PerformanceMasterPortletKeys.PerformanceMaster,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PerformanceMasterPortlet extends MVCPortlet {

	/**
	 * Add PerformanceMaster - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "performanceMaster")
	public void performanceMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("Calll ADDDDD");
		String performanceHeading = ParamUtil.getString(actionRequest, "performanceHeading", StringPool.BLANK);
		String performanceDescription = ParamUtil.getString(actionRequest, "performanceDescription", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		try {
			long performanceId = CounterLocalServiceUtil.increment(PerformanceMaster.class.getName());
			Performance performance = PerformanceLocalServiceUtil.createPerformance(performanceId);
			performance.setCreateDate(date);
			performance.setPerformanceHeading(performanceHeading);
			performance.setPerformanceDescription(performanceDescription);
			PerformanceLocalServiceUtil.addPerformance(performance);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * Update PerformanceMaster - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "updatePerformanceMaster")
	public void updatePerformanceMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		long performanceId = ParamUtil.getLong(actionRequest, "performanceId");
		String performanceHeading = ParamUtil.getString(actionRequest, "performanceHeading", StringPool.BLANK);
		String performanceDescription = ParamUtil.getString(actionRequest, "performanceDescription", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		try {
			Performance performance = PerformanceLocalServiceUtil.getPerformance(performanceId);
			performance.setCreateDate(date);
			performance.setPerformanceHeading(performanceHeading);
			performance.setPerformanceDescription(performanceDescription);
			PerformanceLocalServiceUtil.updatePerformance(performance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete PerformanceMaster - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "deletePerformanceMaster")
	public void deletePerformanceMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		long performanceId = ParamUtil.getLong(actionRequest, "performanceId");
		List<AppraisalPerformance> performances = new ArrayList<>();
		try {
			DynamicQuery dynamicQuery = AppraisalPerformanceLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("performanceId", new Long(performanceId));
			dynamicQuery.add(criterion3);
			performances = AppraisalPerformanceLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (performances.size() == 0) {
				Performance performance = PerformanceLocalServiceUtil.getPerformance(performanceId);
				PerformanceLocalServiceUtil.deletePerformance(performance);

				SessionErrors.add(actionRequest, "delete-success");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
			} else {
				SessionErrors.add(actionRequest, "delete-error");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}