<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectTask"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
long projectId = ParamUtil.getLong(request, "projectId");
List<AddTeamMember> teamMemList = new ArrayList<AddTeamMember>();
List<AddTeamMember> teamMemList1 = new ArrayList<AddTeamMember>();
List<TimeSheetEntry> tsList = new ArrayList<>();
List<TimeSheetEntry> tsList1 = new ArrayList<>();
try {
	DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
	/* criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("isProjectManager", true)); */
	dynamicQuery.add(criterion3);
	teamMemList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
	teamMemList1.addAll(teamMemList);
	System.out.println("atmTempList: " + teamMemList.size());
} catch (Exception e) {
}
for(int i=0;i<teamMemList1.size();i++){
	DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
	criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("employeeId", teamMemList1.get(i).getEmployeeId()));
	dynamicQuery.add(criterion3);
	tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
	tsList1.addAll(tsList);
}
%>
<aui:row>
	<aui:col span="6">
	<label><h3>Timesheet Details</h3></label>
	</aui:col>
</aui:row>
<%if(tsList1.size()!=0) {%>
	<%-- <aui:col span="4">
	
		Employee Name : 
		</br>
		<%
			if (tsList1.size() <= 3) {
						for (int i = 0; i < tsList1.size(); i++) {
							Employee emp = EmployeeLocalServiceUtil.getEmployee(tsList1.get(i).getEmployeeId());
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=emp.getFirstName() + " " + emp.getLastName()%></b>
		</br>
		<%
			}
					} else {
						for (int i = 0; i < 3; i++) {
							Employee emp = EmployeeLocalServiceUtil.getEmployee(tsList1.get(i).getEmployeeId());
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=emp.getFirstName() + " " + emp.getLastName()%></b>
		</br>
		<%
			}
					}
		%>
		</br>
	</aui:col>
	
		<aui:col span="4">
	
		Task Name : 
		</br>
		<%
			if (tsList1.size() <= 3) {
						for (int i = 0; i < tsList1.size(); i++) {
							ProjectTask pt = ProjectTaskLocalServiceUtil.getProjectTask(tsList1.get(i).getProjectTaskId());
		%>
		<b style="color: #f48120;"><%=pt.getTaskName()%></b>
		</br>
		<%
			}
					} else {
						for (int i = 0; i < 3; i++) {
							ProjectTask pt = ProjectTaskLocalServiceUtil.getProjectTask(tsList1.get(i).getProjectTaskId());
		%>
		<b style="color: #f48120;"><%=pt.getTaskName()%></b>
		</br>
		<%
			}
					}
		%>
		</br>
	</aui:col>
	
	
		<aui:col span="4">
	
		Hours : 
		</br>
		<%
			if (tsList1.size() <= 3) {
						for (int i = 0; i < tsList1.size(); i++) {
		%>
		<b style="color: #f48120;"><%=tsList1.get(i).getHours()%></b>
		</br>
		<%
			}
					} else {
						for (int i = 0; i < 3; i++) {
		%>
		<b style="color: #f48120;"><%=tsList1.get(i).getHours()%></b>
		</br>
		<%
			}
					}
		%>
		</br>
	</aui:col> --%>
	
	<table>
  <tr>
    <th>&nbsp&nbspEmployee Name:&nbsp&nbsp</th>
    <th>&nbsp&nbspTask:&nbsp&nbsp</th>
    <th>&nbsp&nbspHours:&nbsp&nbsp</th>
  </tr>
	<%
			if (tsList1.size() <= 3) {
						for (int i = 0; i < tsList1.size(); i++) {
							Employee emp = EmployeeLocalServiceUtil.getEmployee(tsList1.get(i).getEmployeeId());
							ProjectTask pt = ProjectTaskLocalServiceUtil.getProjectTask(tsList1.get(i).getProjectTaskId());
		%>
	<tr>

		<td>&nbsp&nbsp<b style="color: #f48120;"><%=(i + 1) + ". "%><%=emp.getFirstName() + " " + emp.getLastName()%></b>&nbsp&nbsp</td>
		<td>&nbsp&nbsp<b style="color: #f48120;"><%=pt.getTaskName()%></b>&nbsp&nbsp</td>
		<td>&nbsp&nbsp<b style="color: #f48120;"><%=tsList1.get(i).getHours()%></b>&nbsp&nbsp</td>

	</tr>

	<%
			}
					}
	else {
						for (int i = 0; i < 3; i++) {
							Employee emp = EmployeeLocalServiceUtil.getEmployee(tsList1.get(i).getEmployeeId());
							ProjectTask pt = ProjectTaskLocalServiceUtil.getProjectTask(tsList1.get(i).getProjectTaskId());
							
		%>

	<tr>

		<td>&nbsp&nbsp<b style="color: #f48120;"><%=(i + 1) + ". "%><%=emp.getFirstName() + " " + emp.getLastName()%></b>&nbsp&nbsp</td>
		<td>&nbsp&nbsp<b style="color: #f48120;"><%=pt.getTaskName()%></b>&nbsp&nbsp</td>
		<td>&nbsp&nbsp<b style="color: #f48120;"><%=tsList1.get(i).getHours()%></b>&nbsp&nbsp</td>
	</tr>
	<%
			}
					}
		%>
</table>
	
<%} else { %>
	<b style="color: #ADD8E6;">No Record Found</b>
<%} %>

<style>
table, th, td {
    border: 1px solid black;
}
</style>