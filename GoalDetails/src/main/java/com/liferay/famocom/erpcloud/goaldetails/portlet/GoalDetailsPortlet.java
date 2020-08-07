package com.liferay.famocom.erpcloud.goaldetails.portlet;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.goaldetails.constants.GoalDetailsPortletKeys;
import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;
import com.liferay.famocom.erpcloud.model.GoalDetails;
import com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=GoalDetails Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GoalDetailsPortletKeys.GoalDetails, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class GoalDetailsPortlet extends MVCPortlet {

	/**
	 * Add GoalDetails - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "goalDetails")
	public void goalDetails(ActionRequest actionRequest, ActionResponse actionResponse) {
		long selectGoal = ParamUtil.getLong(actionRequest, "selectGoal");
		String parameter = ParamUtil.getString(actionRequest, "parameter", StringPool.BLANK);
		String scaleDesc = ParamUtil.getString(actionRequest, "scaleDesc", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// String strDate = formatter.format(date);
		try {
			long goaldetailId = CounterLocalServiceUtil.increment(GoalDetails.class.getName());
			GoalDetails goalDetails = GoalDetailsLocalServiceUtil.createGoalDetails(goaldetailId);
			goalDetails.setAddedDate(date);
			goalDetails.setGoalId(selectGoal);
			goalDetails.setParameter(parameter);
			goalDetails.setScale(scaleDesc);
			GoalDetailsLocalServiceUtil.addGoalDetails(goalDetails);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Update GoalDetails - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "updateGoalDetails")
	public void updateGoalDetails(ActionRequest actionRequest, ActionResponse actionResponse) {
		long goaldetailId = ParamUtil.getLong(actionRequest, "goaldetailId");
		long selectGoal = ParamUtil.getLong(actionRequest, "selectGoal");
		String parameter = ParamUtil.getString(actionRequest, "parameter", StringPool.BLANK);
		String scaleDesc = ParamUtil.getString(actionRequest, "scaleDesc", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// String strDate = formatter.format(date);
		try {
			GoalDetails goalDetails = GoalDetailsLocalServiceUtil.getGoalDetails(goaldetailId);
			goalDetails.setAddedDate(date);
			goalDetails.setGoalId(selectGoal);
			goalDetails.setParameter(parameter);
			goalDetails.setScale(scaleDesc);
			GoalDetailsLocalServiceUtil.updateGoalDetails(goalDetails);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Delete GoalDetails - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "deleteGoalDetails")
	public void deleteGoalDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException {
		long goaldetailId = ParamUtil.getLong(actionRequest, "goaldetailId");

		try {
			if (Validator.isNotNull(goaldetailId)) {
				DynamicQuery dynamicQuery = AppraisalGoalDetailsLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("goaldetailId", new Long(goaldetailId));
				dynamicQuery.add(criterion3);
				List<AppraisalGoalDetails> details = AppraisalGoalDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
				if (details.size() == 0) {
					GoalDetails goalDetails = GoalDetailsLocalServiceUtil.getGoalDetails(goaldetailId);
					GoalDetailsLocalServiceUtil.deleteGoalDetails(goalDetails);
				}else{
					SessionErrors.add(actionRequest, "delete-error");
					SessionMessages.add(actionRequest,
							PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					actionResponse.setWindowState(WindowState.NORMAL);
					actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
				}
			} 
		} catch (PortalException e) {
			e.printStackTrace();
		}

	}
}