package com.liferay.famocom.erpcloud.managerappraisal.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.liferay.famocom.erpcloud.appraisal.model.ManageAppraisalModel;
import com.liferay.famocom.erpcloud.appraisal.util.ManageAppraisalUtils;
import com.liferay.famocom.erpcloud.managerappraisal.constants.ManagerAppraisalViewPortletKeys;
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;
import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.GoalDetails;
import com.liferay.famocom.erpcloud.model.GoalMaster;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil;
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
 * @author Samaresh Barui
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=ManagerAppraisalView Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ManagerAppraisalViewPortletKeys.ManagerAppraisalView,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ManagerAppraisalViewPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ManagerAppraisalViewPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.info("=====render method called=====");
		// ThemeDisplay themeDisplay = (ThemeDisplay)
		// renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String jspPage = ParamUtil.getString(renderRequest, "jspPage", StringPool.BLANK);
		System.out.println("jspPage..." + jspPage);

		if (Validator.isNotNull(jspPage) && jspPage.equalsIgnoreCase("/META-INF/resources/viewSelectedEmp.jsp")) {
			long employeeId = ParamUtil.getLong(renderRequest, "employeeId");

			long isActive = ManagerAppraisalViewPortletKeys.AppraisalSettingActive;
			System.out.println("Called..." + employeeId);
			AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
			System.out.println("setup: " + setup);
			AppraisalMaster getMasterObj = null;
			System.out.println(".....................: ");
			try {
				System.out.println("...........In side try..........: ");
				getMasterObj = AppraisalMasterLocalServiceUtil
						.findBySettingIdAndEmployeeIds(setup.getAppraisalSettingId(), employeeId);
				System.out.println("getMasterObj.getOverallRatingEmp()>>>>>> " + getMasterObj.getOverallRatingEmp());
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (Validator.isNotNull(jspPage) && jspPage.equalsIgnoreCase("/META-INF/resources/viewSelectedEmp.jsp")) {
				_log.info("=====rendering view page=====");
				try {
					ManageAppraisalModel manageAppraisalModel = ManageAppraisalUtils
							.getEmployeeAppraisalDetails(employeeId);
					if (Validator.isNotNull(manageAppraisalModel)) {
						renderRequest.setAttribute("manageAppraisalModel", manageAppraisalModel);
					}
					if (Validator.isNotNull(getMasterObj)) {
						renderRequest.setAttribute("getMasterObj", getMasterObj);
					}

				} catch (Exception e) {
					_log.error(ManagerAppraisalViewPortletKeys.EXCEPTION + e);
				}
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

		Employee empObj = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());

		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);
		httpResponse.flushBuffer();
		httpResponse.setContentType("html/text");

		long projectId = ParamUtil.getLong(resourceRequest, "projectId", 0);
		long employeeId = ParamUtil.getLong(resourceRequest, "employeeId", 0);
		long appraisalSettingId = ParamUtil.getLong(resourceRequest, "appraisalSettId", 0);
		String projectDesc = StringPool.BLANK;
		String startDate = StringPool.BLANK;
		String endDate = StringPool.BLANK;

		// Appraisal Master
		AppraisalMaster getMasterObj = null;
		String disable = StringPool.BLANK;
		if (Validator.isNotNull(employeeId) && Validator.isNotNull(appraisalSettingId)) {
			getMasterObj = AppraisalMasterLocalServiceUtil.findBySettingIdAndEmployeeIds(appraisalSettingId,
					employeeId);
		}
		AppraisalProjectMaster appProMasObj = null;
		if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
				&& Validator.isNotNull(appraisalSettingId)) {
			appProMasObj = AppraisalProjectMasterLocalServiceUtil
					.findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId, employeeId, projectId);
			System.out.println("=========appProMasObj============" + appProMasObj);

			if (appProMasObj.getSubmitStep() == 2 || appProMasObj.getSubmitStep() == 3) {
				disable = "disabled";
			}

			projectDesc = appProMasObj.getProjectDescription();
			if (Validator.isNotNull(appProMasObj.getStartDate())) {
				startDate = df.format(appProMasObj.getStartDate());
			}
			if (Validator.isNotNull(appProMasObj.getEndDate())) {
				endDate = df.format(appProMasObj.getEndDate());
			}
		}

		AddTeamMember addTMObj = null;
		if (empObj != null) {
			addTMObj = AddTeamMemberLocalServiceUtil.findByGetProjectManager(empObj.getEmployeeId(), projectId);
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
							+ "<th class='text-center'>Employee�s Rating</th>"
							+ "<th class='text-center'>Manager�s Rating</th>" + "</tr>" + "</thead>"
							+ "<tbody id='custom-table'>";
					goalDetailsFooterHtml = "</tbody>" + "</table>";

					ProjectMaster projectMaster = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);

					if (addTMObj != null && addTMObj.getIsProjectManager()) {

						if (Validator.isNotNull(projectMaster)) {

							goalHtmlHeader = "<div class='col-xs-12 col-md-12 panel panel-primary' id='project_panel_'"
									+ projectMaster.getProjectId() + ">"
									+ "<div class='panel-heading clearfix'>Project name:-"
									+ projectMaster.getProjectName() + "<div class='btn-group pull-right'>"
									+ "<a href='#project_" + projectMaster.getProjectId()
									+ "' class='btn btn-default btn-sm collapsed' data-toggle='collapse' data-parent='#accordion' aria-expanded='false'></a>"
									+ "</div>" + "</div>" + "<div id='project_" + projectMaster.getProjectId()
									+ "' class='panel-body collapse' aria-expanded='false' style='height: 30px;'>"
									+ "<input type='hidden' name='projectId_" + projectMaster.getProjectId()
									+ "' value='" + projectMaster.getProjectId() + "'>"
									+ "<div class='col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0'>"
									+ "<div class='form-group float-label-control'>" + "<p>Job Description</p>"
									+ "<textarea id='_" + portletId + "_pojectDescription' disabled='disabled' value='"
									+ projectDesc + "' name='_" + portletId + "_projectDescription_"
									+ projectMaster.getProjectId()
									+ "' class='fs_input custom-full' placeholder='Job Description'>" + projectDesc
									+ "</textarea>" + "</div>" + "</div>"
									+ "<div class='col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0'>"
									+ "<div class='col-md-6 col-sm-6 col-xs-12'>" + "<p>Start Date</p>"
									+ "<div class='form-group'>" + "<input id='_" + portletId
									+ "_startdate'  disabled='disabled' name='_" + portletId + "_startdate_"
									+ projectMaster.getProjectId() + "' value='" + startDate
									+ "' type='text' placeholder='Start Date' class='fs_input dateinput' style='font-size: 14px !important;'>"
									+ "</div></div>" + "<div class='col-md-6 col-sm-6 col-xs-12'>" + "<p>End Date</p>"
									+ "<div class='form-group'>" + "<input id='_" + portletId
									+ "_enddate'  disabled='disabled' name='_" + portletId + "_enddate_"
									+ projectMaster.getProjectId() + "' value='" + endDate
									+ "' type='text' placeholder='End Date' class='fs_input dateinput' style='font-size: 14px !important;'>"
									+ "</div></div></div>";

							List<GoalMaster> goalMasters = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);
							if (Validator.isNotNull(goalMasters) && !goalMasters.isEmpty()) {
								for (GoalMaster goalMaster : goalMasters) {

									AppraisalGoalMaster appGoalMasObj = null;
									String getGoalMasterEmpComment = StringPool.BLANK;
									String getGoalMasterManComment = StringPool.BLANK;
									long getGoalMasterEmpRating = 0;
									long getGoalMasterManRating = 0;
									System.out.println("goalMaster.getGoalId()..." + goalMaster.getGoalId());
									if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
											&& Validator.isNotNull(appraisalSettingId)
											&& Validator.isNotNull(goalMaster.getGoalId())) {
										appGoalMasObj = AppraisalGoalMasterLocalServiceUtil
												.findByApprIdEmpIdProjIdEvalId(appProMasObj.getAppraisalId(),
														employeeId, projectId, goalMaster.getGoalId());
										System.out.println("=========appGoalMasObj============" + appGoalMasObj);
										projectDesc = appProMasObj.getProjectDescription();
										if (Validator.isNotNull(appGoalMasObj.getEmployeeComment())) {
											getGoalMasterEmpComment = appGoalMasObj.getEmployeeComment();
										}
										if (Validator.isNotNull(appGoalMasObj.getManagerComment())) {
											getGoalMasterManComment = appGoalMasObj.getManagerComment();
										}
										if (Validator.isNotNull(appGoalMasObj.getEmployeeOverallRat())) {
											getGoalMasterEmpRating = appGoalMasObj.getEmployeeOverallRat();
										}
										if (Validator.isNotNull(appGoalMasObj.getManagerOverallRat())) {
											getGoalMasterManRating = appGoalMasObj.getManagerOverallRat();
										}
									}

									String ratingGoalMasterOverallEmpOption = StringPool.BLANK;
									String ratingGoalMasterOverallManOption = StringPool.BLANK;
									if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {

										for (RatingMaster ratingMaster : ratingMasters) {
											String selectedEmp = StringPool.BLANK;
											String selectedMan = StringPool.BLANK;
											if (ratingMaster.getRatingId() == getGoalMasterEmpRating) {
												selectedEmp = "selected";
												System.out.println("====ratingMaster.getRatingId()==="
														+ ratingMaster.getRatingId() + "====getGoalMasterEmpRating==="
														+ getGoalMasterEmpRating);
											}
											if (ratingMaster.getRatingId() == getGoalMasterManRating) {
												selectedMan = "selected";
												System.out.println("====ratingMaster.getRatingId()==="
														+ ratingMaster.getRatingId() + "====getGoalMasterManRating==="
														+ getGoalMasterManRating);
											}
											ratingGoalMasterOverallEmpOption = ratingGoalMasterOverallEmpOption
													+ "<option value='" + ratingMaster.getRatingId() + "' "
													+ selectedEmp + " >" + "" + ratingMaster.getRatingKey() + "-"
													+ ratingMaster.getRatingNum() + "" + "</option>";
											ratingGoalMasterOverallManOption = ratingGoalMasterOverallManOption
													+ "<option value='" + ratingMaster.getRatingId() + "' "
													+ selectedMan + " >" + "" + ratingMaster.getRatingKey() + "-"
													+ ratingMaster.getRatingNum() + "" + "</option>";
											System.out.println("ratingGoalOverallEmpOption====>>>> : "
													+ ratingGoalMasterOverallManOption);
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
											long getGoalDetailsManRating = 0;

											if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
													&& Validator.isNotNull(appraisalSettingId)
													&& Validator.isNotNull(goalMaster.getGoalId())
													&& Validator.isNotNull(gDetails.getGoaldetailId())) {
												appGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
														.findByApprIdEmpIdProjIdEvalIdGoalDetId(
																appProMasObj.getAppraisalId(), employeeId, projectId,
																goalMaster.getGoalId(), gDetails.getGoaldetailId());

												System.out
														.println("=========appGoalMasObj============" + appGoalMasObj);
												projectDesc = appProMasObj.getProjectDescription();
												if (Validator.isNotNull(appGoalDetailsObj.getRatingIdEmp())) {
													getGoalDetailsEmpRating = appGoalDetailsObj.getRatingIdEmp();
												}
												if (Validator.isNotNull(appGoalDetailsObj.getRatingIdMan())) {
													getGoalDetailsManRating = appGoalDetailsObj.getRatingIdMan();
												}
											}

											String ratingGoalDetailsEmpOption = StringPool.BLANK;
											String ratingGoalDetailsManOption = StringPool.BLANK;
											if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {

												for (RatingMaster ratingMaster : ratingMasters) {
													String selectedEmp = StringPool.BLANK;
													String selectedMan = StringPool.BLANK;
													if (ratingMaster.getRatingId() == getGoalDetailsEmpRating) {
														selectedEmp = "selected";
														System.out.println("====ratingMaster.getRatingId()==="
																+ ratingMaster.getRatingId()
																+ "====ratingGoalDetailsEmpOption==="
																+ getGoalDetailsEmpRating);
													}
													if (ratingMaster.getRatingId() == getGoalDetailsManRating) {
														selectedMan = "selected";
														System.out.println("====ratingMaster.getRatingId()==="
																+ ratingMaster.getRatingId()
																+ "====ratingGoalDetailsEmpOption==="
																+ getGoalDetailsEmpRating);
													}
													ratingGoalDetailsEmpOption = ratingGoalDetailsEmpOption
															+ "<option value='" + ratingMaster.getRatingId() + "' "
															+ selectedEmp + " >" + "" + ratingMaster.getRatingKey()
															+ "-" + ratingMaster.getRatingNum() + "" + "</option>";
													ratingGoalDetailsManOption = ratingGoalDetailsManOption
															+ "<option value='" + ratingMaster.getRatingId() + "' "
															+ selectedMan + " >" + "" + ratingMaster.getRatingKey()
															+ "-" + ratingMaster.getRatingNum() + "" + "</option>";
													System.out.println("ratingGoalDetailsEmpOption====>>>> : "
															+ ratingGoalDetailsEmpOption);
												}
											}

											goalDetailsBodyHtml += "<tr>" + "<td class='text-left '>" + ++slNo + "</td>"
													+ "<td class='text-left '>" + gDetails.getParameter() + "</td>"
													+ "<td class='text-left '>" + gDetails.getScale() + "</td>"
													+ "<td class='text-left '>" + "<select id='_" + portletId
													+ "_goalEmpRat'  disabled='disabled' name='_" + portletId
													+ "_goalEmpRat_" + projectMaster.getProjectId() + "_"
													+ goalMaster.getGoalId() + "_" + gDetails.getGoaldetailId()
													+ "' class='fs_input custom-full'>"
													+ "<option value='0'>Select Rating</option> " + "'"
													+ ratingGoalDetailsEmpOption + "'" + "</select>" + "</td>"
													+ "<td class='text-left '>" + "<select id='_" + portletId
													+ "_goalManRat' " + disable + " name='_" + portletId
													+ "_goalManRat_" + projectMaster.getProjectId() + "_"
													+ goalMaster.getGoalId() + "_" + gDetails.getGoaldetailId()
													+ "' class='fs_input custom-full' >"
													+ "<option value='0'>Select Rating</option> " + "'"
													+ ratingGoalDetailsManOption + "'" + "</select>" + "</td>"
													+ "</tr>";
										}

										goalDetailsHtml = goalDetailsHeaderHtml + goalDetailsBodyHtml
												+ goalDetailsFooterHtml + "<hr>";
									} else {

										goalDetailsHtml = StringPool.BLANK;
									}

									goalHtml = goalHtml

											+ "<div class='col-xs-12 col-md-12' style='padding-top: 15px;'>"
											+ "<div class='panel panel-info '>"
											+ "<div class='panel-heading'>Goal</div>" + "<div class='panel-body'>"
											+ "<div class='col-lg-12 col-sm-12 col-xs-12 margintop10 paddingleft0'>"
											+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0'>"
											+ "<h4><strong>Goal Name:</strong>&nbsp;" + goalMaster.getGoalName() + ""
											+ "</h4>" + "</div>"
											+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0'>"
											+ "<h4><strong>Goal Description:</strong>&nbsp;"
											+ goalMaster.getGoalDescription() + "" + "</h4></div>" + goalDetailsHtml
											+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0' style=''>"
											+ "<div class='form-group'>" + "<p>Employee's Comments:</p>"
											+ "<textarea id='_" + portletId + "_commentEmp' disabled='disabled' name='_"
											+ portletId + "_commentEmp_" + projectMaster.getProjectId() + "_"
											+ goalMaster.getGoalId()
											+ "' class='fs_input custom-full' placeholder='Employee's Comments'>"
											+ getGoalMasterEmpComment + "</textarea>" + "</div>"
											+ "<div class='form-group'>" + "<p>Overall Goal Rating by Employee:</p>"
											+ "<select id='_" + portletId
											+ "_goalEmpOverallRat' disabled='disabled' name='_" + portletId
											+ "_goalEmpOverallRat_" + projectMaster.getProjectId() + "_"
											+ goalMaster.getGoalId() + "' class='fs_input custom-full'>"
											+ "<option value='0'>Select Rating</option>" + "'"
											+ ratingGoalMasterOverallEmpOption + "'" + "</select>" + "</div></div>"
											+ "<div class='col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0' style=''>"
											+ "<div class='form-group'>" + "<p>Manager's Comments:</p>"
											+ "<textarea id='_" + portletId + "_commentMan' " + disable + " name='_"
											+ portletId + "_commentMan_" + projectMaster.getProjectId() + "_"
											+ goalMaster.getGoalId()
											+ "' class='fs_input custom-full' placeholder='Manager's Comments' >"
											+ getGoalMasterManComment + "</textarea>" + "</div>"
											+ "<div class='form-group'>" + "<p>Overall Goal Rating by Manager:</p>"
											+ "<select id='_" + portletId + "_goalManOverallRat' " + disable
											+ " name='_" + portletId + "_goalManOverallRat_"
											+ projectMaster.getProjectId() + "_" + goalMaster.getGoalId()
											+ "' class='fs_input custom-full' >"
											+ "<option value='0'>Select Rating</option>" + "'"
											+ ratingGoalMasterOverallManOption + "'" + "</select>" + "</div>" + "</div>"
											+ "</div>" + "</div>" + "</div>" + "</div>";

								}
							}

							jsonObject.put("data", goalHtmlHeader + goalHtml);
							jsonObject.put("status", ManagerAppraisalViewPortletKeys.SUCCESS);
						} else {
							jsonObject.put("status", ManagerAppraisalViewPortletKeys.ERROR);
						}
					}
				} catch (PortalException e) {
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
	public void apprisalAction(ActionRequest request, ActionResponse response) throws WindowStateException {
		_log.info("============= Appraisal Action ==============");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> errorList = new ArrayList<String>();
		long employeeId = ParamUtil.getLong(request, "employeeId");
		long managerId = ParamUtil.getLong(request, "managerId");
		String[] assignProjectList = ParamUtil.getParameterValues(request, "assignProjectList");
		String projectLists = ParamUtil.getString(request, "assignProjectList", StringPool.BLANK);
		String assignProjectListsArr[] = projectLists.split(",");
		System.out.println("projectLists : " + projectLists);

		String save = ParamUtil.getString(request, "save", StringPool.BLANK);
		System.out.println("========== save:======" + save);

		long isActive = ManagerAppraisalViewPortletKeys.AppraisalSettingActive;
		long finalSubmit = ManagerAppraisalViewPortletKeys.AppraisalManagerFinalSubmmit;

		AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
		_log.info("========== setup:======" + setup);
		AppraisalMaster getMasterObj = null;
		AppraisalProjectMaster getProjectMasterObj = null;
		AppraisalGoalMaster getGoalMasterObj = null;
		AppraisalGoalDetails getGoalDetailsObj = null;
		try {
			getMasterObj = AppraisalMasterLocalServiceUtil.findBySettingIdAndEmployeeIds(setup.getAppraisalSettingId(),
					employeeId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("========== getMasterObj:======" + getMasterObj);

		// appraisal master details

		AppraisalMaster addMasterObj = null;
		AppraisalMaster appraisalMasterObj = null;
		AppraisalProjectMaster appraisalProjectMasterObj = null;

		if (getMasterObj != null) {
			System.out.println("========== in side if master:======");
			appraisalMasterObj = AppraisalMasterLocalServiceUtil.updateAppraisalMaster(getMasterObj);
		}

		if (Validator.isNotNull(projectLists)) {
			for (int i = 0; i <= assignProjectList.length - 1; i++) {
				_log.info("assignProjectList>>><<<<< : " + assignProjectListsArr[i]);
				long projectId = Long.parseLong(assignProjectListsArr[i]);
				System.out.println("ProjectId : " + projectId);
				try {
					getProjectMasterObj = AppraisalProjectMasterLocalServiceUtil
							.findBySettingIdAndEmployeeIdProjectInfo(setup.getAppraisalSettingId(), employeeId,
									projectId);
					/*
					 * if(getProjectMasterObj!=null){
					 * getProjectMasterObj.setSubmitStep(finalSubmit);
					 * appraisalProjectMasterObj =
					 * AppraisalProjectMasterLocalServiceUtil.
					 * updateAppraisalProjectMaster(getProjectMasterObj); }
					 */
				} catch (Exception e) {
					e.printStackTrace();
				}

				// Goal Master details

				List<GoalMaster> goalMasterList = new ArrayList<GoalMaster>();
				goalMasterList = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);

				for (GoalMaster goalObj : goalMasterList) {

					AppraisalGoalMaster addAppraisalGoalMasterObj = null;
					long goalId = goalObj.getGoalId(); // evaluationId
					String nameGoalCommentMan = "commentMan_" + projectId + "_" + goalId;
					String namegoalManOverallRat = "goalManOverallRat_" + projectId + "_" + goalId;
					String goalCommentMan = ParamUtil.getString(request, nameGoalCommentMan, StringPool.BLANK);
					String goalManOverallRat = ParamUtil.getString(request, namegoalManOverallRat, StringPool.BLANK);
					System.out.println("goalManOverallRat: "+goalManOverallRat);
					try {
						getGoalMasterObj = AppraisalGoalMasterLocalServiceUtil.findByApprIdEmpIdProjIdEvalId(
								appraisalMasterObj.getAppraisalId(), employeeId, projectId, goalId);
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (getGoalMasterObj != null) {
						if (Validator.isNull(goalCommentMan)) {
							errorList.add("Overall Goal Comment is mandatory for Manager");
						} else {
							getGoalMasterObj.setManagerComment(goalCommentMan);
						}
						if (Validator.isNull(goalManOverallRat)) {
							errorList.add("Overall Goal rating is mandatory for Manager");
						} else {
							getGoalMasterObj.setManagerOverallRat(Long.parseLong(goalManOverallRat));
						}
						if (errorList.size() == 0) {
							addAppraisalGoalMasterObj = AppraisalGoalMasterLocalServiceUtil
									.updateAppraisalGoalMaster(getGoalMasterObj);
						}
					}

					// Goal Master details
					System.out.println("errorList : " + errorList);
					if (errorList.size() == 0) {
						List<GoalDetails> goalDetailsList = new ArrayList<GoalDetails>();
						goalDetailsList = GoalDetailsLocalServiceUtil.findByGoalId(goalId);

						for (GoalDetails goalDetailsObj : goalDetailsList) {
							AppraisalGoalDetails addAppraisalGoalDetailsObj = null;
							String nameRatingIdMan = "goalManRat_" + projectId + "_" + goalId + "_"
									+ goalDetailsObj.getGoaldetailId();
							String ratingIdMan = ParamUtil.getString(request, nameRatingIdMan, StringPool.BLANK);

							try {
								getGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
										.findByApprIdEmpIdProjIdEvalIdGoalDetId(appraisalMasterObj.getAppraisalId(),
												employeeId, projectId, goalId, goalDetailsObj.getGoaldetailId());
							} catch (Exception e) {
								e.printStackTrace();
							}

							if (getGoalDetailsObj != null) {

								getGoalDetailsObj.setGoaldetailId(goalDetailsObj.getGoaldetailId());
								if (Validator.isNotNull(ratingIdMan)) {
									getGoalDetailsObj.setRatingIdMan(Long.parseLong(ratingIdMan));
								}
								addAppraisalGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
										.updateAppraisalGoalDetails(getGoalDetailsObj);
							}

						}
					} else {
						System.out.println("errorlist :" + errorList);
						request.setAttribute("currTabs", "Project Information");
						SessionErrors.add(request, "add-error");
						SessionMessages.add(request, PortalUtil.getPortletId(request)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						response.setWindowState(WindowState.NORMAL);
						response.setRenderParameter("managerId", String.valueOf(managerId));
						response.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
					}

				}

				if (getProjectMasterObj != null) {
					System.out.println("errorList : " + errorList);
					if (errorList.size() == 0) {
						getProjectMasterObj.setSubmitStep(finalSubmit);
						appraisalProjectMasterObj = AppraisalProjectMasterLocalServiceUtil
								.updateAppraisalProjectMaster(getProjectMasterObj);
						if (appraisalProjectMasterObj != null) {
							request.setAttribute("finalSubmit", "finalSubmit");
							response.setWindowState(WindowState.NORMAL);
							response.setRenderParameter("managerId", String.valueOf(managerId));
							response.setRenderParameter("jspPage", "/META-INF/resources/viewSelectedEmp.jsp");
						}
					}
				}

			}
		}
	}

}