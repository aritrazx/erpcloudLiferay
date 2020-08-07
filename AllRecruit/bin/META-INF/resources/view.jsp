<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitProcess"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	List<RecruitProcess> recruitList = RecruitProcessLocalServiceUtil.getRecruitProcesses(-1,-1);	

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL interviewURL = renderResponse.createRenderURL();
	interviewURL.setParameter("jspPage", "/META-INF/resources/interview.jsp");
	long recruitProcessId =ParamUtil.getLong(request, "recruitProcessId");
%>

<aui:input name="recruitProcessId" type="hidden" value="<%=recruitProcessId %>"></aui:input>

<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = recruitList;
					total = recruitList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("recruitProcess", recruitList);
					/* if(getRecruitCol.size()!=0){ */
				//RecruitProcess rp=null;
				
		%>
		
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.RecruitProcess"
		modelVar="type">
		<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(type.getEmployeeId());
		
			SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,yyyy");
			String interviewDate = formatter.format(type.getInterviewDate());
		%>
		<liferay-ui:search-container-column-text name="Interviewer"
			orderable="true" orderableProperty="post">
			<%=emp.getFirstName()%> <%=emp.getLastName() %>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Candidate Name"
			orderable="true" orderableProperty="post">
			<%=type.getFirstName()%> <%=type.getLastName() %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Interview Date"
			orderable="true" orderableProperty="interviewDate">
			<%=interviewDate %>

		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="InterView Time"
			orderable="true" orderableProperty="interviewTime">
			<%=type.getInterviewTime() %>

		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu >
				<%
					interviewURL.setParameter("recruitProcessId", String.valueOf(type.getRecruitProcessId()));
				%>
				<liferay-ui:icon url="<%= interviewURL.toString()%>"
					message="view" image="view" />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>
	 
	<liferay-ui:search-iterator  ></liferay-ui:search-iterator>
	 
	
</liferay-ui:search-container>