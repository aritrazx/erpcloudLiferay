<%@page import="com.liferay.famocom.erpcloud.service.ProjectRoleLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectRole"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectStatusLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectStatus"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
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

<%	boolean editURL = false;
	long projectTeamsId = ParamUtil.getLong(request, "projectTeamsId");
	AddTeamMember atm1 = null;
	if (projectTeamsId != 0) {
		editURL = true;
		try {
			atm1 = AddTeamMemberLocalServiceUtil.getAddTeamMember(projectTeamsId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	long val = ParamUtil.getLong(request, "val");
	System.out.println("val in java...." + val);

	List<AddTeamMember> teamMemList = new ArrayList<AddTeamMember>();

	try {
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(val));
		teamMemList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("atmTempList: " + teamMemList.size());
	} catch (Exception e) {
	}
%>
<%
PortletURL atmEditURL = renderResponse.createRenderURL();
atmEditURL.setWindowState(LiferayWindowState.NORMAL);
atmEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL atmDeleteURL = renderResponse.createActionURL();
atmDeleteURL.setWindowState(LiferayWindowState.NORMAL);
atmDeleteURL.setParameter("javax.portlet.action", "deleteTeamMember");
%>


<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = teamMemList;
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
		className="com.liferay.famocom.erpcloud.model.AddTeamMember"
		modelVar="curRow">
		<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(curRow.getEmployeeId());
		%>
		<liferay-ui:search-container-column-text name="Employee Name">
			<%=emp.getFirstName()%>
			<%=emp.getLastName()%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(curRow.getProjectId());
		%>

		<liferay-ui:search-container-column-text name="Project Name"
			 orderableProperty="projectId">
			<%=pm.getProjectName()%>
		</liferay-ui:search-container-column-text>

		<%
			ProjectStatus ps = ProjectStatusLocalServiceUtil.getProjectStatus(pm.getProjectStatusId());
		%>
		<liferay-ui:search-container-column-text name="Project Status">
			<%=ps.getStatusName()%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectRole pr = ProjectRoleLocalServiceUtil.getProjectRole(curRow.getRoleId());
		%>
		<liferay-ui:search-container-column-text name="Role"
			orderableProperty="roleId">
			<%=pr.getRoleName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Is Project Manager"
			orderableProperty="isProjectManager">
			<%=curRow.getIsProjectManager()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">

			<%  
			atmEditURL.setParameter("projectTeamsId", String.valueOf(curRow.getProjectTeamsId()));
			atmEditURL.setParameter("editURL", String.valueOf(editURL));
			atmDeleteURL.setParameter("projectTeamsId1", String.valueOf(curRow.getProjectTeamsId())); 
							 
						%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=atmEditURL.toString() %>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=atmDeleteURL.toString() %>"
					message="Delete" label="Delete" image="delete"></liferay-ui:icon-delete>
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>