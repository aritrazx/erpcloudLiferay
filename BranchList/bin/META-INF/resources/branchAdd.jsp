
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.BranchLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Branch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = td.getUserId();
	Employee empObj = EmployeeLocalServiceUtil.findByemployees(userId);

	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", "/view.jsp");

	long branchId = ParamUtil.getLong(request, "branchId");
	boolean editURL = false;
	Branch branch = null;
	if (branchId != 0) {
		editURL = true;
		try {
			branch = BranchLocalServiceUtil.getBranch(branchId);
		} catch (Exception e) {

		}
	}
%>
<portlet:actionURL name="addBranch" var="addBranchURL" />
<portlet:actionURL name="editBranch" var="editBranchURL" />

<aui:form name="addBranch"
	action="<%=editURL != true ? addBranchURL.toString() : editBranchURL.toString()%>"
	method="post">
	<aui:row>
		<aui:col span="6">
		<aui:input name="branchId" type="hidden" value="<%=branchId%>" />
			<aui:input label="Name" type="text" name="branchName"
				value="<%=branch != null ? branch.getBranchName() : ""%>"
				placeholder="Enter a name">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input label="Address" name="branchAddress" type="textarea"
				value="<%=branch != null ? branch.getBranchAddress() : ""%>"
				placeholder="Reason" />
		</aui:col>
		<aui:col span="6">

			<%
				int isStatus = 1;
							if (Validator.isNotNull(branch)) {
								if (branch.getStatus() == 2) {
									isStatus = 2;
								}
							}
			%>
			<aui:input type="radio" name="status" label="Active"
				checked="<%=isStatus == 1%>" value="1"></aui:input>
			<aui:input type="radio" name="status" checked="<%=isStatus == 2%>"
				label="Inactive" value="2"></aui:input>
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button name="saveButton" type="submit" value="save"
			cssClass="btn btn-success" />
		<aui:button name="cancelButton" type="cancel" value="cancel"
			onClick="<%= viewURL.toString() %>" cssClass="btn btn-danger" />
	</aui:button-row>
</aui:form>