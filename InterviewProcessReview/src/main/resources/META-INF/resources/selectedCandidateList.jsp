<%@page import="com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalService"%>
<%@page import="com.liferay.famocom.erpcloud.service.JobPostLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobPost"%>
<%@page import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateEvaluation"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitmentProcess"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/selectedCandidateList.jsp");
	
	PortletURL candidateSalaryStructureUrl = renderResponse.createRenderURL();
	candidateSalaryStructureUrl.setParameter("jspPage", "/META-INF/resources/candidateSalaryStructure.jsp");
	
	
	/* 
	get the selected candidate
	*/ 
	
	List<RecruitmentProcess> processes = new ArrayList<>();
	List<CandidateEvaluation> candidateEvaluations = new ArrayList<>();
	DynamicQuery dynamicQuery = RecruitmentProcessLocalServiceUtil.dynamicQuery();
	Criterion criterion = RestrictionsFactoryUtil.eq("status",0);
	dynamicQuery.add(criterion);
	processes = RecruitmentProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
	
	//System.out.println("candidateEvaluations:---"+candidateEvaluations+"candidateEvaluations size"+candidateEvaluations.size());
%>


<liferay-ui:search-container delta="5"
			emptyResultsMessage="No Interview found" iteratorURL="<%=iteratorUrl%>">

			<liferay-ui:search-container-results>
				<%
					results = processes;
					total = results.size();
					searchContainer.setTotal(total);
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.liferay.famocom.erpcloud.model.RecruitmentProcess"
				modelVar="selectedCandidate">
				
				
				<%
					CandidateApply candidateApply = null;
					JobOpening jobOpening = null;
					JobPost jobPost = null;
					if(Validator.isNotNull(selectedCandidate.getApplyCandidateId())){
						candidateApply = CandidateApplyLocalServiceUtil.getCandidateApply(selectedCandidate.getApplyCandidateId());
						if(Validator.isNotNull(candidateApply.getJobOpeningId())){
							jobOpening= JobOpeningLocalServiceUtil.getJobOpening(candidateApply.getJobOpeningId());
						}
					}
					
					if(Validator.isNotNull(selectedCandidate.getJobPostId())){
						try{
							jobPost=JobPostLocalServiceUtil.getJobPost(selectedCandidate.getJobPostId());
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				%>
				<liferay-ui:search-container-column-text name="Candidate Name"
					value="<%=candidateApply!=null ? candidateApply.getFirstName()+" "+candidateApply.getLastName():""%>" />

				

				<liferay-ui:search-container-column-text name="Job Post" 
				value="<%=jobPost !=null ? jobPost.getPostName() :null %>" />

				<liferay-ui:search-container-column-text name="Action"
					cssClass="actionCol">
					<liferay-ui:icon-menu>
					<%
					candidateSalaryStructureUrl.setParameter("recruitmentProcessId",
												String.valueOf(selectedCandidate.getRecruitmentProcessId()));
						
					%>
					<liferay-ui:icon url="<%=candidateSalaryStructureUrl.toString()%>" message="Get OfferLetter"
					image="view" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text> 

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
		</liferay-ui:search-container>