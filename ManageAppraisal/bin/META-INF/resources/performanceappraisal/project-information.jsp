<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.model.AppraisalProjectMaster"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="java.util.List"%>
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

<portlet:defineObjects />

<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<style>
.clearfix:after {
	visibility: hidden;
	display: block;
	font-size: 0;
	content: " ";
	clear: both;
	height: 0;
}

.fs_input {
	etter-spacing: inherit;
	width: 100%;
	box-sizing: border-box;
	outline: 0px none;
	border: 1px solid #E1E3E5;
	font-size: inherit !important;
	text-align: inherit;
	color: #36454F;
	font-family: inherit;
	border-radius: 3px !important;
	padding: 14px 12px 15px;
	font-size: 15px !important;
}

.labelinfo1 {
	background-color: #ECF0F5 !important;
}

* html .clearfix {
	zoom: 1;
} /* IE6 */
*:first-child+html .clearfix {
	zoom: 1;
} /* IE7 */
</style>

<%
	PortletURL addProjectURL = renderResponse.createActionURL();
	addProjectURL.setParameter(ActionRequest.ACTION_NAME, "addProject");
	
	PortletURL deleteProjectURL = renderResponse.createActionURL();
	deleteProjectURL.setParameter(ActionRequest.ACTION_NAME, "deleteProject");

	Employee emp = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());

	List<AddTeamMember> assignProjectList = new ArrayList<AddTeamMember>();
	DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(emp.getEmployeeId()));
	assignProjectList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("assignProjectList...<<< : " + assignProjectList.size());
	//System.out.println("setup.getAppraisalSettingId()...<<< : " + setup.getAppraisalSettingId()+"....employee.getEmployeeId()..."+employee.getEmployeeId()+"...getMasterObj.getAppraisalId().."+getMasterObj.getAppraisalId());

	List<AppraisalProjectMaster> appProjectmastermList = new ArrayList<AppraisalProjectMaster>();
	if (Validator.isNotNull(getMasterObj) && Validator.isNotNull(setup)) {
		appProjectmastermList = AppraisalProjectMasterLocalServiceUtil
				.findBySettingIdAndEmployeeIdApprasialIdList(setup.getAppraisalSettingId(),
						employee.getEmployeeId(), getMasterObj.getAppraisalId());
		System.out.println("appProjectmastermObj...<<< : " + appProjectmastermList.size());
	}

	String projectAssign = StringPool.BLANK;
	for (AddTeamMember pObj : assignProjectList) {
		projectAssign = projectAssign + pObj.getProjectId() + ",";
	}
%>

