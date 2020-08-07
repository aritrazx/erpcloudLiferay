<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PayrollSlabsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayrollSlabs"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PayrollIncrementLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayrollIncrement"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalSetup"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
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


<portlet:renderURL var="viewURL"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<portlet:param name="jspPage" value="/view.jsp" />
</portlet:renderURL>

<liferay-ui:header title="Back" backLabel="Back"
	backURL="<%=viewURL.toString() %>"></liferay-ui:header>

<%
	long isActive = 1;
	long submitStep = 3;
	AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);

	List<AppraisalMaster> appraisalMastersList = new ArrayList<AppraisalMaster>();

	appraisalMastersList = AppraisalMasterLocalServiceUtil
			.findBySettingIdAndsubmitStep(setup.getAppraisalSettingId(), submitStep);

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	List<PayrollIncrement> increments = new ArrayList<PayrollIncrement>();
	increments = PayrollIncrementLocalServiceUtil.getPayrollIncrements(-1, -1);
%>

<portlet:actionURL name="appraisalDraftProcess" var="draftProcessURL" />
<portlet:actionURL name="appraisalFinalProcess" var="finalProcessURL" />


<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = appraisalMastersList;
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
		modelVar="var">
		<%
			long employeeCode = 0;
					String employeeName = StringPool.BLANK;
					Employee empObj = EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
					employeeCode = empObj.getEmployeeCode();
					employeeName = empObj.getFirstName() + " " + empObj.getLastName();
		%>
		<liferay-ui:search-container-column-text name="Employee Code"
			orderable="true">
			<%=employeeCode%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Employee"
			orderable="true">
			<%=employeeName%>
		</liferay-ui:search-container-column-text>
		<%
			String ratingKey = StringPool.BLANK;
					RatingMaster ratingMaster = null;
					if (Validator.isNotNull(var.getOverallRatingMan())) {
						ratingMaster = RatingMasterLocalServiceUtil.getRatingMaster(var.getOverallRatingMan());
					}
					if (Validator.isNotNull(ratingMaster)) {
						ratingKey = ratingMaster.getRatingKey();
					}
		%>
		<liferay-ui:search-container-column-text name="Overall Rating"
			orderable="true">
			<%=ratingKey%>
		</liferay-ui:search-container-column-text>

		<%
			double totalPay = 0;
			double bonusPay = 0;
			double bonusPercentage = 0;
			PayrollSlabs payrollSlabs = null;
			payrollSlabs = PayrollSlabsLocalServiceUtil
					.findByAppraisalSettingIdRatingId(setup.getAppraisalSettingId(), var.getOverallRatingMan());
			if (payrollSlabs != null) {
				bonusPercentage = payrollSlabs.getBonusPercentage();
			}

			List<PayrollIncrement> payrollIncrements = PayrollIncrementLocalServiceUtil
					.findByemployeeIdAppraisalSettingIdFinancialYear(var.getEmployeeId(),
							var.getAppraisalSettingId(), setup.getFinancialYear());
		%>
		<%
			if (payrollIncrements.size() > 0) {
				for (PayrollIncrement increment : payrollIncrements) {
					totalPay = totalPay + increment.getPostHeadComponentVal();
					bonusPay = (long) ((totalPay * bonusPercentage) / 100);
					String componentName = "";
					PayComponent component = PayComponentLocalServiceUtil
							.getPayComponent(increment.getComponentId());
					if (component != null) {
						componentName = component.getName();
					}
		%>
		<liferay-ui:search-container-column-text name="<%=componentName%>"
			orderable="true">
			<%=increment.getPostHeadComponentVal()%>
		</liferay-ui:search-container-column-text>
		<%
			}
				}
		%>
		<%
			
		%>
		<liferay-ui:search-container-column-text name="Total Pay"
			orderable="true">
			<%=totalPay%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Bonus Pay"
			orderable="true">
			<%=bonusPay%>
		</liferay-ui:search-container-column-text>
		<%-- <liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					viewAppraisalLetter.setParameter("appraisalSettingId",
											String.valueOf(var.getAppraisalSettingId()));
									viewAppraisalLetter.setParameter("employeeId", String.valueOf(var.getEmployeeId()));
									//	viewSalary.setParameter("jspPage", "/META-INF/resources/addAppraisalSetup.jsp");
				%>

				<liferay-ui:icon url="<%=viewSalary.toString()%>"
					message="View Salary" image="view" />
				<liferay-ui:icon url="<%=viewAppraisalLetter.toString()%>"
					message="View Appraisal Letter" image="view" />

			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text> --%>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>


<%
	if (setup != null) {
		if (setup.getIsLocked() == 0) {
%>
<aui:form name="draftProcess" action="<%=draftProcessURL.toString()%>"
	method="post">
	<aui:button type="submit" value="Draft Process"></aui:button>
</aui:form>


<aui:form name="finalProcess" action="<%=finalProcessURL.toString()%>"
	method="post">
	<aui:button type="submit" value="Final Process"></aui:button>
</aui:form>
<%
	}
	}
%>



