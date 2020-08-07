<%@page import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitmentProcess"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="init.jsp" %>

<%
	System.out.println("AAAA");
	List<RecruitmentProcess> processesList = (List<RecruitmentProcess>) renderRequest.getAttribute("processesList");
	List<RecruitmentProcess> processesToMeList = (List<RecruitmentProcess>) renderRequest.getAttribute("processesToMeList");
/* 	try{
		WorkflowTask workflowTask = workflowTaskDisplayContext.getWorkflowTask();
		System.out.println("workflowTaskDisplayContext.getState(workflowTask)----" + workflowTaskDisplayContext.getState(workflowTask));
	}catch(Exception e){
		e.printStackTrace();
	}
 */	
	
	System.out.println("processesToMeList----" + processesToMeList);
	System.out.println("processesList-----" + processesList);
	
	PortletURL assignToMe = renderResponse.createRenderURL();
	assignToMe.setParameter("jspPage", "/assignToMePopup.jsp");
	assignToMe.setWindowState(LiferayWindowState.POP_UP);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL getInterviewUrl = renderResponse.createRenderURL();
	getInterviewUrl.setParameter("jspPage", "/META-INF/resources/interview.jsp");
	
	PortletURL getOfferLetterUrl = renderResponse.createRenderURL();
	getOfferLetterUrl.setParameter("jspPage", "/META-INF/resources/selectedCandidateList.jsp");
%>
<a href="<%=getOfferLetterUrl.toString()%>" style="display: none;">aaaaaa</a>
<liferay-ui:tabs names="Assigned to Me,Assigned to My Roles"
	refresh="false" tabsValues="Assigned to Me,Assigned to My Roles">
	<liferay-ui:section>
	<liferay-ui:search-container delta="5"
			emptyResultsMessage="No Interview found" iteratorURL="<%=iteratorUrl%>">

			<liferay-ui:search-container-results>
				<%
					results = processesToMeList;
					total = results.size();
					searchContainer.setTotal(total);
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.famocom.erpcloud.model.RecruitmentProcess"
				modelVar="interviewProcessValMe">
				
				<%
					CandidateApply candidateApply = null;
					JobOpening jobOpening = null;
					if(Validator.isNotNull(interviewProcessValMe.getApplyCandidateId())){
						candidateApply = CandidateApplyLocalServiceUtil.getCandidateApply(interviewProcessValMe.getApplyCandidateId());
						if(Validator.isNotNull(candidateApply.getJobOpeningId())){
							jobOpening= JobOpeningLocalServiceUtil.getJobOpening(candidateApply.getJobOpeningId());
						}
					}
				%>
				<liferay-ui:search-container-column-text name="Candidate Name"
					value="<%=candidateApply.getFirstName()+" "+candidateApply.getLastName()%>" />

				

				<liferay-ui:search-container-column-text name="Appling For" value="<%=jobOpening.getOpeningFor() %>" />
					
				

				<liferay-ui:search-container-column-text name="Action"
					cssClass="actionCol">
					<liferay-ui:icon-menu>
					<%
						getInterviewUrl.setParameter("applyCandidateId",
												String.valueOf(interviewProcessValMe.getApplyCandidateId()));
						
						getInterviewUrl.setParameter("jobPostId",
							String.valueOf(interviewProcessValMe.getJobPostId()));
						
						getInterviewUrl.setParameter("recruitmentProcessId",
								String.valueOf(interviewProcessValMe.getRecruitmentProcessId()));
										/* expenseCategoryDeletetURL.setParameter("cat_id", String.valueOf(expenseType.getCat_id())); */
										/*  System.out.println("participantId"+Long.toString(expenseType.getCat_id())); */
					%>
					<liferay-ui:icon url="<%=getInterviewUrl.toString()%>" message="View"
					image="view" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text> 

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
		</liferay-ui:search-container>

		

	</liferay-ui:section>
 <liferay-ui:section>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No Interview found" iteratorURL="<%=iteratorUrl%>">

			<liferay-ui:search-container-results>
				<%
					results = processesList;
					total = results.size();
					searchContainer.setTotal(total);
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.famocom.erpcloud.model.RecruitmentProcess"
				modelVar="interviewProcessVal">

				<%
					CandidateApply candidateApply = null;
					JobOpening jobOpening = null;
					if(Validator.isNotNull(interviewProcessVal.getApplyCandidateId())){
						candidateApply = CandidateApplyLocalServiceUtil.getCandidateApply(interviewProcessVal.getApplyCandidateId());
						if(Validator.isNotNull(candidateApply.getJobOpeningId())){
							jobOpening= JobOpeningLocalServiceUtil.getJobOpening(candidateApply.getJobOpeningId());
						}
					}
				%>
				<liferay-ui:search-container-column-text name="Candidate Name"
					value="<%=candidateApply.getFirstName()+" "+candidateApply.getLastName()%>" />

				

				<liferay-ui:search-container-column-text name="Appling For" value="<%=jobOpening.getOpeningFor() %>" />
				
				<liferay-ui:search-container-column-text name="Action"
					cssClass="actionCol">
					<liferay-ui:icon-menu markupView="lexicon">
						<%
						assignToMe.setParameter("recruitmentProcessId", String.valueOf(interviewProcessVal.getRecruitmentProcessId()));
						
						String popupview = "javascript:popupAssignToMe('"+ assignToMe.toString()+"');";
						%>
						<liferay-ui:icon iconCssClass="icon-user" message="Assign to Me"
							url="<%=popupview%>" />
						<liferay-ui:icon iconCssClass="icon-edit" message="Assign to.."
							url="#" />
						
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
		</liferay-ui:search-container>

		
	</liferay-ui:section>

</liferay-ui:tabs>

<script>
	function popupAssignToMe(url){
		Liferay.Util.openWindow(
			{
				dialog: {
				//cssClass: 'aui-popup-example',
				destroyOnHide: true,
				height: 400,
				width: 700
	},
		dialogIframe: {
	//bodyCssClass: 'custom-css-class'
	},
		title: 'Assign To Me',
		uri: url
	}
	);
	}
</script>