<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%

	long employeeId = ParamUtil.getLong(request, "employeeId");
	boolean editURL = ParamUtil.getBoolean(request, "editURL");
	Employee emp =null;
	if (employeeId != 0) {
		emp = EmployeeLocalServiceUtil.getEmployee(employeeId);
	}
	String employeeCode = ParamUtil.get(renderRequest, String.valueOf("employeeCode"), StringPool.BLANK);
	String dateOfJoing = ParamUtil.get(renderRequest, "dateOfJoing", StringPool.BLANK);
	String firstName = ParamUtil.get(renderRequest, "firstName", StringPool.BLANK);
	String lastName = ParamUtil.get(renderRequest, "lastName", StringPool.BLANK);
	String designation = ParamUtil.get(renderRequest, "designation", StringPool.BLANK);
	String employeePhoto = ParamUtil.get(renderRequest, "employeePhoto", StringPool.BLANK);
	String status = ParamUtil.get(renderRequest, String.valueOf("employeeStatus"), StringPool.BLANK);
	String maritalStatus = ParamUtil.getString(request, "maritalStatus", StringPool.BLANK);
	PortletURL employeeListURL = renderResponse.createRenderURL();
	employeeListURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	/* if(themeDisplay.isSignedIn()){ */
		
		boolean isAddPermission = false;
		try {
			isAddPermission =PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
					"EmployeeDetails", "EMPLOYEE_ADD");
			System.out.print("isAddPermission " + isAddPermission);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		if (isAddPermission) { 
	             
%>


<aui:row>
	<aui:col span="10">
		<label><h2></h2></label>
	</aui:col>
	<aui:col span="2">
			<a class="btn btn-primary btn-default" name="employeeList" type="submit" href="<%=employeeListURL.toString()%>" >Employee List</a>
	</aui:col>
</aui:row>

<portlet:actionURL name="addEmployeeDetails" var="addEmployeeDetailsURL" />
<portlet:actionURL name="editEmployee" var="editEmployeeDetailsURL" />


<%
	List<String> errorList = (List) renderRequest.getAttribute("errorList");
%>
<div id="errDiv" class="errDiv">
	<%
		if (errorList != null) {
	%>
	<table>
		<%
			for (int i = 0; i < errorList.size(); i++) {
		%>
		<tr>
			<td><%=errorList.get(i)%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</div>


<aui:form name="addEmployeeDetails" action="<%=employeeId!=0?editEmployeeDetailsURL.toString():addEmployeeDetailsURL.toString() %>" method="post" >

<liferay-ui:tabs names="Basic Information,Bank Details" refresh="false" type="tabs nav-tabs-default">
 <aui:input name="employeeId" type="hidden" value="<%=employeeId %>" /> 
	<!-- tab for basic information -->
	 <liferay-ui:section>
		<%@ include file="basicInfo.jsp"%>
	</liferay-ui:section> 

	<liferay-ui:section>
		<%@ include file="bankDetails.jsp" %>
	</liferay-ui:section>
</liferay-ui:tabs>
<aui:button name="save" type="submit" value="save"></aui:button>

</aui:form>
 <%
		 }else{
			 %>
		<div class="control-group no-margin">
		<label class="control-label">You don't have permission to view the Pay Component</label>
		</div>
       <% }
	/* } */
%> 
<style>
	.errDiv{
		color: red;
	}

</style>