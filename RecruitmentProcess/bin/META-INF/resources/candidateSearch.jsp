<%@page import="java.util.Date"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
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
	String name = ParamUtil.getString(request,"name",StringPool.BLANK);
	String skillset = ParamUtil.getString(request,"skillset",StringPool.BLANK);
	String email = ParamUtil.getString(request,"email",StringPool.BLANK);
	String yearExp = ParamUtil.getString(request,"yearExp",StringPool.BLANK);
	String monthExp = ParamUtil.getString(request,"monthExp",StringPool.BLANK);
	System.out.println("name ----"+name+"skillset ----"+skillset+"email ----"+email+"yearExp ----"+yearExp+"monthExp ----"+monthExp);
	
	List<CandidateApply> candidateSearch = new ArrayList<>();
	
	if(Validator.isNotNull(name) && Validator.isNotNull(skillset) && Validator.isNotNull(email) 
			&& Validator.isNotNull(yearExp) && Validator.isNotNull(monthExp)){
		
		DynamicQuery dynamicQuery = CandidateApplyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.like("firstName",
				new StringBuilder("%").append(name).append("%").toString());
		criterion3 = RestrictionsFactoryUtil.or(criterion3, RestrictionsFactoryUtil.like("lastName",
				new StringBuilder("%").append(name).append("%").toString()));
		criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.like("skillset", new StringBuilder("%").append(skillset).append("%").toString()));
		criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("emailAddress", email));
		criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("yearOfExp",Integer.parseInt(yearExp)));
		criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("monthOfExp",Integer.parseInt(monthExp)));
		dynamicQuery.add(criterion3);
		candidateSearch = CandidateApplyLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("candidateSearch------ "+candidateSearch);
	}else if(Validator.isNotNull(name)){
		DynamicQuery dynamicQuery = CandidateApplyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.like("firstName",
				new StringBuilder("%").append(name).append("%").toString());
		criterion3 = RestrictionsFactoryUtil.or(criterion3, RestrictionsFactoryUtil.like("lastName",
				new StringBuilder("%").append(name).append("%").toString()));
		if(Validator.isNotNull(skillset)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, 
					RestrictionsFactoryUtil.like("skillset", new StringBuilder("%").append(skillset).append("%").toString()));
		}
		if(Validator.isNotNull(email)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("emailAddress", email));
		}
		if(Validator.isNotNull(yearExp)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("yearOfExp", Integer.parseInt(yearExp)));
		}
		if(Validator.isNotNull(monthExp)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("monthOfExp", Integer.parseInt(monthExp)));
		}
		dynamicQuery.add(criterion3);
		candidateSearch = CandidateApplyLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("candidateSearch------ "+candidateSearch);
	}else if(Validator.isNotNull(skillset)){
		DynamicQuery dynamicQuery = CandidateApplyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.like("skillset", new StringBuilder("%").append(skillset).append("%").toString());
		if(Validator.isNotNull(email)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("emailAddress", email));
		}
		if(Validator.isNotNull(yearExp)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("yearOfExp", Integer.parseInt(yearExp)));
		}
		if(Validator.isNotNull(monthExp)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("monthOfExp", Integer.parseInt(monthExp)));
		}
		dynamicQuery.add(criterion3);
		candidateSearch = CandidateApplyLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("candidateSearch------ "+candidateSearch);
	}else if(Validator.isNotNull(email)){
		DynamicQuery dynamicQuery = CandidateApplyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("emailAddress", email);
		if(Validator.isNotNull(yearExp)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("yearOfExp", Integer.parseInt(yearExp)));
		}
		if(Validator.isNotNull(monthExp)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("monthOfExp", Integer.parseInt(monthExp)));
		}
		dynamicQuery.add(criterion3);
		candidateSearch = CandidateApplyLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("candidateSearch------ "+candidateSearch);
	}else if(Validator.isNotNull(yearExp)){
		DynamicQuery dynamicQuery = CandidateApplyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("yearOfExp", Integer.parseInt(yearExp));
		if(Validator.isNotNull(monthExp)){
			criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("monthOfExp", Integer.parseInt(monthExp)));
		}
		dynamicQuery.add(criterion3);
		candidateSearch = CandidateApplyLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("candidateSearch------ "+candidateSearch);
	}else if(Validator.isNotNull(monthExp)){
		DynamicQuery dynamicQuery = CandidateApplyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3=	RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("monthOfExp", Integer.parseInt(monthExp)));
		dynamicQuery.add(criterion3);
		candidateSearch = CandidateApplyLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("candidateSearch------ "+candidateSearch);
	}
