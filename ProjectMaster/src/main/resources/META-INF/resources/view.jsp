<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectStatusLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectStatus"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="java.util.List"%>
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
<%
boolean isViewPermission = false;
try {
	isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
			"ProjectMaster", "PROJECT_MASTER_VIEW");
	System.out.print("isViewPermission " + isViewPermission);
} catch (Exception exception) {
	exception.printStackTrace();
}
if (isViewPermission) {

%>

<liferay-ui:success key="add-success"
	message="Project added successfully"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Project updated successfully"></liferay-ui:success>
<liferay-ui:error key="error" message="Project already exist"></liferay-ui:error>
<h1>Project List</h1>
<%-- <%
	PortletURL assignURL = renderResponse.createRenderURL();
	assignURL.setWindowState(LiferayWindowState.POP_UP);
	assignURL.setParameter("jspPage", "/META-INF/resources/milestoneView.jsp");
	/* assignURL.setParameter("documentId", String.valueOf(documentId));
	assignURL.setParameter("notifyId", String.valueOf(curRow.getNotifyIdSendId()) );  */
	String popup = "javascript:popup('" + assignURL.toString() + "');";
%> --%>

<%
	boolean editURL = false;
	String projectName = ParamUtil.getString(renderRequest, "projectName", StringPool.BLANK);
	String projectClient = ParamUtil.getString(renderRequest, "clientName", StringPool.BLANK);
	String projectStatus = ParamUtil.getString(renderRequest, "selectStatus", StringPool.BLANK);
	String val = ParamUtil.getString(request, "search", StringPool.BLANK);
	System.out.println("val....." + val);
	List<ProjectMaster> projMastList = new ArrayList<ProjectMaster>();
	projMastList = ProjectMasterLocalServiceUtil.getProjectMasters(-1, -1);
	//System.out.println("list....."+projMastList);
	List<ProjectMaster> pmList = new ArrayList<ProjectMaster>();
	List<ProjectMaster> projList = new ArrayList<ProjectMaster>();
	long projectId = ParamUtil.getLong(request, "projectId");
	//System.out.println("primary key###....."+project_status_id);
	ProjectMaster pm = null;
	if (projectId != 0) {
		editURL = true;
		try {
			pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
%>


<%-- <portlet:actionURL name="projectMaster" var="projectMasterURL" />
<portlet:actionURL name="updateProjectMaster"
	var="updateProjectMasterURL" />

<aui:form name="projectMaster"
	action="<%=editURL != true ? projectMasterURL.toString() : updateProjectMasterURL.toString()%>"
	method="post">
	<aui:input name="projectId" type="hidden" value="<%=projectId%>"></aui:input>
	<aui:input name="projectName" type="text" label="Project Name"
		placeholder="Project Name"
		value="<%=pm != null ? pm.getProjectName() : ""%>">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	
	<aui:select name="clientName" label="Client Name">
		<aui:option value="">Select Client</aui:option>
		<%
			try {
						List<ClientMaster> cmList = ClientMasterLocalServiceUtil.getClientMasters(-1, -1);
						for (ClientMaster obj : cmList) {
							if (pm != null) {
								if (obj.getClientId() == pm.getClientId()) {
		%>
		<option value="<%=obj.getClientId()%>" selected><%=obj.getClientName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getClientId()%>"><%=obj.getClientName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getClientId()%>"><%=obj.getClientName()%></option>
		<%
			}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>


	</aui:select>
	
	<aui:input name="projectDescription" type="textarea"
		label="Project Description" placeholder="Project Description"
		value="<%=pm != null ? pm.getProjectDesc() : ""%>" />

	<aui:select name="selectStatus" label="Select Status">
		<aui:option value="">Select Status</aui:option>
		<%
			try {
						List<ProjectStatus> statList = ProjectStatusLocalServiceUtil.getProjectStatuses(-1, -1);
						for (ProjectStatus obj : statList) {
							if (pm != null) {
								if (obj.getProjectStatusId() == pm.getProjectStatusId()) {
		%>
		<option value="<%=obj.getProjectStatusId()%>" selected><%=obj.getStatusName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getProjectStatusId()%>"><%=obj.getStatusName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getProjectStatusId()%>"><%=obj.getStatusName()%></option>
		<%
			}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>


	</aui:select>
	
	<aui:row>
	<aui:col span="4">
	<aui:input id="txtFromDate_id" name="startDate" type="text"
	label="Select Start Date" placeholder="Start Date" readonly="readonly">
	<aui:validator name="required"></aui:validator>
	</aui:input>
	</aui:col>
	
	<aui:col span="4">
	<aui:input id="txtFromDate_id" name="endDate" type="text"
	label="Select To Date" placeholder="End Date" readonly="readonly">
	<aui:validator name="required"></aui:validator>
	</aui:input>
	</aui:col>
	
	<aui:col span="4">
	<aui:input name="totalAmount" type="text" label="Total Amount" placeholder="Total Amount">
	<aui:validator name="number"></aui:validator>
	<aui:validator name="max">100000</aui:validator>
	</aui:input>
	</aui:col>
	</aui:row>
	<aui:button name="button" type="submit" value="submit"></aui:button>
	
	</br>
	</br>
</aui:form> --%>


<%
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL addProjectURL = renderResponse.createRenderURL();
	addProjectURL.setWindowState(LiferayWindowState.NORMAL);
	addProjectURL.setParameter("jspPage", "/META-INF/resources/projectAdd.jsp");
	
	PortletURL tsURL = renderResponse.createRenderURL();
	tsURL.setWindowState(LiferayWindowState.NORMAL);
	tsURL.setParameter("jspPage", "/META-INF/resources/viewTimesheet.jsp");
	
	PortletURL dashboardURL = renderResponse.createRenderURL();
	dashboardURL.setWindowState(LiferayWindowState.NORMAL);
	dashboardURL.setParameter("jspPage", "/META-INF/resources/projectMasterDashboard.jsp");
	
	PortletURL addMemberURL = renderResponse.createRenderURL();
	addMemberURL.setWindowState(LiferayWindowState.NORMAL);
	addMemberURL.setParameter("jspPage", "/META-INF/resources/addMember.jsp");
	
	PortletURL memberShowURL = renderResponse.createRenderURL();
	memberShowURL.setWindowState(LiferayWindowState.NORMAL);
	memberShowURL.setParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");
	
	PortletURL addMilestoneURL = renderResponse.createRenderURL();
	addMilestoneURL.setWindowState(LiferayWindowState.NORMAL);
	addMilestoneURL.setParameter("jspPage", "/META-INF/resources/milestoneView.jsp");
	
	PortletURL milestoneListURL = renderResponse.createRenderURL();
	milestoneListURL.setWindowState(LiferayWindowState.NORMAL);
	milestoneListURL.setParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");
	
	PortletURL taskListURL = renderResponse.createRenderURL();
	taskListURL.setWindowState(LiferayWindowState.NORMAL);
	taskListURL.setParameter("jspPage", "/META-INF/resources/fetchTask.jsp");

	PortletURL projectMasterEditURL = renderResponse.createRenderURL();
	projectMasterEditURL.setWindowState(LiferayWindowState.NORMAL);
	projectMasterEditURL.setParameter("jspPage", "/META-INF/resources/projectAdd.jsp");

	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL activeURL = renderResponse.createActionURL();
	activeURL.setParameter("javax.portlet.action", "activate");

	PortletURL inActiveURL = renderResponse.createActionURL();
	inActiveURL.setParameter("javax.portlet.action", "deactivate");

	if (null == val || val.isEmpty()) {
		pmList = projMastList;
	} else {
		for (ProjectMaster pm1 : projMastList) {
			//System.out.println("for.....");
			if (val.equals(pm1.getProjectName())) {
				DynamicQuery dynamicQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("projectName").eq(val));
				pmList = ProjectMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
				//System.out.println("pm....." +pm);
			} else {
				DynamicQuery dynamicQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.like("projectName",
						new StringBuilder("%").append(val).append("%").toString());
				//System.out.println("fname ELSE2222........."+criterion3);
				dynamicQuery.add(criterion3);
				pmList = ProjectMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
			}
		}
	}

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	iteratorUrl.setParameter("projectName", projectName);
	iteratorUrl.setParameter("clientId", projectClient);
	iteratorUrl.setParameter("projectStatusId", projectStatus);
%>
<%
	String navigation = ParamUtil.getString(request, "navigation", "active");
	String orderByCol = ParamUtil.getString(request, "orderByCol", "projectname");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	int activeStatus = 1;
	int inActiveStatus = 0;
%>

<liferay-portlet:renderURL varImpl="viewPageURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
	<%-- <portlet:param name="displayStyle" value="<%= displayStyle %>" /> --%>
	<portlet:param name="orderByCol" value="<%=orderByCol%>" />
	<portlet:param name="orderByType" value="<%=orderByType%>" />
	<portlet:param name="navigation" value="<%=navigation%>" />
</liferay-portlet:renderURL>
<%
	System.out.println("navigation... " + navigation);
	System.out.println("orderByCol... " + orderByCol);
	System.out.println("orderByType... " + orderByType);

		DynamicQuery pmQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
		if (navigation.equals("active")) {
			pmQuery.add(PropertyFactoryUtil.forName("projectStatus").eq(activeStatus));
		}
		if (navigation.equals("inactive")) {
			pmQuery.add(PropertyFactoryUtil.forName("projectStatus").eq(inActiveStatus));
		}
		if (orderByCol.equals("projectName")) {
			if (orderByType.equals("asc")) {
				pmQuery.addOrder(OrderFactoryUtil.asc("projectName"));
			} else if (orderByType.equals("desc")) {
				pmQuery.addOrder(OrderFactoryUtil.desc("projectName"));
			}
		}

		projList = ProjectMasterLocalServiceUtil.dynamicQuery(pmQuery);

	

	System.out.println("active user... " + projList.size());
	System.out.println("inactive user... " + projList.size());
%>

<nav class="collapse-basic-search navbar navbar-default"
	data-toggle="collapsible-search">
	<div class="navbar-header navbar-header-right">
		<aui:form cssClass="basic-search input-group" name="searchProjectName"
			action="<%=searchURL.toString()%>">
			<div class="input-group-input">
				<div class="basic-search-slider">
					<button class="basic-search-close btn btn-default" type="button">
						<span aria-hidden="true" class="icon-remove"></span>
					</button>
					<input name="<portlet:namespace/>search" class="form-control"
						value="<%=val%>" placeholder=" Search" type="text" />
				</div>
			</div>
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<span aria-hidden="true" class="icon-search"></span>
				</button>
			</div>
		</aui:form>
	</div>

</nav>

<liferay-frontend:management-bar searchContainerId="pmContainer">
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%=new String[] { "active", "inactive" }%>'
			portletURL="<%=renderResponse.createRenderURL()%>" />


		<liferay-frontend:management-bar-sort orderByCol="<%=orderByCol%>"
			orderByType="<%=orderByType%>"
			orderColumns='<%=new String[] { "projectName" }%>'
			portletURL="<%=viewPageURL%>" />
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%=new String[] { "list" }%>'
			portletURL="<%=renderResponse.createRenderURL()%>"
			selectedDisplayStyle="" />
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href=""
			iconCssClass="icon-undo" id="restoreUsers" label="restore" />
		<liferay-frontend:management-bar-button href="" icon="trash"
			id="deleteUsers" label="" />

	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item
title='<%=LanguageUtil.get(request, "Add Project")%>'
url="<%=addProjectURL.toString()%>" />
</liferay-frontend:add-menu>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
		if (null == val || val.isEmpty()) {
			results = projList;
		} else {
			results = pmList;
		}
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
		className="com.liferay.famocom.erpcloud.model.ProjectMaster"
		modelVar="projMast">
		
		<%
				projectMasterEditURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				projectMasterEditURL.setParameter("editURL", String.valueOf(editURL));
				activeURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				inActiveURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				addMilestoneURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				addMilestoneURL.setParameter("clientId", String.valueOf(projMast.getClientId()));
				milestoneListURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				milestoneListURL.setParameter("clientId", String.valueOf(projMast.getClientId()));
				addMemberURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				memberShowURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				taskListURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				dashboardURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
				dashboardURL.setParameter("clientId", String.valueOf(projMast.getClientId()));
				tsURL.setParameter("projectId", String.valueOf(projMast.getProjectId()));
			%>
		<%if(projMast.getProjectStatus()==1){ %>
		<liferay-ui:search-container-column-text name="Project Name"
			 orderableProperty="projectname">
		<a href="<%=dashboardURL.toString()%>"><b style="color: #ADD8E6; text-decoration: underline;"><%=projMast.getProjectName() %></b></a>
		</liferay-ui:search-container-column-text>
		<%} else { %>
		<liferay-ui:search-container-column-text name="Project Name"
			 orderableProperty="projectname">
			 <%=projMast.getProjectName() %>
		</liferay-ui:search-container-column-text>
		<%} %>
		<%
		ClientMaster cm = ClientMasterLocalServiceUtil.getClientMaster(projMast.getClientId());
		%>
		<liferay-ui:search-container-column-text name="Client Name"
			 orderableProperty="clientId">
			<%=cm.getClientName()%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectStatus ps = ProjectStatusLocalServiceUtil.getProjectStatus(projMast.getProjectStatusId());
		%>
		<liferay-ui:search-container-column-text name="Status"
			 orderableProperty="projectStatusId">
			<%=ps.getStatusName()%>
		</liferay-ui:search-container-column-text>
		<%
					Date addDate = projMast.getStartDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					String strDate = formatter.format(addDate);
		%>
		<liferay-ui:search-container-column-text name="Start Date"
			 orderableProperty="projectname">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%
					Date eDate = projMast.getEndDate();
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMMM,yyyy");
					String strDate1 = formatter1.format(eDate);
		%>
		<liferay-ui:search-container-column-text name="End Date"
			 orderableProperty="projectname">
			<%=strDate1%>
		</liferay-ui:search-container-column-text>
		<%-- <liferay-ui:search-container-column-text name="Total Amount"
			 orderableProperty="projectname">
			<%=projMast.getTotalAmount()%>
		</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">


			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=projectMasterEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<%
					if (projMast.getProjectStatus() == 0) {
				%>
				<liferay-ui:icon url="<%=activeURL.toString()%>" label="Activate"
					message="Activate" image="activate" />
				<%
					} else {
				%>

				<liferay-ui:icon url="<%=inActiveURL.toString()%>"
					label="Deactivate" message="Deactivate" image="deactivate" />

				<%
					}
				%>
				
				<%if(projMast.getProjectStatus()==1) {%>
				<liferay-ui:icon url="<%=milestoneListURL.toString()%>"
					label="View Milestone List" message="View Milestone List" image="view" />
					
				<liferay-ui:icon url="<%=memberShowURL.toString()%>"
					label="View Member List" message="View Member List" image="view" />
				
				<liferay-ui:icon url="<%=taskListURL.toString()%>"
					label="View Task List" message="View Task List" image="view" />
					
				<liferay-ui:icon url="<%=tsURL.toString()%>"
					label="View Timesheet" message="View Timesheet" image="view" />
				
				<liferay-ui:icon url="<%=dashboardURL.toString()%>"
					label="View Dashboard" message="View Dashboard" image="view" />
					
				<%} %>
				
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>
<%
 }else{
%>
<div class="control-group no-margin">
	<label class="control-label">You don't have permission to view
		the Project Master</label>
</div>
<%    
}
%>

<!-- <script>
AUI().use('aui-datepicker', function(A) {
	var dfg = new A.DatePicker({
		trigger : '#<portlet:namespace />txtFromDate_id',
		mask : '%d/%m/%Y',

		popover : {
			zIndex : 1000
		},
		calendar : {
			
		}
	});
});
	
	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />txtToDate_id',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {
				
			}
		});
	});
</script> -->

<%-- <aui:script>
	function popup(url) {
		Liferay.Util.openWindow({
			dialog : {
				//cssClass: 'aui-popup-example',
				destroyOnHide : true,
				height : 600,
				width : 400
			},
			dialogIframe : {
			//bodyCssClass: 'custom-css-class'
			},
			title : 'Milestone',
			uri : url

		});
	}
</aui:script> --%>