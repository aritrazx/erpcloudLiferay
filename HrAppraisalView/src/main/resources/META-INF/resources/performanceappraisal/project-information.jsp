<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
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
	//Employee emp = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());

	List<AddTeamMember> assignProjectList = new ArrayList<AddTeamMember>();
	DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
	assignProjectList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("assignProjectList...<<< : " + assignProjectList.size());
	//System.out.println("setup.getAppraisalSettingId()...<<< : " + setup.getAppraisalSettingId()+"....employee.getEmployeeId()..."+employee.getEmployeeId()+"...getMasterObj.getAppraisalId().."+getMasterObj.getAppraisalId());
	
	List<AppraisalProjectMaster> appProjectmastermList = new ArrayList<AppraisalProjectMaster>();
	if(Validator.isNotNull(getMasterObj) && Validator.isNotNull(setup)){
		appProjectmastermList = AppraisalProjectMasterLocalServiceUtil.findBySettingIdAndEmployeeIdApprasialIdList(
			setup.getAppraisalSettingId(), employeeId, getMasterObj.getAppraisalId());
		System.out.println("appProjectmastermObj...<<< : " + appProjectmastermList.size());
	}
	String assignProjects = StringPool.BLANK;
	/* String projectAssign = StringPool.BLANK;
	for (AddTeamMember pObj : assignProjectList) {
		projectAssign = projectAssign + pObj.getProjectId() + ",";
	} */
%>

<aui:row>
	<aui:col span="10">
		<aui:input name="employeeId" value="<%=employeeId%>"
			showRequiredLabel="" id="employeeId" label="" type="hidden" />
		<%-- <aui:select label="Select your project" name="projectName"
			id="projectName">
			<aui:option value="0">Select</aui:option>
			<c:forEach items="${manageAppraisalModel.projectMasterModel}"
				var="project">
				<aui:option value="${project.projectId}">${project.projectName}</aui:option>
			</c:forEach>
			<%
			for (AddTeamMember pObj : assignProjectList) {
				ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(pObj.getProjectId());
			 %>
				<aui:option value="<%=pObj.getProjectId() %>"><%=pm.getProjectName() %></aui:option>
		<%
			}
			 %>
		</aui:select> --%>
	</aui:col>
	<aui:col span="2">
		<%-- <aui:button-row>
			<aui:button value="Add" id="add"
				onClick="javascript:getGoalDaetils();"></aui:button>
		</aui:button-row> --%>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="12">
		<div id="project_goal_panel" class="clearfix"></div>
	</aui:col>
</aui:row>
<%
	if (appProjectmastermList.size() > 0) {
		for (AppraisalProjectMaster apmObj : appProjectmastermList) {
			assignProjects = assignProjects + apmObj.getProjectId() + ",";
%>

	<%@ include file="selectProjectInfo.jsp"%>

<%
	}
	}
%>
<input name="<portlet:namespace/>assignProjectList"
			id="assignProjectList" type="hidden" value="<%=assignProjects %>" />

<script>
	AUI().use('aui-datepicker', function(A) {
		var datepic = new A.DatePicker({
			trigger : '#<portlet:namespace/>startdate',
			mask : '%d/%m/%Y',

			popover : {
				toolbars : {
					header : [ [ {
						icon : 'icon-trash',
						label : 'Clear',
						on : {
							click : function() {
								datepic.clearSelection();
							}
						}
					}, {
						icon : 'icon-globe',
						label : 'Today',
						on : {
							click : function() {
								datepic.clearSelection();
								datepic.selectDates(new Date());
							}
						}
					} ] ]
				},
				zIndex : 1000
			},

			nullableDay : true,
			nullableMonth : true,
			nullableYear : true,

			calendar : {
				maximumDate : new Date()
			}
		});
	});
</script>
<script>
	AUI().use('aui-datepicker', function(A) {
		var datepic = new A.DatePicker({
			trigger : '#<portlet:namespace/>enddate',
			mask : '%d/%m/%Y',

			popover : {
				toolbars : {
					header : [ [ {
						icon : 'icon-trash',
						label : 'Clear',
						on : {
							click : function() {
								datepic.clearSelection();
							}
						}
					}, {
						icon : 'icon-globe',
						label : 'Today',
						on : {
							click : function() {
								datepic.clearSelection();
								datepic.selectDates(new Date());
							}
						}
					} ] ]
				},
				zIndex : 1000
			},

			nullableDay : true,
			nullableMonth : true,
			nullableYear : true,

			calendar : {
				maximumDate : new Date()
			}
		});
	});
</script>


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>