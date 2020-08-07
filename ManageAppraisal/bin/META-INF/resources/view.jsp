<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.appraisal.constants.ManageAppraisalMVCPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
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
		
	if(themeDisplay.isSignedIn()){

	//Date curDate = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
	Employee employee = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
	long isActive = ManageAppraisalMVCPortletKeys.AppraisalSettingActive;
	AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
	System.out.println("setup object : " + setup);
	long appraisalPeriod = 0;
	Date dateOfJoining = null;
	Date toDateCycle = null;
	Calendar startCalendar = new GregorianCalendar();
	Calendar endCalendar = new GregorianCalendar();
	int diffMonth = 0;
	int diffYear = 0;
	String strDateOfJoining = "";
	String strToDateCycle = "";
	Date fromDateSubmission = null;
	Date toDateSubmission = null;
	if (Validator.isNotNull(setup)) {
		AppraisalMaster getMasterObj = null;
		if (setup != null && employee != null) {
			getMasterObj = AppraisalMasterLocalServiceUtil
					.findBySettingIdAndEmployeeIds(setup.getAppraisalSettingId(), employee.getEmployeeId());
			appraisalPeriod = setup.getAppraisalPeriod();
			dateOfJoining = employee.getDateOfJoing();
			toDateCycle = setup.getToDateCycle();
			fromDateSubmission = setup.getFromDateSubmission();
			toDateSubmission = setup.getToDateSubmission();
			System.out.println("getMasterObj Object : " + getMasterObj);
		}
		long submitStep = 0;
		if (getMasterObj != null) {
			submitStep = getMasterObj.getSubmitStep();
		}

		if (dateOfJoining.before(toDateCycle)) {
			strDateOfJoining = dateFormat.format(dateOfJoining);
			strToDateCycle = dateFormat.format(toDateCycle);
			startCalendar.setTime(dateOfJoining);
			endCalendar.setTime(toDateCycle);
			diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			diffMonth = (diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH))
					+ 1;
			System.out.println("diffMonth if..: " + diffMonth + "diffYear else..: " + diffYear);
		
%>

<liferay-ui:error key="add-error-project"
	message="Project information is mandatory, Please verfy" />
<liferay-ui:error key="add-error-Goal"
	message="Goal rating and comment is mandatory for every project, Please verfy" />
<liferay-ui:error key="add-error-GoalDetails"
	message="Goal Details rating is mandatory for every goal, Please verfy" />
<portlet:resourceURL var="getGoalDetailsURL">
	<portlet:param name="cmd" value="get-goal-details" />
</portlet:resourceURL>
<portlet:actionURL name="apprisalAction" var="apprisalActionURL">
</portlet:actionURL>

<%
String currTabs = StringPool.BLANK;
if (request.getAttribute("currTabs") != null) {
	currTabs = (String) request.getAttribute("currTabs");
}else{
	currTabs = "Project Information";
}
System.out.println("curtabs : "+currTabs);


			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String strCurDate = df.format(new Date());
			Date curDate = new SimpleDateFormat("dd/MM/yyyy").parse(strCurDate);
			System.out.print("curDate : "+curDate);
			System.out.print("fromDateSubmission : "+fromDateSubmission);
			System.out.print("toDateSubmission : "+toDateSubmission);
			if (((curDate.after(fromDateSubmission) && curDate.before(toDateSubmission))
					|| (curDate.after(fromDateSubmission) && curDate.equals(toDateSubmission))
					|| (curDate.equals(fromDateSubmission) && curDate.before(toDateSubmission))
					|| (curDate.equals(fromDateSubmission) && curDate.equals(toDateSubmission)))) {
				
				if (diffMonth >= appraisalPeriod) {

					if (submitStep == 1 || submitStep == 2 || submitStep == 3) {
%>

<div>You have already submitted your appraisal !!</div>

<%
	} else {
%>
<liferay-ui:tabs value="<%=currTabs %>"
	names="Basic Information,Project Information,Performance,Key Accomplishments,Overall Rating"
	refresh="false" type="tabs nav-tabs-default">
	<aui:form id="apprisalForm" name="apprisalForm" method="post"
		action="${apprisalActionURL}">
		<liferay-ui:section>
			<div>
				<%@ include file="performanceappraisal/basic-information.jspf"%></div>
		</liferay-ui:section>
		<liferay-ui:section>
			<div><%@ include
					file="performanceappraisal/project-information.jsp"%></div>
		</liferay-ui:section>
		<liferay-ui:section>
			<div>
				<%@ include file="performanceappraisal/performance.jsp"%></div>
		</liferay-ui:section>
		<liferay-ui:section>
			<div>
				<%@ include file="performanceappraisal/key-accomplishments.jsp"%></div>
		</liferay-ui:section>
		<liferay-ui:section>
			<div>
				<%@ include file="performanceappraisal/overall-rating.jsp"%></div>
		</liferay-ui:section>
		<aui:input id="sumbitVal" name="sumbitVal" type="hidden" value=""></aui:input>
		<aui:button-row>
			<aui:button type="submit" onClick="javascript:setVal(0)" name="save"
				value="Save as Draft" />
			<aui:button type="submit" onClick="javascript:setVal(1)"
				name="saveandsubmit" value="Save and Submit" />
		</aui:button-row>
	</aui:form>
</liferay-ui:tabs>

<%
	}
				} else {
%>
<span>You are not eligible for this appraisal!</span>
<%
	}
			} else {
%>
<span>No Appraisal Found!</span>
<%
	}
		} else {
%>
<span>You are not eligible for this appraisal, Better luck Next
	Year!</span>
<%
	}
	}
%>

<style>
.custom-button {
	border-color: #44a5aa;
	padding: 8px 14px;
	font-size: 16px;
	line-height: 20px;
	border-radius: 8px;
	color: #FFF;
	background-color: #44a5aa;
	width: 145px;
}

.panel-title {
	cursor: pointer;
}

.panel-title {
	display: block;
	padding: 15px 10px;
}

.plus-minus {
	position: absolute;
	top: 10px;
	right: 30px;
}

.delete {
	position: absolute;
	top: 10px;
	right: 10px;
}
</style>

<script>
	function setVal(strVal) {
		//alert(strVal);
		$('#<portlet:namespace/>sumbitVal').val(strVal);
	}

	$('.panel-collapse').on(
			'show.bs.collapse',
			function() {
				$(this).siblings('.panel-heading').addClass('active');
				$(this).siblings('.panel-heading').find('.toggleIcons')
						.removeClass('fa-plus').addClass('fa-minus');
			});

	$('.panel-collapse').on(
			'hide.bs.collapse',
			function() {
				$(this).siblings('.panel-heading').removeClass('active');
				$(this).siblings('.panel-heading').find('.toggleIcons')
						.removeClass('fa-minus').addClass('fa-plus');
			});
</script>


<%}
	}else{%>
<div class="control-group no-margin">
	<label class="control-label">You don't have permission to view
		the Appraisal Form</label>
</div>
<%} %>
