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

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
boolean editURL = false;
long val = ParamUtil.getLong(request, "val");
System.out.println("val in java...." + val);

List<ProjectTask> projTaskList = new ArrayList<ProjectTask>();

try {
	DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(val));
	projTaskList = ProjectTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("atmTempList: " + projTaskList.size());
} catch (Exception e) {
}

PortletURL projectTaskEditURL = renderResponse.createRenderURL();
projectTaskEditURL.setWindowState(LiferayWindowState.NORMAL);
projectTaskEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL projectTaskDeleteURL = renderResponse.createActionURL();
projectTaskDeleteURL.setWindowState(LiferayWindowState.NORMAL);
projectTaskDeleteURL.setParameter("javax.portlet.action", "deleteProjectTask");

%>


<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByType="">
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


		<liferay-ui:search-container-column-text name="Task Name"
			orderableProperty="taskname">
			<%=projTask.getTaskName()%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projTask.getProjectId());
		%>
		<liferay-ui:search-container-column-text name="Project"
			 orderableProperty="project_id">
			<%=pm.getProjectName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
			projectTaskEditURL.setParameter("projectTaskId", String.valueOf(projTask.getProjectTaskId()));
			projectTaskEditURL.setParameter("editURL", String.valueOf(editURL));
			projectTaskDeleteURL.setParameter("projectTaskId1", String.valueOf(projTask.getProjectTaskId()));
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