<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="javax.portlet.PortletURL"%>
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




<%
	System.out.println("Inside employee page");

	List<Employee> empList1 = (List<Employee>) renderRequest.getAttribute("empList");
	List<Employee> empListMe = (List<Employee>) renderRequest.getAttribute("empListMe");
	
	
	System.out.println("list from render" + empList1.size());

	/* List<Employee> empList = new ArrayList<Employee>();
	empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	System.out.println("empList == "+empList); */

	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String navigation = ParamUtil.getString(request, "navigation", "active");
	String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all-users");

	
	PortletURL viewEmployeeURL = renderResponse.createRenderURL();
	viewEmployeeURL.setParameter("jspPage", "/view_employee.jsp");
	
	/* PortletURL editEmployeeURL = renderResponse.createRenderURL();
	editEmployeeURL.setParameter("jspPage", "/view_employee.jsp"); */
	
	
	
	PortletURL assignToMe = renderResponse.createRenderURL();
	assignToMe.setParameter("jspPage", "/assignToMePopup.jsp");
	assignToMe.setWindowState(LiferayWindowState.POP_UP);
	
	System.out.println("empList == "+empList1);
	long portletid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), 
			"EmployeeDetails");
	
	   //ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);  
	   long plidDashboard = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "EmployeeDetails");
	  /*  LiferayPortletURL editEmployeeURL = PortletURLFactoryUtil.create(request, "EmployeeDetails", plidDashboard, "0");
	   editEmployeeURL.setWindowState(LiferayWindowState.NORMAL); */
	 
	   
%>

 

<liferay-ui:tabs names="Assigned to Me,Assigned to My Roles"
	refresh="false" tabsValues="Assigned to Me,Assigned to My Roles">
	<liferay-ui:section>
	<liferay-ui:search-container delta="5"
			emptyResultsMessage="No Employee found">

			<liferay-ui:search-container-results>
				<%
					results = empListMe;
					total = results.size();
					searchContainer.setTotal(total);
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.famocom.erpcloud.model.Employee"
				modelVar="empValMe">

				<liferay-ui:search-container-column-text name="Employee Code"
					value="<%=empValMe.getEmployeeCode() + ""%>" />

				<%
					FileEntry dlfile = null;
									String url = "";
									if (Validator.isNotNull(empValMe.getEmployeePhoto())) {
										dlfile = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(empValMe.getPhotoId()));
									}

									Date date2 = new Date();
									Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60)
											+ date2.getSeconds()) * 1000);
									if (dlfile != null) {
										url = themeDisplay.getPortalURL() + "/documents/" + themeDisplay.getScopeGroupId() + "/"
												+ dlfile.getFolderId() + "/" + dlfile.getFileName() + "/" + dlfile.getUuid()
												+ "?t=" + time2;
									} else {/* 
											url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
												+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/default-user.png"+"a0e6da79-ab27-8c10-acae-e9f27701c129";  */

										System.out.println("url render" + url + "..themeDisplay.getPortalURL().."
												+ themeDisplay.getPortalURL() + "..themeDisplay.getPathContext().."
												+ themeDisplay.getPathContext());

										url = themeDisplay.getPortalURL() + "/documents/20143/46421/default-user.png";
									}
				%>

				<liferay-ui:search-container-column-image name="Photo"
					src="<%=url%>">
				</liferay-ui:search-container-column-image>
				<liferay-ui:search-container-column-text name="Employee Name"
					value="<%=empValMe.getFirstName() + " " + empValMe.getLastName()%>" />

				<%
					String dateString = StringPool.BLANK;
									DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
									if (Validator.isNotNull(empValMe.getDateOfJoing())) {
										dateString = sdf.format(empValMe.getDateOfJoing());
										System.out.println("String.........." + dateString);
									}
				%>
				<liferay-ui:search-container-column-text name="Date of joining"
					value="<%=dateString%>" />


				<liferay-ui:search-container-column-text name="Status">
					<aui:workflow-status showIcon="<%=false%>" showLabel="<%=false%>"
						status="<%=empValMe.getStatus()%>" />
				</liferay-ui:search-container-column-text>
	<liferay-portlet:renderURL var="editEmployeeURL"   plid="<%= portletid %>" 
	 windowState="<%=LiferayWindowState.NORMAL.toString()%>" 
	 portletName="EmployeeDetails" >
	 <liferay-portlet:param name="jspPage" value="/addEmployee.jsp"/> 
	 <liferay-portlet:param name="employeeId" value="<%=String.valueOf(empValMe.getEmployeeId()) %>"	/>
 </liferay-portlet:renderURL>
			