%>

<%
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/candidateSearch.jsp");
	
	PortletURL viewDetailsURL = renderResponse.createRenderURL();
	viewDetailsURL.setParameter("jspPage", "/META-INF/resources/detailsView.jsp");
%>


<liferay-ui:search-container delta="7"
		emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
		orderByCol="" orderByType="">
		<liferay-ui:search-container-results>
			<%
			results = candidateSearch;
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
			className="com.liferay.famocom.erpcloud.model.CandidateApply"
			modelVar="candidate">


			<liferay-ui:search-container-column-text name="Full Name"
				orderable="true" orderableProperty="fullName">
				<%=candidate.getFirstName()+" "+candidate.getLastName()%>
			</liferay-ui:search-container-column-text>
			<%
			JobOpening jobOpeningObj = null;
			String jobFor=StringPool.BLANK;
			if(Validator.isNotNull(candidate.getJobOpeningId())){
				jobOpeningObj = JobOpeningLocalServiceUtil.getJobOpening(candidate.getJobOpeningId());
				jobFor=jobOpeningObj.getOpeningFor();
			}
		%>
			<liferay-ui:search-container-column-text name="Appling For"
				orderable="true" orderableProperty="applingFor">

				<%=jobFor%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Skills"
				orderable="true" orderableProperty="skills">
				<%=candidate.getSkillset()%>
			</liferay-ui:search-container-column-text>
			<%
			String yearEx=StringPool.BLANK;
			if(candidate.getYearOfExp()!=0){
				yearEx= candidate.getYearOfExp()+"."+candidate.getMonthOfExp()+"year";
			}else if(candidate.getMonthOfExp()!=0){
				yearEx=candidate.getMonthOfExp()+"months";
			}
		%>
			<liferay-ui:search-container-column-text name="Experience"
				orderable="true" orderableProperty="experience">
				<%=yearEx%>
			</liferay-ui:search-container-column-text>

			<%-- <liferay-ui:search-container-column-text
			name="Provident Fund Deduction" orderable="true"
			orderableProperty="pfDeduct">
			<%=type.getPfDeduct() == 1 ? "Yes" : "No"%>
		</liferay-ui:search-container-column-text> --%>

			<liferay-ui:search-container-column-text name="Email Address"
				orderable="true" orderableProperty="emailAddress">
				<%=candidate.getEmailAddress()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Phone Number"
				orderable="true" orderableProperty="phNumber">
				<%=candidate.getPhoneNumber()%>
			</liferay-ui:search-container-column-text>
			<%
		FileEntry dlfile = null;
		String url = null;
		
		//System.out.println("111");
		
		try{
			if (candidate != null &&  Validator.isNotNull(candidate.getCvFileId())) {
				dlfile = DLAppServiceUtil.getFileEntry(candidate.getCvFileId());
				Date date2 = new Date();
				Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds())
						* 1000);
				url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/" + dlfile.getFileName() + "/"
						+ dlfile.getUuid() + "?t=" + time2;
				
				System.out.println("112");
			}
		}catch(Exception e){
			
		}		
			if(url!=null){
		%>
			<liferay-ui:search-container-column-text name="View CV"
				orderable="true" orderableProperty="viewCv">
				<a href="<%=url.toString()%>"><b
					style="color: #ADD8E6; text-decoration: underline;">View Cv</b></a>
			</liferay-ui:search-container-column-text>
			<%
			}else{
		%>
			<liferay-ui:search-container-column-text name="View CV"
				orderable="true" orderableProperty="viewCv">
				<h3>Cv not found</h3>
			</liferay-ui:search-container-column-text>
			<%
			}
		%>
			<liferay-ui:search-container-column-text name="Action"
				cssClass="actionCol">

				<liferay-ui:icon-menu>
					<%
				viewDetailsURL.setParameter("applyCandidateId",
											String.valueOf(candidate.getApplyCandidateId()));
				viewDetailsURL.setParameter("yearEx",yearEx);
				viewDetailsURL.setParameter("url",url);
									/* expenseCategoryDeletetURL.setParameter("cat_id", String.valueOf(expenseType.getCat_id())); */
									/*  System.out.println("participantId"+Long.toString(expenseType.getCat_id())); */
				%>

					<liferay-ui:icon url="<%=viewDetailsURL.toString() %>"
						message="View Details" image="view" />

				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator></liferay-ui:search-iterator>
	</liferay-ui:search-container>
