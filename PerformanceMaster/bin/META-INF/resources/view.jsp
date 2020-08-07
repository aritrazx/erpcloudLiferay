<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Performance"%>
<%@page import="com.liferay.famocom.erpcloud.service.PerformanceLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/init.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend"prefix="liferay-frontend"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	boolean editURL = false;
	long performanceId = ParamUtil.getLong(request, "performanceId");
	String performanceHeading = ParamUtil.getString(renderRequest, "performanceHeading", StringPool.BLANK);
	String performanceDescription = ParamUtil.getString(renderRequest, "performanceDescription", StringPool.BLANK);
	String createDate = ParamUtil.getString(renderRequest, "createDate", StringPool.BLANK);
	List<Performance> perMastList = new ArrayList<Performance>();
	perMastList = PerformanceLocalServiceUtil.getPerformances(-1, -1);
	Performance pm = null;
	if (performanceId != 0) {
		editURL = true;
		try {
			pm = PerformanceLocalServiceUtil.getPerformance(performanceId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL performanceMasterEditURL = renderResponse.createRenderURL();
	performanceMasterEditURL.setParameter("jspPage", "/META-INF/resources/addPerformanceMaster.jsp");

	PortletURL addPerformanceMasterURL = renderResponse.createRenderURL();
	addPerformanceMasterURL.setParameter("jspPage", "/META-INF/resources/addPerformanceMaster.jsp");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL performanceMasterDeleteURL = renderResponse.createActionURL();
	performanceMasterDeleteURL.setParameter("javax.portlet.action", "deletePerformanceMaster");

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	iteratorUrl.setParameter("performanceheading", performanceHeading);
	iteratorUrl.setParameter("performanceDescription", performanceDescription);
	iteratorUrl.setParameter("createDate", createDate);
%>
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Performance Master")%>'
		url="<%=addPerformanceMasterURL.toString()%>" />
</liferay-frontend:add-menu>
<liferay-ui:success key="delete-success" message="Your request is  deleted successfully!"/>
<liferay-ui:error key="delete-error" message="Sorry, GoalId Already in Use , Please Check " />
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = perMastList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("perMastList", perMastList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Performance"
		modelVar="perMast">
		<liferay-ui:search-container-column-text name="Performance Heading"
			orderable="true" orderableProperty="performanceheading">
			<%=perMast.getPerformanceHeading()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="Performance Description" orderable="true"
			orderableProperty="performancedescription">
			<%=perMast.getPerformanceDescription()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true" orderableProperty="addeddate">
			<%=dateFormat.format(perMast.getCreateDate())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				performanceMasterEditURL.setParameter("performanceId",String.valueOf(perMast.getPerformanceId()));
				performanceMasterEditURL.setParameter("editURL", String.valueOf(editURL));
				performanceMasterDeleteURL.setParameter("performanceId", String.valueOf(perMast.getPerformanceId()));
							//System.out.println("primary key in jsp...."+rating_id);
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=performanceMasterEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon url="<%=performanceMasterDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>