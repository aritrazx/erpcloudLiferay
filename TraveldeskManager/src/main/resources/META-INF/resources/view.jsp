<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
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
%>

<%
	List<TravelDeskDetails> tdList = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetailses(-1, -1);
	List<AddTeamMember> projMangrList = new ArrayList<>();
	List<AddTeamMember> projMembrList = new ArrayList<>();
	List<TravelDeskDetails> travelList = new ArrayList<>();
	ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	long userDetails = td.getUserId();
	Employee emp=EmployeeLocalServiceUtil.findByemployees(userDetails);
	long employeeId = emp.getEmployeeId();
	Role role = RoleLocalServiceUtil.getRole(td.getCompanyId(), "Project Manager");
	System.out.println("role...." + role.getRoleId());
	DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("employeeId", employeeId);
	criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("roleId", role.getRoleId()));
	dynamicQuery.add(criterion3);
	projMangrList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("projMangrList...."+projMangrList);
	for (AddTeamMember addTeam : projMangrList) {
		if (Validator.isNotNull(addTeam.getProjectId())) {
	/* for(int i=0;i<projMangrList.size();i++){ */
	DynamicQuery projQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.eq("projectId", addTeam.getProjectId());
	criterion = RestrictionsFactoryUtil.and(criterion,
			RestrictionsFactoryUtil.ne("roleId", role.getRoleId()));
	projQuery.add(criterion);
	projMembrList = AddTeamMemberLocalServiceUtil.dynamicQuery(projQuery);
	System.out.println("projMembrList...." + projMembrList);
	/* } */
		}

	}
	List<TravelDeskDetails> travelDeskList = new ArrayList<>();
	
			 for (int i = 0; i < projMembrList.size(); i++) { 
				DynamicQuery membrQuery = TravelDeskDetailsLocalServiceUtil.dynamicQuery();
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("employeeId", projMembrList.get(i).getEmployeeId());
				membrQuery.add(criterion);
				travelList = TravelDeskDetailsLocalServiceUtil.dynamicQuery(membrQuery);
				travelDeskList.addAll(travelList);
				System.out.println("travelList.." + travelList);
			 } 
	System.out.println("travelDeskList.." + travelDeskList);
	DynamicQuery sortQuery = TravelDeskDetailsLocalServiceUtil.dynamicQuery();
	sortQuery.addOrder(OrderFactoryUtil.desc("modifiedDate"));
	travelDeskList = TravelDeskDetailsLocalServiceUtil.dynamicQuery(sortQuery);
	/* List<AddTeamMember> addTeamMembers=null;
	try{
		addTeamMembers = AddTeamMemberLocalServiceUtil.findByprojectManager(true);
		System.out.println("addTeamMembers:"+addTeamMembers);
	}catch(Exception e){
		
	}
	List<AddTeamMember> listProject=new ArrayList<>();
	List<TravelDeskDetails> listEmployee=new ArrayList<>();
	for(AddTeamMember addTeam:addTeamMembers){
		if(Validator.isNotNull(addTeam.getProjectId())){
		listProject=AddTeamMemberLocalServiceUtil.findByprojectMember(addTeam.getProjectId());
		}
	}
		System.out.println("listProject"+listProject); */
	//System.out.println("travelList.." + travelList);
%>
<%
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("asc")) {
		orderByType = "asc";
	} else {
		orderByType = "desc";
	}

	if (Validator.isNull(orderByType)) {
		orderByType = "asc";
	}

	/* OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol,
			orderByType);
	List<TravelDeskDetails> tdSortList = ListUtil.copy(travelDeskList);
	ListUtil.sort(tdSortList, orderByComparator); */
	/* if (Validator.isNull(orderByCol)) {
	 orderByCol = "goal_name";
	} */
%>


<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="<%=orderByCol %>" orderByType="<%=orderByType %>">
	<liferay-ui:search-container-results>
		<%
			results = travelDeskList;
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