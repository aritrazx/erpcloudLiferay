<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectStatusLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectStatus"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="init.jsp"%>
<%
	String clientId = ParamUtil.getString(request, "clientId");
	System.out.println("clientId..............."+clientId);

	ClientMaster clientMaster = null;
	try {
		if (Validator.isNotNull(clientId)) {
			clientMaster = ClientMasterLocalServiceUtil.getClientMaster(Long.valueOf(clientId));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	List<ProjectMaster> clientProjectList = new ArrayList<>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	PortletURL clientViewMilestoneURL = renderResponse.createRenderURL();
	clientViewMilestoneURL.setParameter("jspPage", "/milestoneList.jsp");
	
	PortletURL clientViewInvoiceURL = renderResponse.createRenderURL();
	clientViewInvoiceURL.setParameter("jspPage", "/projectList.jsp");
	
	PortletURL  iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/projectList.jsp");
	
	try{
	DynamicQuery clientProjectListQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
	Criterion criterion3=null;
	criterion3 = RestrictionsFactoryUtil.eq("clientId",Long.valueOf(clientId));
	clientProjectListQuery.add(criterion3);
	clientProjectList = ProjectMasterLocalServiceUtil.dynamicQuery(clientProjectListQuery);
	System.out.println("Project List :::"+clientProjectList);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<h1>ProjectList of <b><%=clientMaster.getClientName()%></b></h1>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl %>" orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%	
				results = clientProjectList;			    
				total = results.size();
				searchContainer.setTotal(results.size());
				pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
			    pageContext.setAttribute("total", results.size());
			    pageContext.setAttribute("delta", results.size());
			%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.ProjectMaster"
		modelVar="projectMaster">


		<liferay-ui:search-container-column-text name="Project Name"
			orderable="true" orderableProperty="projectName">
			<%= projectMaster.getProjectName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Start Date" orderable="true"
			orderableProperty="startDate">
			<%=dateFormat.format(projectMaster.getStartDate())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="End Date"
			orderable="true" orderableProperty="endDate">
			<%= dateFormat.format(projectMaster.getEndDate())%>
		</liferay-ui:search-container-column-text>
		
			<%
					ProjectStatus status = null;
					try {
						status = ProjectStatusLocalServiceUtil.getProjectStatus(projectMaster.getProjectStatusId());
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>
		
		<liferay-portlet:renderURL varImpl="goalURL">
		<portlet:param name="projectStatusId"
		value="<%=String.valueOf(projectMaster.getProjectStatusId())%>" />
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-row-parameter name="goalURL"
		value="<%=goalURL.toString()%>" />
		<liferay-ui:search-container-column-text name="Status"
			orderable="true" orderableProperty="projectStatusId" href="<%=goalURL%>">
			<%= projectMaster.getProjectStatusId()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">
			<%  
						clientViewMilestoneURL.setParameter("projectId", String.valueOf(projectMaster.getProjectId()));
						clientViewMilestoneURL.setParameter("clientId", String.valueOf(clientMaster.getClientId()));
				
			
						/* clientViewInvoiceURL.setParameter("projectId", String.valueOf(projectMaster.getProjectId())); */
						
						%>
			<liferay-ui:icon-menu markupView="lexicon">
					<liferay-ui:icon url="<%=clientViewMilestoneURL.toString() %>" label="view"
					message="View Milestone" image="view" />
					<liferay-ui:icon url="<%=clientViewInvoiceURL.toString() %>" label="view Invoice"
					message="View Bill" image="view" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>
