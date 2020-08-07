<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApply"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = td.getUserId();
	System.out.println("UserId..............." + userId);
	//Employee empObj = EmployeeLocalServiceUtil.findByemployees(userId);

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	long leaveApplyId = ParamUtil.getLong(request, "leaveApplyId");
	long leaveTypeId = ParamUtil.getLong(request, "leaveTypeId");
	if (Validator.isNotNull(leaveApplyId)) {
		LeaveApply leaveApply = null;
		LeaveType leaveType = null;
		Employee employee = null;
		if (Validator.isNotNull(leaveTypeId) && Validator.isNotNull(leaveTypeId)) {

			leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(leaveApplyId);
			leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
			employee = EmployeeLocalServiceUtil.getEmployee(leaveApply.getEmployeeId());
		}
%>
<aui:row  span="12">
	<aui:col span="4">
		<label>
			Employee Code : <b style="color: #f48120;"><%=employee.getEmployeeCode()%></b>
		</label>
	</aui:col>

	<aui:col span="4">
		<label>
			Employee Name : <b style="color: #f48120;"><%=employee.getFirstName()%>
				<%=employee.getLastName()%></b>
		</label>
	</aui:col>
	<aui:col span="4">
		<label>
			Total Leave Applied for : <b style="color: #f48120;"><%=leaveApply.getLeaveDays()%></b>
		</label>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="4">
		<p>
			From Date : <b style="color: #f48120;"><%=dateFormat.format(leaveApply.getFromDate())%></b>
		</p>
	</aui:col>
	<aui:col span="4">
	</aui:col>
	<aui:col span="4">
		<p>
			To Date :<b style="color: #f48120;"><%=dateFormat.format(leaveApply.getToDate())%></b>
		</p>
	</aui:col>
</aui:row>

<aui:row>
	<p>
		<%if(Validator.isNull(leaveApply.getReason())){ %>

		Reason :<b style="color:#b4b4b4">No Comments</b>

		<%}else{ %>
		Reason :<b style="color:  #f48120;;"><%=leaveApply.getReason()%></b>

		<%} %>
	</p>
</aui:row>
<aui:row>
	<p>
		Status :<b style="color: #f48120;">Approved</b>
	</p>
</aui:row>
<%
	}
%>