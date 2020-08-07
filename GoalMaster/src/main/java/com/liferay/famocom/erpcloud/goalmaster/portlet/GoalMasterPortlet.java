package com.liferay.famocom.erpcloud.goalmaster.portlet;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.goalmaster.constants.GoalMasterPortletKeys;
import com.liferay.famocom.erpcloud.model.GoalDetails;
import com.liferay.famocom.erpcloud.model.GoalMaster;
import com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.GoalMasterLocalServiceUtil;
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
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=GoalMaster Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GoalMasterPortletKeys.GoalMaster, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class GoalMasterPortlet extends MVCPortlet {

	/**
	 * Add GoalMaster - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "goalMaster")
	public void goalMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		String goal = ParamUtil.getString(actionRequest, "goal", StringPool.BLANK);
		String goalDesc = ParamUtil.getString(actionRequest, "goalDesc", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// String strDate = formatter.format(date);
		try {
			long goalId = CounterLocalServiceUtil.increment(GoalMaster.class.getName());
			GoalMaster goalMaster = GoalMasterLocalServiceUtil.createGoalMaster(goalId);
			goalMaster.setAddedDate(date);
			goalMaster.setGoalName(goal);
			goalMaster.setGoalDescription(goalDesc);
			GoalMasterLocalServiceUtil.addGoalMaster(goalMaster);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Update GoalMaster - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "updateGoalMaster")
	public void updateGoalMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		long goalId = ParamUtil.getLong(actionRequest, "goalId");
		String goal = ParamUtil.getString(actionRequest, "goal", StringPool.BLANK);
		String goalDesc = ParamUtil.getString(actionRequest, "goalDesc", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// String strDate = formatter.format(date);
		try {
			GoalMaster goalMaster = GoalMasterLocalServiceUtil.getGoalMaster(goalId);
			goalMaster.setAddedDate(date);
			goalMaster.setGoalName(goal);
			goalMaster.setGoalDescription(goalDesc);
			GoalMasterLocalServiceUtil.updateGoalMaster(goalMaster);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Delete GoalMaster - From form Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "deleteGoalMaster")
	public void deleteGoalMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		long goalId = ParamUtil.getLong(actionRequest, "goalId");
		System.out.println(":::goalId:::"+goalId);
		try {
			DynamicQuery dynamicQuery = GoalDetailsLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("goalId", goalId);
			dynamicQuery.add(criterion3);
			List<GoalDetails> details = GoalDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (details.size() == 0) {
				GoalMaster goalMaster = GoalMasterLocalServiceUtil.getGoalMaster(goalId);
				GoalMasterLocalServiceUtil.deleteGoalMaster(goalMaster);
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