<%@page
	import="com.liferay.famocom.erpcloud.hrappraisal.constants.HrAppraisalViewPortletKeys"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalSetup"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalMaster"%>
<%@ include file="init.jsp"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PerformanceLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Performance"%>
<%@page import="java.util.List"%>


<%
	boolean isViewPermission = false;
	try {
		isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
				"ManageAppraisalMVC", "VIEW");
		System.out.print("isViewPermission " + isViewPermission);
	} catch (Exception exception) {
		exception.printStackTrace();
	}
	if (isViewPermission) {

		if (themeDisplay.isSignedIn()) {

			long isActive = HrAppraisalViewPortletKeys.AppraisalSettingActive;
			long submitStepForPending = HrAppraisalViewPortletKeys.SubmitStepForPending;
			long submitStepForReviewed = HrAppraisalViewPortletKeys.SubmitStepForReviewed;
			List<AppraisalMaster> appraisalMasterPendingList = new ArrayList<AppraisalMaster>();
			List<AppraisalMaster> appraisalMasterReviewedList = new ArrayList<AppraisalMaster>();
			AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
			if (setup != null) {
				appraisalMasterPendingList = AppraisalMasterLocalServiceUtil
						.findBySettingIdAndsubmitStep(setup.getAppraisalSettingId(), submitStepForPending);
				appraisalMasterReviewedList = AppraisalMasterLocalServiceUtil
						.findBySettingIdAndsubmitStep(setup.getAppraisalSettingId(), submitStepForReviewed);
			}
%>

<%
	PortletURL iteratorUrl = renderResponse.createRenderURL();
			iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
			PortletURL appraisalViewURL = renderResponse.createRenderURL();
%>
<h2>Pending Review List</h2>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = appraisalMasterPendingList;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.AppraisalMaster"
		modelVar="type">
		<%
			Employee emp = null;
							try {
								emp = EmployeeLocalServiceUtil.getEmployee(type.getEmployeeId());
								System.out.println(".......emp......" + emp);
							} catch (Exception e) {

							}
		%>

		<liferay-ui:search-container-column-text name="Employee Name"
			orderable="true">

			<%=emp.getFirstName() + " " + emp.getLastName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Employee Code"
			orderable="true">
			<%=emp.getEmployeeCode()%>
		</liferay-ui:search-container-column-text>
		<%-- <%
			Date addDate = type.getAddedDate();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
			String strDate = formatter.format(addDate);
		%>

		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true">
			<%=strDate%>
		</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<liferay-ui:icon-menu>
				<%
					appraisalViewURL.setParameter("employeeId", String.valueOf(type.getEmployeeId()));
											appraisalViewURL.setParameter("jspPage", "/META-INF/resources/viewSelectedEmp.jsp");
				%>

				<liferay-ui:icon url="<%=appraisalViewURL.toString()%>"
					message="view" image="view" />

			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>








<h2>Reviewed List</h2>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = appraisalMasterReviewedList;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.AppraisalMaster"
		modelVar="type">
		<%
			Employee emp = null;
							try {
								emp = EmployeeLocalServiceUtil.getEmployee(type.getEmployeeId());
								System.out.println(".......emp......" + emp);
							} catch (Exception e) {

							}
		%>

		<liferay-ui:search-container-column-text name="Employee Name"
			orderable="true">

			<%=emp.getFirstName() + " " + emp.getLastName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Employee Code"
			orderable="true">
			<%=emp.getEmployeeCode()%>
		</liferay-ui:search-container-column-text>
		<%-- <%
			Date addDate = type.getAddedDate();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
			String strDate = formatter.format(addDate);
		%>

		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true">
			<%=strDate%>
		</liferay-ui:search-container-column-text> --%>
		<%-- <liferay-ui:search-container-column-text name="Status"   orderable="true" orderableProperty="status">
				<%=type.getStatus()%>
				</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<liferay-ui:icon-menu>
				<%
					appraisalViewURL.setParameter("employeeId", String.valueOf(type.getEmployeeId()));
											appraisalViewURL.setParameter("jspPage", "/META-INF/resources/viewSelectedEmp.jsp");
				%>

				<liferay-ui:icon url="<%=appraisalViewURL.toString()%>"
					message="view" image="view" />

			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>

<%
	}
	}
%>