<aui:row>
	<aui:col span="10">
		<aui:input name="employeeId" value="<%=emp.getEmployeeId()%>"
			showRequiredLabel="" id="employeeId" label="" type="hidden" />
		<aui:select label="Select your project" name="projectName" style="height: 35px !important;"
			id="projectName">
			<aui:option value="0">Select</aui:option>
			<%-- <c:forEach items="${manageAppraisalModel.projectMasterModel}"
				var="project">
				<aui:option value="${project.projectId}">${project.projectName}</aui:option>
			</c:forEach> --%>
			<%
				System.out.println("assignProjectList.next..<<< : " + assignProjectList.size());
							for (AddTeamMember pObj : assignProjectList) {
								System.out.println("assignProjectList..pObj.<<< : " + pObj);
								ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(pObj.getProjectId());
			%>
			<aui:option value="<%=pObj.getProjectId()%>"><%=pm.getProjectName()%></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:col>
	<aui:col span="2">
		<aui:button-row>
			<aui:button value="Add" id="add"
				onClick="javascript:addProjectInfoRow();"></aui:button>
		</aui:button-row>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="12">
		<div id="project_goal_panel" class="clearfix">
			<%
				String assignProjects = StringPool.BLANK;
						List<AppraisalProjectMaster> appraisalProjectMasters = AppraisalProjectMasterLocalServiceUtil
								.findByAppraisalSettingIdAndEmployeeId(setup.getAppraisalSettingId(),
										employee.getEmployeeId());
						System.out.println("appraisalProjectMasters : " + appraisalProjectMasters.size());
						if (appraisalProjectMasters.size() > 0 && !appraisalProjectMasters.isEmpty()) {
							for (AppraisalProjectMaster appraisalProjectMaster : appraisalProjectMasters) {
								System.out.println("Call Include info jsp");
								assignProjects = assignProjects + appraisalProjectMaster.getProjectId() + ",";
			%>

			<%@ include file="selectProjectInfo.jsp"%>
			<%
				}
						}
			%>
			<input name="<portlet:namespace/>assignProjectList"
				id="assignProjectList" type="hidden" value="<%=assignProjects%>" />
		</div>
	</aui:col>
</aui:row>


<script type="text/javascript">



function addProjectInfoRow(){
	var projectId = $("#<portlet:namespace/>projectName").val();
	$(".projectId").each(function(){
		var existingProjectId = $(this).val();
		if(existingProjectId==projectId){
			alert("This Project is already added");
			return false;
		}
	});
	
	var appraisalSettingId = <%=setup.getAppraisalSettingId()%>;
	var employeeId = <%=employee.getEmployeeId()%>;
	var url = "<%=addProjectURL.toString()%>";
		jQuery.ajax({
			url : url,
			data : {
				'<portlet:namespace/>projectId' : projectId,
				'<portlet:namespace/>appraisalSettingId' : appraisalSettingId,
				'<portlet:namespace/>employeeId' : employeeId
			},
			success : function(result) {
				//alert("success");
				window.location.reload();
			},
			error : function() {
				//alert("error");
			},
			type : 'POST'
		});
	}

	function deleteProjectRow(val) {
		//alert("Call "+val);
		var projectId = val;
		var appraisalSettingId =
<%=setup.getAppraisalSettingId()%>;
	var employeeId = <%=employee.getEmployeeId()%>;
	//alert("appraisalSettingId : "+appraisalSettingId);
	//alert("employeeId : "+employeeId);
	var url = "<%=deleteProjectURL.toString()%>";
	jQuery.ajax({
		url : url,
		data : {
			'<portlet:namespace/>projectId' : projectId,
			'<portlet:namespace/>appraisalSettingId' : appraisalSettingId,
			'<portlet:namespace/>employeeId' : employeeId

		},
		success : function(result) {
			//alert("success");
			window.location.reload();
		},
		error : function() {
			//alert("error");
		},
		type : 'POST'
	});
}
</script>

<aui:script>
	AUI()
			.use(
					'aui-datepicker',
					'datatype-date',
					'datatype-date-math',
					'datatype-date-parse',
					function(A) {
						var toDatePicker;
						var fromDatePicker = new A.DatePicker(
								{
									trigger : '#<portlet:namespace />startdate',
									mask : '%d/%m/%Y',
									popover : {
										zIndex : 1000
									},
									on : {
										selectionChange : function(event) {
											if (event.newSelection[0]) {
												var oldToValue = A.Date
														.parse(
																"%d/%m/%Y",
																document
																		.getElementById("<portlet:namespace />enddate").value);
												toDatePicker.getCalendar().set(
														'minimumDate',
														event.newSelection[0]);
												if (A.Date.isGreater(
														event.newSelection[0],
														oldToValue)) {
													document
															.getElementById("<portlet:namespace />enddate").value = A.Date
															.format(
																	event.newSelection[0],
																	{
																		format : "%d/%m/%Y"
																	});
												}
											}
										}
									},
									calendar : {
									// minimumDate: new Date()
									}
								});

						toDatePicker = new A.DatePicker({
							trigger : '#<portlet:namespace />enddate',
							mask : '%d/%m/%Y',
							popover : {
								zIndex : 1000
							},
							calendar : {
							//   minimumDate: new Date()
							}
						});
					});
</aui:script>


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>