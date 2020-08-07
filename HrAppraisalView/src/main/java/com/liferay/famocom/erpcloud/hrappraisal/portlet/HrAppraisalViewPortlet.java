package com.liferay.famocom.erpcloud.hrappraisal.portlet;

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

import com.liferay.famocom.erpcloud.appraisal.model.ManageAppraisalModel;
import com.liferay.famocom.erpcloud.appraisal.util.ManageAppraisalUtils;
import com.liferay.famocom.erpcloud.hrappraisal.constants.HrAppraisalViewPortletKeys;
import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;
import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalPerformance;
import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;
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
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=HrAppraisalView Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HrAppraisalViewPortletKeys.HrAppraisalView,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class HrAppraisalViewPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(HrAppraisalViewPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.info("=====render method called=====");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String jspPage = ParamUtil.getString(renderRequest, "jspPage", StringPool.BLANK);
		System.out.println("jspPage..." + jspPage);
		/*
		 * if (Validator.isNull(jspPage)) { List<AppraisalMaster> amList = new
		 * ArrayList<AppraisalMaster>(); amList=
		 * AppraisalMasterLocalServiceUtil.getAppraisalMasters(-1,-1); if
		 * (Validator.isNotNull(amList) && !amList.isEmpty()) {
		 * renderRequest.setAttribute("amList", amList); } }else
		 */
		if (Validator.isNotNull(jspPage) && jspPage.equalsIgnoreCase("/META-INF/resources/viewSelectedEmp.jsp")) {
			long employeeId = ParamUtil.getLong(renderRequest, "employeeId");

			// Employee employee =
			// EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
			// long employeeId = 1;
			long isActive = HrAppraisalViewPortletKeys.AppraisalSettingActive;
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
				// TODO: handle exception
			}

			/*
			 * if (Validator.isNull(jspPage)) {
			 * 
			 * } else
			 */
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
					// TODO Auto-generated catch block
					_log.error(HrAppraisalViewPortletKeys.EXCEPTION + e);
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
			System.out.println("=========appProMasObj============" + appProMasObj);
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
									appGoalMasObj = AppraisalGoalMasterLocalServiceUtil.findByApprIdEmpIdProjIdEvalId(
											appProMasObj.getAppraisalId(), employeeId, projectId,
											goalMaster.getGoalId());
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
											System.out.println(
													"====ratingMaster.getRatingId()===" + ratingMaster.getRatingId()
															+ "====getGoalMasterEmpRating===" + getGoalMasterEmpRating);
										}
										if (ratingMaster.getRatingId() == getGoalMasterManRating) {
											selectedMan = "selected";
											System.out.println(
													"====ratingMaster.getRatingId()===" + ratingMaster.getRatingId()
															+ "====getGoalMasterManRating===" + getGoalMasterManRating);
										}
										ratingGoalMasterOverallEmpOption = ratingGoalMasterOverallEmpOption
												+ "<option value='" + ratingMaster.getRatingId() + "' " + selectedEmp
												+ " >" + "" + ratingMaster.getRatingKey() + "-"
												+ ratingMaster.getRatingNum() + "" + "</option>";
										ratingGoalMasterOverallManOption = ratingGoalMasterOverallManOption
												+ "<option value='" + ratingMaster.getRatingId() + "' " + selectedMan
												+ " >" + "" + ratingMaster.getRatingKey() + "-"
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

											System.out.println("=========appGoalMasObj============" + appGoalMasObj);
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
														+ selectedEmp + " >" + "" + ratingMaster.getRatingKey() + "-"
														+ ratingMaster.getRatingNum() + "" + "</option>";
												ratingGoalDetailsManOption = ratingGoalDetailsManOption
														+ "<option value='" + ratingMaster.getRatingId() + "' "
														+ selectedMan + " >" + "" + ratingMaster.getRatingKey() + "-"
														+ ratingMaster.getRatingNum() + "" + "</option>";
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
												+ "_goalManRat' disabled='disabled' name='_" + portletId
												+ "_goalManRat_" + projectMaster.getProjectId() + "_"
												+ goalMaster.getGoalId() + "_" + gDetails.getGoaldetailId()
												+ "' class='fs_input custom-full' >"
												+ "<option value='0'>Select Rating</option> " + "'"
												+ ratingGoalDetailsManOption + "'" + "</select>" + "</td>" + "</tr>";
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
										+ portletId + "_commentEmp' disabled='disabled' name='_" + portletId
										+ "_commentEmp_" + projectMaster.getProjectId() + "_" + goalMaster.getGoalId()
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
										+ "<div class='form-group'>" + "<p>Manager's Comments:</p>" + "<textarea id='_"
										+ portletId + "_commentMan' disabled='disabled' name='_" + portletId
										+ "_commentMan_" + projectMaster.getProjectId() + "_" + goalMaster.getGoalId()
										+ "' class='fs_input custom-full' placeholder='Manager's Comments' >"
										+ getGoalMasterManComment + "</textarea>" + "</div>"
										+ "<div class='form-group'>" + "<p>Overall Goal Rating by Manager:</p>"
										+ "<select id='_" + portletId
										+ "_goalManOverallRat' disabled='disabled' name='_" + portletId
										+ "_goalManOverallRat_" + projectMaster.getProjectId() + "_"
										+ goalMaster.getGoalId() + "' class='fs_input custom-full' >"
										+ "<option value='0'>Select Rating</option>" + "'"
										+ ratingGoalMasterOverallManOption + "'" + "</select>" + "</div>" + "</div>"
										+ "</div>" + "</div>" + "</div>" + "</div>";

							}
						}

						jsonObject.put("data", goalHtmlHeader + goalHtml);
						jsonObject.put("status", HrAppraisalViewPortletKeys.SUCCESS);
					} else {
						jsonObject.put("status", HrAppraisalViewPortletKeys.ERROR);
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
	public void apprisalAction(ActionRequest request, ActionResponse response) throws WindowStateException {
		System.out.println("============= Appraisal Action ==============");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> errorList = new ArrayList<String>();
		long employeeId = ParamUtil.getLong(request, "employeeId");

		String accomplishmentsMan = ParamUtil.getString(request, "accomplishmentsMan", StringPool.BLANK);
		String strengthsMan = ParamUtil.getString(request, "strengthsMan", StringPool.BLANK);
		String developmentMan = ParamUtil.getString(request, "developmentMan", StringPool.BLANK);
		String careerMan = ParamUtil.getString(request, "careerMan", StringPool.BLANK);
		String companyValue = ParamUtil.getString(request, "companyValue", StringPool.BLANK);
		String developmentPlan = ParamUtil.getString(request, "developmentPlan", StringPool.BLANK);

		String overallCommentMan = ParamUtil.getString(request, "overallCommentMan", StringPool.BLANK);
		long overallRatMan = ParamUtil.getLong(request, "overallRatMan");

		String[] performanceArr = ParamUtil.getParameterValues(request, "performanceList");
		String performanceLists = ParamUtil.getString(request, "performanceList", StringPool.BLANK);
		String performanceListsArr[] = performanceLists.split(",");

		String[] assignProjectList = ParamUtil.getParameterValues(request, "assignProjectList");
		String projectLists = ParamUtil.getString(request, "assignProjectList", StringPool.BLANK);
		String assignProjectListsArr[] = projectLists.split(",");
		System.out.println("projectLists : " + projectLists);

		String save = ParamUtil.getString(request, "save", StringPool.BLANK);
		System.out.println("========== accomplishmentsEmp:======" + accomplishmentsMan);
		System.out.println("========== strengthsEmp:======" + strengthsMan);
		System.out.println("========== developmentEmp:======" + developmentMan);
		System.out.println("========== careerEmp:======" + careerMan);
		System.out.println("========== save:======" + save);

		long isActive = HrAppraisalViewPortletKeys.AppraisalSettingActive;
		long finalSubmitHr = HrAppraisalViewPortletKeys.AppraisalHrFinalSubmmit;

		AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
		System.out.println("========== setup:======" + setup);
		AppraisalMaster getMasterObj = null;
		AppraisalPerformance getPerformanceObj = null;
		AppraisalProjectMaster getProjectMasterObj = null;
		AppraisalGoalMaster getGoalMasterObj = null;
		AppraisalGoalDetails getGoalDetailsObj = null;
		try {
			getMasterObj = AppraisalMasterLocalServiceUtil.findBySettingIdAndEmployeeIds(setup.getAppraisalSettingId(),
					employeeId); // findBySettingIdAndEmployeeId(setup.getAppraisalSettingId(),
									// emp.getEmployeeId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("========== getMasterObj:======" + getMasterObj);

		// appraisal master details

		AppraisalMaster addMasterObj = null;
		AppraisalMaster appraisalMasterObj = null;

		if (getMasterObj != null) {
			System.out.println("========== in side if master:======");
			getMasterObj.setAppraisalSettingId(setup.getAppraisalSettingId());
			getMasterObj.setEmployeeId(employeeId);

			if (Validator.isNotNull(accomplishmentsMan)) {
				getMasterObj.setAccomplishmentsMan(accomplishmentsMan);
			}
			if (Validator.isNotNull(strengthsMan)) {
				getMasterObj.setStrengthsMan(strengthsMan);
			}
			if (Validator.isNotNull(developmentMan)) {
				getMasterObj.setDevelopmentMan(developmentMan);
			}
			if (Validator.isNotNull(careerMan)) {
				getMasterObj.setCareerMan(careerMan);
			}
			if (Validator.isNotNull(companyValue)) {
				getMasterObj.setCompanyValue(companyValue);
			}
			if (Validator.isNotNull(developmentPlan)) {
				getMasterObj.setDevelopmentPlan(developmentPlan);
			}

			if (Validator.isNull(overallCommentMan)) {
				errorList.add("Overall Comment is mandatory for HR");
			}else {
				getMasterObj.setOverallCommentMan(overallCommentMan);
			}
			// Overall HR rating required checking
			if (Validator.isNull(overallRatMan)) {
				errorList.add("Overall Rating is mandatory for HR");
			}else{
				getMasterObj.setOverallRatingMan(overallRatMan);
			}
			/*
			 * if (Validator.isNotNull(overallRatMan)) {
			 * getMasterObj.setOverallRatingMan(overallRatMan); }
			 */

			if (errorList.size() == 0) {
				if (getMasterObj.getSubmitStep() != HrAppraisalViewPortletKeys.AppraisalHrFinalSubmmit) {
					getMasterObj.setSubmitStep(finalSubmitHr);

					appraisalMasterObj = AppraisalMasterLocalServiceUtil.updateAppraisalMaster(getMasterObj);
				}
			}

		}

		// performance details

		if (errorList.size() == 0) {

			AppraisalPerformance addPerformanceObj = null;
			AppraisalPerformance appraisalPerformanceObj = null;

			System.out.println("getPerformanceObj::" + getPerformanceObj);
			for (int i = 0; i <= performanceArr.length - 1; i++) {

				String nameratinIdMan = "performanceManRat_" + performanceListsArr[i];
				long performanceId = Long.parseLong(performanceListsArr[i]);
				System.out.println(" nameratinIdMan.. : " + nameratinIdMan);
				long ratinIdMan = ParamUtil.getLong(request, nameratinIdMan);
				// System.out.println("performanceCom : " + performanceCom + "
				// ratinIdEmp : " + ratinIdEmp);
				System.out.println("ratinIdMan : "+ratinIdMan);

				getPerformanceObj = AppraisalPerformanceLocalServiceUtil.findByApprIdSettingIdAndEmployeeIdPerformId(
						appraisalMasterObj.getAppraisalId(), setup.getAppraisalSettingId(), employeeId, performanceId);

				if (getPerformanceObj != null) {
					System.out.println("========== in side if getPerformanceObj:======");
					System.out.println("performancelist : " + performanceLists);

					if (Validator.isNotNull(ratinIdMan)) {
						getPerformanceObj.setRatingIdMan(ratinIdMan);
					}
					if (getMasterObj.getSubmitStep() == HrAppraisalViewPortletKeys.AppraisalHrFinalSubmmit) {
						appraisalPerformanceObj = AppraisalPerformanceLocalServiceUtil
								.updateAppraisalPerformance(getPerformanceObj);
					}
					System.out.println("appraisalPerformanceObj obj>>>>..." + appraisalPerformanceObj);
					System.out.println("Appraisal Performance updated successfully");
				}
			}
		}else{
			System.out.println("errorlist :"+errorList);
			request.setAttribute("currTabs", "Overall Rating");
			SessionErrors.add(request, "add-error");
			SessionMessages.add(request, PortalUtil.getPortletId(request)
					+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			response.setWindowState(WindowState.NORMAL);
			//response.setRenderParameter("currTabs", "Overall Rating");
			response.setRenderParameter("jspPage", "/META-INF/resources/viewSelectedEmp.jsp");
		}

	}
	
	

	public static void main(String[] args) throws ParseException {  
		String sDate1="31/12/1998";  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    System.out.println(sDate1+"\t"+date1);   
	}  

}