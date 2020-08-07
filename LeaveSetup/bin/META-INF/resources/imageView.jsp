<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveDoc"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	System.out.println(":::::::leaveApplyId::::::::::::::::::::::" + leaveApplyId);
	LeaveApply leaveApply = null;
	boolean isStatus = false;
	if (Validator.isNotNull(leaveApplyId)) {
		leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(Long.valueOf(leaveApplyId));
	}
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	PortletURL statusURL = renderResponse.createActionURL();
	statusURL.setParameter("javax.portlet.action", "updateStatus");
	if (leaveApply.getStatus() == 1) {
		isStatus = true;
	}
	PortletURL rejectURL = renderResponse.createActionURL();
	rejectURL.setParameter("javax.portlet.action", "reject");

	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/displayAllLeave.jsp");

	List<LeaveDoc> docList = new ArrayList<>();
	if (Validator.isNotNull(leaveApplyId)) {
		DynamicQuery dynamicQuery = LeaveDocLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("leaveApplyId", Long.valueOf(leaveApplyId));
		dynamicQuery.add(criterion3);
		docList = LeaveDocLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println(":::::::::::::docList::::::::::::::::" + docList.size());
	}
	Employee employee = null;
	LeaveType leaveType = null;
	if (Validator.isNotNull(leaveApply.getEmployeeId())) {
		employee = EmployeeLocalServiceUtil.getEmployee(leaveApply.getEmployeeId());
	}
	if (Validator.isNotNull(leaveApply.getLeaveTypeId())) {
		leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveApply.getLeaveTypeId());
	}
%>
<liferay-ui:header title="Approve/Reject" backLabel="Back"
	backURL="<%=backURL.toString()%>"></liferay-ui:header>
<aui:row span="12">
	<aui:form action="<%=statusURL%>" name="statusUpdate">
		<aui:input type="hidden" name="leaveApplyId" value="<%=leaveApplyId%>" />
		<aui:col span="6" style="width: 50%; float: left;">
			<p>
				Name:<b style="color: #f48120;"><%=employee.getFirstName()%>
				<%=employee.getLastName()%></b></p>

			<p>
				From Date : <b style="color: #f48120;"><%= dateFormat.format(leaveApply.getFromDate())%></b>
			</p>
			<p>
				Reason :<b style="color: #f48120;"><%=leaveApply.getReason()%></b>
			</p>
			<%
				if (Validator.isNotNull(leaveApply)) {
								if (leaveApply.getStatus() == 0) {
			%>

			<%
				}
							}
			%>
		</aui:col>
		<p>
			Leave Type:<b style="color: #f48120;"><%=leaveType.getLeaveName()%>
			(<%=leaveType.getAbb()%>)</b>
		</p>
		<aui:col span="6" style="width: 50%; float: left;">
			<p>
				To Date :<b style="color: #f48120;"><%= dateFormat.format(leaveApply.getToDate())%></b>
			</p>
			<aui:input type="textarea" name="comment"
				value="<%=leaveApply != null ? leaveApply.getHrComments() : ""%>"
				label="Comments"></aui:input>

			<p>
				Uploaded Document :
				<%
				if (docList.size() == 0) {
			%><b style="color: #f48120;">No Document Uploaded</b>
				<%
					}
				%>

				<%
					for (LeaveDoc doc : docList) {
									System.out.println("FileEntry Iddd-" + doc.getFileEntryId());
									if (doc.getFileEntryId() > 0) {

										FileEntry fileEntry = DLAppServiceUtil.getFileEntry(doc.getFileEntryId());
										String filePath = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(),
												themeDisplay, "");
										System.out.println("FilePath .....................:-" + filePath);
				%>
				<a href="<%=filePath%>" target="_blank"><b
					style="color: #f48120; text-decoration: underline;"><%=fileEntry.getTitle()%></b></a>
				</br>
				<%
					}
								}
				%>
				
				<aui:input type="radio" name="status"
					checked="<%=isStatus == false%>" label="Reject" value="2"></aui:input>
				<aui:input type="radio" name="status" label="Approve"
					checked="<%=isStatus == true%>" value="1"></aui:input>
		</aui:col>
		<aui:button name="saveButton" type="submit" value="Submit"
			cssClass="btn btn-success" />
	</aui:form>
</aui:row>