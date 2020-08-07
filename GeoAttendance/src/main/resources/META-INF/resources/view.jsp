<%@page import="com.liferay.famocom.erpcloud.geoattendance.util.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.EmailAddressLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.model.GeoAttendance"%>
<%@page import="com.liferay.famocom.erpcloud.service.GeoAttendanceLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.geoattendance.portlet.GeoAttendancePortlet"%>
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
	List<GeoAttendance> geoAttendanceList = new ArrayList<>();
	geoAttendanceList= GeoAttendanceLocalServiceUtil.getGeoAttendances(-1, -1);
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
	 /* if (Validator.isNull(orderByCol)) {
		 orderByCol = "goal_name";
		} */
	 System.out.println("orderByCol..." + orderByCol);
	 System.out.println("orderByType..." + orderByType);
	 List<GeoAttendance> geoAttendanceSortList = new ArrayList<>();
	 OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);
	 geoAttendanceSortList = ListUtil.copy(geoAttendanceList);
	 
	 ListUtil.sort(geoAttendanceSortList, orderByComparator);
%>

<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = geoAttendanceSortList;
			total = results.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
					results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.GeoAttendance"
		modelVar="var">
			<%
			Date addDate = var.getAttDate();
			SimpleDateFormat formatter = new SimpleDateFormat("dd, MMMM yyyy");
			String strDate = formatter.format(addDate);
			%>
		<liferay-ui:search-container-column-text name="Date"
			orderable="true" orderableProperty="attDate">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%
			Employee emp =EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
		%>
		<liferay-ui:search-container-column-text name="Name"
			orderable="true" orderableProperty="employeeId">
			<b><%=emp.getFirstName()+" "+emp.getLastName()%></b>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="InTime"
			orderable="true" orderableProperty="inTime">
			<%=var.getInTime()%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Address"
			orderable="true" orderableProperty="geoAddress">
			<%=var.getGeoAddress() %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container> 