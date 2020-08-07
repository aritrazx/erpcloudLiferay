/**
 * 
 */
package com.liferay.famocom.erpcloud.appraisal.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.famocom.erpcloud.appraisal.model.ManageAppraisalModel;
import com.liferay.famocom.erpcloud.appraisal.model.ProjectMastersModel;
import com.liferay.famocom.erpcloud.appraisal.model.RatingMastersModel;
import com.liferay.famocom.erpcloud.hrappraisal.constants.HrAppraisalViewPortletKeys;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.GoalDetails;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil;
/*import com.liferay.famocom.erpcloud.view.AppraisalView;*/
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Priyajit
 *
 */
public class ManageAppraisalUtils {
	private static final Log _log = LogFactoryUtil.getLog(ManageAppraisalUtils.class);

	public static ManageAppraisalModel getEmployeeAppraisalDetails(long employeeId) {
		_log.info("==== getEmployeeAppraisalDetails ====");
		DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
		ManageAppraisalModel manageAppraisalModel = new ManageAppraisalModel();
		List<RatingMastersModel> ratingMastersModel = new ArrayList<RatingMastersModel>();
		List<ProjectMastersModel> projectMasterModel = new ArrayList<ProjectMastersModel>();
		long userId = 0;
		String fullName = StringPool.BLANK;
	
		try {
			//userId = themeDisplay.getUserId();
			System.out.println("employeeId<<>>||.. "+employeeId);
			if (employeeId > 0) {
				//Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
				Employee employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
				if (Validator.isNotNull(employee)) {
					fullName = (Validator.isNotNull(employee.getFirstName()) ? employee.getFirstName()
							: StringPool.BLANK) + StringPool.SPACE
							+ (Validator.isNotNull(employee.getLastName()) ? employee.getLastName()
									: StringPool.BLANK);
					manageAppraisalModel.setFullName(fullName);
					manageAppraisalModel.setDateOfJoining(Validator.isNotNull(employee.getDateOfJoing())
							? df.format(employee.getDateOfJoing()) : StringPool.BLANK);
					manageAppraisalModel.setDesignation(Validator.isNotNull(employee.getDesignation())
							? employee.getDesignation() : StringPool.BLANK);
					manageAppraisalModel.setEmailId(Validator.isNotNull(employee.getEmaiAddress())
							? employee.getEmaiAddress() : StringPool.BLANK);
					manageAppraisalModel.setUserId(userId);
					manageAppraisalModel.setEmployeeId(employee.getEmployeeId());
					
					/*get ratings from Rating Master*/
					List<RatingMaster> ratingMasters = RatingMasterLocalServiceUtil.getRatingMasters(-1, -1);
					if(Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()){
						for (RatingMaster ratingMaster : ratingMasters) {
							RatingMastersModel rating = new RatingMastersModel();
							rating.setRatingId(ratingMaster.getRatingId());
							rating.setRatingKey((Validator.isNotNull(ratingMaster.getRatingKey())?ratingMaster.getRatingKey():StringPool.BLANK));
							rating.setRatingDescription((Validator.isNotNull(ratingMaster.getRatingDescription())?ratingMaster.getRatingDescription():StringPool.BLANK));
							rating.setRatingNum((Validator.isNotNull(ratingMaster.getRatingNum())?ratingMaster.getRatingNum():StringPool.BLANK));
							ratingMastersModel.add(rating);
						}
					}
					manageAppraisalModel.setRatingMasterModel(ratingMastersModel);
					
					/*get Project from Project Master By employee id*/
					List<ProjectMaster> projectMaster =  ProjectMasterLocalServiceUtil.findByEmployeeId(employee.getEmployeeId());
					if(Validator.isNotNull(projectMaster) && !projectMaster.isEmpty()){
						for (ProjectMaster prm : projectMaster) {
							ProjectMastersModel projectMstModel = new ProjectMastersModel();
							projectMstModel.setProjectId(prm.getProjectId());
							projectMstModel.setProjectName(Validator.isNotNull(prm.getProjectName())?prm.getProjectName():StringPool.BLANK);
							projectMasterModel.add(projectMstModel);
						}
					}
					manageAppraisalModel.setProjectMasterModel(projectMasterModel);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(HrAppraisalViewPortletKeys.EXCEPTION + e);
		}

		return manageAppraisalModel;

	}

	/*public static AppraisalView setAppraisalView(ActionRequest actionRequest){
		System.out.println("============= setAppraisalView ==============");
		AppraisalView appraisalView = new AppraisalView();
		return appraisalView;
	}*/
	
}
