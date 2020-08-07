<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.JobEvaluationLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobEvaluation"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobPost"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitmentProcess"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	
	String applyCandidateId = ParamUtil.getString(request,"applyCandidateId",StringPool.BLANK);
	long jobPostId =ParamUtil.getLong(request,"jobPostId");
	String recruitmentProcessId =ParamUtil.getString(request,"recruitmentProcessId",StringPool.BLANK);
	System.out.println("applyCandidateId ---- "+applyCandidateId+"  jobPostId----"+jobPostId+" recruitmentProcessId---"+recruitmentProcessId);
	
	
	CandidateApply applyObj = null;
	JobOpening openingObj = null;
	Employee findEmployee = null;
	FileEntry dlfile = null;
	String url = StringPool.BLANK;
	String yearEx = StringPool.BLANK;
	RecruitmentProcess process = null;
	List<JobEvaluation> evaluation=null;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String interviewDate = StringPool.BLANK;
		if (Validator.isNotNull(recruitmentProcessId)) {
			process = RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(Long.parseLong(recruitmentProcessId));
			 interviewDate = dateFormat.format(process.getInterviewDate());
		}

		/* if (Validator.isNotNull(interviewerId)) {
			employee = EmployeeLocalServiceUtil.getEmployee(interviewerId);
			interViewerName = employee.getFirstName() + " " + employee.getLastName();
		} */

		if (Validator.isNotNull(applyCandidateId)) {
			applyObj = CandidateApplyLocalServiceUtil.getCandidateApply(Long.parseLong(applyCandidateId));
			System.out.println("applyObj "+applyObj);
			if (Validator.isNotNull(applyObj.getJobOpeningId())) {
				openingObj = JobOpeningLocalServiceUtil.getJobOpening(applyObj.getJobOpeningId());
				System.out.println("openingObj "+openingObj);
			}
			if (Validator.isNotNull(applyObj.getReferenceEmployeeId())) {

				findEmployee = EmployeeLocalServiceUtil.getEmployee(applyObj.getReferenceEmployeeId());
			}
		}
			System.out.println("11111" + applyObj.getCvFileId());
			
		/*----------for cv url------------*/	
		try {
		if (applyObj != null && Validator.isNotNull(applyObj.getCvFileId())) {
			System.out.println("1");
			dlfile = DLAppServiceUtil.getFileEntry(applyObj.getCvFileId());
			Date date2 = new Date();
			Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60)
					+ date2.getSeconds()) * 1000);
			url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
					+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/"
					+ dlfile.getFileName() + "/" + dlfile.getUuid() + "?t=" + time2;

			System.out.println("2");
		}
		} catch (Exception e) {
		}
		
		/*---------------caculate experience-------------- */
		if (applyObj.getYearOfExp() != 0) {
			yearEx = applyObj.getYearOfExp() + "." + applyObj.getMonthOfExp() + "year";
		} else if (applyObj.getMonthOfExp() != 0) {
			yearEx = applyObj.getMonthOfExp() + "months";
		}
	
		/*--------------find job evaluations-----------------*/
		if(Validator.isNotNull(jobPostId)){
			evaluation = JobEvaluationLocalServiceUtil.findByjobEvaluation(jobPostId);
		}
		
		
	/* PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/META-INF/resources/view.jsp"); */
%>

