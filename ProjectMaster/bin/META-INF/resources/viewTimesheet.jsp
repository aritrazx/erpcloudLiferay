<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
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
ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
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

PortletURL tsListURL = renderResponse.createRenderURL();
tsListURL.setWindowState(LiferayWindowState.NORMAL);
tsListURL.setParameter("projectId", String.valueOf(projectId));
tsListURL.setParameter("jspPage", "/META-INF/resources/timesheetList.jsp");

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setWindowState(LiferayWindowState.NORMAL);
viewURL.setParameter("projectId", String.valueOf(projectId));
viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("projectId", String.valueOf(projectId));
iteratorUrl.setParameter("jspPage", "/META-INF/resources/viewTimesheet.jsp");
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Timesheet Details" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<h4>Project Name:<%=" "+pm.getProjectName() %></h4>
</br>
</br>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByType="" iteratorURL="<%=iteratorUrl %>">
	<liferay-ui:search-container-results>
		<%
			 results = tsList1;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("results", results);
					
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.TimeSheetEntry"
		modelVar="tsEntry">
		<%
			Date addDate = tsEntry.getEntryDate();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
			String strDate = formatter.format(addDate);
		%>

		<liferay-ui:search-container-column-text name="Entry Date"
			orderableProperty="entry_date">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(tsEntry.getEmployeeId());
		%>
		
		<liferay-ui:search-container-column-text name="Employee Name"
			orderableProperty="project_id">
			<%=emp.getFirstName()+" "+emp.getLastName()%>
		</liferay-ui:search-container-column-text>
		<%
			TaskMaster projTask = TaskMasterLocalServiceUtil.getTaskMaster(tsEntry.getProjectTaskId());
		%>
		
		<liferay-ui:search-container-column-text name="Task Name"
			 orderableProperty="project_task_id">
			<%=projTask.getTaskName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Hours"
			orderableProperty="hours">
			<%=tsEntry.getHours()%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>