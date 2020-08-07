<%@page import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	PortletURL leaveViewURL = renderResponse.createRenderURL();
	leaveViewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	List<LeaveType> leaveType = new ArrayList<>();
	leaveType = LeaveTypeLocalServiceUtil.getLeaveTypes(-1, -1);

	long leaveTypeId = ParamUtil.getLong(request, "leaveTypeId");
	boolean editURL = ParamUtil.getBoolean(request, "editURL", false);

	System.out.println("editURL Id >>>>>>>...." + editURL);

	/* boolean editURL = false; */
	LeaveType leave = null;
	if (leaveTypeId != 0) {
		leave = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
	}
	System.out.println("Leave Id >>>>>>>...." + leaveTypeId);
%>
<liferay-ui:error key="Add-error"
	message="Sorry, Leave Name Already Exist" />
<aui:row>
	<aui:col span="10">
		<h1>Add Leave</h1>
	</aui:col>
	<aui:col span="2">
	<%-- 	<aui:button type="submit" name="LeaveList"
			href="<%=leaveViewURL.toString()%>" value="Leave List" /> --%>
			<a class="btn btn-primary btn-default"
	name="LeaveList" type="submit"
	href="<%=leaveViewURL.toString()%>">Leave List</a>
	</aui:col>
</aui:row>
<portlet:actionURL name="addLeave" var="addLeaveURL" />
<portlet:actionURL name="editLeave" var="editLeaveURL" />
<aui:form name="addLeave"
	action="<%=editURL != true ? addLeaveURL.toString() : editLeaveURL.toString()%>"
	method="post">
	<%
		System.out.println("EDit URL Id >>>>>>>...." + editURL);
	%>
	<aui:input name="leaveTypeId" type="hidden" value="<%=leaveTypeId%>" />
	<liferay-ui:tabs names="Leave Information,Rules" refresh="false">
		<!-- tab for basic information -->
		<liferay-ui:section>
			<%@ include file="leaveInformation.jsp"%>
		</liferay-ui:section>
		<liferay-ui:section>
			<%@ include file="rules.jsp"%>
		</liferay-ui:section>
	</liferay-ui:tabs>
	<aui:button name="save" type="submit" value="save" cssClass="btn btn-success"/>
	<aui:button name="cancel" type="cancel" value="cancel" onClick="<%= viewURL.toString() %>" cssClass="btn btn-danger" />
</aui:form>