<%@page import="com.liferay.famocom.erpcloud.hrappraisal.constants.HrAppraisalViewPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalSetup"%>
<%@page import="com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalMaster"%>
<%@ include file="init.jsp"%>
<%@page import="com.liferay.famocom.erpcloud.service.PerformanceLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Performance"%>
<%@page import="java.util.List"%>


<%
	String currTabs = StringPool.BLANK;
if (request.getAttribute("currTabs") != null) {
	currTabs = (String) request.getAttribute("currTabs");
}else{
	currTabs = "Performance";
}
	
	//Employee employee = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
	long employeeId = ParamUtil.getLong(request, "employeeId");
	long isActive = HrAppraisalViewPortletKeys.AppraisalSettingActive;
	AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
	System.out.println("setup object : "+setup);
	AppraisalMaster getMasterObj = null;
	getMasterObj = AppraisalMasterLocalServiceUtil.findBySettingIdAndEmployeeIds(setup.getAppraisalSettingId(),
			employeeId);
	System.out.println("getMasterObj Object : "+getMasterObj);
	System.out.println("currTabs : "+currTabs);
%>

<%
		boolean disabled = false;
		if(getMasterObj.getSubmitStep()==3){
			disabled = true;
			System.out.print("disabled..."+disabled);
		}
		System.out.print("disabled..11."+disabled);
		
%>

<liferay-ui:error key="add-error"
	message="Overall Rating and Comment is mandatory" />
<portlet:resourceURL var="getGoalDetailsURL">
	<portlet:param name="cmd" value="get-goal-details" />
</portlet:resourceURL>
<portlet:actionURL name="apprisalAction" var="apprisalActionURL">
</portlet:actionURL>
<liferay-ui:tabs value="<%=currTabs %>"
	names="Basic Information,Project Information,Performance,Key Accomplishments,Overall Rating"
	refresh="false">
	<aui:form id="apprisalForm" name="apprisalForm" method="post" action="${apprisalActionURL}">
	<aui:input name="employeeId" type="hidden" value="<%=employeeId %>"></aui:input>		
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
		<%if(getMasterObj.getSubmitStep()!=3){ %>
		<aui:button-row>
			<aui:input type="submit" cssClass="custom-button" name="save" label="" value="Final Submit" ></aui:input>
		</aui:button-row>
		<%} %>
	</aui:form>
</liferay-ui:tabs>

<style>
.custom-button{
	border-color: #44a5aa;
    padding: 8px 14px;
    font-size: 16px;
    line-height: 20px;
    border-radius: 8px;
    color: #FFF;
    background-color: #44a5aa;
    width: 145px;
    }
</style>

