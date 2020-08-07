<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateReviewLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateReview"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectRoleLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectRole"%>
<%@page import="com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.InterviewEvaluation"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitProcess"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	long recruitProcessId = ParamUtil.getLong(request,"recruitProcessId");	
	System.out.println("recruitProcessId"+recruitProcessId);

	User userGet = (User) request.getAttribute(WebKeys.USER);
	System.out.println("userGet" + userGet.getUserId());
	Employee emp = EmployeeLocalServiceUtil.findByemployees(userGet.getUserId());
	List<RecruitProcess> processes = RecruitProcessLocalServiceUtil.findRecruitProcessByEmployeeId(emp.getEmployeeId());
	List<InterviewEvaluation> evaluation = InterviewEvaluationLocalServiceUtil.getInterviewEvaluations(-1,-1);
	
	RecruitProcess recruitProcess = RecruitProcessLocalServiceUtil.getRecruitProcess(recruitProcessId);
	ProjectRole role = ProjectRoleLocalServiceUtil.getProjectRole(recruitProcess.getProjectRoleId());
	List<CandidateReview> candidateReview = new ArrayList<CandidateReview>();
	String remarks = StringPool.BLANK;
	candidateReview = CandidateReviewLocalServiceUtil.findCandidateReviewByRecruitProcessId(recruitProcessId);
	if(Validator.isNotNull(recruitProcess)){
		if(Validator.isNotNull(recruitProcess.getInterviewerRemarks())){
			remarks = recruitProcess.getInterviewerRemarks();
		}
		
	}
	boolean iscandidateReview = false;
	if(Validator.isNotNull(candidateReview) && candidateReview.size()>0){
		iscandidateReview = true;
	}
	
	String evaluationIds=StringPool.BLANK;
	String status = StringPool.BLANK;
	SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy");
	String strDate = formatter.format(recruitProcess.getInterviewDate());
	PortletURL addCandidateReviewURL = renderResponse.createActionURL();
	addCandidateReviewURL.setParameter("javax.portlet.action", "addCandidateReview");
	addCandidateReviewURL.setParameter("recruitProcessId", String.valueOf(recruitProcess.getRecruitProcessId()));
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage","/view.jsp"); 
%>

<liferay-ui:header title="Back" backLabel="Back" backURL="<%=backURL.toString()%>" />

<aui:form name="interview" action="<%=addCandidateReviewURL.toString() %>" method="post">
	<aui:row>
		<aui:col span="6">
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Name :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=recruitProcess.getFirstName()%> <%=recruitProcess.getLastName()%></b>
					
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Interview For :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=role.getRoleName() %></b>
					
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Interview Date :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=strDate%></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Interview Time :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"><%=recruitProcess.getInterviewTime()%></b>
				</aui:col>
			</aui:row>
			
			
			<%
				for (InterviewEvaluation interviewEvaluation : evaluation) {
								if (recruitProcess.getProjectRoleId() == interviewEvaluation.getRoleId()) {
									evaluationIds+=String.valueOf(interviewEvaluation.getEvaluationId())+",";
									
			%>
			</br>
			<aui:row>
				<aui:col span="6">
					<label><font size="4"><%=interviewEvaluation.getEvaluationName()%></b> :</label>
				</aui:col>
				<aui:col span="6">
				
				<%  if(Validator.isNotNull(candidateReview) && candidateReview.size()>0){
						for(CandidateReview review:candidateReview){
				
							if(review.getEvaluationId()==interviewEvaluation.getEvaluationId()){
				%>
		<input class="field form-control" name="name" value="<%=review.getScroring() %>"  type="text" readonly="readonly"  label=""></input>
				
				<%		}	
						}
					}else{
				
				%>
				
					<input class="field form-control" name='<portlet:namespace/>name_<%=interviewEvaluation.getEvaluationId()%>' type="text" value="" label=""></input>
					
				
				<% } %>
	        
				</aui:col>
			</aui:row>
			<%
					}
						}
			%>
		
			<aui:input name="evaluationIds" type="hidden" value="<%=evaluationIds %>" label=""></aui:input>
			<aui:input name="remark" type="textarea" label="Remark" value="<%=remarks %>" ></aui:input>

		</aui:col>
		<aui:col span="6">
		<a href="<%=recruitProcess.getFileUrl()%>" style="color: blue" >Download</a>
		<%-- <embed src="<%=recruitProcess.getFileUrl()%>" width="800px" height="700px" /> --%>
			
		</aui:col>

	</aui:row>
	<%if(!iscandidateReview) {%>
	<aui:button name="save" type="submit"></aui:button>
	<%}%>
</aui:form>
