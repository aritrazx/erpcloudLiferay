<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page
	import="com.liferay.famocom.erpcloud.managerappraisal.constants.ManagerAppraisalViewPortletKeys"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.model.AppraisalProjectMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
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

			Employee employee = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
			boolean isProjectManager = true;
			long isActive = ManagerAppraisalViewPortletKeys.AppraisalSettingActive;
			long submitStepForPending = ManagerAppraisalViewPortletKeys.SubmitStepForPending;
			long submitStepForReviewed = ManagerAppraisalViewPortletKeys.SubmitStepForReviewed;
			AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);

			List<AddTeamMember> projectList = new ArrayList<AddTeamMember>();
			List<AppraisalProjectMaster> employeePendingList = new ArrayList<AppraisalProjectMaster>();
			List<AppraisalProjectMaster> employeeReviewedList = new ArrayList<AppraisalProjectMaster>();
			List<AppraisalMaster> appraisalMasters = new ArrayList<AppraisalMaster>();
			if (Validator.isNotNull(employee)) {
				projectList = AddTeamMemberLocalServiceUtil
						.findByGetProjectManagerProjectList(employee.getEmployeeId(), isProjectManager);
				System.out.println("projectList size : " + projectList.size());
			}
			if (Validator.isNotNull(setup)) {
				if (projectList.size() > 0) {
					for (AddTeamMember memberObj : projectList) {
						System.out.print(
								"setup.getAppraisalSettingId(), memberObj.getProjectId(), submitStepForPending: "
										+ setup.getAppraisalSettingId() + ".." + memberObj.getProjectId() + ".."
										+ submitStepForPending);
						employeePendingList = AppraisalProjectMasterLocalServiceUtil
								.findByEmployeeListFromManager(setup.getAppraisalSettingId(),
										memberObj.getProjectId(), submitStepForPending);
						employeeReviewedList = AppraisalProjectMasterLocalServiceUtil
								.findByEmployeeListFromManager(setup.getAppraisalSettingId(),
										memberObj.getProjectId(), submitStepForReviewed);
						System.out.println("employeeList size : " + employeePendingList.size());
					}
				}
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
			results = employeePendingList;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.AppraisalProjectMaster"
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
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<liferay-ui:icon-menu markupView="lexicon">
				<%
					appraisalViewURL.setParameter("managerId",
													String.valueOf(employee.getEmployeeId()));
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
			results = employeeReviewedList;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.AppraisalProjectMaster"
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
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<liferay-ui:icon-menu markupView="lexicon">
				<%
					appraisalViewURL.setParameter("finalSubmit", "finalSubmit");
											appraisalViewURL.setParameter("managerId",
													String.valueOf(employee.getEmployeeId()));
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
