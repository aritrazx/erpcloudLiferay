<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApply"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Date"%>

<%@page import="javax.portlet.PortletURL"%>
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
	long notifyId = ParamUtil.getLong(request, "notifyId");
	String leaveApplyId = request.getParameter("leaveApplyId");
	System.out.println("leaveApplyId..."+leaveApplyId);
	LeaveApply leave = null;
	if (Validator.isNotNull(leaveApplyId)) {
		leave = LeaveApplyLocalServiceUtil.getLeaveApply(Long.valueOf(leaveApplyId));
	}

	PortletURL statusURL = renderResponse.createActionURL();
	statusURL.setParameter("javax.portlet.action", "updateStatus");

	PortletURL rejectURL = renderResponse.createActionURL();
	rejectURL.setParameter("javax.portlet.action", "reject");
%>

<aui:row span="12">
	<aui:form action="<%=statusURL%>" name="statusUpdate">
		<aui:col span="6" style="width: 50%; float: left;">
			<aui:input type="hidden" name="leaveApplyId"
				value="<%=leaveApplyId%>" />
			<aui:input type="text" name="fromDate" id="fromDate" readonly="true"
				value="<%=leave != null ? leave.getFromDate() : ""%>"
				 disabled="true" placeholder="Start Date" label="From Date">
			</aui:input>
			<aui:input name="reason" type="textarea" readonly="true"
				value="<%=leave != null ? leave.getReason() : ""%>"
				placeholder="Reason" label="Reason" />

			<aui:button name="saveButton" type="submit" value="Submit"
				cssClass="btn btn-success" />
		</aui:col>
		<aui:col span="6" style="width: 50%; float: left;">
			<aui:input type="text" name="toDate" readonly="true" id="toDate"
				value="<%=leave != null ? leave.getToDate() : ""%>" disabled="true"
				placeholder="To Date" label="To Date">

			</aui:input>
			<textarea name="Comment"> Comments </textarea>

			<aui:input type="radio" name="status" checked="true" label="Reject"
				value="1"></aui:input>
			<aui:input type="radio" name="status" label="Approve" value="2"></aui:input>
		</aui:col>
	</aui:form>
	<%-- aui:col span="6" style="width: 50%; float: left;">
		<aui:form action="<%=acceptURL.toString()%>" name="acceptURL">
			<aui:input name="notifyId" type="hidden" value="<%=notifyId %>" ></aui:input>
			<aui:button style="width: 130px;" value="Approved" type="submit"></aui:button>
		</aui:form>
	</aui:col>
	<aui:col span="6" style="width: 50%; float: left;">
		<aui:form action="<%=rejectURL.toString()%>" name="rejectURL">
			<aui:input name="notifyId" type="hidden" value="<%=notifyId %>" ></aui:input>
			<aui:input name="comment" label="Comment for Rejection" type="textarea" value="" ></aui:input><br/>
			<aui:button style="width: 130px;" value="Reject" type="submit"></aui:button>
		</aui:form>
	</aui:col> --%>
</aui:row>