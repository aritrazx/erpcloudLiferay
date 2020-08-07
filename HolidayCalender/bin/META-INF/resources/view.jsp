<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.portlet.ThemeDisplayModel"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/view.jsp");

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	List<HolidayCalenderManagement> holiList = HolidayCalenderManagementLocalServiceUtil
			.getHolidayCalenderManagements(-1, -1);

	PortletURL holiDayEditURL = renderResponse.createRenderURL();
	holiDayEditURL.setParameter("jspPage", "/addHoliday.jsp");

	PortletURL holidayDeleteURL = renderResponse.createActionURL();
	holidayDeleteURL.setParameter("javax.portlet.action", "holidayCalenderDelete");
	
	PortletURL addHolidayURL = renderResponse.createRenderURL();
	addHolidayURL.setParameter("jspPage", "/META-INF/resources/addHoliday.jsp");

%>
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Holiday")%>'
		url="<%=addHolidayURL.toString()%>" />
</liferay-frontend:add-menu>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." orderByCol=""
	iteratorURL="<%=iteratorUrl%>" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = holiList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"
		modelVar="var">

		<liferay-ui:search-container-column-text name="Date" orderable="true"
			orderableProperty="holidayDate">
			<%=dateFormat.format(var.getHolidayDate())%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Name" orderable="true"
			orderableProperty="holidayName">
			<%=var.getHolidayName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				holiDayEditURL.setParameter("holidayId", String.valueOf(var.getHolidayId()));
				holiDayEditURL.setParameter("isEdit", "true");

				holidayDeleteURL.setParameter("holidayId", String.valueOf(var.getHolidayId()));
			%>
			<liferay-ui:icon-menu markupView="lexicon">
				<liferay-ui:icon url="<%=holiDayEditURL.toString()%>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=holidayDeleteURL.toString()%>"
					image="delete" message="Delete" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>