<%
	//ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

	viewEmployeeURL.setParameter("empId", String.valueOf(empValMe.getEmployeeId()));
	//empValMe.getStatusByUserId()==themeDisplay.getUserId() && empValMe.getStatus()==1
	boolean edit = false;
	if(empValMe.getStatusByUserId()==themeDisplay.getUserId() && empValMe.getStatus()==1){
		edit=true;
	}

%>

				<liferay-ui:search-container-column-text name="Action"
					cssClass="actionCol">
					<%
					if(edit!=true){
					%>
					<liferay-ui:icon url="<%=viewEmployeeURL.toString()%>" message="View"
					image="view" />
					
					<%
					}
					else{
					%>
					<liferay-ui:icon url="<%=editEmployeeURL.toString()%>" message="Edit"
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
			emptyResultsMessage="No Employee found">

			<liferay-ui:search-container-results>
				<%
					results = empList1;
					total = results.size();
					searchContainer.setTotal(total);
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.famocom.erpcloud.model.Employee"
				modelVar="empVal">

				<liferay-ui:search-container-column-text name="Employee Code"
					value="<%=empVal.getEmployeeCode() + ""%>" />

				<%
					FileEntry dlfile = null;
									String url = "";
									if (Validator.isNotNull(empVal.getEmployeePhoto())) {
										dlfile = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(empVal.getPhotoId()));
									}

									Date date2 = new Date();
									Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60)
											+ date2.getSeconds()) * 1000);
									if (dlfile != null) {
										url = themeDisplay.getPortalURL() + "/documents/" + themeDisplay.getScopeGroupId() + "/"
												+ dlfile.getFolderId() + "/" + dlfile.getFileName() + "/" + dlfile.getUuid()
												+ "?t=" + time2;
									} else {/* 
											url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
												+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/default-user.png"+"a0e6da79-ab27-8c10-acae-e9f27701c129";  */

										System.out.println("url render" + url + "..themeDisplay.getPortalURL().."
												+ themeDisplay.getPortalURL() + "..themeDisplay.getPathContext().."
												+ themeDisplay.getPathContext());

										url = themeDisplay.getPortalURL() + "/documents/20143/46421/default-user.png";
									}
				%>

				<liferay-ui:search-container-column-image name="Photo"
					src="<%=url%>">
				</liferay-ui:search-container-column-image>
				<liferay-ui:search-container-column-text name="Employee Name"
					value="<%=empVal.getFirstName() + " " + empVal.getLastName()%>" />

				<%
					String dateString = StringPool.BLANK;
									DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
									if (Validator.isNotNull(empVal.getDateOfJoing())) {
										dateString = sdf.format(empVal.getDateOfJoing());
										System.out.println("String.........." + dateString);
									}
									
				%>
				<liferay-ui:search-container-column-text name="Date of joining"
					value="<%=dateString%>" />


				<liferay-ui:search-container-column-text name="Status">
					<aui:workflow-status showIcon="<%=false%>" showLabel="<%=false%>"
						status="<%=empVal.getStatus()%>" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text name="Action"
					cssClass="actionCol">
					<liferay-ui:icon-menu markupView="lexicon">
						<%
						assignToMe.setParameter("empId", String.valueOf(empVal.getEmployeeId()));
						
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



