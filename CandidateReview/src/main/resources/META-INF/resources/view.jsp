<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitProcess"%>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	
		User userGet = (User) request.getAttribute(WebKeys.USER);
		System.out.println("userId...."+userGet.getUserId());		
		Employee  emp = EmployeeLocalServiceUtil.findByemployees(userGet.getUserId());
		List<RecruitProcess> recruitProcesses = new ArrayList<RecruitProcess>();
		if(Validator.isNotNull(emp)){
			recruitProcesses = RecruitProcessLocalServiceUtil.findRecruitProcessByEmployeeId(emp.getEmployeeId());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String status = StringPool.BLANK;	
		PortletURL iteratorUrl = renderResponse.createRenderURL();
		iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");		
		PortletURL interviewURL = renderResponse.createRenderURL();
		interviewURL.setParameter("jspPage", "/META-INF/resources/interview.jsp");
		long recruitProcessId =ParamUtil.getLong(request, "recruitProcessId");
		int listValue=0;
		if(Validator.isNotNull(recruitProcesses)){
%>

<aui:input name="recruitProcessId" type="hidden" value="<%=recruitProcessId %>"></aui:input>

<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = recruitProcesses;
					total = recruitProcesses.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("recruitProcess", recruitProcesses);				
		%>
		
	</liferay-ui:search-container-results>
	<%
		System.out.println("listValue:-"+listValue);
	%>
	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.RecruitProcess"
		modelVar="recuit">
		
		<%
		
		
		if(Validator.isNotNull(recuit.getStatus())){
			System.out.print("recruit.getStatus()...."+recuit.getStatus());
			if(recuit.getStatus()==1){
				status = "PENDING";
			}else if(recuit.getStatus()==2){
				status = "ABSENT";
			}if(recuit.getStatus()==3){
				status = "TAKEN";
			}else if(recuit.getStatus()==4){
				status = "REJECTED";
			}else if(recuit.getStatus()==5){
				status = "SELECTED";
			}
		} 
		
		%>
		<liferay-ui:search-container-column-text name="Candidate Name"
			orderable="true" orderableProperty="post">
			<%=recuit.getFirstName() +" "+recuit.getLastName() %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Interview Date"
			orderable="true" orderableProperty="interviewDate">
			<%=sdf.format(recuit.getInterviewDate()) %>

		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="InterView Time"
			orderable="true" orderableProperty="interviewTime">
			<%=recuit.getInterviewTime() %>

		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Status" ><%=status%></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu >
				<%
					interviewURL.setParameter("recruitProcessId", String.valueOf(recuit.getRecruitProcessId()));
				%>
				<liferay-ui:icon url="<%= interviewURL.toString()%>"
					message="view" image="view" />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>
	 
	<liferay-ui:search-iterator  ></liferay-ui:search-iterator>
	 
	
</liferay-ui:search-container>
<%} %>


