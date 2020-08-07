<%@page import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="/init.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	String navigation = ParamUtil.getString(request, "navigation", "active");
	String orderByCol = ParamUtil.getString(request, "orderByCol", "leaveName");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	boolean activeStatus = true;
	boolean inActiveStatus = false;

	long leaveTypeId = ParamUtil.getLong(request, "leaveTypeId");

	LeaveType leave = null;
	if (leaveTypeId != 0) {
		leave = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
	}
%>

<liferay-portlet:renderURL varImpl="viewPageURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
	<%-- <portlet:param name="displayStyle" value="<%= displayStyle %>" /> --%>
	<portlet:param name="orderByCol" value="<%=orderByCol%>" />
	<portlet:param name="orderByType" value="<%=orderByType%>" />
	<portlet:param name="navigation" value="<%=navigation%>" />
</liferay-portlet:renderURL>

<%
	DynamicQuery dynamicQuery = LeaveTypeLocalServiceUtil.dynamicQuery();

	if (navigation.equals("active")) {
		dynamicQuery.add(PropertyFactoryUtil.forName("leaveStatus").eq(activeStatus));
	}
	if (navigation.equals("inactive")) {
		dynamicQuery.add(PropertyFactoryUtil.forName("leaveStatus").eq(inActiveStatus));
	}
	if (orderByCol.equals("leaveName")) {
		if (orderByType.equals("asc")) {
			dynamicQuery.addOrder(OrderFactoryUtil.asc("leaveName"));
		} else if (orderByType.equals("desc")) {
			dynamicQuery.addOrder(OrderFactoryUtil.desc("leaveName"));
		}
	}
	List<LeaveType> objList = LeaveTypeLocalServiceUtil.dynamicQuery(dynamicQuery);

	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage", "/META-INF/resources/displayAllLeave.jsp");
%>
<aui:row>
	<aui:col span="8">

	</aui:col>
	<aui:col span="2">
	</aui:col>

	<aui:col span="2">
		<a class="btn btn-primary btn-default" name="displayAllLeave"
			type="submit" href="<%=searchURL.toString()%>">Total Applied
			Leave</a>
	</aui:col>
</aui:row>
<liferay-frontend:management-bar includeCheckBox="<%=false%>"
	searchContainerId="leaveType">
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%=new String[] { "active", "inactive" }%>'
			portletURL="<%=renderResponse.createRenderURL()%>" />

		<liferay-frontend:management-bar-sort orderByCol="<%=orderByCol%>"
			orderByType="<%=orderByType%>"
			orderColumns='<%=new String[] { "Leave Type" }%>'
			portletURL="<%=viewPageURL%>" />
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%=new String[] { "list" }%>'
			portletURL="<%=renderResponse.createRenderURL()%>"
			selectedDisplayStyle="" />
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>
<%
	List<LeaveType> LeaveType = null;
	try {
		LeaveType = LeaveTypeLocalServiceUtil.getLeaveTypes(-1, -1);
	} catch (Exception e) {
		System.out.print("error in leave ..........");
	}

	String err = "";
	err = String.valueOf(renderRequest.getAttribute("error"));

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL leaveAddURL = renderResponse.createRenderURL();
	leaveAddURL.setParameter("jspPage", "/META-INF/resources/index.jsp");

	PortletURL leaveEditURL = renderResponse.createRenderURL();
	leaveEditURL.setParameter("jspPage", "/META-INF/resources/index.jsp");

	PortletURL leaveDeleteURL = renderResponse.createActionURL();
	leaveDeleteURL.setParameter("javax.portlet.action", "deleteLeave");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL deactivateURL = renderResponse.createActionURL();
	deactivateURL.setParameter("javax.portlet.action", "deactivate");

	PortletURL activeURL = renderResponse.createActionURL();
	activeURL.setParameter("javax.portlet.action", "activate");
%>

<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Leave")%>'
		url="<%=leaveAddURL.toString()%>" />
</liferay-frontend:add-menu>
<div>
	<%
		if (!err.isEmpty() && Validator.isNotNull(err)) {
	%>
	<div style="color: red;"><%=err%></div>
	<%
		}
	%>

</div>
<liferay-ui:success key="add-success"
	message="Your request Added successfully!" />
<liferay-ui:error key="add-error"
	message="Sorry, an error prevented saving your Requesting" />
<liferay-ui:success key="success"
	message="Your request Updated successfully!" />
<liferay-ui:error key="error"
	message="Sorry, an error prevented Updtaing your Requesting" />
<liferay-ui:success key="delete-success"
	message="Your request Deleted successfully!" />
<liferay-ui:error key="delete-error"
	message="Sorry, an error prevented Deleting your Requesting" />

<aui:input name="leaveTypeId" type="hidden" value="<%=leaveTypeId%>"></aui:input>
<%
	if (Validator.isNotNull(objList)) {
%>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = objList;
						total = results.size();
						searchContainer.setTotal(results.size());
						pageContext.setAttribute("results",
								results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
						pageContext.setAttribute("total", results.size());
						pageContext.setAttribute("delta", results.size());
						portletSession.setAttribute("projectListTemp", LeaveType);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.LeaveType"
		modelVar="leaveType">


		<liferay-ui:search-container-column-text name="Leave Name"
			orderable="true" orderableProperty="leaveName">
			<%=leaveType.getLeaveName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Abbreviation"
			orderable="true" orderableProperty="abb">
			<%=leaveType.getAbb()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Max Credit Days"
			orderable="true" orderableProperty="maxCreditDay">
			<%=leaveType.getMaxCreditDay()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Addeddate"
			orderable="true" orderableProperty="addeddate">
			<%=dateFormat.format(leaveType.getAddedDate())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				boolean editURL = true;
								leaveEditURL.setParameter("leaveTypeId", String.valueOf(leaveType.getLeaveTypeId()));
								leaveEditURL.setParameter("editURL", String.valueOf(editURL));
								leaveDeleteURL.setParameter("leaveTypeId", String.valueOf(leaveType.getLeaveTypeId()));
								deactivateURL.setParameter("leaveTypeId", String.valueOf(leaveType.getLeaveTypeId()));
								activeURL.setParameter("leaveTypeId", String.valueOf(leaveType.getLeaveTypeId()));
			%>
			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=leaveEditURL.toString()%>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=leaveDeleteURL.toString()%>"
					image="delete" message="Delete" />
				<%
					if (leaveType.getLeaveStatus() == false) {
				%>
				<liferay-ui:icon url="<%=activeURL.toString()%>" label="Activate"
					message="Activate" image="activate" />
				<%
					} else {
				%>
				<liferay-ui:icon url="<%=deactivateURL.toString()%>"
					label="Deactivate" message="Deactivate" image="deactivate" />
				<%
					}
				%>
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>

<%
	}
%>