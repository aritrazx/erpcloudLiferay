<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectTask"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:success key="add-success"
	message="Task is successfully assigned to the project!"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Task is updated successfully!"></liferay-ui:success>
<liferay-ui:success key="delete-success"
	message="Task is successfully deleted!"></liferay-ui:success>
<liferay-ui:error key="error" message="Task Name already exist!"></liferay-ui:error>

<%
boolean editURL = false;
long val = ParamUtil.getLong(request, "val");
System.out.println("val in java...." + val);

long projectId = ParamUtil.getLong(request, "projectId");
ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
List<ProjectTask> projTaskList = new ArrayList<ProjectTask>();

try {
	DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(projectId));
	projTaskList = ProjectTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("atmTempList: " + projTaskList.size());
} catch (Exception e) {
}

PortletURL projectTaskEditURL = renderResponse.createRenderURL();
projectTaskEditURL.setWindowState(LiferayWindowState.NORMAL);
projectTaskEditURL.setParameter("jspPage", "/META-INF/resources/addTask.jsp");

PortletURL addProjectTaskURL = renderResponse.createRenderURL();
addProjectTaskURL.setWindowState(LiferayWindowState.NORMAL);
addProjectTaskURL.setParameter("projectId", String.valueOf(projectId));
addProjectTaskURL.setParameter("jspPage", "/META-INF/resources/addTask.jsp");

PortletURL projectTaskDeleteURL = renderResponse.createActionURL();
projectTaskDeleteURL.setWindowState(LiferayWindowState.NORMAL);
projectTaskDeleteURL.setParameter("javax.portlet.action", "deleteProjectTask");

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setWindowState(LiferayWindowState.NORMAL);
viewURL.setParameter("projectId", String.valueOf(projectId));
viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("projectId", String.valueOf(projectId));
iteratorUrl.setParameter("jspPage", "/META-INF/resources/fetchTask.jsp");
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Task List" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<h4>Project Name:<%=" "+pm.getProjectName() %></h4>

<aui:input name="projectId" type="hidden" value="<%=projectId %>"></aui:input>
</br>
</br>

<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item
title='<%=LanguageUtil.get(request, "Add Task")%>'
url="<%=addProjectTaskURL.toString()%>" />
</liferay-frontend:add-menu>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByType="" iteratorURL="<%=iteratorUrl %>">
	<liferay-ui:search-container-results>
		<%
			results = projTaskList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("projTaskList", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.ProjectTask"
		modelVar="projTask">
		<%
		TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(projTask.getTaskId());
		
		%>

		<liferay-ui:search-container-column-text name="Task Name"
			orderableProperty="taskname">
			<%=tm.getTaskName()%>
		</liferay-ui:search-container-column-text>
		<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(projTask.getEmployeeId());
		%>
		<liferay-ui:search-container-column-text name="Employee Name"
			 orderableProperty="project_id">
			<%=emp.getFirstName()+" "+emp.getLastName()%>
		</liferay-ui:search-container-column-text>
		<%
					Date addDate = projTask.getStartDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					String strDate = formatter.format(addDate);
		%>
		<liferay-ui:search-container-column-text name="Start Date"
			orderableProperty="taskname">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%
					Date date = projTask.getEndDate();
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMMM,yyyy");
					String eDate = formatter1.format(date);
		%>
		<liferay-ui:search-container-column-text name="End Date"
			orderableProperty="taskname">
			<%=eDate%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Hours"
			orderableProperty="taskname">
			<%=projTask.getHours()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">

			<%
			projectTaskEditURL.setParameter("projectTaskId", String.valueOf(projTask.getProjectTaskId()));
			projectTaskEditURL.setParameter("projectId", String.valueOf(projTask.getProjectId()));
			projectTaskEditURL.setParameter("editURL", String.valueOf(editURL));
			projectTaskDeleteURL.setParameter("projectTaskId1", String.valueOf(projTask.getProjectTaskId()));
			projectTaskDeleteURL.setParameter("projectId", String.valueOf(projTask.getProjectId()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=projectTaskEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=projectTaskDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>