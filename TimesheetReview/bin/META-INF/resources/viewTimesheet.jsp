<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Projection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
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

<portlet:defineObjects />


<%
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Employee emp = EmployeeLocalServiceUtil.findByemployees(td.getUserId());
	long timesheetParentId = ParamUtil.getLong(request, "timesheetParentId");
	System.out.println("timesheetParentId in view timesheet---"+timesheetParentId);
	//long timesheetParentId = (long)renderRequest.getAttribute("timesheetParentId");
	TimeSheetMaster tsMaster = null;
	if (timesheetParentId != 0)
		tsMaster = TimeSheetMasterLocalServiceUtil.getTimeSheetMaster(timesheetParentId);
	Employee employee = null;

	String dateString = StringPool.BLANK;
	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	if (tsMaster != null) {
		employee = EmployeeLocalServiceUtil.getEmployee(tsMaster.getEmployeeId());
	}
	List<TimeSheetEntry> tsEntryForProjList = new ArrayList<>();
	//---------------------------
	/* List<TimeSheetEntry> tsEntryList = new ArrayList<>();
	DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
	Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("projectId"));
	dynamicQuery.add(RestrictionsFactoryUtil.eq("timesheetParentId", timesheetParentId));
	dynamicQuery.setProjection(projection);
	tsEntryList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("tsEntryList---"+tsEntryList);
	
	dynamicQuery = null;
	dynamicQuery = RoleLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(RestrictionsFactoryUtil.eq("name", "Project Manager"));
	List<Role> roleList = RoleLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("roleList--"+roleList);
	List<AddTeamMember> atmListForProj = new ArrayList<>();
	try{
	if(Validator.isNotNull(tsEntryList) && Validator.isNotNull(roleList)){
	for(int i=0;i<tsEntryList.size();i++){
		dynamicQuery = null;
		dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("projectId", tsEntryList.get(i)));
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.eq("roleId", roleList.get(0).getRoleId()));
		dynamicQuery.add(criterion);
		List<AddTeamMember> atmList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		atmListForProj.addAll(atmList);
		System.out.println("atmList----"+atmList);
	}
	}
	} catch(Exception e){
		e.printStackTrace();
		
	}
	
//--------------------------------------	

	
	List<TimeSheetEntry> tsEntryForProjAndEmpList = new ArrayList<>();
	if(atmListForProj.size()!=0){
	if (timesheetParentId != 0) {
		for(int j=0;j<atmListForProj.size();j++){
		DynamicQuery dynamicQuery1 = TimeSheetEntryLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("timesheetParentId", timesheetParentId);
		criterion3 = RestrictionsFactoryUtil.and(criterion3,
				RestrictionsFactoryUtil.eq("projectId", atmListForProj.get(j).getProjectId()));
		dynamicQuery1.add(criterion3);
		tsEntryForProjList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery1);
		tsEntryForProjAndEmpList.addAll(tsEntryForProjList);
		}
	}
	} */
	
	DynamicQuery dynamicQuery1 = TimeSheetEntryLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("timesheetParentId", timesheetParentId);
	dynamicQuery1.add(criterion3);
	tsEntryForProjList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery1);
%>

<portlet:actionURL name="approveTimesheet" var="approveTimesheet"></portlet:actionURL>
<portlet:actionURL name="rejectTimesheet" var="rejectTimesheet"></portlet:actionURL>

<aui:row>
	<aui:col span="4"></aui:col>
	<aui:col span="8">
		<label>Employee Name:<%=" " + employee.getFirstName() + " " + employee.getLastName()%></label>

	</aui:col>
</aui:row>
<aui:row>

	<aui:col span="12">
		<table width="100%">
			<thead>
				<tr>
					<th>&nbsp&nbsp Project &nbsp&nbsp</th>
					<th>&nbsp&nbsp Task &nbsp&nbsp</th>
					<th>&nbsp&nbsp Entry Date &nbsp&nbsp</th>
					<th>&nbsp&nbsp Description &nbsp&nbsp</th>
					<th>&nbsp&nbsp Hours &nbsp&nbsp</th>
				</tr>
				<%
					for (TimeSheetEntry tsEntry : tsEntryForProjList) {
								ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(tsEntry.getProjectId());
								TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(tsEntry.getProjectTaskId());
								dateString = sdf.format(tsEntry.getEntryDate());
				%>
				<tr>
					<td>&nbsp&nbsp<%=pm.getProjectName()%>&nbsp&nbsp
					</td>
					<td>&nbsp&nbsp<%=tm.getTaskName()%>&nbsp&nbsp
					</td>
					<td>&nbsp&nbsp<%=dateString%>&nbsp&nbsp
					</td>
					<td>&nbsp&nbsp<%=tsEntry.getWorkDescription()%>&nbsp&nbsp
					</td>
					<td>&nbsp&nbsp<%=tsEntry.getHours()%>&nbsp&nbsp
					</td>
				</tr>
				<%
					}
				%>
			</thead>
			<tbody></tbody>
		</table>
	</aui:col>


</aui:row>
<br>
<br>

<%-- <aui:row>

<aui:col span="6">
<aui:input label="Employee Name" readonly="true"  name="empName" value="<%=emp.getFirstName()+" "+emp.getLastName() %>"></aui:input>
</aui:col>
<aui:col span="6">
<aui:input label="Project Name" readonly="true"  name="projName" value="<%=pm.getProjectName() %>"></aui:input>
</aui:col>

</aui:row>

<aui:row>
<aui:col span="6">
<aui:input label="Entry Date" readonly="true"  name="entryDate" value="<%=dateString%>"></aui:input>
</aui:col>
<aui:col span="6">
<aui:input label="Hours" readonly="true"  name="hours" value="<%=tsEntry.getHours()%>"></aui:input>
</aui:col>
</aui:row> --%>

<aui:row>
	<aui:col span="6">
		<aui:input label="Comment" name="comment" type="textarea"></aui:input>
	</aui:col>
	<aui:col span="3">
		<aui:form name="editTimesheet"
			action="<%=approveTimesheet.toString()%>" method="post"
			enctype="multipart/form-data">
			<aui:input name="timesheetParentId" type="hidden"
				value="<%=timesheetParentId%>" />

			<aui:button name="approve" type="submit" value="Approve"></aui:button>
		</aui:form>

	</aui:col>
	<aui:col span="3">
		<aui:form name="editTimesheet"
			action="<%=rejectTimesheet.toString()%>" method="post"
			enctype="multipart/form-data">
			<aui:input name="timesheetParentId" type="hidden"
				value="<%=timesheetParentId%>" />

			<aui:button name="reject" type="submit" value="Reject"></aui:button>
		</aui:form>
	</aui:col>
</aui:row>

<style>
table, th, td {
	border: 1px solid black;
}
</style>