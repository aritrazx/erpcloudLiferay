<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalSetup"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalMaster"%>
<%@page import="java.util.List"%>
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
	List<AppraisalMaster> aMSList = new ArrayList<AppraisalMaster>();
	aMSList = AppraisalMasterLocalServiceUtil.getAppraisalMasters(-1, -1);

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL finalReviewUrl = renderResponse.createRenderURL();
	finalReviewUrl.setParameter("jspPage", "/META-INF/resources/finalReview.jsp");

	/* PortletURL sendMailUrl = renderResponse.createActionURL();
	sendMailUrl.setParameter("jspPage", "/META-INF/resources/finalReview.jsp"); */

	PortletURL viewSalary = renderResponse.createRenderURL();
	viewSalary.setParameter("jspPage", "/META-INF/resources/viewSalary.jsp");

	PortletURL viewAppraisalLetter = renderResponse.createRenderURL();
	viewAppraisalLetter.setParameter("jspPage", "/viewAppraisalLetter.jsp");

	long isActive = 1;
	AppraisalSetup seAppraisalSetup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
%>

<portlet:actionURL name="sendMailAppraisal" var="sendMailUrl">
</portlet:actionURL>

<%-- <aui:button type="submit" href="<%=finalReviewUrl.toString()%>"
	cssClass="custom-button" name="submit" label="" value="+Final Review"></aui:button> --%>
	<a class="btn btn-primary btn-default" href="<%=finalReviewUrl.toString()%>">+Final Review</a>
<%
	if (seAppraisalSetup != null) {
		if (seAppraisalSetup.getIsLocked() == 1) {
%>
<%-- <aui:button type="submit" href="<%=sendMailUrl.toString()%>"
	cssClass="custom-button" name="submit" label="" value="Send Mail"></aui:button> --%>
	<a class="btn btn-primary btn-default" href="<%=finalReviewUrl.toString()%>">Send Mail</a>
<%
		}
	}
%>

<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = aMSList;
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
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					viewAppraisalLetter.setParameter("appraisalSettingId",
											String.valueOf(var.getAppraisalSettingId()));
									viewAppraisalLetter.setParameter("employeeId", String.valueOf(var.getEmployeeId()));
									//	viewSalary.setParameter("jspPage", "/META-INF/resources/addAppraisalSetup.jsp");
				%>
				<%
				
					if (seAppraisalSetup != null) {
						if (seAppraisalSetup.getIsLocked() == 1) {
							if (var.getSubmitStep() == 3) {
				%>
				<%-- <liferay-ui:icon url="<%=viewSalary.toString()%>" message="View Salary" image="view" /> --%>
				<liferay-ui:icon url="<%=viewAppraisalLetter.toString()%>"
					message="View Appraisal Letter" image="view" />
				<%
							}
						}
					}
				%>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>


<script>
$(document).on({
    "contextmenu": function(e) {
        console.log("ctx menu button:", e.which); 

        // Stop the context menu
        e.preventDefault();
    },
    "mousedown": function(e) { 
        console.log("normal mouse down:", e.which); 
    },
    "mouseup": function(e) { 
        console.log("normal mouse up:", e.which); 
    }
});


$(document).keydown(function (event) {
    if (event.keyCode == 123) { // Prevent F12
        return false;
    } else if (event.ctrlKey && event.shiftKey && event.keyCode == 73) { // Prevent Ctrl+Shift+I        
        return false;
    }
});

</script>


