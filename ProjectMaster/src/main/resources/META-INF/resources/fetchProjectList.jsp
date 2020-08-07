<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
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
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-ui:success key="add-success"
	message="Team Member added successfully"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Team Member updated successfully"></liferay-ui:success>
<liferay-ui:success key="delete-success"
	message="Team Member deleted successfully"></liferay-ui:success>
<liferay-ui:error key="error"
	message="This Project is already assigned to the Employee"></liferay-ui:error>
	
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
	long projectId = ParamUtil.getLong(request, "projectId");
	System.out.println("projectId in member list...." + projectId);
	ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
	List<AddTeamMember> teamMemList = new ArrayList<AddTeamMember>();

	try {
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
		/* criterion3 = RestrictionsFactoryUtil.and(criterion3,
		RestrictionsFactoryUtil.eq("isProjectManager", true)); */
		dynamicQuery.add(criterion3);
		teamMemList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("atmTempList: " + teamMemList.size());
	} catch (Exception e) {
	}
%>
<%
PortletURL atmEditURL = renderResponse.createRenderURL();
atmEditURL.setWindowState(LiferayWindowState.NORMAL);
atmEditURL.setParameter("jspPage", "/META-INF/resources/addMember.jsp");

PortletURL addMemberURL = renderResponse.createRenderURL();
addMemberURL.setWindowState(LiferayWindowState.NORMAL);
addMemberURL.setParameter("projectId", String.valueOf(projectId));
addMemberURL.setParameter("jspPage", "/META-INF/resources/addMember.jsp");

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setWindowState(LiferayWindowState.NORMAL);
viewURL.setParameter("projectId", String.valueOf(projectId));
viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL atmDeleteURL = renderResponse.createActionURL();
atmDeleteURL.setWindowState(LiferayWindowState.NORMAL);
atmDeleteURL.setParameter("javax.portlet.action", "deleteTeamMember");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("projectId", String.valueOf(projectId));
iteratorUrl.setParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");

%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Member List" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<h4>Project Name:<%=" "+pm.getProjectName() %></h4>

</br>
</br>
<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item
title='<%=LanguageUtil.get(request, "Add Member")%>'
url="<%=addMemberURL.toString()%>" />
</liferay-frontend:add-menu>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="" iteratorURL="<%=iteratorUrl %>">
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
		<%-- <%
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
		</liferay-ui:search-container-column-text> --%>
		<%
			Role pr = RoleLocalServiceUtil.getRole(curRow.getRoleId());
		%>
		<liferay-ui:search-container-column-text name="Role"
			orderableProperty="roleId">
			<%=pr.getName()%>
		</liferay-ui:search-container-column-text>
		<%-- <%
		String manager = "";
		if(Validator.isNotNull(curRow)){
			if(curRow.getIsProjectManager()==true){
				manager = "Yes";
			} else {
				manager = "--";
			}
		}
		
		%>
		<liferay-ui:search-container-column-text name="Is Project Manager"
			orderableProperty="isProjectManager">
			<%=manager%>
		</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">

			<%  
			atmEditURL.setParameter("projectTeamsId", String.valueOf(curRow.getProjectTeamsId()));
			atmEditURL.setParameter("projectId", String.valueOf(curRow.getProjectId()));
			//addMemberURL.setParameter("projectId", String.valueOf(curRow.getProjectId()));
			atmEditURL.setParameter("editURL", String.valueOf(editURL));
			atmDeleteURL.setParameter("projectTeamsId1", String.valueOf(curRow.getProjectTeamsId()));
			atmDeleteURL.setParameter("projectId", String.valueOf(curRow.getProjectId()));
							 
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