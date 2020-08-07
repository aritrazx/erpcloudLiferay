package com.liferay.famocom.erpcloud.ratingmaster.portlet;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;
import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalPerformance;
import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.ratingmaster.constants.RatingMasterPortletKeys;
import com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=RatingMaster Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RatingMasterPortletKeys.RatingMaster, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class RatingMasterPortlet extends MVCPortlet {
	/**
	 * Add RatingMaster - From Submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "ratingMaster")
	public void ratingMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		String ratingNumber = ParamUtil.getString(actionRequest, "ratingNumber", StringPool.BLANK);
		String ratingKey = ParamUtil.getString(actionRequest, "ratingKey", StringPool.BLANK);
		String ratingDesc = ParamUtil.getString(actionRequest, "ratingDesc", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		try {
			DynamicQuery dynamicQuery = RatingMasterLocalServiceUtil.dynamicQuery();
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("ratingNum",ratingNumber);
			dynamicQuery.add(criterion);
			List<RatingMaster> ratingMasters = RatingMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(ratingMasters.size()==0){
			long ratingId = CounterLocalServiceUtil.increment(RatingMaster.class.getName());
			RatingMaster ratingMaster = RatingMasterLocalServiceUtil.createRatingMaster(ratingId);
			ratingMaster.setAddedDate(date);
			ratingMaster.setRatingNum(ratingNumber);
		
		
			ratingMaster.setRatingKey(ratingKey);
			ratingMaster.setRatingDescription(ratingDesc);
			RatingMasterLocalServiceUtil.addRatingMaster(ratingMaster);
			}else{
				SessionErrors.add(actionRequest, "add-error");
				SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addRating.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * Update RatingMaster - from form submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "updateRatingMaster")
	public void updateRatingMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		long ratingId = ParamUtil.getLong(actionRequest, "ratingId");
		String ratingNumber = ParamUtil.getString(actionRequest, "ratingNumber", StringPool.BLANK);
		String ratingKey = ParamUtil.getString(actionRequest, "ratingKey", StringPool.BLANK);
		String ratingDesc = ParamUtil.getString(actionRequest, "ratingDesc", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		try {
			RatingMaster ratingMaster = RatingMasterLocalServiceUtil.getRatingMaster(ratingId);
			ratingMaster.setAddedDate(date);
			ratingMaster.setRatingNum(ratingNumber);
			ratingMaster.setRatingKey(ratingKey);
			ratingMaster.setRatingDescription(ratingDesc);
			RatingMasterLocalServiceUtil.updateRatingMaster(ratingMaster);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Delete RatingMaster - from form submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "deleteRatingMaster")
	public void deleteRatingMaster(ActionRequest actionRequest, ActionResponse actionResponse) {

		long ratingId = ParamUtil.getLong(actionRequest, "ratingId");
		if (Validator.isNotNull(ratingId)) {
			try {
				DynamicQuery dynamicQuery = AppraisalMasterLocalServiceUtil.dynamicQuery()
						.add(RestrictionsFactoryUtil.eq("overallRatingEmp", ratingId));
				List<AppraisalMaster> appraisalMasterList = AppraisalMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("appraisalMasterList" + appraisalMasterList.size());
				DynamicQuery dynamicQuery1 = AppraisalGoalDetailsLocalServiceUtil.dynamicQuery()
						.add(RestrictionsFactoryUtil.eq("ratingIdEmp", ratingId));
				List<AppraisalGoalDetails> appraisalGoalDetailsList = AppraisalGoalDetailsLocalServiceUtil
						.dynamicQuery(dynamicQuery1);
				System.out.println("appraisalGoalDetailsList" + appraisalGoalDetailsList.size());
				DynamicQuery dynamicQuery2 = AppraisalGoalMasterLocalServiceUtil.dynamicQuery()
						.add(RestrictionsFactoryUtil.eq("employeeOverallRat", ratingId));
				List<AppraisalGoalMaster> appraisalGoalMasterList = AppraisalGoalMasterLocalServiceUtil
						.dynamicQuery(dynamicQuery2);
				System.out.println("appraisalGoalMasterList" + appraisalGoalDetailsList.size());
				DynamicQuery dynamicQuery3 = AppraisalPerformanceLocalServiceUtil.dynamicQuery()
						.add(RestrictionsFactoryUtil.eq("ratingIdEmp", ratingId));
				List<AppraisalPerformance> appraisalPerformanceList = AppraisalPerformanceLocalServiceUtil
						.dynamicQuery(dynamicQuery3);
				System.out.println("appraisalPerformanceList" + appraisalPerformanceList.size());
				if (appraisalMasterList.size() == 0 && appraisalGoalDetailsList.size() == 0
						&& appraisalGoalMasterList.size() == 0 && appraisalPerformanceList.size() == 0) {
					RatingMaster ratingMaster = RatingMasterLocalServiceUtil.getRatingMaster(ratingId);
					RatingMasterLocalServiceUtil.deleteRatingMaster(ratingMaster);
				}else{
					SessionErrors.add(actionRequest, "delete-error");
					SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					actionResponse.setWindowState(WindowState.NORMAL);
					actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}