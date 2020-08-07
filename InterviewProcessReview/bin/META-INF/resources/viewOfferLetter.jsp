<%@page
	import="com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalService"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitmentProcess"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@include file="init.jsp"%>


<%
	String recruitmentProcessId = StringPool.BLANK;
	CandidateApply apply = null;
	JobOpening jobOpening = null;
	String candidateFullName=StringPool.BLANK;
	
	if(request.getAttribute("recruitmentProcessId") != null){
		recruitmentProcessId=(String)request.getAttribute("recruitmentProcessId");
		try{
			RecruitmentProcess process = RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(Long.parseLong(recruitmentProcessId));
			/*find the candidate name from candidateapply table */
			//SelectedCandidatePayStructureMaster 
			if(Validator.isNotNull(process.getApplyCandidateId())){
				apply = CandidateApplyLocalServiceUtil.getCandidateApply(process.getApplyCandidateId());
				candidateFullName = apply.getFirstName()+" "+apply.getLastName();
				
				if(Validator.isNotNull(apply.getJobOpeningId())){
					jobOpening= JobOpeningLocalServiceUtil.getJobOpening(apply.getJobOpeningId());
				}
			}
		}catch(Exception e){
			
		}
	}
	System.out.println("recruitmentProcessId:--"+recruitmentProcessId);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");
	Date date = new Date();
	
	ResourceURL printPdf = renderResponse.createResourceURL();
	printPdf.setParameter(Constants.CMD, "generateOfferLetter");
	printPdf.setParameter("recruitmentProcessId",recruitmentProcessId);
	printPdf.setParameter("date", dateFormat.format(date));
	printPdf.setParameter("candidateFullName",candidateFullName);
	printPdf.setParameter("title", jobOpening.getOpeningFor());
	printPdf.setParameter("description", jobOpening.getDescription());
	
%>


<div style="padding: 35px;">
<p align="right">
	<!-- <a class=""  style="color: blue; text-decoration: underline;"
		href=""></a> -->
		<aui:a target="_blank" cssClass="btn btn-primary btn-default" label="Download Offer Letter" href="<%=printPdf.toString() %>"></aui:a>
</p>
	<h4>
		Date :
		<%=dateFormat.format(date) %></b>
	</h4>
	<h4>
		Name :
		<%=candidateFullName %></b>
	</h4>
	<!-- <h4>Address: []</b></h4>
	<h4>Pin Code: []</b></h4> -->
	<p align="center">
		RE: LETTER OF OFFER OF EMPLOYMENT
		<!--  Position title -->
	</p>
	<p align="left">
		Dear Mr. /Ms.
		<%=apply.getFirstName()+" "+apply.getLastName() %>,
	</p>
	<p align="justify">Following our recent discussions, we are
		delighted to offer you the position of Position Title with Our
		Organization. Our Organization is describe key highlights about your
		organization. If you join Our Organization, you will become part of a
		fast-paced and dedicated team that works together to provide our
		clients with the highest possible level of service and advice. As a
		member of Our Organization team, we would ask for your commitment to
		deliver outstanding quality and results that exceed client
		expectations. In addition, we expect your personal accountability in
		all the products, actions, advice and results that you provide as a
		representative of Our Organization. In return, we are committed to
		providing you with every opportunity to learn, grow and stretch to the
		highest level of your ability and potential. We are confident you will
		find this new opportunity both challenging and rewarding. The
		following points outline the terms and conditions we are proposing.</p>
	<p align="left">
		Title :
		<%=jobOpening.getOpeningFor() %>
		<!-- Position title -->
	</p>
	<p>
		Job description :
		<%=jobOpening.getDescription() %>
		<!-- See attached -->
	</p>
	<p>
		Start date:[]
		<!-- Start date -->
	</p>
	<p>Salary: [] Amount per year</p>
	<!--<p>
		Probation: []
		Describe your organization’s probationary policy
	<p>
		Group benefits:[]
		 Succinctly describe your organization’s group benefits plan, including when the new employee will be eligible
	</p>
	<p>
		Hours of work:[]
		 Describe the hours of work per week this position requires
	</p>
	<p>
		Reporting relationship:[]
		Identify the position that this position will report to
	</p>
	<p>
		Vacation:[]
		Explain your organization’s vacation policy including how many days, how they are accumulated etc.
	</p> -->
	<p align="justify">Following the initial probationary period, a
		progression and performance review will be conducted on a quarterly
		basis to assess performance to-date, and to clarify or modify this
		arrangement, as the need may arise.</p>
	<p align="justify">This arrangement may be terminated by either
		party upon notice in writing to either party with notice that complies
		with Employment Standards (or Labour Standards) for Your Province We
		look forward to the opportunity to work with you in an atmosphere that
		is successful and mutually challenging and rewarding.</p>
	<p align="right">Sincerely,</p>
	<p align="right">
		<!-- Your name -->
		[]
	</p>
	<p align="right">
		<!-- Your title -->
		[]
	</p>
	<p align="right">
		<!-- Your organization -->
		[organizationName]
	</p>
	<p align="left">With the signature below, I accept this offer for
		employment.</p>
	<p align="left">
	<hr>
	</p>

</div>
