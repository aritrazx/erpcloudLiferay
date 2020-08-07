<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	long applyCandidateId = ParamUtil.getLong(request, "applyCandidateId");
	String yearEx = ParamUtil.getString(request,"yearEx",StringPool.BLANK);
	String url =ParamUtil.getString(request, "url",StringPool.BLANK);
	System.out.println("url"+url);
	CandidateApply apply =null;
	JobOpening opening = null;
	Employee findEmployee=null;
	
	if(Validator.isNotNull(applyCandidateId)){
		apply = CandidateApplyLocalServiceUtil.getCandidateApply(applyCandidateId);
		if(Validator.isNotNull(apply.getJobOpeningId())){
			opening= JobOpeningLocalServiceUtil.getJobOpening(apply.getJobOpeningId());
		}
		/* if(Validator.isNotNull(apply.getEmployeeCode())){
			findEmployee=EmployeeLocalServiceUtil.findByemployeeCode(apply.getEmployeeCode());
		} */
	}
%>

<aui:row>
	<h3 align="center">Candidate Information</h3>
		<aui:col span="6">
			<p>
				First Name : <b style="color: #f48120;"><%=apply.getFirstName()%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Last Name : <b style="color: #f48120;"><%=apply.getLastName()%></b>
			</p>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<p>
				Email Address : <b style="color: #f48120;"><%=apply.getEmailAddress()%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Phone Number : <b style="color: #f48120;"><%=apply.getPhoneNumber()%></b>
			</p>
		</aui:col>
	</aui:row>
	<hr>
	<aui:row>
		<aui:col span="6">
			<p>
				Appling For : <b style="color: #f48120;"><%=opening !=null? opening.getOpeningFor():""%></b>
			</p>
		</aui:col>
		
		<aui:col span="6">
			<p>
				Skills : <b style="color: #f48120;"><%=apply.getSkillset()%></b>
			</p>
		</aui:col>
	
	</aui:row>
	<hr>
	<aui:row>
		<aui:col span="6">
			<p>
				Relevant experience : <b style="color: #f48120;"><%=yearEx%></b>
			</p>
		
		</aui:col>
	</aui:row>
	<hr>
	<aui:row>
		<aui:col span="6">
			<p>
				CurrentCTC : <b style="color: #f48120;"><%=apply.getCurrentCTC()%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				ExpectedCTC : <b style="color: #f48120;"><%=apply.getExpectedCTC()%></b>
			</p>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<p>
				Current Company : <b style="color: #f48120;"><%=apply.getCurrentCompany()%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Notice Period: <b style="color: #f48120;"><%=apply.getNoticePeriod()%>months</b>
			</p>
		</aui:col>
	</aui:row>
	<hr >
	<% 
		if(Validator.isNotNull(findEmployee)){
	%>
	<aui:row>
		<h3 align="center" >Any Reference</h3>
		<aui:col span="6">
			<p>
				Employee Name: <b style="color: #f48120;"><%=findEmployee!=null? findEmployee.getFirstName()+" "+findEmployee.getLastName():""%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Employee Code: <b style="color: #f48120;"><%=findEmployee!=null? findEmployee.getEmployeeCode() : ""%></b>
			</p>
			<%-- <aui:validator name="digits"></aui:validator> --%>
		</aui:col>
		
	</aui:row></br>
	<%
		}
	%>
	<aui:row>

	<aui:col span="4">
		<%
			if (url != null) {
		%>
		<p>
			View Cv :<a href="<%=url.toString()%>"><b style="color: #ADD8E6; text-decoration: underline ;">&nbsp&nbspView Cv</b></a>
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
