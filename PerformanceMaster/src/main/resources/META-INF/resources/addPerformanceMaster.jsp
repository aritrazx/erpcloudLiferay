<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.PerformanceLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.Performance"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
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
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>
<aui:row>
	<liferay-ui:header title="Add Performance" backLabel="Back"
		backURL="<%=backURL.toString()%>"></liferay-ui:header>
</aui:row>

<portlet:actionURL name="performanceMaster" var="performanceMasterURL" />
<portlet:actionURL name="updatePerformanceMaster"
	var="updatePerformanceMasterURL" />
<aui:form name="performanceMaster"
	action="<%=editURL != true ? performanceMasterURL.toString() : updatePerformanceMasterURL.toString()%>"
	method="post">
	<aui:input name="performanceId" type="hidden"
		value="<%=performanceId%>"></aui:input>
	<aui:input name="performanceHeading" type="text" 
		label="Performance Heading" placeholder="Performance Heading"
		value="<%=pm != null ? pm.getPerformanceHeading() : ""%>">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="performanceDescription" type="text" required="true"
		label="Performance Description" placeholder="Performance Description"
		value="<%=pm != null ? pm.getPerformanceDescription() : ""%>">
	</aui:input>
	<aui:button name="button" type="submit" value="submit"></aui:button>
	</br>
	</br>
</aui:form>