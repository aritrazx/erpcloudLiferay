<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitmentProcess"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	List<RecruitmentProcess> recruitmentProcess = RecruitmentProcessLocalServiceUtil.getRecruitmentProcesses(-1,-1);
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/interviewList.jsp");
	PortletURL editInterviewUrl = renderResponse.createRenderURL();
	editInterviewUrl.setParameter("jspPage", "/META-INF/resources/interviewSet.jsp");
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage","/view.jsp"); 
%>

<liferay-ui:header title="Interview List" backLabel="Back" backURL="<%=backURL.toString()%>"></liferay-ui:header>
<liferay-ui:search-container delta="7"
		emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
		orderByCol="" orderByType="">
		<liferay-ui:search-container-results>
			<%
			results = recruitmentProcess;
			total = results.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
			results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
			portletSession.setAttribute("wrkSchedules", results);
		%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.famocom.erpcloud.model.RecruitmentProcess"
			modelVar="interview">
			
			<%
				CandidateApply candidate =null;
				if(Validator.isNotNull(interview.getApplyCandidateId())){
					candidate = CandidateApplyLocalServiceUtil.getCandidateApply(interview.getApplyCandidateId());
				}
			%>

			<liferay-ui:search-container-column-text name="Candidate Name"
				orderable="true" orderableProperty="fullName">
				<%=candidate.getFirstName()+" "+candidate.getLastName()%>
			</liferay-ui:search-container-column-text>
			<%
				Employee employee = null;
				String interviewerName= StringPool.BLANK;
				if(Validator.isNotNull(interview.getInterviewerId())){
					employee= EmployeeLocalServiceUtil.getEmployee(interview.getInterviewerId());
					interviewerName=employee.getFirstName()+" "+employee.getLastName();
				}
			%>
			
			<liferay-ui:search-container-column-text name="Interviewer Name"
				orderable="true" orderableProperty="interviewerName">

				<%=interviewerName%>
			</liferay-ui:search-container-column-text>
			<%
					SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");
					String interviewDate = sdf.format(interview.getInterviewDate());
			%>
			<liferay-ui:search-container-column-text name="Interview Date"
				orderable="true" orderableProperty="interviewDate">
				<%=interviewDate%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Interview Time"
				orderable="true" orderableProperty="interviewTime">
				<%=interview.getInterviewTime()%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Status"
				orderable="true" orderableProperty="status">
				<%=interview.getStatus()%>
			</liferay-ui:search-container-column-text>

			<%-- <liferay-ui:search-container-column-text
			name="Provident Fund Deduction" orderable="true"
			orderableProperty="pfDeduct">
			<%=type.getPfDeduct() == 1 ? "Yes" : "No"%>
		</liferay-ui:search-container-column-text> --%>

			<liferay-ui:search-container-column-text name="Action"
				cssClass="actionCol">

				<liferay-ui:icon-menu>
				<%
					editInterviewUrl.setParameter("recruitmentProcessId",
											String.valueOf(interview.getRecruitmentProcessId()));
									editInterviewUrl.setParameter("interviewerId",
											String.valueOf(interview.getInterviewerId()));
									//viewDetailsURL.setParameter("url",url);

									editInterviewUrl.setParameter("applyCandidateId",
											String.valueOf(candidate.getApplyCandidateId()));
									//interviewSetURL.setParameter("yearEx",yearEx);
									//interviewSetURL.setParameter("url",url);

									/* expenseCategoryDeletetURL.setParameter("cat_id", String.valueOf(expenseType.getCat_id())); */
									/*  System.out.println("participantId"+Long.toString(expenseType.getCat_id())); */
				%>

				<liferay-ui:icon url="<%=editInterviewUrl.toString() %>"
						message="Edit interview" image="edit" icon="edit" />
					

				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator></liferay-ui:search-iterator>
	</liferay-ui:search-container>