<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.DocumentUploadFile"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.TravelDeskDetails"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
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
iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL listShowURL = renderResponse.createRenderURL();
listShowURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL travelViewURL = renderResponse.createRenderURL();
travelViewURL.setParameter("jspPage", "/META-INF/resources/travelView.jsp");

List<TravelDeskDetails> travelList = new ArrayList<>();
DynamicQuery membrQuery = TravelDeskDetailsLocalServiceUtil.dynamicQuery();
Criterion criterion = null;
criterion = RestrictionsFactoryUtil.eq("status", 1);
membrQuery.add(criterion);
membrQuery.addOrder(OrderFactoryUtil.desc("modifiedDate"));
travelList = TravelDeskDetailsLocalServiceUtil.dynamicQuery(membrQuery);
%>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = travelList;
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
		className="com.liferay.famocom.erpcloud.model.TravelDeskDetails"
		modelVar="type">
		
		<%
			Employee empName=EmployeeLocalServiceUtil.getEmployee(type.getEmployeeId());
			ProjectMaster master = ProjectMasterLocalServiceUtil.getProjectMaster(type.getProjectId());
		%>

		<liferay-ui:search-container-column-text name="Employee Name"
			orderable="true" orderableProperty="employeeId">
			<%=empName.getFirstName()+" "+empName.getLastName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="Project Name" orderable="true"
			orderableProperty="projectId">
			<%=master.getProjectName()%>
		</liferay-ui:search-container-column-text>
		<%
			Date fromDate = type.getFromDate();
			Date toDate = type.getToDate(); 
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
			String strfromDate = formatter.format(fromDate);
			String strToDate =formatter.format(toDate);
		%>

		<liferay-ui:search-container-column-text name="Ticket For"
			orderable="true" orderableProperty="ticketType">
			<%=type.getTicketType()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="From Date and Time"   orderable="true" orderableProperty="fromDate">
				<%=strfromDate+" at "+type.getFromTime()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="To Date and Time"   orderable="true" orderableProperty="toDate">
			<%=strToDate+" at "+type.getToTime()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Location"
			orderable="true" orderableProperty="location">
			<%=type.getLocation()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Purpose"
			orderable="true" orderableProperty="purpose">
			<%=type.getPurpose()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Hotel Requirement"
			orderable="true" orderableProperty="hotel">
			<%=type.getHotel()==true?"Yes":"No"%>
		</liferay-ui:search-container-column-text>
		<%
			String status="";
			if(type.getStatus()==0){
				status="Pending";
			}else if(type.getStatus()==1){
				status="Accepted";
			}else if(type.getStatus()==2){
				status="Rejected";
			} else {
				status="Resubmited";
			}
		%>
		<liferay-ui:search-container-column-text name="Status"
			orderable="true" orderableProperty="status">
			<%=status%>
		</liferay-ui:search-container-column-text>
		<%
		String docName = null;
		List<DocumentUploadFile> docList = new ArrayList<>();
		DynamicQuery docQuery = DocumentUploadFileLocalServiceUtil.dynamicQuery();
		Criterion criterion2 = null;
		criterion2 = RestrictionsFactoryUtil.eq("employeeId", empName.getEmployeeId());
		criterion2 = RestrictionsFactoryUtil.and(criterion2,
				RestrictionsFactoryUtil.eq("travelDetailsId", type.getTravelDetailsId()));
		docQuery.add(criterion2);
		docList = DocumentUploadFileLocalServiceUtil.dynamicQuery(docQuery);
		if(docList.size()!=0){
			docName = "Document uploaded";
		} else {
			docName = "No document uploaded";
		}
		%>
		<liferay-ui:search-container-column-text name="Uploaded Document"
			orderable="true" orderableProperty="documentName">
			<%=docName%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<liferay-ui:icon-menu>
				<%
					travelViewURL.setParameter("travelId",
							String.valueOf(type.getTravelDetailsId()));
					travelViewURL.setParameter("employeeId",
						String.valueOf(type.getEmployeeId()));
					listShowURL.setParameter("travelId",
						String.valueOf(type.getTravelDetailsId()));
				%>
				<liferay-ui:icon url="<%=travelViewURL.toString()%>"
					message="view" image="view" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>