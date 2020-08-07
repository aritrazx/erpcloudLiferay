package com.liferay.famocom.erpcloud.appraisal.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.appraisal.constants.ManageAppraisalMVCPortletKeys;
import com.liferay.famocom.erpcloud.appraisal.model.ManageAppraisalModel;
import com.liferay.famocom.erpcloud.appraisal.util.ManageAppraisalUtils;
import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;
import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalPerformance;
import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.GoalDetails;
import com.liferay.famocom.erpcloud.model.GoalMaster;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.GoalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author Priyajit
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=ManageAppraisal Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ManageAppraisalMVCPortletKeys.ManageAppraisalMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ManageAppraisalMVCPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(ManageAppraisalMVCPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.info("=====render method called=====");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String jspPage = ParamUtil.getString(renderRequest, "jspPage", StringPool.BLANK);
		_log.info("jspPage:::" + jspPage);
		Employee employee = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
		long isActive = ManageAppraisalMVCPortletKeys.AppraisalSettingActive;
		_log.info("Called...");
		AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
		_log.info("setup: " + setup);
		AppraisalMaster getMasterObj = null;
		_log.info(".....................: ");
		try {
			_log.info("...........In side try..........: ");
			getMasterObj = AppraisalMasterLocalServiceUtil.findBySettingIdAndEmployeeIds(setup.getAppraisalSettingId(),
					employee.getEmployeeId());
			// _log.info("getMasterObj.getOverallRatingEmp()>>>>>> " +
			// getMasterObj.getOverallRatingEmp());
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (Validator.isNotNull(jspPage)) {

		} else {
			_log.info("=====rendering view page=====");
			try {
				ManageAppraisalModel manageAppraisalModel = ManageAppraisalUtils
						.getEmployeeAppraisalDetails(themeDisplay);
				if (Validator.isNotNull(manageAppraisalModel)) {
					renderRequest.setAttribute("manageAppraisalModel", manageAppraisalModel);
				}
				if (Validator.isNotNull(getMasterObj)) {
					renderRequest.setAttribute("getMasterObj", getMasterObj);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error(ManageAppraisalMVCPortletKeys.EXCEPTION + e);
			}
		}
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		_log.info("==== inside serveResourse method =====");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		String portletId = portletDisplay.getId();
		String action = ParamUtil.getString(resourceRequest, Constants.CMD);
		PrintWriter printWriter = resourceResponse.getWriter();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		String goalHtml = StringPool.BLANK;
		String goalDetailsHtml = StringPool.BLANK;
		String goalDetailsHeaderHtml = StringPool.BLANK;
		String goalDetailsFooterHtml = StringPool.BLANK;
		String goalDetailsBodyHtml = StringPool.BLANK;
		String ratingOption = StringPool.BLANK;
		String goalHtmlHeader = StringPool.BLANK;

		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);
		httpResponse.flushBuffer();
		httpResponse.setContentType("html/text");

		long projectId = ParamUtil.getLong(resourceRequest, "projectId", 0);
		long employeeId = ParamUtil.getLong(resourceRequest, "employeeId", 0);
		long appraisalSettingId = ParamUtil.getLong(resourceRequest, "appraisalSettId", 0);
		String projectDesc = StringPool.BLANK;
		String startDate = StringPool.BLANK;
		String endDate = StringPool.BLANK;

		AppraisalProjectMaster appProMasObj = null;
		if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
				&& Validator.isNotNull(appraisalSettingId)) {
			appProMasObj = AppraisalProjectMasterLocalServiceUtil
					.findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId, employeeId, projectId);
			_log.info("=========appProMasObj============" + appProMasObj);
			projectDesc = appProMasObj.getProjectDescription();
			if (Validator.isNotNull(appProMasObj.getStartDate())) {
				startDate = df.format(appProMasObj.getStartDate());
			}
			if (Validator.isNotNull(appProMasObj.getEndDate())) {
				endDate = df.format(appProMasObj.getEndDate());
			}
		}

		if ("get-goal-details".trim().equalsIgnoreCase(action)) {
			if (projectId > 0 && employeeId > 0) {
				try {
					List<RatingMaster> ratingMasters = RatingMasterLocalServiceUtil.getRatingMasters(-1, -1);
					if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {
						for (RatingMaster ratingMaster : ratingMasters) {
							ratingOption = ratingOption + "<option value='" + ratingMaster.getRatingId() + "'>" + ""
									+ ratingMaster.getRatingKey() + "-" + ratingMaster.getRatingNum() + ""
									+ "</option>";
						}
					}

					goalDetailsHeaderHtml = "<table class='table no-margin table-hover bg-warning'>" + "<thead>"
							+ "<tr class='label-info labelinfo1'>" + "<th class='text-center'>Sr. No.</th>"
							+ "<th class='text-center'>Parameter</th>" + "<th class='text-center'>Scale</th>"
							+ "<th class='text-center'>Employee’s Rating</th>"
							+ "<th class='text-center'>Manager’s Rating</th>" + "</tr>" + "</thead>"
							+ "<tbody id='custom-table'>";
					goalDetailsFooterHtml = "</tbody>" + "</table>";

					ProjectMaster projectMaster = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
					if (Validator.isNotNull(projectMaster)) {
						_log.info("appProMasObj : " + appProMasObj);
						/* if (Validator.isNull(appProMasObj)) { */

						goalHtmlHeader = "<div class='col-xs-12 col-md-12 panel panel-primary' id='project_panel_'"
								+ projectMaster.getProjectId() + ">"
								+ "<div class='panel-heading clearfix'>Project name:-" + projectMaster.getProjectName()
								+ "<div class='btn-group pull-right'>" + "<a href='#project_"
								+ projectMaster.getProjectId()
								+ "' class='btn btn-default btn-sm collapsed' data-toggle='collapse' data-parent='#accordion' aria-expanded='false'></a>"
								+ "</div>" + "</div>" + "<div id='project_" + projectMaster.getProjectId()
								+ "' class='panel-body collapse' aria-expanded='false' style='height: 30px;'>"
								+ "<input type='hidden' name='projectId_" + projectMaster.getProjectId() + "' value='"
								+ projectMaster.getProjectId() + "'>"
								+ "<div class='col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0'>"
								+ "<div class='form-group float-label-control'>" + "<p>Job Description</p>"
								+ "<textarea id='_" + portletId + "_pojectDescription' value='" + projectDesc
								+ "' name='_" + portletId + "_projectDescription_" + projectMaster.getProjectId()
								+ "' class='fs_input custom-full' placeholder='Job Description'>" + projectDesc
								+ "</textarea>" + "</div>" + "</div>"
								+ "<div class='col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0'>"
								+ "<div class='col-md-6 col-sm-6 col-xs-12'>" + "<p>Start Date</p>"
								+ "<div class='form-group'>" + "<input id='_" + portletId + "_startdate' name='_"
								+ portletId + "_startdate_" + projectMaster.getProjectId() + "' value='" + startDate
								+ "' type='text' placeholder='Start Date' class='fs_input dateinput' style='font-size: 14px !important;'>"
								+ "</div></div>" + "<div class='col-md-6 col-sm-6 col-xs-12'>" + "<p>End Date</p>"
								+ "<div class='form-group'>" + "<input id='_" + portletId + "_enddate' name='_"
								+ portletId + "_enddate_" + projectMaster.getProjectId() + "' value='" + endDate
								+ "' type='text' placeholder='End Date' class='fs_input dateinput' style='font-size: 14px !important;'>"
								+ "</div></div></div>";

						List<GoalMaster> goalMasters = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);
						if (Validator.isNotNull(goalMasters) && !goalMasters.isEmpty()) {
							for (GoalMaster goalMaster : goalMasters) {

								AppraisalGoalMaster appGoalMasObj = null;
								String getGoalMasterEmpComment = StringPool.BLANK;
								long getGoalMasterEmpRating = 0;
								_log.info("goalMaster.getGoalId()..." + goalMaster.getGoalId());
								if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
										&& Validator.isNotNull(appraisalSettingId)
										&& Validator.isNotNull(goalMaster.getGoalId())) {
									appGoalMasObj = AppraisalGoalMasterLocalServiceUtil.findByApprIdEmpIdProjIdEvalId(
											appProMasObj.getAppraisalId(), employeeId, projectId,
											goalMaster.getGoalId());
									_log.info("=========appGoalMasObj============" + appGoalMasObj);
									projectDesc = appProMasObj.getProjectDescription();
									if (Validator.isNotNull(appGoalMasObj.getEmployeeComment())) {
										getGoalMasterEmpComment = appGoalMasObj.getEmployeeComment();
									}
									if (Validator.isNotNull(appGoalMasObj.getEmployeeOverallRat())) {
										getGoalMasterEmpRating = appGoalMasObj.getEmployeeOverallRat();
									}
								}

								String ratingGoalMasterOverallEmpOption = StringPool.BLANK;
								if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {

									for (RatingMaster ratingMaster : ratingMasters) {
										String selected = StringPool.BLANK;
										if (ratingMaster.getRatingId() == getGoalMasterEmpRating) {
											selected = "selected";
											_log.info("====ratingMaster.getRatingId()===" + ratingMaster.getRatingId()
													+ "====getGoalMasterEmpRating===" + getGoalMasterEmpRating);
										}
										ratingGoalMasterOverallEmpOption = ratingGoalMasterOverallEmpOption
												+ "<option value='" + ratingMaster.getRatingId() + "' " + selected
												+ " >" + "" + ratingMaster.getRatingKey() + "-"
												+ ratingMaster.getRatingNum() + "" + "</option>";
										_log.info("ratingGoalOverallEmpOption====>>>> : "
												+ ratingGoalMasterOverallEmpOption);
									}
								}

								goalDetailsBodyHtml = StringPool.BLANK;
								List<GoalDetails> goalDetails = GoalDetailsLocalServiceUtil
										.findByGoalId(goalMaster.getGoalId());
								if (Validator.isNotNull(goalDetails) && !goalDetails.isEmpty()) {
									long slNo = 0;
									for (GoalDetails gDetails : goalDetails) {

										AppraisalGoalDetails appGoalDetailsObj = null;
										long getGoalDetailsEmpRating = 0;
										if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
												&& Validator.isNotNull(appraisalSettingId)
												&& Validator.isNotNull(goalMaster.getGoalId())
												&& Validator.isNotNull(gDetails.getGoaldetailId())) {
											appGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
													.findByApprIdEmpIdProjIdEvalIdGoalDetId(
															appProMasObj.getAppraisalId(), employeeId, projectId,
															goalMaster.getGoalId(), gDetails.getGoaldetailId());

											_log.info("=========appGoalMasObj============" + appGoalMasObj);
											projectDesc = appProMasObj.getProjectDescription();
											if (Validator.isNotNull(appGoalDetailsObj.getRatingIdEmp())) {
												getGoalDetailsEmpRating = appGoalDetailsObj.getRatingIdEmp();
											}
										}

										String ratingGoalDetailsEmpOption = StringPool.BLANK;
										if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {

											for (RatingMaster ratingMaster : ratingMasters) {
												String selected = StringPool.BLANK;
												if (ratingMaster.getRatingId() == getGoalDetailsEmpRating) {
													selected = "selected";
													_log.info("====ratingMaster.getRatingId()==="
															+ ratingMaster.getRatingId()
															+ "====ratingGoalDetailsEmpOption==="
															+ getGoalDetailsEmpRating);
												}
												ratingGoalDetailsEmpOption = ratingGoalDetailsEmpOption
														+ "<option value='" + ratingMaster.getRatingId() + "' "
														+ selected + " >" + "" + ratingMaster.getRatingKey() + "-"
														+ ratingMaster.getRatingNum() + "" + "</option>";
												_log.info("ratingGoalDetailsEmpOption====>>>> : "
														+ ratingGoalDetailsEmpOption);
											}
										}

										goalDetailsBodyHtml += "<tr>" + "<td class='text-left '>" + ++slNo + "</td>"
												+ "<td class='text-left '>" + gDetails.getParameter() + "</td>"
												+ "<td class='text-left '>" + gDetails.getScale() + "</td>"
												+ "<td class='text-left '>" + "<select id='_" + portletId
												+ "_goalEmpRat' name='_" + portletId + "_goalEmpRat_"
												+ projectMaster.getProjectId() + "_" + goalMaster.getGoalId() + "_"
												+ gDetails.getGoaldetailId() + "' class='fs_input custom-full'>"
												+ "<option value='0'>Select Rating</option> " + "'"
												+ ratingGoalDetailsEmpOption + "'" + "</select>" + "</td>"
												+ "<td class='text-left '>" + "<select id='_" + portletId
												+ "_goalManRat' name='_" + portletId + "_goalManRat_'"
												+ projectMaster.getProjectId() + "_" + goalMaster.getGoalId() + "_"
												+ gDetails.getGoaldetailId()
												+ "' class='fs_input custom-full' disabled=''>"
												+ "<option value='0'>Select Rating</option> " + "'" + ratingOption + "'"
												+ "</select>" + "</td>" + "</tr>";
									}

									goalDetailsHtml = goalDetailsHeaderHtml + goalDetailsBodyHtml
											+ goalDetailsFooterHtml + "<hr>";
								} else {

									goalDetailsHtml = StringPool.BLANK;
								}

								goalHtml = goalHtml

										+ "<div class='col-xs-12 col-md-12' style='padding-top: 15px;'>"
										+ "<div class='panel panel-info '>" + "<div class='panel-heading'>Goal</div>"
										+ "<div class='panel-body'>"
										+ "<div class='col-lg-12 col-sm-12 col-xs-12 margintop10 paddingleft0'>"
										+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0'>"
										+ "<h4><strong>Goal Name:</strong>&nbsp;" + goalMaster.getGoalName() + ""
										+ "</h4>" + "</div>"
										+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0'>"
										+ "<h4><strong>Goal Description:</strong>&nbsp;"
										+ goalMaster.getGoalDescription() + "" + "</h4></div>" + goalDetailsHtml
										+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0' style=''>"
										+ "<div class='form-group'>" + "<p>Employee's Comments:</p>" + "<textarea id='_"
										+ portletId + "_commentEmp' name='_" + portletId + "_commentEmp_"
										+ projectMaster.getProjectId() + "_" + goalMaster.getGoalId()
										+ "' class='fs_input custom-full' placeholder='Employee's Comments'>"
										+ getGoalMasterEmpComment + "</textarea>" + "</div>"
										+ "<div class='form-group'>" + "<p>Overall Goal Rating by Employee:</p>"
										+ "<select id='_" + portletId + "_goalEmpOverallRat' name='_" + portletId
										+ "_goalEmpOverallRat_" + projectMaster.getProjectId() + "_"
										+ goalMaster.getGoalId() + "' class='fs_input custom-full'>"
										+ "<option value='0'>Select Rating</option>" + "'"
										+ ratingGoalMasterOverallEmpOption + "'" + "</select>" + "</div></div>"
										+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0' style=''>"
										+ "<div class='form-group'>" + "<p>Manager's Comments:</p>" + "<textarea id='_"
										+ portletId + "_commentMan' name='_" + portletId + "_commentMan_"
										+ projectMaster.getProjectId() + "_" + goalMaster.getGoalId()
										+ "' class='fs_input custom-full' placeholder='Manager's Comments' disabled=''></textarea>"
										+ "</div>" + "<div class='form-group'>"
										+ "<p>Overall Goal Rating by Manager:</p>" + "<select id='_" + portletId
										+ "_goalManOverallRat' name='_" + portletId + "_goalManOverallRat_"
										+ projectMaster.getProjectId() + "_" + goalMaster.getGoalId()
										+ "' class='fs_input custom-full' disabled=''>"
										+ "<option value='0'>Select Rating</option>" + "'" + ratingOption + "'"
										+ "</select>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>" + "</div>";

							}
						}

						jsonObject.put("data", goalHtmlHeader + goalHtml);
						jsonObject.put("status", ManageAppraisalMVCPortletKeys.SUCCESS);
						/*
						 * } else { jsonObject.put("status",
						 * ManageAppraisalMVCPortletKeys.ERROR); }
						 */
					} else {
						jsonObject.put("status", ManageAppraisalMVCPortletKeys.ERROR);
					}
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			printWriter.write(jsonObject.toJSONString());
			printWriter.flush();
			printWriter.close();
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	@ProcessAction(name = "apprisalAction")
	public void apprisalAction(ActionRequest request, ActionResponse response)
			throws ParseException, WindowStateException {
		_log.info("============= Appraisal Action ==============");
		Date fromDateSubmission = null;
		Date toDateSubmission = null;

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String strCurDate = df.format(new Date());
		Date curDate = new SimpleDateFormat("dd/MM/yyyy").parse(strCurDate);

		List<String> errorListProject = new ArrayList<String>();
		List<String> errorListGoal = new ArrayList<String>();

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Employee emp = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());

		String accomplishmentsEmp = ParamUtil.getString(request, "accomplishmentsEmp", StringPool.BLANK);
		String strengthsEmp = ParamUtil.getString(request, "strengthsEmp", StringPool.BLANK);
		String developmentEmp = ParamUtil.getString(request, "developmentEmp", StringPool.BLANK);
		String careerEmp = ParamUtil.getString(request, "careerEmp", StringPool.BLANK);

		String overallCommentEmp = ParamUtil.getString(request, "overallCommentEmp", StringPool.BLANK);
		long overallRatEmp = ParamUtil.getLong(request, "overallRatEmp");

		String[] performanceArr = ParamUtil.getParameterValues(request, "performanceList");
		String performanceLists = ParamUtil.getString(request, "performanceList", StringPool.BLANK);
		String performanceListsArr[] = performanceLists.split(",");

		String[] assignProjectList = ParamUtil.getParameterValues(request, "assignProjectList");
		String projectLists = ParamUtil.getString(request, "assignProjectList", StringPool.BLANK);
		String assignProjectListsArr[] = projectLists.split(",");
		_log.info("projectLists : " + projectLists);

		int sumbitVal = ParamUtil.getInteger(request, "sumbitVal");
		_log.info("========== accomplishmentsEmp:======" + accomplishmentsEmp);
		_log.info("========== strengthsEmp:======" + strengthsEmp);
		_log.info("========== developmentEmp:======" + developmentEmp);
		_log.info("========== careerEmp:======" + careerEmp);
		_log.info("========== buttonValue:======" + sumbitVal);

		long isActive = ManageAppraisalMVCPortletKeys.AppraisalSettingActive;
		long saveAsDraft = ManageAppraisalMVCPortletKeys.AppraisalSaveAsDraft;
		long saveAndSubmit = ManageAppraisalMVCPortletKeys.AppraisalSaveAndSubmmit;

		AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
		_log.info("========== setup:======" + setup);
		AppraisalMaster getMasterObj = null;
		AppraisalPerformance getPerformanceObj = null;
		AppraisalProjectMaster getProjectMasterObj = null;
		AppraisalGoalMaster getGoalMasterObj = null;
		AppraisalGoalDetails getGoalDetailsObj = null;
		if (setup != null && emp != null) {
			fromDateSubmission = setup.getFromDateSubmission();
			toDateSubmission = setup.getToDateSubmission();
			try {
				getMasterObj = AppraisalMasterLocalServiceUtil
						.findBySettingIdAndEmployeeIds(setup.getAppraisalSettingId(), emp.getEmployeeId()); // findBySettingIdAndEmployeeId(setup.getAppraisalSettingId(),
																											// emp.getEmployeeId());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		_log.info("========== getMasterObj:======" + getMasterObj);

		// appraisal master details

		AppraisalMaster addMasterObj = null;
		AppraisalMaster appraisalMasterObj = null;

		if (getMasterObj != null) {
			_log.info("========== in side if master:======");
			getMasterObj.setAppraisalSettingId(setup.getAppraisalSettingId());
			getMasterObj.setEmployeeId(emp.getEmployeeId());

			if (Validator.isNotNull(accomplishmentsEmp)) {
				getMasterObj.setAccomplishmentsEmp(accomplishmentsEmp);
			}

			if (Validator.isNotNull(strengthsEmp)) {
				getMasterObj.setStrengthsEmp(strengthsEmp);
			}

			if (Validator.isNotNull(developmentEmp)) {
				getMasterObj.setDevelopmentEmp(developmentEmp);
			}

			if (Validator.isNotNull(careerEmp)) {
				getMasterObj.setCareerEmp(careerEmp);
			}

			if (Validator.isNotNull(overallCommentEmp)) {
				getMasterObj.setOverallCommentEmp(overallCommentEmp);
			}

			if (Validator.isNotNull(overallRatEmp)) {
				getMasterObj.setOverallRatingEmp(overallRatEmp);
			}

			/*
			 * if (sumbitVal == 1) { getMasterObj.setSubmitStep(saveAndSubmit);
			 * } else { getMasterObj.setSubmitStep(saveAsDraft); }
			 */

			/*
			 * if (curDate.after(fromDateSubmission) &&
			 * curDate.before(toDateSubmission)) {
			 */
			if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
					|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
					|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
					|| (curDate.equals(fromDateSubmission) && curDate.equals(toDateSubmission)))) {
				appraisalMasterObj = AppraisalMasterLocalServiceUtil.updateAppraisalMaster(getMasterObj);
			}

		} else {
			_log.info("========== in side else master:======");
			long appraisalId = CounterLocalServiceUtil.increment(AppraisalMaster.class.getName());
			addMasterObj = AppraisalMasterLocalServiceUtil.createAppraisalMaster(appraisalId);
			addMasterObj.setAppraisalSettingId(setup.getAppraisalSettingId());
			addMasterObj.setEmployeeId(emp.getEmployeeId());

			if (Validator.isNotNull(accomplishmentsEmp)) {
				addMasterObj.setAccomplishmentsEmp(accomplishmentsEmp);
			}

			if (Validator.isNotNull(strengthsEmp)) {
				addMasterObj.setStrengthsEmp(strengthsEmp);
			}

			if (Validator.isNotNull(developmentEmp)) {
				addMasterObj.setDevelopmentEmp(developmentEmp);
			}

			if (Validator.isNotNull(overallCommentEmp)) {
				addMasterObj.setOverallCommentEmp(overallCommentEmp);
			}

			if (Validator.isNotNull(overallRatEmp)) {
				addMasterObj.setOverallRatingEmp(overallRatEmp);
			}

			if (Validator.isNotNull(careerEmp)) {
				addMasterObj.setCareerEmp(careerEmp);
			}
			addMasterObj.setAddedDate(new Date());
			/*
			 * if (sumbitVal == 1) { addMasterObj.setSubmitStep(saveAndSubmit);
			 * } else { addMasterObj.setSubmitStep(saveAsDraft); }
			 */
			if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
					|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
					|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
					|| (curDate.equals(fromDateSubmission) && curDate.equals(toDateSubmission)))) {
				appraisalMasterObj = AppraisalMasterLocalServiceUtil.addAppraisalMaster(addMasterObj);
			}
		}

		// performance details

		AppraisalPerformance addPerformanceObj = null;
		AppraisalPerformance appraisalPerformanceObj = null;

		_log.info("getPerformanceObj::" + getPerformanceObj);
		for (int i = 0; i <= performanceArr.length - 1; i++) {

			String namePerformanceCom = "performance_" + performanceListsArr[i];
			String nameratinIdEmp = "performanceEmpRat_" + performanceListsArr[i];
			long performanceId = Long.parseLong(performanceListsArr[i]);
			System.out
					.println("namePerformanceCom.. : " + namePerformanceCom + " nameratinIdEmp.. : " + nameratinIdEmp);
			String performanceCom = ParamUtil.getString(request, namePerformanceCom, StringPool.BLANK);
			long ratinIdEmp = ParamUtil.getLong(request, nameratinIdEmp);
			_log.info("performanceCom : " + performanceCom + " ratinIdEmp : " + ratinIdEmp);
			if (appraisalMasterObj != null) {
				getPerformanceObj = AppraisalPerformanceLocalServiceUtil.findByApprIdSettingIdAndEmployeeIdPerformId(
						appraisalMasterObj.getAppraisalId(), setup.getAppraisalSettingId(), emp.getEmployeeId(),
						performanceId);
			}

			if (appraisalMasterObj != null) {
				if (getPerformanceObj != null) {
					_log.info("========== in side if getPerformanceObj:======");
					_log.info("performancelist : " + performanceLists);

					getPerformanceObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
					getPerformanceObj.setEmployeeId(emp.getEmployeeId());
					getPerformanceObj.setAppraisalSettingId(setup.getAppraisalSettingId());
					getPerformanceObj.setPerformanceId(performanceId);

					if (Validator.isNotNull(performanceCom)) {
						getPerformanceObj.setPerformanceComm(performanceCom);
					}
					if (Validator.isNotNull(ratinIdEmp)) {
						getPerformanceObj.setRatingIdEmp(ratinIdEmp);
					}
					/*
					 * if (curDate.after(fromDateSubmission) &&
					 * curDate.before(toDateSubmission)) {
					 */
					if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
							|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
							|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
							|| (curDate.equals(fromDateSubmission) && curDate.equals(toDateSubmission)))) {
						appraisalPerformanceObj = AppraisalPerformanceLocalServiceUtil
								.updateAppraisalPerformance(getPerformanceObj);
					}
					_log.info("appraisalPerformanceObj obj>>>>..." + appraisalPerformanceObj);
					_log.info("Appraisal Performance updated successfully");

				} else {
					_log.info("========== in side else performance:======");
					/* for (int i = 0; i <= performanceArr.length - 1; i++) { */

					_log.info("performancelist>>><<<<< : " + performanceListsArr[i]);

					long appraisalPerformId = CounterLocalServiceUtil.increment(AppraisalPerformance.class.getName());
					addPerformanceObj = AppraisalPerformanceLocalServiceUtil
							.createAppraisalPerformance(appraisalPerformId);
					addPerformanceObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
					addPerformanceObj.setEmployeeId(emp.getEmployeeId());
					addPerformanceObj.setAppraisalSettingId(setup.getAppraisalSettingId());
					addPerformanceObj.setPerformanceId(performanceId);

					if (Validator.isNotNull(performanceCom)) {
						addPerformanceObj.setPerformanceComm(performanceCom);
					}
					if (Validator.isNotNull(ratinIdEmp)) {
						addPerformanceObj.setRatingIdEmp(ratinIdEmp);
					}
					/*
					 * if (curDate.after(fromDateSubmission) &&
					 * curDate.before(toDateSubmission)) {
					 */
					if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
							|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
							|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
							|| (curDate.equals(fromDateSubmission) && curDate.equals(toDateSubmission)))) {
						appraisalPerformanceObj = AppraisalPerformanceLocalServiceUtil
								.addAppraisalPerformance(addPerformanceObj);
					}
					/* } */

				}
			}
		}
		// Project info details

		AppraisalProjectMaster addProjectMasterObj = null;
		AppraisalProjectMaster appraisalProjectMasterObj = null;

		if (Validator.isNotNull(projectLists)) {
			for (int i = 0; i <= assignProjectList.length - 1; i++) {

				_log.info("assignProjectList>>><<<<< : " + assignProjectListsArr[i]);
				String nameProjectDescription = "projectDescription_" + assignProjectListsArr[i];
				String nameStartdate = "startdate_" + assignProjectListsArr[i];
				String nameEnddate = "enddate_" + assignProjectListsArr[i];
				long projectId = Long.parseLong(assignProjectListsArr[i]);
				String projectDescription = ParamUtil.getString(request, nameProjectDescription, StringPool.BLANK);
				String startDate = ParamUtil.getString(request, nameStartdate, StringPool.BLANK);
				String endDate = ParamUtil.getString(request, nameEnddate, StringPool.BLANK);
				_log.info("ProjectId : " + projectId);
				_log.info("nameStartdate : " + nameStartdate + " nameEnddate : " + nameEnddate);
				_log.info("startDate : " + startDate + " endDate : " + endDate);
				Date startDate1 = null;
				Date endDate1 = null;
				try {
					getProjectMasterObj = AppraisalProjectMasterLocalServiceUtil
							.findBySettingIdAndEmployeeIdProjectInfo(setup.getAppraisalSettingId(), emp.getEmployeeId(),
									projectId);
					if (Validator.isNotNull(startDate)) {
						startDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
					}
					if (Validator.isNotNull(endDate)) {
						endDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (appraisalMasterObj != null) {
					if (getProjectMasterObj != null) {
						_log.info("========== in side else project info:======");
						_log.info("performancelist>>><<<<< : " + assignProjectListsArr[i]);

						getProjectMasterObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
						getProjectMasterObj.setAppraisalSettingId(setup.getAppraisalSettingId());
						getProjectMasterObj.setEmployeeId(emp.getEmployeeId());
						getProjectMasterObj.setProjectId(projectId);

						if (Validator.isNull(projectDescription)) {
							errorListProject.add("Project Information is Mandatory");
						} else {
							getProjectMasterObj.setProjectDescription(projectDescription);
						}
						if (Validator.isNull(startDate1)) {
							errorListProject.add("Project Information is Mandatory");
						} else {
							getProjectMasterObj.setStartDate(startDate1);
						}
						if (Validator.isNull(endDate1)) {
							errorListProject.add("Project Information is Mandatory");
						} else {
							getProjectMasterObj.setEndDate(endDate1);
						}
						if (sumbitVal == 1) {
							getProjectMasterObj.setSubmitStep(saveAndSubmit);
						} else {
							getProjectMasterObj.setSubmitStep(saveAsDraft);
						}
						if (errorListProject.size() == 0) {
							if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
									|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
									|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
									|| (curDate.equals(fromDateSubmission) && curDate.equals(toDateSubmission)))) {
								appraisalProjectMasterObj = AppraisalProjectMasterLocalServiceUtil
										.updateAppraisalProjectMaster(getProjectMasterObj);
							}
						}

					} else {
						_log.info("========== in side else project info:======");
						/*
						 * for( int i = 0; i <= assignProjectList.length-1 ;
						 * i++){
						 */

						long projectInfoId = CounterLocalServiceUtil.increment(AppraisalProjectMaster.class.getName());
						addProjectMasterObj = AppraisalProjectMasterLocalServiceUtil
								.createAppraisalProjectMaster(projectInfoId);
						addProjectMasterObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
						addProjectMasterObj.setAppraisalSettingId(setup.getAppraisalSettingId());
						addProjectMasterObj.setEmployeeId(emp.getEmployeeId());
						addProjectMasterObj.setProjectId(projectId);

						if (Validator.isNull(projectDescription)) {
							errorListProject.add("Project Information is Mandatory");
						} else {
							addProjectMasterObj.setProjectDescription(projectDescription);
						}

						if (Validator.isNull(startDate1)) {
							errorListProject.add("Project Information is Mandatory");
						} else {
							addProjectMasterObj.setStartDate(startDate1);
						}

						if (Validator.isNull(endDate1)) {
							errorListProject.add("Project Information is Mandatory");
						} else {
							addProjectMasterObj.setEndDate(endDate1);
						}

						if (sumbitVal == 1) {
							addProjectMasterObj.setSubmitStep(saveAndSubmit);
						} else {
							addProjectMasterObj.setSubmitStep(saveAsDraft);
						}
						/*
						 * if (curDate.after(fromDateSubmission) &&
						 * curDate.before(toDateSubmission)) {
						 */
						if (errorListProject.size() == 0) {
							if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
									|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
									|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
									|| (curDate.equals(fromDateSubmission) && curDate.equals(toDateSubmission)))) {
								appraisalProjectMasterObj = AppraisalProjectMasterLocalServiceUtil
										.addAppraisalProjectMaster(addProjectMasterObj);
							}
						}
					}
				}

				// Goal Master details

				List<GoalMaster> goalMasterList = new ArrayList<GoalMaster>();
				goalMasterList = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);

				if (appraisalMasterObj != null) {
					if (errorListProject.size() == 0) {
						for (GoalMaster goalObj : goalMasterList) {

							AppraisalGoalMaster addAppraisalGoalMasterObj = null;
							long goalId = goalObj.getGoalId(); // evaluationId
							String nameGoalCommentEmp = "commentEmp_" + projectId + "_" + goalId;
							String namegoalEmpOverallRat = "goalEmpOverallRat_" + projectId + "_" + goalId;
							String goalCommentEmp = ParamUtil.getString(request, nameGoalCommentEmp, StringPool.BLANK);
							String goalEmpOverallRat = ParamUtil.getString(request, namegoalEmpOverallRat,
									StringPool.BLANK);

							try {
								getGoalMasterObj = AppraisalGoalMasterLocalServiceUtil.findByApprIdEmpIdProjIdEvalId(
										appraisalMasterObj.getAppraisalId(), emp.getEmployeeId(), projectId, goalId);
							} catch (Exception e) {
								// TODO: handle exception
							}

							if (getGoalMasterObj != null) {

								getGoalMasterObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
								getGoalMasterObj
										.setAppraisalProjectId(appraisalProjectMasterObj.getAppraisalProjectId());
								getGoalMasterObj.setEmployeeId(emp.getEmployeeId());
								getGoalMasterObj.setProjectId(projectId);
								getGoalMasterObj.setEvaluationId(goalId); // Goal
																			// Id
								if (Validator.isNull(goalCommentEmp)) {
									errorListGoal.add("Goal is mandatory");
								} else {
									getGoalMasterObj.setEmployeeComment(goalCommentEmp);
								}

								if (Validator.isNull(goalEmpOverallRat)) {
									errorListGoal.add("Goal is mandatory");
								} else {
									getGoalMasterObj.setEmployeeOverallRat(Long.parseLong(goalEmpOverallRat));
								}
								/*
								 * if (curDate.after(fromDateSubmission) &&
								 * curDate.before(toDateSubmission)) {
								 */
								if (errorListGoal.size() == 0) {
									if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
											|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
											|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
											|| (curDate.equals(fromDateSubmission)
													&& curDate.equals(toDateSubmission)))) {
										addAppraisalGoalMasterObj = AppraisalGoalMasterLocalServiceUtil
												.updateAppraisalGoalMaster(getGoalMasterObj);
									}
								}
							} else {

								long appraisalGoalId = CounterLocalServiceUtil
										.increment(AppraisalGoalMaster.class.getName());
								AppraisalGoalMaster addGoalMasterObj = AppraisalGoalMasterLocalServiceUtil
										.createAppraisalGoalMaster(appraisalGoalId);
								addGoalMasterObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
								addGoalMasterObj
										.setAppraisalProjectId(appraisalProjectMasterObj.getAppraisalProjectId());
								addGoalMasterObj.setEmployeeId(emp.getEmployeeId());
								addGoalMasterObj.setProjectId(projectId);
								addGoalMasterObj.setEvaluationId(goalId); // Goal
																			// Id
								if (Validator.isNull(goalCommentEmp)) {
									errorListGoal.add("Goal is mandatory");
								} else {
									addGoalMasterObj.setEmployeeComment(goalCommentEmp);
								}

								if (Validator.isNull(goalEmpOverallRat)) {
									errorListGoal.add("Goal is mandatory");
								} else {
									addGoalMasterObj.setEmployeeOverallRat(Long.parseLong(goalEmpOverallRat));
								}
								/*
								 * if (curDate.after(fromDateSubmission) &&
								 * curDate.before(toDateSubmission)) {
								 */
								if (errorListGoal.size() == 0) {
									if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
											|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
											|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
											|| (curDate.equals(fromDateSubmission)
													&& curDate.equals(toDateSubmission)))) {
										addAppraisalGoalMasterObj = AppraisalGoalMasterLocalServiceUtil
												.addAppraisalGoalMaster(addGoalMasterObj);
									}
								}
							}

							// Goal Master details

							List<GoalDetails> goalDetailsList = new ArrayList<GoalDetails>();
							goalDetailsList = GoalDetailsLocalServiceUtil.findByGoalId(goalId);
							if (errorListGoal.size() == 0) {
								for (GoalDetails goalDetailsObj : goalDetailsList) {

									AppraisalGoalDetails addAppraisalGoalDetailsObj = null;
									String nameRatingIdEmp = "goalEmpRat_" + projectId + "_" + goalId + "_"
											+ goalDetailsObj.getGoaldetailId();
									String ratingIdEmp = ParamUtil.getString(request, nameRatingIdEmp,
											StringPool.BLANK);

									try {
										getGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
												.findByApprIdEmpIdProjIdEvalIdGoalDetId(
														appraisalMasterObj.getAppraisalId(), emp.getEmployeeId(),
														projectId, goalId, goalDetailsObj.getGoaldetailId());
									} catch (Exception e) {
										// TODO: handle exception
									}

									if (getGoalDetailsObj != null) {

										getGoalDetailsObj.setAppraisalGoalMasterId(
												addAppraisalGoalMasterObj.getAppraisalGoalMasterId());
										getGoalDetailsObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
										getGoalDetailsObj.setEmployeeId(emp.getEmployeeId());
										getGoalDetailsObj.setProjectId(projectId);
										getGoalDetailsObj.setEvaluationId(goalId); // Goal
																					// Id
										getGoalDetailsObj.setGoaldetailId(goalDetailsObj.getGoaldetailId());
										if (Validator.isNotNull(ratingIdEmp)) {
											getGoalDetailsObj.setRatingIdEmp(Long.parseLong(ratingIdEmp));
										}
										/*
										 * if (curDate.after(fromDateSubmission)
										 * && curDate.before(toDateSubmission))
										 * {
										 */
										if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
												|| (curDate.after(fromDateSubmission)
														&& curDate.equals(toDateSubmission))
												|| (curDate.equals(fromDateSubmission)
														&& curDate.before(toDateSubmission))
												|| (curDate.equals(fromDateSubmission)
														&& curDate.equals(toDateSubmission)))) {
											addAppraisalGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
													.updateAppraisalGoalDetails(getGoalDetailsObj);
										}
									} else {

										long appraisalGoalDetailsId = CounterLocalServiceUtil
												.increment(AppraisalGoalMaster.class.getName());
										AppraisalGoalDetails addGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
												.createAppraisalGoalDetails(appraisalGoalDetailsId);
										addGoalDetailsObj.setAppraisalGoalMasterId(
												addAppraisalGoalMasterObj.getAppraisalGoalMasterId());
										addGoalDetailsObj.setAppraisalId(appraisalMasterObj.getAppraisalId());
										addGoalDetailsObj.setEmployeeId(emp.getEmployeeId());
										addGoalDetailsObj.setProjectId(projectId);
										addGoalDetailsObj.setEvaluationId(goalId); // Goal
																					// Id
										addGoalDetailsObj.setGoaldetailId(goalDetailsObj.getGoaldetailId());
										if (Validator.isNotNull(ratingIdEmp)) {
											addGoalDetailsObj.setRatingIdEmp(Long.parseLong(ratingIdEmp));
										}
										/*
										 * if (curDate.after(fromDateSubmission)
										 * && curDate.before(toDateSubmission))
										 * {
										 */
										if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
												|| (curDate.after(fromDateSubmission)
														&& curDate.equals(toDateSubmission))
												|| (curDate.equals(fromDateSubmission)
														&& curDate.before(toDateSubmission))
												|| (curDate.equals(fromDateSubmission)
														&& curDate.equals(toDateSubmission)))) {
											addAppraisalGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
													.addAppraisalGoalDetails(addGoalDetailsObj);
										}
									}

								}
							} else {
								System.out.println("errorListGoal :" + errorListGoal);
								request.setAttribute("currTabs", "Project Information");
								SessionErrors.add(request, "add-error-Goal");
								SessionMessages.add(request, PortalUtil.getPortletId(request)
										+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
								response.setWindowState(WindowState.NORMAL);
								response.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
							}
						}
					} else {
						System.out.println("errorListProject :" + errorListProject);
						request.setAttribute("currTabs", "Project Information");
						SessionErrors.add(request, "add-error-project");
						SessionMessages.add(request, PortalUtil.getPortletId(request)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						response.setWindowState(WindowState.NORMAL);
						response.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
					}
				}

			}
		}
		if ((errorListGoal.size() == 0 && errorListGoal.isEmpty())
				&& (errorListProject.size() == 0 && errorListProject.isEmpty())) {
			if (getMasterObj != null) {
				if (sumbitVal == 1) {
					getMasterObj.setSubmitStep(saveAndSubmit);
				} else {
					getMasterObj.setSubmitStep(saveAsDraft);
				}
				appraisalMasterObj = AppraisalMasterLocalServiceUtil.updateAppraisalMaster(getMasterObj);
			} else {
				if (sumbitVal == 1) {
					addMasterObj.setSubmitStep(saveAndSubmit);
				} else {
					addMasterObj.setSubmitStep(saveAsDraft);
				}
				appraisalMasterObj = AppraisalMasterLocalServiceUtil.updateAppraisalMaster(addMasterObj);
			}
		}
	}

	public void addProject(ActionRequest request, ActionResponse response) {
		System.out.println("Call Method of Add Project");
		long projectId = ParamUtil.getLong(request, "projectId");
		long employeeId = ParamUtil.getLong(request, "employeeId");
		long appraisalSettingId = ParamUtil.getLong(request, "appraisalSettingId");
		AppraisalMaster appraisalMaster = null;
		if (Validator.isNotNull(employeeId) && Validator.isNotNull(appraisalSettingId)) {
			appraisalMaster = AppraisalMasterLocalServiceUtil.findBySettingIdAndEmployeeId(appraisalSettingId,
					employeeId);
		}
		System.out.println("appraisalMaster : " + appraisalMaster);
		if (Validator.isNull(appraisalMaster)) {
			long appraisalId = CounterLocalServiceUtil.increment(AppraisalMaster.class.getName());
			AppraisalMaster addMasterObj = AppraisalMasterLocalServiceUtil.createAppraisalMaster(appraisalId);
			addMasterObj.setAppraisalSettingId(appraisalSettingId);
			addMasterObj.setEmployeeId(employeeId);
			appraisalMaster = AppraisalMasterLocalServiceUtil.addAppraisalMaster(addMasterObj);
			System.out.println("Add appraisal Master Successfully");
		}

		AppraisalProjectMaster appraisalProjectMaster = null;
		if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
				&& Validator.isNotNull(appraisalSettingId)) {
			appraisalProjectMaster = AppraisalProjectMasterLocalServiceUtil
					.findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId, employeeId, projectId);
		}
		System.out.println("appraisalProjectMaster : " + appraisalProjectMaster);

		if (Validator.isNull(appraisalProjectMaster)) {
			long appraisalProjectMasterId = CounterLocalServiceUtil.increment(AppraisalProjectMaster.class.getName());
			appraisalProjectMaster = AppraisalProjectMasterLocalServiceUtil
					.createAppraisalProjectMaster(appraisalProjectMasterId);
			appraisalProjectMaster.setAppraisalId(appraisalMaster.getAppraisalId());
			appraisalProjectMaster.setProjectId(projectId);
			appraisalProjectMaster.setEmployeeId(employeeId);
			appraisalProjectMaster.setAppraisalSettingId(appraisalSettingId);
			AppraisalProjectMasterLocalServiceUtil.addAppraisalProjectMaster(appraisalProjectMaster);
			System.out.println("Add Projects Successfully");
		}
	}

	public void deleteProject(ActionRequest request, ActionResponse response) {
		System.out.println("Call Method of Delete Project");
		long projectId = ParamUtil.getLong(request, "projectId");
		long employeeId = ParamUtil.getLong(request, "employeeId");
		long appraisalSettingId = ParamUtil.getLong(request, "appraisalSettingId");

		AppraisalProjectMaster appraisalProjectMaster = null;
		if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
				&& Validator.isNotNull(appraisalSettingId)) {
			appraisalProjectMaster = AppraisalProjectMasterLocalServiceUtil
					.findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId, employeeId, projectId);
		}
		System.out.println("appraisalProjectMaster : " + appraisalProjectMaster);
		if (Validator.isNotNull(appraisalProjectMaster)) {
			AppraisalProjectMasterLocalServiceUtil.deleteAppraisalProjectMaster(appraisalProjectMaster);
			System.out.println("Delete Projects Successfully");
		}

	}

	public static void main(String args[]) throws ParseException {
		Date curDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strcurDate = dateFormat.format(curDate);

		_log.info("curDate : " + curDate);
		String fromDateSubmission = "10/07/2018";
		String toDateSubmission = "16/07/2018";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromDateSubmission);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(toDateSubmission);
		Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse(strcurDate);
		_log.info("date3 : " + date3);
		_log.info("date2 : " + date2);
		if (date2.compareTo(curDate) == 0) {
			_log.info("no date");
		}
		if (date2.equals(date3)) {
			_log.info("no1 date");
		}
		if (date3.after(date1) && date3.before(date2) || date3.after(date1) && date3.equals(date2)) {
			_log.info("currdate  : ");
		}
	}

}