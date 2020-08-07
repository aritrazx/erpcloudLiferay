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

	
	
	RecruitProcess recruitProcess = RecruitProcessLocalServiceUtil.getRecruitProcess(recruitProcessId);
	ProjectRole role = ProjectRoleLocalServiceUtil.getProjectRole(recruitProcess.getRoleId());
	Employee employee= EmployeeLocalServiceUtil.getEmployee(recruitProcess.getEmployeeId()); 
	List<InterviewEvaluation> evaluation = InterviewEvaluationLocalServiceUtil.getInterviewEvaluations(-1,-1);
	
	SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy");
	String strDate = formatter.format(recruitProcess.getInterviewDate());
	System.out.println("recruitProcess.getIsSelected()"+recruitProcess.getIsSelected());
%>


<portlet:actionURL name="interviewAdd" var="interviewAddURL" />
<aui:form name="interview" action="<%=interviewAddURL.toString()%>" method="post">
	<aui:row>
		<aui:input name="recruitProcessId" type="hidden" value="<%=recruitProcessId %>"></aui:input>
		<aui:col span="6">
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Interviewer Name :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=employee.getFirstName()%> <%=employee.getLastName()%></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Candidate Name :</label>
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
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4"><b>Score</b></label>
				</aui:col>
			</aui:row>
			<%
				for (InterviewEvaluation interviewEvaluation : evaluation) {
								if (recruitProcess.getRoleId() == interviewEvaluation.getRoleId()) {
			%>
			</br>
			<aui:row>
				<aui:col span="6">
					<label><font size="4"><%=interviewEvaluation.getEvaluationName()%></b> :</label>
				</aui:col>
				<aui:col span="6">
				
					<!--Scores  -->
					<label><b style=" color: #f48120;"><font size="4">Score for Candidate</b></label>
				</aui:col>
			</aui:row>
			<%
					}
						}
			%>
			
		</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Remarks :</label>
				</aui:col>
				<aui:col span="6">
				
					<label ><b style=" color: #f48120;">Interviewer Remarks</b></label>
				</aui:col>
			</aui:row>	
			<!--Admin Remarks  -->
		<aui:input name="adminRemark" type="textarea" label="Hr Remark" value="<%=recruitProcess.getHrRemarks()!=null?recruitProcess.getHrRemarks():""%>"></aui:input>
		<%
			String isCheck="";
			if(recruitProcess.getIsSelected()==true)
			{
				isCheck="checked";
			}
		%>
		<input name="<portlet:namespace/>isSelect"  type="checkbox" value="1" <%=isCheck%>>Is Select</input>
		<%-- <%
			}
		%> --%>
 </aui:col>
 
 <aui:col span="6">
 	//for file
 </aui:col>
	</aui:row>
<aui:button name="save" type="submit"></aui:button>

</aui:form>