<portlet:actionURL name="interviewResult" var="interviewResultURL" />
<aui:form name="interviewResult"
	action="<%=interviewResultURL.toString()%>" method="post">
	
	<aui:input name="jobPostId" type="hidden" id="jobPostId"
		value="<%=jobPostId%>"></aui:input>
	<aui:input name="applyCandidateId" type="hidden" id="applyCandidateId"
		value="<%=applyCandidateId%>"></aui:input>
	<aui:input name="interviewerId" type="hidden" id="interviewerId"
		value="<%=process.getInterviewerId()%>"></aui:input>
	<aui:input name="recruitmentProcessId" type="hidden"
		value="<%=recruitmentProcessId%>"></aui:input>
	
	<aui:row>
		<aui:col span="12">
			<%-- <a href="<%=backURL.toString()%>"><span
				class="icon-monospaced"><svg
						class="lexicon-icon lexicon-icon-angle-left" focusable="false"
						role="img" title="Back" backLabel="Back" viewBox="0 0 512 512">
    					<path class="lexicon-icon-outline"
							d="M114.106 254.607c0.22 6.936 2.972 13.811 8.272 19.11l227.222 227.221c11.026 11.058 28.94 11.058 39.999 0 11.058-11.026 11.058-28.94 0-39.999l-206.333-206.333c0 0 206.333-206.333 206.333-206.333 11.058-11.059 11.058-28.973 0-39.999-11.058-11.059-28.973-11.059-39.999 0l-227.221 227.221c-5.3 5.3-8.052 12.174-8.273 19.111z"></path>
			</svg></span>Back</a> --%>
			<h3 align="center">Candidate Information</h3>
			</br>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<p>
				Full Name : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getFirstName() + " " + applyObj.getLastName() : ""%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Email Address : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getEmailAddress() : " "%></b>
			</p>
		</aui:col>
	</aui:row>
	</br>
	<aui:row>
		<aui:col span="6">
			<p>
				Mobile Number : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getPhoneNumber() : " "%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Experience : <b style="color: #f48120;"><%=yearEx%></b>
			</p>
		</aui:col>
	</aui:row>
	</br>

	<aui:row>
		<aui:col span="6">
			<p>
				Apply For : <b style="color: #f48120;"><%=openingObj != null ? openingObj.getOpeningFor() : " "%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Skills : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getSkillset() : " "%></b>
			</p>
		</aui:col>
	</aui:row>
	</br>
	<aui:row>
		<aui:col span="12">
			<%
				if (url != null) {
			%>
			<p>
				View Cv :<a href="<%=url.toString()%>" target="_blank"><b
					style="color: #ADD8E6; text-decoration: underline;">&nbsp&nbspView
						Cv</b></a>
			</p>
			<%
				} else {
			%>
			<p>
				View Cv :<b style="color: #f48120;">&nbsp&nbspCv Not Found</b>
			</p>
			<%
				}
			%>
		</aui:col>
	</aui:row>
	<hr>
	<%
		if (Validator.isNotNull(findEmployee)) {
	%>

	<aui:row>
		<h3 align="center">Reference</h3>
		</br>
		<aui:col span="6">
			<p>
				Employee Name: <b style="color: #f48120;"><%=findEmployee != null
									? findEmployee.getFirstName() + " " + findEmployee.getLastName()
									: ""%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Employee Code: <b style="color: #f48120;"><%=findEmployee != null ? findEmployee.getEmployeeCode() : ""%></b>
			</p>
			<%-- <aui:validator name="digits"></aui:validator> --%>
		</aui:col>

	</aui:row>
	<hr>
	<%
		}
	%>

	<%			
				String jobPost = "";
				for (JobEvaluation jobEvaluation : evaluation) {
					jobPost = jobEvaluation.getPostEvaluationId()+","+jobPost;
					
			%>
			
	</br>
	<aui:row>
		<aui:col span="4">
			<label><font size="4"><%=jobEvaluation.getEvaluationName()%></b>
					:</label>
		</aui:col>
		<aui:col span="3">

			<input name="<portlet:namespace/>rating_<%=jobEvaluation.getPostEvaluationId() %>" type="text" value="" label="" required="true">
			</input>
		</aui:col>
	</aui:row>
	<%
						}
			%>
			<aui:input name="postEvaluationId" type="hidden"
		value="<%=jobPost%>"></aui:input>
	<aui:row>
		<aui:col span="6">
			<aui:input name="interviewerRemark" type="textarea" label="Remark" value="" required="true"></aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:input id="sumbitVal" name="sumbitVal" type="hidden" value=""></aui:input>
		<aui:col span="6">
			<button type="submit" name="approve" value=""
				class="active btn btn-primary" onClick="javascript:setVal(0)">Approve</button>&nbsp&nbsp
		
		
		<button type="submit" name="reject" value=""
				class="active btn btn-danger" onClick="javascript:setVal(1)">Reject</button>
		</aui:col>
	</aui:row>
</aui:form>

<script>
	function setVal(strVal) {
		//alert(strVal);
		$('#<portlet:namespace/>sumbitVal').val(strVal);
	}
</script>