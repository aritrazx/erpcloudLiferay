<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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
long projectMasterId = ParamUtil.getLong(request, "projectId");
long clientMasterId = ParamUtil.getLong(request, "clientId");
ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectMasterId);
PortletURL memURL = renderResponse.createRenderURL();
memURL.setWindowState(LiferayWindowState.NORMAL);
memURL.setParameter("projectId", String.valueOf(projectMasterId));
memURL.setParameter("jspPage", "/META-INF/resources/memberList.jsp");

PortletURL mileURL = renderResponse.createRenderURL();
mileURL.setWindowState(LiferayWindowState.NORMAL);
mileURL.setParameter("projectId", String.valueOf(projectMasterId));
mileURL.setParameter("clientId", String.valueOf(clientMasterId));
mileURL.setParameter("jspPage", "/META-INF/resources/milestoneList.jsp");

PortletURL taskURL = renderResponse.createRenderURL();
taskURL.setWindowState(LiferayWindowState.NORMAL);
taskURL.setParameter("projectId", String.valueOf(projectMasterId));
taskURL.setParameter("jspPage", "/META-INF/resources/taskList.jsp");

PortletURL tsURL = renderResponse.createRenderURL();
tsURL.setWindowState(LiferayWindowState.NORMAL);
tsURL.setParameter("projectId", String.valueOf(projectMasterId));
tsURL.setParameter("jspPage", "/META-INF/resources/viewTimesheet.jsp");

PortletURL teamMemberURL = renderResponse.createRenderURL();
teamMemberURL.setWindowState(LiferayWindowState.NORMAL);
teamMemberURL.setParameter("projectId", String.valueOf(projectMasterId));
teamMemberURL.setParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");

PortletURL projTaskURL = renderResponse.createRenderURL();
projTaskURL.setWindowState(LiferayWindowState.NORMAL);
projTaskURL.setParameter("projectId", String.valueOf(projectMasterId));
projTaskURL.setParameter("jspPage", "/META-INF/resources/fetchTask.jsp");

PortletURL milestoneURL = renderResponse.createRenderURL();
milestoneURL.setWindowState(LiferayWindowState.NORMAL);
milestoneURL.setParameter("projectId", String.valueOf(projectMasterId));
milestoneURL.setParameter("clientId", String.valueOf(clientMasterId));
milestoneURL.setParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");

%>
<aui:row>
	<aui:col span="4"></aui:col>
	<aui:col span="6">
	<label><h2>Dashboard(<%=pm.getProjectName() %>)</h2></label>
	</aui:col>
</aui:row>
<hr>
<aui:row>
<aui:col span="6">
<%@ include file="memberList.jsp" %>
<%if(empList.size()!=0){ %>
<a href="<%=teamMemberURL.toString()%>"><b style="color: #ADD8E6; text-decoration: underline;">View More</b></a>
<%} %>
</aui:col>
<!-- <div class="vl"></div> -->
<aui:col span="6">
<%@ include file="taskList.jsp" %>
<%if(projTaskList.size()!=0){ %>
<a href="<%=projTaskURL.toString()%>"><b style="color: #ADD8E6; text-decoration: underline;">View More</b></a>
<%} %>
</aui:col>
</aui:row>
<hr>
<aui:row>
<aui:col span="6">
<%@ include file="milestoneList.jsp" %>
<%if(milList.size()!=0){ %>
<a href="<%=milestoneURL.toString()%>"><b style="color: #ADD8E6; text-decoration: underline;">View More</b></a>
<%} %>
</aui:col>
<!-- <div class="vl"></div> -->
<aui:col span="6">
<%@ include file="timesheetList.jsp" %>
<%if(tsList1.size()!=0){ %>
<a href="<%=tsURL.toString()%>"><b style="color: #ADD8E6; text-decoration: underline;">View More</b></a>
<%} %>
</aui:col>
</aui:row>
<hr>

<!-- <style>
.vl {
    border-left: 1px solid black;
    height: 245px;
    position: absolute;
    left: 40%;
    margin-left: -3px;
    margin-top: -18px;
    top: 1;
}
</style> -->