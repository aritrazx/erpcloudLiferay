<%@page import="com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApply"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = td.getUserId();
	System.out.println("UserId..............."+userId);
	Employee empObj = EmployeeLocalServiceUtil.findByemployees(userId);

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	long leaveApplyId = ParamUtil.getLong(request, "leaveApplyId");
	
	boolean editURL = false;
	LeaveApply leave = null;
		if (leaveApplyId != 0) {
			editURL = true;
			try{
			leave = LeaveApplyLocalServiceUtil.getLeaveApply(leaveApplyId);
			}catch(Exception e){
				
			}
	} 
		
%>
<aui:row>
	<aui:col span="4">
		<p>
			Employee Code : <b style="color: #f48120;"><%=empObj.getEmployeeCode()%></b>
	</p>
</aui:col>

<aui:col span="4">
 <p>
		Employee Name : <b style="color: #f48120;"><%=empObj.getFirstName()%> <%=empObj.getLastName()%></b> 
		</p>
	</aui:col>
	<aui:col span="4">
		<p>
			Total Leave Applied for : <b style="color: #f48120;"><%=leave.getLeaveDays()%></b>
		</p>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="4">
		<p>
			From Date : <b style="color: #f48120;"><%= dateFormat.format(leave.getFromDate())%></b>
		</p>
	</aui:col>
	<aui:col span="4">
		<p>
			To Date :<b style="color: #f48120;"><%= dateFormat.format(leave.getToDate())%></b> 
		</p>
	</aui:col>
	<aui:col span="4">
	</aui:col>
</aui:row>

<aui:row>
	<p>
		Reason :<b style="color: #f48120;"><%=leave.getReason()%></b> 
	</p>
</aui:row>
<aui:row>
	<p>
		Status :<b style="color: #f48120;">Approved</b>
	</p>
</aui:row>