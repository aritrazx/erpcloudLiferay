<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	long employeeId = 0;
	if(Validator.isNotNull(employeeId)){
		Employee employee = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
		employeeId = employee.getEmployeeId();
	}else{
		employeeId = ParamUtil.getLong(request, "employeeId");
	}
	System.out.println("employeeId:---"+employeeId);
	//boolean editURL = ParamUtil.getBoolean(request, "editURL");
	Employee emp = EmployeeLocalServiceUtil.getEmployee(employeeId);
	//System.out.println("EMP:-"+emp+"editURL.."+editURL);

	String employeeCode = ParamUtil.get(request,"employeeCode", StringPool.BLANK);
	/* String dateOfJoing = ParamUtil.get(renderRequest, "dateOfJoing", StringPool.BLANK);
	String firstName = ParamUtil.get(renderRequest, "firstName", StringPool.BLANK);
	String lastName = ParamUtil.get(renderRequest, "lastName", StringPool.BLANK);
	String designation = ParamUtil.get(renderRequest, "designation", StringPool.BLANK);
	String employeePhoto = ParamUtil.get(renderRequest, "employeePhoto", StringPool.BLANK);
	String status = ParamUtil.get(renderRequest, String.valueOf("employeeStatus"), StringPool.BLANK);
	String maritalStatus = ParamUtil.getString(request, "maritalStatus", StringPool.BLANK);
	PortletURL employeeListURL = renderResponse.createRenderURL();
	employeeListURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	System.out.println("EMP:ddddded-"); */
	PortletURL viewEmployeeURL = renderResponse.createRenderURL();
	viewEmployeeURL.setParameter("jspPage", "/META-INF/resources/viewEmployee.jsp");
	 
%>
<%
PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

%>
<portlet:actionURL name="viewEmployeeDetails" var="viewEmployeeDetailsURL" />
<aui:form name="viewEmployeeDetails" action="" method="post" >

	

	<aui:row>
	<aui:col span="10">
	<a href="<%=backURL.toString()%>"><span class="icon-monospaced"><svg
				class="lexicon-icon lexicon-icon-angle-left" focusable="false"
				role="img" title="" viewBox="0 0 512 512">
     <path class="lexicon-icon-outline"
					d="M114.106 254.607c0.22 6.936 2.972 13.811 8.272 19.11l227.222 227.221c11.026 11.058 28.94 11.058 39.999 0 11.058-11.026 11.058-28.94 0-39.999l-206.333-206.333c0 0 206.333-206.333 206.333-206.333 11.058-11.059 11.058-28.973 0-39.999-11.058-11.059-28.973-11.059-39.999 0l-227.221 227.221c-5.3 5.3-8.052 12.174-8.273 19.111z"></path>
</svg></span></a>
	<p>
		<h3>View Employee Details(<%=emp.getFirstName()%> <%=emp.getLastName()%>)</h3></b>
	</p>
	</aui:col>
	<%-- <aui:col span="2">
		<aui:button name="back" type="button" href="<%=backURL.toString() %>" value="back"  class="btn btn-primary"></aui:button>
	
	</aui:col> --%>
</aui:row>

<liferay-ui:tabs names="Basic Information,Bank Details" refresh="false" type="tabs nav-tabs-default">
	<%-- <liferay-ui:tabs names="tab1,tab2,tab3,tab4" refresh="false" tabsValues="tab1,tab2,tab3,tab4">
 --%>
 <%-- <aui:input name="employeeId" type="hidden" value="" /> --%> 
	<!-- tab for basic information -->
	<liferay-ui:section>
		<%@ include file="viewBasicInfo.jsp"%>
	</liferay-ui:section>

	<!-- tab for salary details -->
	<%-- <liferay-ui:section>
		 <%@ include file="viewSalaryDetails.jsp"%>
	</liferay-ui:section> --%>

	<!-- tab for bank details -->
	<liferay-ui:section>
		<%@ include file="viewBankDetails.jsp"%>
	</liferay-ui:section>
</liferay-ui:tabs>
</aui:form>