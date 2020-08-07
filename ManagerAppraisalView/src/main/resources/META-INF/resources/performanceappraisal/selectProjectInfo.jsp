<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalGoalDetails"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalGoalMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalDetails"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.GoalMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalMaster"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<%@ page contentType="text/html; charset=utf-8" language="java"%>

<%
	System.out.println("Call Select project info jsp");
	long appraisalSettingId = setup.getAppraisalSettingId();
	//long employeeId = employee.getEmployeeId();
	long projectId = apmObj.getProjectId();
	System.out.println("appraisalSettingId employeeId projectId " + appraisalSettingId + "..." + employeeId
			+ "...." + projectId);
	//portletDisplay = themeDisplay.getPortletDisplay();
	DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	String portletId = portletDisplay.getId();
	String projectName = StringPool.BLANK;
	//long projectId = ParamUtil.getLong(request, "projectId");
	ProjectMaster projectMaster = null;
	if (Validator.isNotNull(projectId)) {
		projectMaster = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
		System.out.println("projectMaster : " + projectMaster);
		projectName = projectMaster.getProjectName();
	}
	List<GoalMaster> goalMasters = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);
	List<RatingMaster> ratingMasters = RatingMasterLocalServiceUtil.getRatingMasters(-1, -1);

	AppraisalProjectMaster appProMasObj = null;
	String projectDesc = StringPool.BLANK;
	String startDate = StringPool.BLANK;
	String endDate = StringPool.BLANK;
	String disable = StringPool.BLANK;
	
	if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
			&& Validator.isNotNull(appraisalSettingId)) {
		appProMasObj = AppraisalProjectMasterLocalServiceUtil
				.findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId, employeeId, projectId);
		projectDesc = appProMasObj.getProjectDescription();
		if (Validator.isNotNull(appProMasObj.getStartDate())) {
			startDate = format.format(appProMasObj.getStartDate());
		}
		if (Validator.isNotNull(appProMasObj.getEndDate())) {
			endDate = format.format(appProMasObj.getEndDate());
		}
		if (appProMasObj.getSubmitStep() == 2 || appProMasObj.getSubmitStep() == 3) {
			disable = "disabled";
		}
	}
%>

