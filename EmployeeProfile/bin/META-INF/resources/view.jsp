<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	ThemeDisplay td = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	User user2 = td.getUser();
	Employee emp = null;
	if(Validator.isNotNull(user2)){
		emp = EmployeeLocalServiceUtil.findByemployees(user.getUserId());
	}
	long portletid = PortalUtil.getPlidFromPortletId(td.getScopeGroupId(), 
		"EmployeeDetails");
	
	
	
%>



<liferay-portlet:renderURL var="viewEmployeeURL"   plid="<%= portletid %>" 
	 windowState="<%=LiferayWindowState.NORMAL.toString()%>" 
	 portletName="EmployeeDetails" >
	 <liferay-portlet:param name="jspPage" value="/viewEmployee.jsp"/> 
	 <liferay-portlet:param name="employeeId" value="<%=String.valueOf(emp.getEmployeeId())%>"	/>
	  <liferay-portlet:param name="employeeCode" value="<%=String.valueOf(emp.getEmployeeCode())%>"	/>
 </liferay-portlet:renderURL>


<%-- <aui:input name="a" type="hidden" href="<%=viewEmployeeURL.toString() %>"></aui:input> --%>


