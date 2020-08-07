<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.famocom.erpcloud.workschedule.util.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.SchedulesMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.SchedulesMasterLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:error key="error" message="sorry!!"></liferay-ui:error>
<%
	List<SchedulesMaster> schedulerName= SchedulesMasterLocalServiceUtil.getSchedulesMasters(-1,-1);
	
	String errorList = ParamUtil.getString(request, "errorList");
	long schedulesId = ParamUtil.getLong(request, "schedulesId");
	boolean editURL = false;
	SchedulesMaster schedule=null;
	if (Validator.isNotNull(schedulesId)) {
		System.out.println("schedulesId >>>"+schedulesId);
		System.out.println("errorList>>"+errorList);
		editURL = true;
		try {
			schedule = SchedulesMasterLocalServiceUtil.getSchedulesMaster(schedulesId);
			//scheduleMaster=SchedulesMasterLocalServiceUtil.getSchedulesMaster(worksSchedulesId);
		} catch (Exception e) {
	
		}
	}

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/addNewWorkSchedules.jsp");
	
	PortletURL schedulesDeleteURL = renderResponse.createActionURL();
	schedulesDeleteURL.setParameter("javax.portlet.action", "deleteSchedule");
	
	
	
	PortletURL schedulesEditUrl = renderResponse.createRenderURL();
	schedulesEditUrl.setParameter("jspPage", "/META-INF/resources/addNewWorkSchedules.jsp");
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage","/view.jsp"); 
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
	 List<SchedulesMaster> tsSortList = new ArrayList<>();
	 OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);
	 tsSortList = ListUtil.copy(schedulerName);
	 ListUtil.sort(tsSortList, orderByComparator);
%>
<liferay-ui:header title="Back" backLabel="Back" backURL="<%=backURL.toString()%>" />

		
<portlet:actionURL name="addSchedules" var="addWorksSchedulesURL" />
<portlet:actionURL name="editSchedules" var="editSchedulesURL" />
<aui:form name="worksSchedules" action="<%=editURL != true ?addWorksSchedulesURL.toString():editSchedulesURL.toString()%>"
	method="post">
	<aui:input name="schedulesId" type="hidden" value="<%=schedulesId%>" />
	<aui:row>
		<aui:col span="4">
			<label>Schedule Name</label>
			</br>
			</br>
			<aui:input name="scheduleName" type="text" value="<%=schedule!=null?schedule.getSchedulesName():""%>" label="" />
		</aui:col>
		<aui:col span="4">
			<aui:input name="scheduleDescription" type="textarea" value="<%=schedule!=null?schedule.getSchedulesDescription():""%>" label="Schedule Description" />
		</aui:col>
		<aui:col span="4">
			<aui:button name="save" type="submit" value="save" />
		</aui:col>
	</aui:row>
</aui:form>

<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found."
	iteratorURL="<%=iteratorUrl%>" orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = tsSortList;
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
		className="com.liferay.famocom.erpcloud.model.SchedulesMaster"
		modelVar="type">
		
		<liferay-ui:search-container-column-text name="Schedules Name"
			orderable="true" orderableProperty="schedulesName">
			<%=type.getSchedulesName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Description"
			orderable="true" orderableProperty="schedulesDescription">
			<%=type.getSchedulesDescription()%>
		</liferay-ui:search-container-column-text>
		<%-- <liferay-ui:search-container-column-text name="Create Date"
			orderable="true" orderableProperty="fromDate">
			<%=type.getCreateDate()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Modified Date"
			orderable="true" orderableProperty="fromDate">
			<%=type.getModifiedDate()%>
		</liferay-ui:search-container-column-text> --%>

		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					schedulesEditUrl.setParameter("schedulesId", String.valueOf(type.getSchedulesId()));
					schedulesDeleteURL.setParameter("id", String.valueOf(type.getSchedulesId()));
				%>

				<liferay-ui:icon url="<%=schedulesEditUrl.toString()%>"
					message="edit" image="edit" />
				<liferay-ui:icon-delete url="<%=schedulesDeleteURL.toString()%>"
					message="delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>