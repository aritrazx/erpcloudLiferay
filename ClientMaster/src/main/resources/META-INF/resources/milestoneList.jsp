<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.Milestone"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@include file="init.jsp"%>
<portlet:defineObjects />

<liferay-theme:defineObjects />
<%
	List<Milestone> clientProjectList = new ArrayList<>();
	String projectId = ParamUtil.getString(request, "projectId");
	System.out.println(" ");
	String clientId = ParamUtil.getString(request, "clientId");
	String gstStatus = StringPool.BLANK;
	String status = StringPool.BLANK;
	
	ProjectMaster projectMaster = null;
	try {
		if (Validator.isNotNull(projectId)) {
			projectMaster = ProjectMasterLocalServiceUtil.getProjectMaster(Long.valueOf(projectId));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	ClientMaster clientMaster = null;
	try{
		if (Validator.isNotNull(projectId)) {
			clientMaster = ClientMasterLocalServiceUtil.getClientMaster(Long.valueOf(clientId));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/mileStoneList.jsp");

	try {
		DynamicQuery clientProjectListQuery = MilestoneLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("projectId", Long.valueOf(projectId));
		clientProjectListQuery.add(criterion3);
		clientProjectList = MilestoneLocalServiceUtil.dynamicQuery(clientProjectListQuery);
		System.out.println("Project List :::" + clientProjectList);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<h1>MilestoneList Of <b><%=projectMaster.getProjectName() %></b> of <b><%=clientMaster.getClientName() %></b></h1>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = clientProjectList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Milestone"
		modelVar="var">


		<liferay-ui:search-container-column-text name="Milestone Name"
			orderable="true" orderableProperty="milestoneId">
			<%=var.getMilestoneName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Due Date"
			orderable="true" orderableProperty="dueDate">
			<%= dateFormat.format(var.getDueDate())%>
		</liferay-ui:search-container-column-text>
		<%
			Milestone milestone = null;
					try {
						milestone = MilestoneLocalServiceUtil.getMilestone(var.getMilestoneId());
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (Validator.isNotNull(var.getCheckGST())) {
						if (var.getCheckGST() == 0) {
							gstStatus = "Excluding";
						} else if (var.getCheckGST() == 1) {
							gstStatus = "Including";
						}
					}
		%>
		<liferay-ui:search-container-column-text name="GST" orderable="true"
			orderableProperty="checkGST">
			<%=gstStatus%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Amount"
			orderable="true" orderableProperty="amount">
			<%=var.getAmount()%>
		</liferay-ui:search-container-column-text>
		<%
			if (Validator.isNotNull(var.getStatus())) {
						if (var.getStatus() == 0) {
							status = "Pending";
						} else if (var.getStatus() == 1) {
							status = "Raised";
						}
					}
		%>
		<liferay-ui:search-container-column-text name="Status"
			orderable="true" orderableProperty="status">
			<%=status%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>