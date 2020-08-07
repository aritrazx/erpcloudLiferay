<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetMaster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
boolean isViewPermission = false;
try {
	isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
			"TimesheetReview", "TIMESHEET_REVIEW_VIEW");
	System.out.print("isViewPermission " + isViewPermission);
} catch (Exception exception) {
	exception.printStackTrace();
}
if (isViewPermission) {

%>
<%
	System.out.println("Inside Timesheet page");
	List<TimeSheetMaster> tsList = (List<TimeSheetMaster>) renderRequest.getAttribute("tsList");
	List<TimeSheetMaster> tsListMe = (List<TimeSheetMaster>) renderRequest.getAttribute("tsListMe");
	
	
	System.out.println("list from render" + tsList.size());

	/* List<Employee> empList = new ArrayList<Employee>();
	empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	System.out.println("empList == "+empList); */

	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String navigation = ParamUtil.getString(request, "navigation", "active");
	String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all-users");

	
	PortletURL viewTimesheetURL = renderResponse.createRenderURL();
	viewTimesheetURL.setParameter("jspPage", "/viewTimesheet.jsp");
	
	/* PortletURL editEmployeeURL = renderResponse.createRenderURL();
	editEmployeeURL.setParameter("jspPage", "/view_employee.jsp"); */
	
	
	
	PortletURL assignToMe = renderResponse.createRenderURL();
	assignToMe.setParameter("jspPage", "/assignToMePopup.jsp");
	assignToMe.setWindowState(LiferayWindowState.POP_UP);
	
	System.out.println("tsList == "+tsList);
	System.out.println("tsListMe == "+tsListMe);
	long portletid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), 
			"MyTimesheet");
	
	   //ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);  
	   long plidDashboard = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "MyTimesheet");
	  /*  LiferayPortletURL editEmployeeURL = PortletURLFactoryUtil.create(request, "EmployeeDetails", plidDashboard, "0");
	   editEmployeeURL.setWindowState(LiferayWindowState.NORMAL); */
	 
	   
%>


<liferay-ui:tabs names="Assigned to Me,Assigned to My Roles"
	refresh="false" tabsValues="Assigned to Me,Assigned to My Roles">
	<liferay-ui:section>
	
	<liferay-ui:search-container delta="5"
			emptyResultsMessage="No Entry found">

			<liferay-ui:search-container-results>
				<%
					results = tsListMe;
					total = results.size();
					searchContainer.setTotal(total);
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("results", results);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.famocom.erpcloud.model.TimeSheetMaster"
				modelVar="tsValMe">
			<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(tsValMe.getEmployeeId());
			String dateStringStart = StringPool.BLANK;
			String dateStringEnd = StringPool.BLANK;
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateStringStart = sdf.format(tsValMe.getFromDate());
			dateStringEnd = sdf.format(tsValMe.getToDate());
			%>
				<liferay-ui:search-container-column-text name="Employee Name"
					value="<%=emp.getFirstName() + " "+emp.getLastName()%>" />
				<liferay-ui:search-container-column-text name="From Date"
					value="<%=dateStringStart%>" />
				<liferay-ui:search-container-column-text name="To Date"
					value="<%=dateStringEnd%>" />
				

				<liferay-ui:search-container-column-text name="Status">
					<aui:workflow-status showIcon="<%=false%>" showLabel="<%=false%>"
						status="<%=tsValMe.getStatus()%>" />
				</liferay-ui:search-container-column-text>
	<liferay-portlet:renderURL var="editTimesheetURL"   plid="<%= portletid %>" 
	 windowState="<%=LiferayWindowState.NORMAL.toString()%>" 
	 portletName="MyTimesheet" >
	 <liferay-portlet:param name="jspPage" value="/dateRangePage.jsp"/> 
	 <liferay-portlet:param name="timesheetParentId" value="<%=String.valueOf(tsValMe.getTimesheetParentId()) %>"	/>
 </liferay-portlet:renderURL>
			
<%
	//ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

	viewTimesheetURL.setParameter("timesheetParentId", String.valueOf(tsValMe.getTimesheetParentId()));
	//empValMe.getStatusByUserId()==themeDisplay.getUserId() && empValMe.getStatus()==1
	boolean edit = false;
	if(tsValMe.getStatusByUserId()==themeDisplay.getUserId() && tsValMe.getStatus()==1){
		edit=true;
	}
	System.out.println("after assign to me--- ");
%>

				<liferay-ui:search-container-column-text name="Action"
					cssClass="actionCol">
					<%
					if(edit!=true){
					%>
					<liferay-ui:icon url="<%=viewTimesheetURL.toString()%>" message="View"
					image="view" />
					
					<%
					}
					else{
					%>
					<liferay-ui:icon url="<%=editTimesheetURL.toString()%>" message="Edit"
					image="edit" />
					<%
					}
					%>
				</liferay-ui:search-container-column-text>	

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
		</liferay-ui:search-container>

		

	</liferay-ui:section>
	<liferay-ui:section>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No Entry found">

			<liferay-ui:search-container-results>
				<%
				results = tsList;
				total = results.size();
				searchContainer.setTotal(results.size());
				pageContext.setAttribute("results",
						results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
				pageContext.setAttribute("total", results.size());
				pageContext.setAttribute("delta", results.size());
				portletSession.setAttribute("results", results);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.famocom.erpcloud.model.TimeSheetMaster"
				modelVar="tsVal">
			<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(tsVal.getEmployeeId());
			String dateStringStart = StringPool.BLANK;
			String dateStringEnd = StringPool.BLANK;
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateStringStart = sdf.format(tsVal.getFromDate());
			dateStringEnd = sdf.format(tsVal.getToDate());
			%>
				<liferay-ui:search-container-column-text name="Employee Name"
					value="<%=emp.getFirstName() + " "+emp.getLastName()%>" />
				<liferay-ui:search-container-column-text name="From Date"
					value="<%=dateStringStart%>" />
				<liferay-ui:search-container-column-text name="To Date"
					value="<%=dateStringEnd%>" />



				<liferay-ui:search-container-column-text name="Status">
					<aui:workflow-status showIcon="<%=false%>" showLabel="<%=false%>"
						status="<%=tsVal.getStatus()%>" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="Action"
					cssClass="actionCol">
					<liferay-ui:icon-menu markupView="lexicon">
						<%
						assignToMe.setParameter("timesheetParentId", String.valueOf(tsVal.getTimesheetParentId()));
						
						String popupview = "javascript:popupAssignToMe('"+ assignToMe.toString()+"');";
						%>
						<liferay-ui:icon iconCssClass="icon-user" message="Assign to Me"
							url="<%=popupview%>" />
						<%-- <liferay-ui:icon iconCssClass="icon-edit" message="Assign to.."
							url="#" /> --%>
						
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
		</liferay-ui:search-container>

		
	</liferay-ui:section>

</liferay-ui:tabs>

<script>
function popupAssignToMe(url){
	//alert("..url.."+url);
//alert("call");
	Liferay.Util.openWindow(
		{
			dialog: {
			//cssClass: 'aui-popup-example',
			destroyOnHide: true,
			height: 400,
			width: 700
},
	dialogIframe: {
//bodyCssClass: 'custom-css-class'
},
	title: 'Assign To Me',
	uri: url
}
);
}
</script>

<%
 }else{
%>
<div class="control-group no-margin">
	<label class="control-label">You don't have permission to view
		the Timesheet Review</label>
</div>
<%    
}
%>