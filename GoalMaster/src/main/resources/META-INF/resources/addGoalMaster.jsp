
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.GoalMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalMaster"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
long goalId = ParamUtil.getLong(request, "goalId");
String goal = ParamUtil.getString(renderRequest, "goal", StringPool.BLANK);
String goalDesc = ParamUtil.getString(renderRequest, "goalDesc", StringPool.BLANK);
String addeddate = ParamUtil.getString(renderRequest, "addeddate", StringPool.BLANK);
List<GoalMaster> goalMastList = new ArrayList<GoalMaster>();
goalMastList = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);
GoalMaster gm = null;
if (goalId != 0) {
	editURL = true;
	try {
		gm = GoalMasterLocalServiceUtil.getGoalMaster(goalId);
	} catch (Exception ex) {
		ex.getMessage();
	}
}

PortletURL filter = renderResponse.createRenderURL();
filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

/* PortletURL goalMasterEditURL = renderResponse.createRenderURL();
goalMasterEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp"); */

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>
<aui:row>
	<liferay-ui:header title="Add GoalMaster " backLabel="Back"
		backURL="<%=backURL.toString()%>"></liferay-ui:header>
</aui:row>
<portlet:actionURL name="goalMaster" var="goalMasterURL" />
<portlet:actionURL name="updateGoalMaster" var="updateGoalMasterURL" />
<aui:form name="goalMaster"
	action="<%=editURL != true ? goalMasterURL.toString() : updateGoalMasterURL.toString()%>"
	method="post">
	<aui:input name="goalId" type="hidden" value="<%=goalId%>"></aui:input>
	<aui:input name="goal" type="text" label="Goal" placeholder="Goal" 
		value="<%=gm != null ? gm.getGoalName() : ""%>">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="goalDesc" type="textarea" label="Goal Description" required="true"
		placeholder="Goal Description"
		value="<%=gm != null ? gm.getGoalDescription() : ""%>">
	</aui:input>
	<aui:button name="button" type="submit" value="submit"></aui:button>
</aui:form>