<div class="panel panel-primary"
	id="project_panel_<%=projectId%>">
	<div class="panel-heading clearfix">
		Project name:-
		<%=projectName%>
		<div class="btn-group pull-right">
			<a href="#project_<%=projectId%>"
				style="display: inline-block; margin-right: 10px;" class="collapsed"
				data-toggle="collapse" data-parent="#accordion"
				aria-expanded="false"> <i class="icon-plus"
				style="color: white;"></i>
			</a> <a href="#project_<%=projectId%>"
				onclick="deleteProjectRow(<%=projectId %>)" class="collapsed"> <i
				class="icon-remove" style="color: white;"></i>
			</a>
		</div>
	</div>
	<div id="project_<%=projectId%>" class="panel-body collapse"
		aria-expanded="false" style="height: 30px;">
		<input type="hidden" name="projectId_<%=projectId%>"
			value="<%=projectId%>">
		<div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0">
			<div class="form-group float-label-control">
				<p>Job Description</p>
				<textarea id="_<%=portletId%>_pojectDescription" value="" disabled="disabled"
					name="_<%=portletId%>_projectDescription_<%=projectId%>"
					class="fs_input custom-full" placeholder="Job Description"><%=projectDesc%></textarea>
			</div>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<p>Start Date</p>
				<div class="form-group">
					<input id="_<%=portletId%>_startdate" disabled="disabled"
						name="_<%=portletId%>_startdate_<%=projectId%>"
						value="<%=startDate%>" type="text" placeholder="Start Date"
						class="fs_input dateinput" style="font-size: 14px !important;">
				</div>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<p>End Date</p>
				<div class="form-group">
					<input id="_<%=portletId%>_enddate" disabled="disabled"
						name="_<%=portletId%>_enddate_<%=projectId%>" value="<%=endDate%>"
						type="text" placeholder="End Date" class="fs_input dateinput"
						style="font-size: 14px !important;">
				</div>
			</div>
		</div>

		<%
			if (goalMasters.size() > 0 && !goalMasters.isEmpty()) {
				for (GoalMaster goalMaster : goalMasters) {

					AppraisalGoalMaster appGoalMasObj = null;
					String getGoalMasterEmpComment = StringPool.BLANK;
					long getGoalMasterEmpRating = 0;
					String getGoalMasterManComment = StringPool.BLANK;
					long getGoalMasterManRating = 0;
					if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
							&& Validator.isNotNull(appraisalSettingId) && Validator.isNotNull(goalMaster.getGoalId())) {
						appGoalMasObj = AppraisalGoalMasterLocalServiceUtil.findByApprIdEmpIdProjIdEvalId(
								appProMasObj.getAppraisalId(), employeeId, projectId, goalMaster.getGoalId());
						projectDesc = appProMasObj.getProjectDescription();
						if(Validator.isNotNull(appGoalMasObj)){
							if (Validator.isNotNull(appGoalMasObj.getEmployeeComment())) {
								getGoalMasterEmpComment = appGoalMasObj.getEmployeeComment();
							}
							if (Validator.isNotNull(appGoalMasObj.getEmployeeOverallRat())) {
								getGoalMasterEmpRating = appGoalMasObj.getEmployeeOverallRat();
							}
							if (Validator.isNotNull(appGoalMasObj.getManagerComment())) {
								getGoalMasterManComment = appGoalMasObj.getManagerComment();
							}
							if (Validator.isNotNull(appGoalMasObj.getManagerOverallRat())) {
								getGoalMasterManRating = appGoalMasObj.getManagerOverallRat();
							}
						}
					}
		%>

		<div class="col-xs-12 col-md-12" style="padding-top: 15px;">
			<div class="panel panel-info ">
				<div class="panel-heading">
					<strong>Goal: </strong><%=goalMaster.getGoalName()%></div>
				<div class="panel-body">
					<div class="col-lg-12 col-sm-12 col-xs-12 margintop10 paddingleft0">
						<div
							class="col-lg-12 col-sm-12 col-xs-12 margintop10 paddingleft0">
							<h4>
								<strong>About Goal:</strong>&nbsp;<%=goalMaster.getGoalDescription()%>
							</h4>
						</div>
						<table class="table no-margin table-bordered table-striped  table-hover bg-warning">
							<thead>
								<tr class="label-info">
									<th class="text-center">Sr. No.</th>
									<th class="text-center">Parameter</th>
									<th class="text-center">Scale</th>
									<th class="text-center">Employee’s Rating</th>
									<th class="text-center">Manager’s Rating</th>
								</tr>
							</thead>
							<tbody id="custom-table">

								<%
										List<GoalDetails> goalDetails = GoalDetailsLocalServiceUtil.findByGoalId(goalMaster.getGoalId());
												if (goalDetails.size() > 0 && !goalDetails.isEmpty()) {
													int counter = 1;
													for (GoalDetails details : goalDetails) {
														AppraisalGoalDetails appGoalDetailsObj = null;
														long getGoalDetailsEmpRating = 0;
														long getGoalDetailsManRating = 0;
														if (Validator.isNotNull(projectId) && Validator.isNotNull(employeeId)
																&& Validator.isNotNull(appraisalSettingId)
																&& Validator.isNotNull(goalMaster.getGoalId())
																&& Validator.isNotNull(details.getGoaldetailId())) {
															appGoalDetailsObj = AppraisalGoalDetailsLocalServiceUtil
																	.findByApprIdEmpIdProjIdEvalIdGoalDetId(appProMasObj.getAppraisalId(),
																			employeeId, projectId, goalMaster.getGoalId(),
																			details.getGoaldetailId());

															projectDesc = appProMasObj.getProjectDescription();
															if(Validator.isNotNull(appGoalDetailsObj)){
																if (Validator.isNotNull(appGoalDetailsObj.getRatingIdEmp())) {
																	getGoalDetailsEmpRating = appGoalDetailsObj.getRatingIdEmp();
																}
																if (Validator.isNotNull(appGoalDetailsObj.getRatingIdMan())) {
																	getGoalDetailsManRating = appGoalDetailsObj.getRatingIdMan();
																}
															}
														}
									%>
								<tr>
									<td class="text-left "><%=counter%></td>
									<td class="text-left "><%=details.getParameter()%></td>
									<td class="text-left "><%=details.getScale()%></td>
									<td class="text-left "><select disabled="disabled"
										id="_<%=portletId%>_goalEmpRat"
										name="_<%=portletId%>_goalEmpRat_<%=projectMaster.getProjectId()%>_<%=goalMaster.getGoalId()%>_<%=details.getGoaldetailId()%>"
										class="fs_input custom-full"><option value="0">Select
												Rating</option>
											<%
												if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {
																	for (RatingMaster ratingMaster : ratingMasters) {
																		String selected = StringPool.BLANK;
																		if (ratingMaster.getRatingId() == getGoalDetailsEmpRating) {
																			selected = "selected";
																		}
											%>
											<option value="<%=ratingMaster.getRatingId()%>" <%=selected%>><%=ratingMaster.getRatingNum()%>-<%=ratingMaster.getRatingKey()%></option>
											<%
												}
																}
											%>
									</select></td>

									<%-- <%
										if(AppraisalPermission.contains(permissionChecker, appraisalSettingId, "MANAGER_VIEW")){
									%> --%>

									<td class="text-left "><select
										id="_<%=portletId%>_goalManRat"
										name="_<%=portletId%>_goalManRat_<%=projectMaster.getProjectId()%>_<%=goalMaster.getGoalId()%>_<%=details.getGoaldetailId()%>"
										class="fs_input custom-full" <%=disable %>><option
												value="0">Select Rating</option> '
											<%
										if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {
											for (RatingMaster ratingMaster : ratingMasters) {
												String selected = StringPool.BLANK;
												if (ratingMaster.getRatingId() == getGoalDetailsManRating) {
													selected = "selected";
												}
									%>
											<option value="<%=ratingMaster.getRatingId()%>" <%=selected %> ><%=ratingMaster.getRatingNum()%>-<%=ratingMaster.getRatingKey()%></option>
											<%
												}
																}
											%>
									</select></td>

									<%-- <%
										}
									%> --%>

								</tr>
								<%
										counter++;
													}
												}
									%>

							</tbody>
						</table>
						<hr>
						<div class="col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0">
							<div class="form-group">
								<p>Employee's Comments:</p>
								<textarea id="_<%=portletId%>_commentEmp" disabled="disabled"
									name="_<%=portletId%>_commentEmp_<%=projectMaster.getProjectId()%>_<%=goalMaster.getGoalId()%>"
									class="fs_input custom-full" placeholder="Employee's comments"><%=getGoalMasterEmpComment%></textarea>
							</div>
							<div class="form-group">
								<p>Overall Goal Rating by Employee:</p>
								<select id="_<%=portletId%>_goalEmpOverallRat" disabled="disabled"
									name="_<%=portletId%>_goalEmpOverallRat_<%=projectMaster.getProjectId()%>_<%=goalMaster.getGoalId()%>"
									class="fs_input custom-full"><option value="">Select
										Rating</option>
									<%
										if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {
													for (RatingMaster ratingMaster : ratingMasters) {
														String selected = StringPool.BLANK;
														if (ratingMaster.getRatingId() == getGoalMasterEmpRating) {
															selected = "selected";
														}
									%>
									<option value="<%=ratingMaster.getRatingId()%>" <%=selected%>><%=ratingMaster.getRatingNum()%>-<%=ratingMaster.getRatingKey()%></option>
									<%
										}
												}
									%>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-sm-12 col-xs-12 margintop10 paddingleft0"
							style="">
							<div class="form-group">
								<p>Manager's Comments<span style="color: red">*</span>:</p>
								<textarea id="_<%=portletId%>_commentMan" <%=disable %>
									name="_<%=portletId%>_commentMan_<%=projectMaster.getProjectId()%>_<%=goalMaster.getGoalId()%>"
									class="fs_input custom-full" placeholder="Manager's comments"><%=getGoalMasterManComment %></textarea>
							</div>
							<div class="form-group">
								<p>Overall Goal Rating by Manager<span style="color: red">*</span>:</p>
								<select id="_<%=portletId%>_goalManOverallRat" <%=disable %>
									name="_<%=portletId%>_goalManOverallRat_<%=projectMaster.getProjectId()%>_<%=goalMaster.getGoalId()%>"
									class="fs_input custom-full" ><option
										value="">Select Rating</option>'
									<%
									if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {
												for (RatingMaster ratingMaster : ratingMasters) {
													String selected = StringPool.BLANK;
													if (ratingMaster.getRatingId() == getGoalMasterManRating) {
														selected = "selected";
													}
								%>
									<option value="<%=ratingMaster.getRatingId()%>" <%=selected %> ><%=ratingMaster.getRatingNum()%>-<%=ratingMaster.getRatingKey()%></option>
									<%
										}
												}
									%>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%
			}
			}
		%>
	</div>
</div>

<style>
select, textarea{
	height: 60px !important;
}
</style>