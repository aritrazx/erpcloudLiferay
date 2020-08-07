<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="java.util.List"%>
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

<h1>Task List</h1>

<liferay-ui:success key="add-success"
	message="Task added successfully"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Task updated successfully"></liferay-ui:success>
<liferay-ui:error key="error" message="Task already exist"></liferay-ui:error>

<%

List<TaskMaster> tmList = new ArrayList<>();

tmList = TaskMasterLocalServiceUtil.getTaskMasters(-1, -1);

PortletURL addTaskURL = renderResponse.createRenderURL();
addTaskURL.setWindowState(LiferayWindowState.NORMAL);
addTaskURL.setParameter("jspPage", "/META-INF/resources/addTask.jsp");

PortletURL taskEditURL = renderResponse.createRenderURL();
taskEditURL.setWindowState(LiferayWindowState.NORMAL);
taskEditURL.setParameter("jspPage", "/META-INF/resources/addTask.jsp");

PortletURL taskDeleteURL = renderResponse.createActionURL();
taskDeleteURL.setWindowState(LiferayWindowState.NORMAL);
taskDeleteURL.setParameter("javax.portlet.action", "deleteTask");

%>

<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item
title='<%=LanguageUtil.get(request, "Add Task")%>'
url="<%=addTaskURL.toString()%>" />
</liferay-frontend:add-menu>

<liferay-ui:search-container delta="75"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = tmList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("teamMemList", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.TaskMaster"
		modelVar="curRow">
		<liferay-ui:search-container-column-text name="Task Name"
			 orderableProperty="projectId">
			<%=curRow.getTaskName()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Task Description"
			 orderableProperty="projectId">
			<%=curRow.getTaskDesc()%>
		</liferay-ui:search-container-column-text>
		<%
		String stat = "";
		if(curRow.getStatus()==0){
			stat = "InActive";
		} else {
			stat = "Active";
		}
		
		%>
		
		<liferay-ui:search-container-column-text name="Status"
			 orderableProperty="projectId">
			<%=stat%>
		</liferay-ui:search-container-column-text>
		
		<%
					Date addDate = curRow.getCreateDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					String strDate = formatter.format(addDate);
		%>
		<liferay-ui:search-container-column-text name="Create Date"
			 orderableProperty="projectId">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">

			<%  
			taskEditURL.setParameter("taskId", String.valueOf(curRow.getTaskId()));
			taskDeleteURL.setParameter("taskId1", String.valueOf(curRow.getTaskId()));
						%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=taskEditURL.toString() %>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=taskDeleteURL.toString() %>" label="Delete"
					message="Delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>