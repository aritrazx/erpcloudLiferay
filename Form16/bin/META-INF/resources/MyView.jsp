<%@page
	import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.FormSixteenLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.FormSixteen"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@include file="/init.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	boolean isViewPermission = false;
	try {
		isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(), "Form16",
				"MY_FORM_VIEW");
		System.out.print("isViewPermission " + isViewPermission);
	} catch (Exception exception) {
		exception.printStackTrace();
	}
	if (isViewPermission) {
		PortletURL backURL = renderResponse.createRenderURL();
		backURL.setParameter("jspPage", "/view.jsp");

		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		//System.out.println("UserId..............."+userId);
		Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
		if (employee != null) {
			List<FormSixteen> formSixteenList = new ArrayList<>();
			DynamicQuery dynamicQuery = FormSixteenLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("employeeId", employee.getEmployeeId());
			dynamicQuery.add(criterion3);
			formSixteenList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("formSixteenList..............." + formSixteenList.size());
%>
<liferay-ui:header title="My Form16" backLabel="Back"
	backURL="<%=backURL.toString()%>"></liferay-ui:header>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = formSixteenList;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
							//portletSession.setAttribute("formSixteens", formSixteens);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.FormSixteen"
		modelVar="var">
		<%
			Employee empObj = null;
							try {
								empObj = EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
							} catch (Exception e) {
								e.printStackTrace();
							}
		%>
		<liferay-ui:search-container-column-text name="Employee Id">
			<b><%=empObj.getEmployeeId()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Name">
			<b><%=empObj.getFirstName()%> <%=empObj.getLastName()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Financial Year">
			<b><%=var.getFinancialYear()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Attached File">
			<%
				try {
										if (var.getFileEnteryId() > 0) {

											FileEntry fileEntry = DLAppServiceUtil.getFileEntry(var.getFileEnteryId());
											String filePath = DLUtil.getDownloadURL(fileEntry, fileEntry.getFileVersion(),
													themeDisplay, "");
											//System.out.println("FilePath .....................:-" + filePath);
			%>
			<liferay-ui:icon
				iconCssClass="<%=DLUtil.getFileIconCssClass(fileEntry.getExtension())%>"
				label="<%=true%>" url='<%=filePath%>' icon="pdf"
				message="<%=fileEntry.getTitle()%>" target="_blank" />
			<br>
			<%
				}
									} catch (Exception e) {
										e.printStackTrace();
									}
			%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>
<%
	} else {
%>
<liferay-ui:header title="Back" backLabel="Back"
	backURL="<%=backURL.toString()%>"></liferay-ui:header>
<h4 style="color: red">Sorry, You have no permission to acess this
	page!</h4>
<%
	}
	} else {
%>
<div class="control-group no-margin">
	<label class="control-label">You don't have permission to view
		the Form16</label>
</div>
<%
	}
%>