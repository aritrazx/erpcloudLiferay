<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Milestone"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
	message="Milestone created successfully"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Milestone updated successfully"></liferay-ui:success>
<liferay-ui:success key="delete-success"
	message="Milestone deleted successfully"></liferay-ui:success>

<%
long projectId = ParamUtil.getLong(request, "projectId");
long clientId = ParamUtil.getLong(request, "clientId");
long billingId = ParamUtil.getLong(request, "billingId");

String milestoneName = ParamUtil.getString(renderRequest, "milestoneName", StringPool.BLANK);
String dueDate = ParamUtil.getString(renderRequest, "dueDate", StringPool.BLANK);
String amount = ParamUtil.getString(renderRequest, "amount", StringPool.BLANK);
String checkGST = ParamUtil.getString(renderRequest, "checkGST", StringPool.BLANK);
/* String projectId = ParamUtil.getString(renderRequest, "projectId", StringPool.BLANK);
String clientId = ParamUtil.getString(renderRequest, "clientId", StringPool.BLANK); */
Date tempDueDate = null;
if(Validator.isNotNull(dueDate)){
tempDueDate=new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
}
ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
List<Milestone> milList = new ArrayList<>();
DynamicQuery dynamicQuery = MilestoneLocalServiceUtil.dynamicQuery();
Criterion criterion3 = null;
criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
criterion3 = RestrictionsFactoryUtil.and(criterion3,
RestrictionsFactoryUtil.eq("clientId", clientId));
dynamicQuery.add(criterion3);
milList = MilestoneLocalServiceUtil.dynamicQuery(dynamicQuery);
%>

<%
PortletURL milestoneEditURL = renderResponse.createRenderURL();
milestoneEditURL.setWindowState(LiferayWindowState.NORMAL);
milestoneEditURL.setParameter("jspPage", "/META-INF/resources/milestoneView.jsp");

PortletURL milestoneDeleteURL = renderResponse.createActionURL();
milestoneDeleteURL.setWindowState(LiferayWindowState.NORMAL);
milestoneDeleteURL.setParameter("javax.portlet.action", "deleteMilestone");

PortletURL addMilestoneURL = renderResponse.createRenderURL();
addMilestoneURL.setWindowState(LiferayWindowState.NORMAL);
addMilestoneURL.setParameter("clientId", String.valueOf(clientId));
addMilestoneURL.setParameter("projectId", String.valueOf(projectId));
addMilestoneURL.setParameter("jspPage", "/META-INF/resources/milestoneView.jsp");

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setWindowState(LiferayWindowState.NORMAL);
viewURL.setParameter("clientId", String.valueOf(clientId));
viewURL.setParameter("projectId", String.valueOf(projectId));
viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("clientId", String.valueOf(clientId));
iteratorUrl.setParameter("projectId", String.valueOf(projectId));
iteratorUrl.setParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Milestone List" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<h4>Project Name:<%=" "+pm.getProjectName() %></h4>

<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item
title='<%=LanguageUtil.get(request, "Add Milestone")%>'
url="<%=addMilestoneURL.toString()%>" />
</liferay-frontend:add-menu>

<%-- <aui:row>
	<aui:col span="9">
	</aui:col>
	<aui:col span="3">
		<a class="btn btn-primary btn-default" name="timesheetList"
			type="submit" href="<%=addMilestoneURL.toString()%>">Back</a>
	</aui:col>
</aui:row> --%>

<aui:input name="billingId" type="hidden" value="<%=billingId %>"></aui:input>
<aui:input name="projectId" type="hidden" value="<%=projectId %>"></aui:input>
<aui:input name="clientId" type="hidden" value="<%=clientId %>"></aui:input>
</br>
</br>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="" iteratorURL="<%=iteratorUrl %>">
	<liferay-ui:search-container-results>
		<%
			results = milList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("projList", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Milestone"
		modelVar="mile">


		<liferay-ui:search-container-column-text name="Milestone Name"
			 orderableProperty="projectname">
			<%=mile.getMilestoneName()%>
		</liferay-ui:search-container-column-text>
		<%
		ClientMaster cm = ClientMasterLocalServiceUtil.getClientMaster(mile.getClientId());
		%>
		<liferay-ui:search-container-column-text name="Client Name"
			 orderableProperty="clientId">
			<%=cm.getClientName()%>
		</liferay-ui:search-container-column-text>
		<%-- <%
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(mile.getProjectId());
		%>
		
		<liferay-ui:search-container-column-text name="Project Name"
			 orderableProperty="clientId">
			<%=pm.getProjectName()%>
		</liferay-ui:search-container-column-text> --%>
		<%
					Date addDate = mile.getDueDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					String strDate = formatter.format(addDate);
		%>
		<liferay-ui:search-container-column-text name="Due Date"
			 orderableProperty="projectStatusId">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Amount"
			 orderableProperty="projectStatusId">
			<%=mile.getAmount()%>
		</liferay-ui:search-container-column-text>
		<%
		boolean incGST = false;
		if(mile.getCheckGST()==1){
			incGST = true;
		}
		%>
		<liferay-ui:search-container-column-text name="Including GST"
			 orderableProperty="projectStatusId">
			<%=incGST%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">

			<%
			milestoneEditURL.setParameter("billingId", String.valueOf(mile.getMilestoneId()));
			milestoneEditURL.setParameter("clientId", String.valueOf(mile.getClientId()));
			milestoneEditURL.setParameter("projectId", String.valueOf(mile.getProjectId()));
			milestoneDeleteURL.setParameter("billingId1", String.valueOf(mile.getMilestoneId()));
			milestoneDeleteURL.setParameter("clientId", String.valueOf(mile.getClientId()));
			milestoneDeleteURL.setParameter("projectId", String.valueOf(mile.getProjectId()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">
				<%if(mile.getStatus()==0){ %>
				<liferay-ui:icon url="<%=milestoneEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon url="<%=milestoneDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />
				<%} %>
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>